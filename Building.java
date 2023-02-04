import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Talal Aleisa, Naif Binkhathlan) 
 */ 
public class Building extends OtherObject
{
    private static int Objcount;
    /**
     * Constructor for objects of class Building.
     * 
     */

    public Building() {
        this.Objcount++;
    }

    /**
     * Act - do whatever the Building wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.moveDown();
        super.checkRemoveObject();
    } 
    //getter
    public int getObjCount() {
        return this.Objcount;
    }
    //Prints all the variables in Class
    public String toString() {
        return "Class Building" + "\n" +
        "Objcount = " + getObjCount() ;
    }
}
