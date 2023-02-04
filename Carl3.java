import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Talal Aleisa, Naif Binkhathlan) 
 */ 
public class Carl3 extends Carl2
{

    private static int Objcount;
    private int Price;
    /**
     * Constructor for objects of class Carl3.
     * 
     */
    public Carl3() {
        this.Objcount++;
        this.Price = 1500;
    }

    /**
     * Act - do whatever the Carl3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        playSound();
    }

    private void playSound() {
        if(Greenfoot.isKeyDown("space")) Greenfoot.playSound("CarHorn.mp3");
        else if(Greenfoot.isKeyDown("up")) Greenfoot.playSound("newExhaust.mp3");
        else if(Greenfoot.isKeyDown("down")) Greenfoot.playSound("Brakes.mp3");
    }

    public int getPrice() {
        return Price;
    }

    public int getObjCount() {
        return this.Objcount;
    }
    //Compares price between Carl3 and Carl2
    public int compareTo(Object temp) {
        Carl2 C2 = (Carl2) temp;
        if(getPrice() > C2.getPrice()) { return 1;}
        else if(getPrice()  < C2.getPrice()) { return -1;}
        else { return 0;}

    }
    //Prints all the variables in Class
    public String toString() {
        return "Class Carl3" + "\n" +
        "Objcount = " + getObjCount() + "\n" +
        "Price = " + getPrice() + "\n" +
        "Compare To returns = " + this.compareTo((new Carl2()));
    }
}
