import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShootingManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShootingManager extends Mover
{
    /**
     * Act - do whatever the ShootingManager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        killBadGuys();
        crosshair();
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
    
    public void kill(Class clss) {
        Actor enemy = getOneObjectAtOffset(0, 0, clss);
        if (enemy != null)
            getWorld().removeObject(enemy);
    }
    
    public void killBadGuys() {
        if (hitEnemy(AI.class)) {
            //kill(AI.class);
            getWorld().removeObject(this);
        }
        else
            remove();
    }
    
    public void crosshair() {
        if (Greenfoot.mouseMoved(null)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX(), mouse.getY());
        }
    }
}
