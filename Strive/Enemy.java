import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends AI
{
    private int speed = 1;
    private boolean direction = true;
    
    
    private boolean inRange = false;
    private boolean shootingRange = false;
    private int range = 200;
    private int offset = 100;
    private int chase = 1;
    private List<Player> list;
    private List<Player> list2;
    private int shootTimer = 0;
    private EnemyHP bar;
    private int onAdd = 0;
    
    private int aniRight = 13;
    private int aniLeft = 1;
    private int aniCD = 0;
    
    public Enemy() {
        EnemyHP hp = new EnemyHP();
        bar = hp;
    }
   
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       if (onAdd == 0) {
           getWorld().addObject(bar, this.getX(), this.getY());
           onAdd = 1;
       }
       
       //if player is not in range, patrol, else shoot and fall down platforms.
       if (!inRange) {
           Patrol();
       }
       else {
           if (list.get(0) != null) {
               shooting(list.get(0));
           }
       }
       
       checkFall();
       //check if player is within range
       checkRange();
       
       //makes hp bar move to player
       bar.setLocation(this.getX(), this.getY() - 35);
       
       
       if (isTouching(Bullet.class)) {
           bar.decreaseHealth(10);
       }
       
       //animations for moving
       if (aniCD <= 0) {
           animation();
       }
       aniCD--;
       
       //checks health, if its 0, remove.
       if (bar != null) {
           checkDeath();
       }
       
       //shooting cooldown
       shootTimer--;
    }
    
    public void animation() {
        aniCD = 7;
        if (speed > 0) {
            aniLeft = 1;
            setImage("enemy" + aniRight + ".png");
            aniRight++;
            if (aniRight == 24) {
                aniRight = 13;
            }
        }
        else {
            if (speed < 0) {
                aniRight = 13;
                setImage("enemy" + aniLeft + ".png");
                aniLeft++;
                if (aniLeft == 12) {
                    aniLeft = 1;
                }
            }
            else {
                GreenfootImage stillImage = new GreenfootImage("enemy28.png");
                if (!list.isEmpty()) {
                    if (list.get(0).getX() >= this.getX()) {
                        stillImage.mirrorHorizontally();
                        setImage(stillImage);
                    }
                    else {
                        setImage(stillImage);
                    }
                }
            }
        }
    }
    
    
    public boolean shooting(Player player) {
        
        if (shootTimer <= 0) {
            getWorld().addObject(new enemyBullet(player.getX(), player.getY(), getX(), getY()), getX(), getY());
            shootTimer = 50;
            return true;
        }
        return false;
    }
    
    public void checkRange() {
        /*if (!inRange) {
            list = getObjectsInRange(range, Player.class);
        }*/
        
        if (!inRange) {
            list = getObjectsInRange(range, Player.class);
            if (list.size() == 1) {
                if (this.getY() > list.get(0).getY() + 50 || this.getY() < list.get(0).getY() - 50) {
                    list.clear();
                }
                else {
                    inRange = true;
                    chase(list.get(0));
                }
            }
        }
        else {
            list2 = getObjectsInRange((int)(range * 1.5), Player.class);
            if (!list.isEmpty()) {
                chase(list.get(0));
            }
            if (list2.size() == 0) {
                inRange = false;
                list.clear();
                list2.clear();
            }
        }
    }
    
    
    public void chase(Player player) {
        int run = 0;
        offset = offset > 0 ? offset : offset * -1;
        offset = player.getX() > this.getX() ? offset * -1 : offset;
        
        if (offset > 0) {
            run = -chase;
        }
        else {
            run = chase;
        }
        
        /*if (player.getX() >= this.getX() + offset) {
            speed = 1;
            setLocation(this.getX() + run, getY());
        }
        
        if (player.getX() <= this.getX() + offset) {
            speed = -1;
            setLocation(this.getX() + run, getY());
        }*/
        
        
        //enemies stop chasing if you're within 100pixels of them and just shoot.
        if (player.getX() >= this.getX() + 100) {
            speed = 1;
            setLocation(this.getX() + run, getY());
        }
        else {
            if (player.getX() <= this.getX() - 100) {
                speed = -1;
                setLocation(this.getX() + run, getY());
            }
            else {
                speed = 0;
            }
        }
    }
    
    public void Patrol() {
        int spriteHeight = getImage().getHeight();
        int spriteWidth = getImage().getWidth();
        int lookForGround = (int)(spriteHeight/2);
        int lookForEdge = (int)(spriteWidth/2);
        
        //player walks over left edge of platforms, this fixes it.
        if (speed < 0) {
            lookForEdge -= 20;
        }
        
        
        Actor ground = getOneObjectAtOffset(lookForEdge, lookForGround, Floor.class);
        
        if (ground == null && direction) {
            speed = speed * -1;
            lookForEdge *= -1;
            cooldown();
        }
        else {
            move(speed);
            direction = true;
            if (Greenfoot.getRandomNumber(100) < 1) {
                speed *= -1;
            }
            
            //fix so that enemies dont walk through walls
            if (isTouching(invisWall.class)) {
                speed *= -1;
            }
            if (getX() <= 5 || getX() >= getWorld().getWidth() - 5) {
                speed *= -1;
            }
        }
    }
    
    public void cooldown() {
        if (direction) {
            direction = false;
        }
        else {
            direction = true;
        }
        
        for (int i = 0; i < 100; i++) {
            
        }
        return;
    }
    
    public void checkDeath() {
        if (bar.getHealth() == 0) {
            getWorld().removeObject(this);
            bar.remove();
        }
    }
}
