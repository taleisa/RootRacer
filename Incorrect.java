import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author (Talal Aleisa, Naif Binkhathlan) 
 * 
 */
public class Incorrect extends RoadsCar
{
    private static int Objcount;
    /**
     * Constructor for objects of class Truck.
     * 
     */

    public Incorrect() {
        this.Objcount++;
        super.setImage(new GreenfootImage("Incorrect"+(Greenfoot.getRandomNumber(5)+1)+".jpg"));

    }

    /**
     * Act - do whatever the Truck wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.moveDown();
        super.checkRemoveObject();
        Greenfoot.playSound("Siren2.mp3");
    }
    //getter
    public int getObjCount() {
        return this.Objcount;
    }
    //Prints all the variables in Class
    public String toString() {
        return "Class Truck" + "\n" +
        "Objcount = " + getObjCount() ;
    }
}
