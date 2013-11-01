import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PreWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PreWorld extends World
{
    /**
     * Constructor for objects of class PreWorld.
     * 
     */
    public PreWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Start start = new Start();
        addObject(start, 147, 510);
        Controls con = new Controls();
        addObject(con, 400, 510);
        End end = new End();
        addObject(end, 653, 510);
        
    }
}
