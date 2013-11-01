import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerHP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerHP extends HealthBar
{
    public PlayerHP() {
        super(100, 50, 10);
        drawBar();
    }
    
    
    /**
     * Act - do whatever the PlayerHP wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        updateBar();
        checkDeath();
    }
    
    public void checkDeath() {
        if (getHealth() == 0) {
            Greenfoot.setWorld(new PostWorld());
        }
    }
}
