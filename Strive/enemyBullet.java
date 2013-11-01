import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemyBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemyBullet extends Shooting
{
    private int shootingSpeed = 8;
    private int playerX;
    private int playerY;
    private int bulletX;
    private int bulletY;
    
    public enemyBullet(int playerX, int playerY, int bulletX, int bulletY) {
        this.playerX = playerX;
        this.playerY = playerY;
        this.bulletX = bulletX;
        this.bulletY = bulletY;
    }
    /**
     * Act - do whatever the Shooting wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        fly();
        killPerson();
    }    
    
    public void fly() {
        double x = playerX - bulletX;
        double y = playerY - bulletY;
        if (x != 0) {
            int rot = (int)(Math.atan(y/x) * (180/Math.PI));
            if (x < 0) {
                if (y > 0) {
                    rot -= 180;
                }
                else {
                    rot += 180;
                }
            }
            setRotation(rot);
        }
        else {
            if (y > 0)
                setRotation(90);
            else if (y < 0)
                setRotation(270);
            else
                setRotation(0);
            }
        move(shootingSpeed);
    }  
}
