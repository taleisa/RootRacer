import greenfoot.*; 
// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Talal Aleisa, Naif Binkhathlan) 
 */ 
public class RoadsCar extends OtherObject
{
    private static int Rate = 1;
    private static int Speed = 2;
    private static int Objcount;
    private static int NextLevel = 2500;
    /**
     * Constructor for objects of class RoadsCar.
     * 
     */

    public RoadsCar() {
        this.Objcount++;
    }

    /**
     * Act - do whatever the RoadsCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveDown();
        super.checkRemoveObject();
        increaseLevel();
    }

    public void moveDown() {
        setLocation(getX(),getY() + this.Speed);
    }
    //As the levels increase as do the difficulty
    public void increaseLevel() {
        if(CarWorld.getScore() == NextLevel) {
            Rate++;
            Speed++;
            NextLevel+= 2500;
        }
    }
    //getters
    public int getSpeed() {
        return Speed;
    }

    public int getRate() {
        return Rate;
    }

    public int getNextLevel() {
        return NextLevel;
    }

    public int getObjCount() {
        return this.Objcount;
    }
    //setters
    public void setRate(int Rate) {
        this.Rate = Rate;
    }

    public void setSpeed(int Speed) {
        this.Speed = Speed;
    }

    public void setNextLevel(int NextLevel) {
        this.NextLevel = NextLevel;
    }

    //Prints the attributes of the class
    public String toString() {
        return "Class RoadCar" + "\n" +
        "Rate = " + getRate() + "\n" +
        "Speed = " + getSpeed() + "\n" +
        "NextLevel = " + getNextLevel() + "\n" +
        "Objcount = " + getObjCount() ;
    }
}

