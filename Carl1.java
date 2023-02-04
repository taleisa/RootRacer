import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Talal Aleisa, Naif Binkhathlan) 
 */ 
public class Carl1 extends Car
{
    private static int Objcount;
    private  int Price;
    /**
     * Constructor for objects of class Carl1.
     * 
     */

    public Carl1() {
        this.Objcount++;
        this. Price = 500;
    }

    /**
     * Act - do whatever the Carl1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.moveRight();
        super.moveLeft();
        super.checkCollision();
    } 
    //getters
    public int getPrice() {
        return this.Price;
    }

    public int getObjCount() {
        return this.Objcount;
    }
    //compares the price between Carl1 and Carl3
    public int compareTo(Object temp) {
        Carl3 C3 = (Carl3) temp;
        if(getPrice() > C3.getPrice()) { return 1;}
        else if(getPrice() < C3.getPrice()) { return -1;}
        else { return 0;}

    }
    //Prints all the variables in Class
    public String toString() {
        return "Class Carl1" + "\n" +
        "Objcount = " + getObjCount() + "\n" +
        "Price = " + getPrice() + "\n" +
        "Compare To returns = " + this.compareTo(new Carl3());
    }
}
