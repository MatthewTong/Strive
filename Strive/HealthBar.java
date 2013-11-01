import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class HealthBar extends Actor
{
    private GreenfootImage emptyBar;
    private double health;
    private double maxHp;
    private int width;
    private int height;
    
    public HealthBar(double maxHp, int w, int h) {
        health = maxHp;
        this.maxHp = maxHp;
        width = w;
        height = h;
        drawBar();
    }
    
    
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        updateBar();
    }    
    
    
    public void drawBar()
    {
        GreenfootImage bar = new GreenfootImage(width, height);
        
        bar.setColor(java.awt.Color.GREEN);
        
        emptyBar = new GreenfootImage(width, height);
        emptyBar.setColor(java.awt.Color.RED);
        emptyBar.fill();
        
        bar.drawImage(emptyBar , 0, 0);
        bar.setColor(java.awt.Color.GREEN);
        
        setImage(bar);

    }
    
    public void updateBar() {
        GreenfootImage bar = getImage();
        
        bar.drawImage(emptyBar, 0, 0);
        bar.setColor(java.awt.Color.GREEN);
        
        double stat = health/maxHp * width;
        
        bar.fillRect(0, 0, (int)stat, height);
        
        setImage(bar);
    }
    
    public void decreaseHealth(int damage)
    {
        if (health - damage < 0) {
            health = 0;
        }
        health -= damage;
        return;
    }
    
    public void increaseHealth(int bonus)
    {
        if (health + bonus > maxHp ) {
            health = maxHp;
        }
        else {
            health += bonus;
        }
        return;
    }
    
    public double getHealth()
    {
        return health;
    }
}

