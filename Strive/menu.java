import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class menu extends StartMenu
{
    /**
     * Act - do whatever the menu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {
            List remove = getObjectsInRange(800, Actor.class);
            for (Object objects : remove) {
                getWorld().removeObject((Actor)objects);
            }
            
            Start start = new Start();
            getWorld().addObject(start, 147, 510);
            Controls con = new Controls();
            getWorld().addObject(con, 400, 510);
            End end = new End();
            getWorld().addObject(end, 653, 510);
            
            getWorld().removeObject(this);
        }
    }    
}
