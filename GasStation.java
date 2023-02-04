import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Talal Aleisa, Naif Binkhathlan) 
 */ 
public class GasStation extends OtherObject
{

    private static int Objcount;
    /**
     * Constructor for objects of class GasStation.
     * 
     */
    public GasStation() {
        this.Objcount++;
    }

    /**
     * Act - do whatever the GasStation wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.moveDown();
        super.checkRemoveObject();
    } 

    public int getObjCount() {
        return this.Objcount;
    }
    //Prints the attributes of the class
    public String toString() {
        return "Class GasStation" + "\n" +
        "Objcount = " + getObjCount() ;
    }
}
