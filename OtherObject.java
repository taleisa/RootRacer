import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Talal Aleisa, Naif Binkhathlan) 
 */ 
public abstract class OtherObject extends Actor
{

    private static int Objcount;
    /**
     * Constructor for objects of class OtherObject.
     * 
     */

    public OtherObject() {
        this.Objcount++;
    }

    /**
     * Act - do whatever the OtherObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

    } 
    public void moveDown(){
        CarWorld CW = (CarWorld) getWorld();
        int x_current= super.getX();
        int y_current= super.getY();
        int y_new= y_current+ CW.getLevel();
        setLocation(x_current,y_new);

    }
    //checks and removes objects at 630 pixels
    public void checkRemoveObject() {
        if(getY() > getWorld().getHeight() + 30) {
            getWorld().removeObject(this);
        }
    }
    //Prints all the variables in Class
    public String toString() {
        return "Class OtherObject" + "\n" +
        "Objcount = " + this.Objcount ;
    }
}
