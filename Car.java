import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Talal Aleisa, Naif Binkhathlan) 
 */ 

public abstract class Car extends Actor implements Comparable
{

    private static int Objcount;
    /**
     * Cons tructor for objects of class Car.
     * 
     */
    public Car() {
        this.Objcount++;
    }

    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

    }

    public void moveRight()
    {       if(Greenfoot.isKeyDown("right")){
            int x_current = super.getX();
            int y_current = super.getY();
            int x_new = x_current+3; // +3 to move the car 3 pixels on the x-axis
            setLocation(x_new, y_current);
        }
    }

    public void moveLeft()
    {   if(Greenfoot.isKeyDown("left")){
            int x_current = super.getX();
            int y_current = super.getY();
            int x_new = x_current-3; // -3 to move the car 3 pixels on the x-axis
            setLocation(x_new, y_current);
        }
    }

    public void moveUp()
    {   if(Greenfoot.isKeyDown("up")){
            int x_current = super.getX();
            int y_current = super.getY();
            int y_new = y_current-3; // +3 to move the car 3 pixels on the y-axis
            setLocation(x_current, y_new);
        }
    }  

    public void moveDown()
    {   if(Greenfoot.isKeyDown("down")){
            int x_current = super.getX();
            int y_current = super.getY();
            int y_new = y_current+3; // +3 to move the car 3 pixels on the y-axis
            setLocation(x_current, y_new);
        }
    }   
    //checks if the hero had any kind if Collision
    public void checkCollision() {
        CarWorld CW = (CarWorld) getWorld();
        Actor [] AC = new Actor[3];
        AC[0] = getOneIntersectingObject(Incorrect.class);
        AC[1] = getOneIntersectingObject(Correct.class);
        AC[2] = getOneIntersectingObject(GasStation.class);

        if(AC[2] != null) {
            CW.setFuel(100);
            removeTouching(GasStation.class);
        } 
        if(AC[1] != null) {
            CW.setScore(CW.getScore() + 1);
            Greenfoot.playSound("Coin.mp3");
            removeTouching(Correct.class);
        } 
        if(AC[0] != null) {
            CW.setLives(CW.getLives() - 1);
            Greenfoot.playSound("Crash.mp3");
            removeTouching(Incorrect.class);
        }
        if(getX() >= 450 || getX() <= 150) {
            CW.setScore(CW.getScore() - 100);
           // Greenfoot.playSound("Crash.mp3");
           // CW.setLives(CarWorld.getLives()-1);
            setLocation(300,550);
        }
    }
    //getter
    public int getObjCount() {
        return this.Objcount;
    }
    //Prints all the variables in Class
    public String toString() {
        return "Class Car" + "\n" +
        "Objcount = " + getObjCount() ;
    }

}
