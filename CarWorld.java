import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Talal Aleisa, Naif Binkhathlan) 
 */ 
import javax.swing.JOptionPane;
public class CarWorld extends World
{
    private static Bar Lives;
    private static Bar Fuel;
    private static  Counter Score;
    private static Counter Price;
    private static Counter Level = new Counter("Level: ");
    private static Counter HighScore = new Counter("HighScore: ");
    private static String userName;
    private Carl3 Car3 = new Carl3();
    private Carl2 Car2 = new Carl2();
    private Carl1 Car1= new Carl1();
    private LeaderBoard L = new LeaderBoard();
    private int Counter;
    private static int Objcount;

    /**
     * Constructor for objects of class CarWorld.
     * 
     */
    public CarWorld()
    {    
        // Create a new world with 600x600 cells with a cell size of 1x1 pixels.
        super(600, 600, 1,false);

        userName= JOptionPane.showInputDialog("Please enter your name");
        setPaintOrder (LeaderBoard.class,Bar.class,Counter.class,Car.class,RoadsCar.class,OtherObject.class,Line.class);
        setActOrder(CarWorld.class);
        prepObjects();
        this.Objcount++;

    }

    /**
     * Act - do whatever the CarWorld wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        add();
        switchingObjects();
        setNumbers();
        changeLevels();
        wonOrLost();
        HighScore.setValue(L.getHighScore());
        this.Counter++;
    }
    // Prepares Object before starting the game.
    private void prepObjects() { 
        addObject(HighScore, 90,20);
        Score =new Counter("Score: ");
        addObject(Score, 70,50);
        addObject(Level, 530,20);
        //Price = new Counter("Price: ");
        //addObject(Price, 530,50);
        Lives = new Bar("Life","/3",3,3);
        setLivesBarWidth(30);
        setLivesBarHeight(200);
        addObject(Lives, 70,300);
        addObject(Car1, 320,550);
        addObject(new Line(),300,0);
        addObject(new Line(),300,120);
        addObject(new RoadsCar(),200,0);
        Fuel = new Bar("Fuel","%",100,100);
        addObject(Fuel,325,20);

    }
    // resetting the number
    private void setNumbers() {
        //Score.setValue(Score.getValue() + 1);
        HighScore.setValue(getHighScore());
        if(Counter % 50 == 0) {setFuel(getFuel() - 1);}

    }
    //Switches  car objects dependent on score
    private void switchingObjects(){
        if(getLevel() == 1) {
            if(getObjects(null).contains(Car3)){
                addObject(Car1,Car3.getX(),Car3.getY());
                removeObject(Car3);
            }
            else if(getObjects(null).contains(Car2)){
                addObject(Car1,Car2.getX(),Car2.getY());
                removeObject(Car2);
            }
        }
        if(getLevel() == 2) {
            if(getObjects(null).contains(Car3)){
                addObject(Car2,Car3.getX(),Car3.getY());
                removeObject(Car3);
            } 
            else if(getObjects(null).contains(Car1)){
                addObject(Car2,Car1.getX(),Car1.getY());
                removeObject(Car1);
            }
        }
        if(getLevel() == 3) {
            if(getObjects(null).contains(Car1)){
                addObject(Car3,Car1.getX(),Car1.getY());
                removeObject(Car1);
            }
            else if(getObjects(null).contains(Car2)){
                addObject(Car3,Car2.getX(),Car2.getY());
                removeObject(Car2);
            }
        }
    }
    //adds other object 
    private void add(){
        RoadsCar RC = new RoadsCar();
        if(Greenfoot.getRandomNumber(400) == 1 ) {
            addObject(new Correct(),Greenfoot.getRandomNumber(getWidth()-400)+200,-30);
            addObject(new Incorrect(),Greenfoot.getRandomNumber(getWidth()-400)+200,-30);

        } 
        if(Counter % 60 == 0){
            addObject(new Line(),300,0);
            addObject(new Line(),300,120);
        }
        if(Counter % 2000 == 0) {
            addObject(new GasStation(),Greenfoot.getRandomNumber(getWidth()-400)+200,-30);
            addObject(new Building(),Greenfoot.getRandomNumber(getWidth()-500),-30);
            addObject(new Building(),Greenfoot.getRandomNumber(getWidth()-500)+500,-30);
        }
        if(Counter % 100 == 0) {
            addObject(new Tree(),Greenfoot.getRandomNumber(getWidth()-500),-30);
            addObject(new Tree(),Greenfoot.getRandomNumber(getWidth()-500)+500,-30);
        }
    }
    //sets levels depends on Score
    private void changeLevels() {
        if( getScore() < 2) {
            setLevel(1);
        }
        else if( getScore() >= 2 && getScore() < 10) {
            setLevel(2);
        }
        else if( getScore() >= 15) {
            setLevel(3);
        }
    }
    //prints out the leaderboard of either lost or won.
    private void wonOrLost() {
        if(getLives() == 0 || getFuel() == 0 || getScore() == 7500) {
            L.setHighScore();
            L.editArray();
            String [] Scores = new String[5];
            String [] name = L.getName();

            int[] Score = L.getScore();
            for (int i =0; i<5; i++)
            {
                Scores[i] = name[i] +" : "+Score[i];
                showText("Leaderboard",300,100);
                showText(name[i],250,100+((i+1)*25));
                showText(Integer.toString(Score[i]),350,100+((i+1)*25));
            }
            L.printFile();
            Greenfoot.stop();
        }
    }
    //getters
    public static String getUserName(){
        return userName;
    }

    public static int getScore(){
        return Score.getValue();
    }

    public static int getLives(){
        return Lives.getValue();
    }

    public int getFuel() {
        return this.Fuel.getValue();
    }

    public int getLevel(){
        return this.Level.getValue();
    }

    public int getPrice(){
        return Price.getValue();
    }

    public int getHighScore() {
        this.L.readFile();
        return this.L.getHighScore();
    }

    public int getObjCount() {
        return this.Objcount;
    }
    //setters
    public void setFuel(int Fuel) {
        this.Fuel.setValue(Fuel);
    }

    public void setScore(int Score){
        this.Score.setValue(Score);
    }

    public void setLevel(int Level){
        this.Level.setValue(Level);
    }

    public void setLives(int Lives){
        this.Lives.setValue(Lives);    
    }

    public void setPrice(int Price) {
        this.Price.setValue(Price);
    }

    public void setLivesBarWidth(int Width) {
        this.Lives.setBarWidth(Width);
    }

    public void setLivesBarHeight(int Height) {
        this.Lives.setBarHeight(Height);
    }
    //Prints all the variables in Class
    public String toString() {
        return "Class CarWorld" + "\n" +
        "Fuel = " + getFuel() + "\n" +
        "Score = " + getScore() + "\n" +
        "Price = " + getPrice() + "\n" +
        "Level = " + getLevel() + "\n" +
        "HighScore = " + getHighScore() + "\n" +
        "UserName = " + getUserName() + "\n" +
        "Counter = " + this.Counter + "\n" +
        "Objcount = " + getObjCount() ;
    }

   
}
