import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss1HP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss1HP extends HealthBar
{
    public Boss1HP() {
        super(100, 50, 10);
        drawBar();
    }
    
    /**
     * Act - do whatever the Boss1HP wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        updateBar();
    }    
    
    public void remove() {
        getWorld().removeObject(this);
    }
}
