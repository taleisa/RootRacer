import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Talal Aleisa, Naif Binkhathlan) 
 */ 
public class Carl2 extends Carl1
{

    private static int Objcount;
    private int Price;
    /**
     * Constructor for objects of class Carl2.
     * 
     */
    public Carl2() {
        this.Objcount++;
        this.Price = 500;
    }

    /**
     * Act - do whatever the Carl2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        super.moveUp();
        super.moveDown();
    }
    //getters
    public int getPrice() {
        return Price;
    }

    public int getObjCount() {
        return this.Objcount;
    }
    //Compares price between Carl2 and Carl1
    public int compareTo(Object temp) {
        Carl1 C1 = (Carl1) temp;
        if(getPrice()  > C1.getPrice()) { return 1;}
        else if(getPrice()  < C1.getPrice()) { return -1;}
        else { return 0;}

    }
    //Prints all the variables in Class
    public String toString() {
        return "Class Carl2" + "\n" +
        "Objcount = " + getObjCount() + "\n" +
        "Price = " + getPrice() + "\n" +
        "Compare To returns = " + this.compareTo((new Carl1()));
    }
}
