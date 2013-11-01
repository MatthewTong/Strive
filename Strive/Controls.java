import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Controls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controls extends StartMenu
{
    private boolean flag = true;
    /**
     * Act - do whatever the Controls wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {
            List remove = getObjectsInRange(800, Actor.class);
            for (Object objects : remove) {
                getWorld().removeObject((Actor)objects);
            }
            
            if (flag) {
                getWorld().addObject(new blah(), 400, 400);
                getWorld().addObject(new menu(), 375, 680);
                flag = false;
            }  
            getWorld().removeObject(this);
        }
        
        
        
        
    }
}
