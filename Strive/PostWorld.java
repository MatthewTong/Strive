import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PreWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PostWorld extends World
{
    /**
     * Constructor for objects of class PreWorld.
     * 
     */
    public PostWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 800, 1);

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Retry retry = new Retry();
        addObject(retry, 392, 372);
    }
}
