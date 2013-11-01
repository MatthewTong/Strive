import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shooting here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shooting extends AI
{
    /**
     * Act - do whatever the Shooting wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        killPerson();
    }    
    
    public void remove() {
        Actor walls = getOneIntersectingObject(Floor.class);
        
        if (getX() <= 1|| getX() >= getWorld().getWidth() - 1)
            getWorld().removeObject(this);
        else if (walls != null)
            getWorld().removeObject(this);
    }
    
    public boolean hitEnemy(Class clss) {
        Actor enemy = getOneObjectAtOffset(0, 0, clss);
        return enemy != null;
    }
    
    
    public void killPerson() {
        if (hitEnemy(Player.class)) {
            getWorld().removeObject(this);
        }
        else
            remove();
    }
}
