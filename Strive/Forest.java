import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Forest extends World
{
    GreenfootSound backgroundMusic = new GreenfootSound("horror.mp3");
    /**
     * Constructor for objects of class TestWorld.
     * 
     */
    public Forest()
    {    
        // Create a new world with 600x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false); 
        //backgroundMusic.playLoop();

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        ScrollingBackground scrollingbackground = new ScrollingBackground();
        addObject(scrollingbackground, 960, 0);        
        
        ComplexFloor complexfloor = new ComplexFloor();
        addObject(complexfloor, 372, 555);  

        LargeColumn largecolumn = new LargeColumn();
        addObject(largecolumn, 541, 145);

        LeftFirstStair leftfirststair = new LeftFirstStair();
        addObject(leftfirststair, 347, 486);

        LeftSecondStair leftsecondstair = new LeftSecondStair();
        addObject(leftsecondstair, 413, 439);

        LeftThirdStair leftthirdstair = new LeftThirdStair();
        addObject(leftthirdstair, 437, 392);

        LargeAnchorAscent largeanchorascent = new LargeAnchorAscent();
        addObject(largeanchorascent, 406, 197);

        LeftSmallStep leftsmallstep = new LeftSmallStep();
        addObject(leftsmallstep, 708, 502);

        Invisiwall invisiwall = new Invisiwall();
        addObject(invisiwall, 0, 0);
        
        Invisiwall invisiwall2 = new Invisiwall();
        addObject(invisiwall2, 1920, 0);

        TopLevel toplevel = new TopLevel();
        addObject(toplevel, 1008, -199);

        DescentLeft descentleft = new DescentLeft();
        addObject(descentleft, 710, 278);

        DescentLeft descentleft2 = new DescentLeft();
        addObject(descentleft2, 710, 86);

        MiddleLevel middlelevel = new MiddleLevel();
        addObject(middlelevel, 1427, 118);

        SmallColumn smallcolumn = new SmallColumn();
        addObject(smallcolumn, 890, 225);

        DescentRight descentright = new DescentRight();
        addObject(descentright, 766, 364);

        DescentRight descentright2 = new DescentRight();
        addObject(descentright2, 766, 180);

        SmallAscent smallascent = new SmallAscent();
        addObject(smallascent, 282, 360);

        BottomMiddle bottommiddle = new BottomMiddle();
        addObject(bottommiddle, 1050, 555);  

        BottomRight bottomright = new BottomRight();
        addObject(bottomright, 1638, 555);
        
        LargeAscent largeascent = new LargeAscent();
        addObject(largeascent, 100, 317);
        
        SmallAscent smallascent2 = new SmallAscent();
        addObject(smallascent2, 298, 225);
        
        SmallAscent smallascent3 = new SmallAscent();
        addObject(smallascent3, 349, 91);
        
        OffAscent offascent = new OffAscent();
        addObject(offascent, 125, 39);
        
        MiddleSmallStep middlesmallstep = new MiddleSmallStep();
        addObject(middlesmallstep, 840, 502);
        
        MediumAscent midascent = new MediumAscent();
        addObject(midascent, 120, -60);
        
        SmallAscent smallascent4 = new SmallAscent();
        addObject(smallascent4, 310, -91);
        
        SmallAscent smallascent5 = new SmallAscent();
        addObject(smallascent5, 375, -141);
        
        invisWall i1 = new invisWall();
        addObject(i1, 475, 321);
        invisWall i2 = new invisWall();
        addObject(i2, 475, 111);
        invisWall i3 = new invisWall();
        addObject(i3, 4, 0);
        invisWall i4 = new invisWall();
        addObject(i4, 608, 219);
        
        Enemy e1 = new Enemy();
        addObject(e1, 135, 260);
        Enemy e2 = new Enemy();
        //addObject(e2, 439, 350);
        Enemy e3 = new Enemy();
        addObject(e3, 439, 141);
        Enemy e4 = new Enemy();
        addObject(e4, 212, 4);
        Enemy e5 = new Enemy();
        addObject(e5, 775, 244);
        Enemy e6 = new Enemy();
        addObject(e6, 1096, 491);
        Enemy e7 = new Enemy();
        addObject(e7, 1527, 491);
        Enemy e8 = new Enemy();
        addObject(e8, 1074, 54);
        
        PlayerHP bar = new PlayerHP();
        
        Player player = new Player(bar);
        addObject(player, 439, 350);
        //addObject(player, 180, 490);
        
        StatusHUD hud = new StatusHUD();
        addObject(hud, 116, 50);
        addObject(bar, 180, 38);
    }
}