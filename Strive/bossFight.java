import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bossFight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bossFight extends World
{

    /**
     * Constructor for objects of class bossFight.
     * 
     */
    public bossFight()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        bgBoss scrollingbackground = new bgBoss();
        addObject(scrollingbackground, 400, 300);
        
        
        DescentRight descentright = new DescentRight();
        addObject(descentright, 723, 594);
        descentright.setLocation(716, 587);
        SmallAscent smallascent = new SmallAscent();
        addObject(smallascent, 64, 585);
        SmallAscent smallascent2 = new SmallAscent();
        addObject(smallascent2, 159, 589);
        SmallAscent smallascent3 = new SmallAscent();
        addObject(smallascent3, 366, 592);
        SmallAscent smallascent4 = new SmallAscent();
        addObject(smallascent4, 473, 594);
        SmallAscent smallascent5 = new SmallAscent();
        addObject(smallascent5, 579, 590);
        LeftThirdStair leftthirdstair = new LeftThirdStair();
        addObject(leftthirdstair, 775, 330);
        leftthirdstair.setLocation(770, 323);
        TopLevel toplevel = new TopLevel();
        addObject(toplevel, 260, 597);
        LargeAscent largeascent = new LargeAscent();
        addObject(largeascent, 316, 541);
        largeascent.setLocation(309, 535);
        DescentLeft descentleft = new DescentLeft();
        addObject(descentleft, 105, 226);
        descentleft.setLocation(92, 301);
        DescentRight descentright2 = new DescentRight();
        addObject(descentright2, 707, 457);
        descentright2.setLocation(715, 462);
        SmallAscent smallascent7 = new SmallAscent();
        addObject(smallascent7, 535, 440);
        smallascent7.setLocation(479, 461);
        
        Boss1 boss = new Boss1();
        addObject(boss, 749, 397);
        
        PlayerHP bar = new PlayerHP();
        
        Player player = new Player(bar);
        addObject(player, 350, 450);
        
        StatusHUD hud = new StatusHUD();
        addObject(hud, 116, 50);
        addObject(bar, 180, 38);
    }
}
