import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Talal Aleisa, Naif Binkhathlan) 
 */ 
public class Coin extends OtherObject
{
    private static int Objcount;
    /**
     * Constructor for objects of class Coin.
     * 
     */
    public Coin() {
        this.Objcount++;
    }

    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
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
    //Prints the attributes of the class
    public String toString() {
        return "Class Coin" + "\n" +
        "Objcount = " + getObjCount() ;
    }
}
