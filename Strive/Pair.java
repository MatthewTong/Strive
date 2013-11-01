import java.lang.Comparable;

/**
 * Write a description of class Pair here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pair
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;

    /**
     * Constructor for objects of class Pair
     */
    public Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Pair.class)
            return false;
        if (((Pair)obj).getX() != this.x)
            return false;
        if (((Pair)obj).getY() != this.y)
            return false;
        return true;
    }
}
