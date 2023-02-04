import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.util.Scanner;
/**
 * @author (Talal Aleisa, Naif Binkhathlan) 
 */ 
public class LeaderBoard extends Actor
{

    private static int HighScore = 0;
    private String [] name = new String[5];
    private int [] Score = new int[5];
    private CarWorld CW = (CarWorld) getWorld();
    private int n = -1;
    private String[] arr = new String[10];
    private File file = new File("HighScore.txt");
    private static int Objcount;
    /**
     * Constructor for objects of class LeaderBoard.
     * 
     */

    public LeaderBoard() {
        this.Objcount++;
    }

    /**
     * Act - do whatever the Leadrerboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {

    }
    //prints out file HighScore.txt.
    public void printFile(){
        FileWriter writeFile;

        try {

            FileWriter write = new FileWriter(file);
            try (PrintWriter PW = new PrintWriter(write)) {
                for (int i=0;i<5;i++){
                    PW.println(name[i]);
                    PW.println(Score[i]);
                }

            }

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void editArray(){

        int newarr[] = new int[6]; 
        String [] newarr1 = new String[6]; 

        for (int i = 0; i < 6; i++) { 
            if (i < n) {
                newarr[i] = Score[i];
                newarr1[i] = name[i];
            }
            else if (i == n) {
                newarr[i] = CarWorld.getScore();
                newarr1[i] = CarWorld.getUserName();
            }
            else
            {
                if(i!=0){
                    newarr[i] = Score[i - 1];
                    newarr1[i] = name[i - 1];
                }
            }
        } 
        for (int i = 0; i < 5; i++) { 
            Score[i] = newarr[i];
            name[i] = newarr1[i];
        }  
    }
    //reads HighScore.txt File
    public void readFile(){
        try{
            try (Scanner R = new Scanner(file)) {
                for (int i=0;i<10;i++)
                {
                    arr[i] = R.nextLine();
                }

                for (int i=0, j=1;j<10&&i<5;j+=2,i++)
                {
                    Score[i] = Integer.parseInt(arr[j]);

                    if(Score[i] > HighScore)
                        HighScore = Score[i];
                }

                for (int i=0, j=0;j<9&&i<5;j+=2,i++)
                {

                    name[i] = arr[j];

                }
                R.close();
            }
        }catch(IOException e) {
        }
    }
    //getters
    public int getHighScore(){
        return HighScore;
    }

    public String[] getName(){
        return name;
    }

    public int[] getScore(){
        return Score;
    }

    public int getObjCount() {
        return this.Objcount;
    }
    //sets the HighScore
    public void setHighScore(){

        for (int i=0;i<5;i++)
        {
            if(CarWorld.getScore()> Score[i]){
                n = i;
                break;
            }
        }
        if (CarWorld.getScore()>HighScore)
        {
            HighScore = CarWorld.getScore();
        }
    }
    //Prints all the variables in Class
    public String toString() {
        return "Class LeaderBoard" + "\n" +
        "name = " + name.toString() + "\n" +
        "n = " + this.n  + "\n" +
        "arr =" + arr.toString() + "\n" +
        "Objcount =" + this.Objcount;
    }
}    
