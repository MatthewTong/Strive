import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Hook here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hook extends Mover
{
    private int shootingSpeed = 8;
    private int mouseX;
    private int mouseY;
    private int initialX;
    private int initialY;
    private LinkedList<Pair> locations;
    private int maxLength = 400;
    private int imageNum = 1;
    private Player player;
    private boolean hitEdge = false;
    private boolean hitWall = false;
    private World world;
    private List<Mover> scroll;
    
    public Hook(int mouseX, int mouseY, int hookX, int hookY, Player player) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
        this.initialX = hookX;
        this.initialY = hookY;
        locations = new LinkedList<Pair>();
        this.player = player;
    }
        
    /**
     * Act - do whatever the Hook wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        direction();
        startFlying();
        if (hitWall)
            playerFly();
        else if (hitEdge)
            retractBasic();
    }    
    
    public void direction() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            double x = mouseX - initialX;
            double y = mouseY - initialY;
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
        }
    }
    
    public void launch() {
        player.fall();
    }

    public boolean hitMaxLength() {
        double x = (getX() - this.initialX) * (getX() - this.initialX);
        double y = (getY() - this.initialY) * (getY() - this.initialY);
        double totalLength = Math.sqrt(x+y);
        
        if (totalLength < this.maxLength)
            return false;
        return true;
    }

    public void startFlying() {
        if (!hitWall && !hitEdge) {
            locations.add(new Pair(getX(), getY()));
            if (getOneObjectAtOffset(0, 0, Floor.class) != null || touchingWallLeft() || touchingWallRight() || platformAbove() || platformBelow()) {
                if (Greenfoot.isKeyDown("e")) {
                    hitWall = true;
                    locations.add(new Pair(getX(), getY()));
                }
                else getWorld().removeObject(this);
                //animate in reverse
            }
            //else if (getOneIntersectingObject(Enemy.class))
            //    enemyFly();
            else if (hitMaxLength())
                hitEdge = true;
            else {
                move(20);
                animation();
            }
        }
    }
    
    public void playerFly() {
        if (Greenfoot.isKeyDown("e")) {
                if (locations.size() >= 2) {
                    Pair moveTo = locations.poll();
                    //gotta update animation every time player moves 
                    int moveX = moveTo.getX() - locations.peek().getX();
                    int moveY = moveTo.getY() - locations.peek().getY();
                    world = getWorld();
                    scroll = world.getObjects(Mover.class);
                    for(int i = 0; i < scroll.size(); i++)
                        scroll.get(i).setLocation(scroll.get(i).getX() + moveX, scroll.get(i).getY() + moveY);
                }
                else {
                    player.fall();
                    getWorld().removeObject(this);
                }
        }
        else {
            retractAdvance();
            launch();
        }
    }
    
    public void retractBasic() {
        getWorld().removeObject(this);
    }
    
    public void retractAdvance() {
        getWorld().removeObject(this);
    }
    
    public boolean touchingWallLeft() {
        boolean one = getOneObjectAtOffset(-getImage().getWidth()-23, getImage().getHeight()/2 - 1, Floor.class) != null;
        boolean two = getOneObjectAtOffset(-getImage().getWidth()-23, - getImage().getHeight()/2 + 1, Floor.class) != null;
        
        return one || two;
    }
    
    public boolean touchingWallRight() {
        boolean one = getOneObjectAtOffset(getImage().getWidth()+23, getImage().getHeight()/2 - 1, Floor.class) != null;
        boolean two = getOneObjectAtOffset(getImage().getWidth()+23, - getImage().getHeight()/2 + 1, Floor.class) != null;
        
        return one || two;
    }
    
    public boolean platformAbove() {
        int spriteHeight = getImage().getHeight();
        int lookForCeiling = (int)(-spriteHeight) - 23;
        
        Actor ceiling = getOneObjectAtOffset(0, lookForCeiling, Floor.class);
        
        if (ceiling != null)
            return true;
        return false;
    }
    public boolean platformBelow() {
        int spriteHeight = getImage().getHeight();
        int lookForCeiling = (int)(spriteHeight);
        
        Actor ceiling = getOneObjectAtOffset(0, lookForCeiling, Floor.class);
        
        if (ceiling != null)
            return true;
        return false;
    }
    
    public void animation() {
        hookImage hk = new hookImage(getRotation(), player, imageNum);
        getWorld().addObject(hk, player.getX(), player.getY());
        hk.animation();
        imageNum++;
        if (imageNum == 5)
            imageNum--;
    }
}
