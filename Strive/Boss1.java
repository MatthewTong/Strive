import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Boss1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss1 extends AI
{
    private Boss1HP bar;
    private int onAdd = 0;
    private int teleportCooldown = 180;
    
    public Boss1() {
        Boss1HP hp = new Boss1HP();
        bar = hp;
    }
    /**
     * Act - do whatever the Boss1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (onAdd == 0) {
            getWorld().addObject(bar, this.getX(), this.getY());
            onAdd = 1;
        }
        
        bar.setLocation(this.getX(), this.getY() - 35);
        checkFall();
        
        
        if (teleportCooldown <= 0) {
            bossPhase1();
        }
        teleportCooldown--;
        
        
        if (isTouching(Bullet.class)) {
            bar.decreaseHealth(10);
        }
       
        if (bar != null) {
            checkDeath();
        }
        
    }
    
    public void bossPhase1() {
        int random = Greenfoot.getRandomNumber(2);
        List<Player> list = getObjectsInRange(800, Player.class);
        
        if (list.size() == 1) {
            if (random == 0) {
                teleport(100, 130);
                shooting(list.get(0), 0, 0);
                shooting(list.get(0), 100, -200);
            }
            if (random == 1) {
                teleport(750, 100);
            }
            if (random == 2) {
                
            }
            if (random == 3) {
                
            }
        }
        teleportCooldown = 360;
    }
    
    public void teleport(int x, int y) {
        setLocation(x, y);
    }
    
    public boolean shooting(Player player, int x, int y) {
       getWorld().addObject(new enemyBullet(player.getX() + x, player.getY() + y, getX(), getY()), getX(), getY());
       return true;
    }
    //Colliding with player will deal 1 HP damage.
    //Hitframe invincibility 1s after he's been shot (2dmg) or slashed (5dmg).
    //Has 30 HP. Same speed, size as the player.
    
    //Chooses one of three moves randomly. Waits 2s after each move in idleanim:
        //Jump across screen, aim towards player triple shot. Each shot deals 1 damage.
            //Jumpanim, shotanim.
            //Jumpsound, shotsoundx3
        //BIG MOVE. Jumps to one corner of the screen. charges up, releases a linear beam of energy.
            //Jumpanim, chargeanim, releaseanim.
                //If hits, taunt anim.
            //jumpsound, chargesound, releasesound
                //if hits, tauntsound.
            //Must be dodged by hanging on top of wall.
            //Only done at half HP or less.
        //Jumps to within 15px of player, attempts to slash twice.
            //jumpanim, slashanim1, slashanim2
            //jumpsound, slashsoundx2
            
    public void checkDeath() {
        if (bar.getHealth() == 0) {
            getWorld().removeObject(this);
            bar.remove();
        }
    }
}
