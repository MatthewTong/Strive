import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class hookImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class hookImage extends Mover
{
    private int imageNumber;
    
    public hookImage(int rotation, Player player, int imageNumber) {
        setLocation(player.getX(), player.getY());
        setRotation(rotation);
        this.imageNumber = imageNumber;
    }
    public void act() 
    {
        //animation();
    }    
    
    public void animation() {
        setImage("hook" + imageNumber + ".png");
        /*
        else {
            aniRight = 13;
            setImage("enemy" + aniLeft + ".png");
            aniLeft++;
            if (aniLeft == 12) {
                aniLeft = 1;
            }
        }
        */
    }
}
