import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HUDicon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HUDicon extends Actor
{
    private int icon = 0;
    private int cooldown = 0;
    
    private GreenfootImage hook = new GreenfootImage("hudHook.png");
    private GreenfootImage gun = new GreenfootImage("hudGun.png");
    
    /**
     * Act - do whatever the HUDicon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (cooldown <= 0) {
            if(Greenfoot.isKeyDown("g")) {
                if (icon == 0) {
                    setImage(hook);
                    icon = 1;
                }
                else {
                    setImage(gun);
                    icon = 0;
                }
                cooldown = 30;
            }
        }
        cooldown--;
    }    
}
