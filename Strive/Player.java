import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Jumping/Falling/Moving
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//remember to replace "floor" with whatever we call the platforms
public class Player extends Actor
{
    GreenfootSound gameover = new GreenfootSound("gameover.mp3");
    
    
    private int vSpeed = 0;
    private int acceleration = 1;
    private boolean jumping;
    private int jumpStrength = 15;
    private int speed = 4;
    private PlayerHP bar;
    private int shootingTimer = 0;
    private List<Mover> scroll;
    private int hookTimer = 0;
    
    public Player(PlayerHP status) {
        bar = status;
    }
    
    public void act() 
    {
        checkDeath();
        checkFall();
        platformAbove();
        checkKey();
        scroll();
        shooting();
        hookShot();
        
        if (isTouching(enemyBullet.class)) {
            bar.decreaseHealth(5);
        }
           
        shootingTimer--;
        hookTimer--;
    }    
    
    public boolean shooting() {
        
        if (Greenfoot.mouseClicked(null) && shootingTimer <= 0) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse.getButton() == 1) {
                new GreenfootSound("Shot.wav").play();
                getWorld().addObject(new Bullet(mouse.getX(), mouse.getY(), getX(), getY()), getX(), getY());
                shootingTimer = 20;
                return true;
            }
        }
        return false;
    }
    
    public void hookShot() {
        if (Greenfoot.isKeyDown("e") && getObjectsInRange(500, Hook.class).size() == 0 && hookTimer <= 0) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
                getWorld().addObject(new Hook(mouse.getX(), mouse.getY(), getX(), getY(), this), getX(), getY());
                hookTimer = 30;
                if (getWorld().getObjects(Hook.class).size() != 0)
                    hookTimer--;
        }
    }
    
    public void checkKey() {
        if (Greenfoot.isKeyDown("space") && jumping == false) {
            new GreenfootSound("Jump2.wav").play();
            jump();
        }
    }
    
    public void scroll()
    {
        scroll = getWorld().getObjects(Mover.class);
        
        if(Greenfoot.isKeyDown("a"))
        {
            if(!touchingWallLeft())
                for(int i = 0; i < scroll.size(); i++)
                {
                    scroll.get(i).setLocation(scroll.get(i).getX() + speed, scroll.get(i).getY());
                } 
        }
        
        if(Greenfoot.isKeyDown("d"))
        {
            if(!touchingWallRight())
                for(int i = 0; i < scroll.size(); i++)
                {
                    scroll.get(i).setLocation(scroll.get(i).getX() - speed, scroll.get(i).getY());
                }
        }
    }
    
    public boolean touchingWallLeft() {
        boolean one = getOneObjectAtOffset(-getImage().getWidth()/2, getImage().getHeight()/2 - 1, Floor.class) != null;
        boolean two = getOneObjectAtOffset(-getImage().getWidth()/2, - getImage().getHeight()/2 + 1, Floor.class) != null;
        
        return one || two;
    }
    
    public boolean touchingWallRight() {
        boolean one = getOneObjectAtOffset(getImage().getWidth()/2, getImage().getHeight()/2 - 1, Floor.class) != null;
        boolean two = getOneObjectAtOffset(getImage().getWidth()/2, - getImage().getHeight()/2 + 1, Floor.class) != null;
        
        return one || two;
    }
    
    public void fall() {
        scroll = getWorld().getObjects(Mover.class);
        for(int i = 0; i < scroll.size(); i++)
        {
            scroll.get(i).setLocation(scroll.get(i).getX(), scroll.get(i).getY() - vSpeed);
        } 
         
        if (vSpeed <= 9)
            vSpeed += acceleration;
        jumping = true;
    }
    
    public boolean onGround() {
        int spriteHeight = getImage().getHeight();
        int lookForGround = (int)(spriteHeight/2);
        
        Actor ground = getOneObjectAtOffset(0, lookForGround, Floor.class);
        
        if (ground == null) {
            jumping = true;
            return false;
        }
        else {
            int groundHeight = ground.getImage().getHeight();
            int newY = ground.getY() - (groundHeight + getImage().getHeight())/2;
            int y = newY - getY();
            
            scroll = getWorld().getObjects(Mover.class);
            for(int i = 0; i < scroll.size(); i++)
            {
                scroll.get(i).setLocation(scroll.get(i).getX(), scroll.get(i).getY() - y);
            } 
            jumping = false;
            
            return true;
        }
    }
    
    public void moveToGround(Actor floor) {
        
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
        int newY = ceiling.getY() + (ceiling.getImage().getHeight() + getImage().getHeight())/2 - getY();
        
        scroll = getWorld().getObjects(Mover.class);
        for(int i = 0; i < scroll.size(); i++)
        {
            scroll.get(i).setLocation(scroll.get(i).getX(), scroll.get(i).getY() - newY);
        }
    }
    
    public void checkFall() {
        if (onGround())
            vSpeed = 0;
        else
            fall();
    }
    
    public void jump() {
        vSpeed = vSpeed - jumpStrength;
        jumping = true;
        fall();
    }
    
    public void checkDeath() {
        List<ScrollingBackground> bgl = getWorld().getObjects(ScrollingBackground.class);
        
        if(bgl != null) {
            if(!intersects(bgl.get(0))) {
                gameover.play();
                Greenfoot.setWorld(new PostWorld());
            }
        }
    }
}
