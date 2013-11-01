import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shooting here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends ShootingManager
{
    private int shootingSpeed = 8;
    private int mouseX;
    private int mouseY;
    private int bulletX;
    private int bulletY;
    
    public Bullet(int mouseX, int mouseY, int bulletX, int bulletY) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
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
        killBadGuys();
    }    
    
    public void fly() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            double x = mouseX - bulletX;
            double y = mouseY - bulletY;
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
}
