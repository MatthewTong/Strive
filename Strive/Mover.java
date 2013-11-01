import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Mover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mover extends Actor
{
    private int vSpeed = 0;
    private int acceleration = 1;
    private boolean jumping;
    private int jumpStrength = 20;
    
    private boolean lock = true;
    
    public void act() {
    }
    
    public void jump() {
        if(jumping == false) {
            vSpeed = vSpeed - jumpStrength;
            jumping = true;
            fall();
        }
    }
    
    public void jump(int distance) {
        if(jumping == false) {
            vSpeed = vSpeed - jumpStrength;
            jumping = true;
            fall(distance);
        }
    }
    
    public void move() {
        //This is the standard move that all other NPCs and objects can use.
    }
    
    public void fall() {
        setLocation(getX(), getY() + vSpeed);
        if (vSpeed <= 9)
            vSpeed += acceleration;
        jumping = true;
    }
    
    public void fall(int distance) {
        setLocation(getX() + distance/40, getY() + vSpeed);
        if (vSpeed <= 9)
            vSpeed += acceleration;
        jumping = true;
    }
    
    public void checkFall() {
        if (onGround())
            vSpeed = 0;
        else
            fall();
    }
    
    public void checkFall(int distance) {
        if (onGround())
            vSpeed = 0;
        else
            fall(distance);
    }
    
    public void moveToGround(Actor floor) {
        int groundHeight = floor.getImage().getHeight();
        int newY = floor.getY() - (groundHeight + getImage().getHeight())/2;
        
        setLocation(getX(), newY);
        jumping = false;
    }
    
    public boolean onGround() {
        int spriteHeight = getImage().getHeight();
        int lookForGround = (int)(spriteHeight/2) + 5;
        
        Actor ground = getOneObjectAtOffset(0, lookForGround, Floor.class);
        
        if (ground == null) {
            jumping = true;
            return false;
        }
        else {
            moveToGround(ground);
            return true;
        }
    }
    
    public boolean platformAbove() {
        int spriteHeight = getImage().getHeight();
        int lookForCeiling = (int)(spriteHeight/ -2);
        
        Actor ceiling = getOneObjectAtOffset(0, lookForCeiling, Floor.class);
        
        if (ceiling != null) {
            vSpeed = 1;
            bopHead(ceiling);
            return true;
        }
        else {
            return false;
        }
    }
    
    public void bopHead(Actor ceiling) {
        int ceilingHeight = ceiling.getImage().getHeight();
        int newY = ceiling.getY() + (ceilingHeight + getImage().getHeight())/2;
        
        setLocation(getX(), newY);
    }
    
    public boolean checkWalls() {
        int spriteWidth = getImage().getWidth();
        int xDistance = (int)(spriteWidth/2);
        boolean right;
        
        Actor wallRight = getOneObjectAtOffset(xDistance, 0, Floor.class);
        Actor wallLeft = getOneObjectAtOffset(-xDistance, 0, Floor.class);
        
        if (wallRight == null && wallLeft == null)
            return false;
        else {
            if (wallRight == null) {
                right = false;
                stopByWall(wallLeft, right);
            }
            else {
                right = true;
                stopByWall(wallRight, right);
            }
            return true;
        }
    }
    
    public void stopByWall(Actor wall, boolean right) {
        int wallWidth = wall.getImage().getWidth();
        int newXRight = wall.getX() - (wallWidth + getImage().getWidth())/2;
        int newXLeft = wall.getX() + (wallWidth+ getImage().getWidth())/2;
        
        if (right)
            setLocation(newXRight - 5, getY());
        else
            setLocation(newXLeft + 5, getY());
    }
    
    public boolean isLocked(){
        return lock;
    }
}
