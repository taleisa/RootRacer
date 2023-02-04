import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Talal Aleisa, Naif Binkhathlan) 
 */ 
public class Line extends OtherObject
{
    private static int Objcount;
    /**
     * Constructor for objects of class Line.
     * 
     */

    public Line() {
        this.Objcount++;
    }

    /**
     * Act - do whatever the Line wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveDown();
        super.checkRemoveObject();
    }

    public void moveDown(){
        int x_current=super.getX();
        int y_current=super.getY();
        int y_new= y_current+3;
        setLocation(300,y_new);

    }
    //getter
    public int getObjCount() {
        return this.Objcount;
    }
    //Prints the attributes of the class
    public String toString() {
        return "Class Line" + "\n" +
        "Objcount = " + getObjCount() ;
    }
}
