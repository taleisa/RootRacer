import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Talal Aleisa, Naif Binkhathlan) 
 */ 
public class Correct extends RoadsCar
{
    private static int Objcount;
    /**
     * Constructor for objects of class FourxFour.
     * 
     */

    public Correct() {
        this.Objcount++;
        super.setImage(new GreenfootImage("Correct"+(Greenfoot.getRandomNumber(5)+1)+".jpg"));

    }

    /**
     * Act - do whatever the FourxFour wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.moveDown();
        randomMove();
        super.checkRemoveObject();
    }
    //Lets the object have random movement
    private void randomMove() {
        if(getX() >= 400) {setLocation(getX() - 1, getY());}
        else if(getX() <= 200) {setLocation(getX() + 1, getY());}
        else { setLocation(getX() + 1, getY());}

    }
    //getter
    public int getObjCount() {
        return this.Objcount;
    }
    //Prints all the variables in Class
    public String toString() {
        return "Class FourxFour" + "\n" +
        "Objcount = " + getObjCount() ;
    }
}
