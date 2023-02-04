import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Talal Aleisa, Naif Binkhathlan) 
 */ 
public class MainMenu extends World
{
    private static int Objcount;
    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        this.Objcount++;

    }

    /**
     * Act - do whatever the MainMenu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if(Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new CarWorld());
        }
    }
    //getter
    public int getObjCount() {
        return this.Objcount;
    }
    //Prints all the variables in Class
    public String toString() {
        return "Class MainMenu" + "\n" +
        "Objcount = " + getObjCount();
    }
}
