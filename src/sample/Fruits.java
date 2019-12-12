package sample;
import java.io.File;
import java.util.ArrayList;

import java.util.Scanner;

class Fruits extends Food {

    static private ArrayList<Fruits> fruits;

    private int potassium;
    private int fiber;
    private int protein;
    private int sugar;
    private int calcium;
    private int iron;

    private int vitaminA;
    private int vitaminC;

    //private int ranking;

    public Fruits(String name, String servingSize, int calories,  double fat, int sodium, int potassium, int carbs, int fiber, int sugar, int protein, int vitaminA, int vitaminC, int calcium, int iron){

        super(name,Integer.parseInt(servingSize),calories,fat,sodium,carbs);

        this.potassium = potassium;
        this.fiber = fiber;
        this.protein = protein;
        this.sugar = sugar;
        this.calcium = calcium;
        this.iron = iron;

        this.vitaminA = vitaminA;
        this.vitaminC = vitaminC;

    }

    static void readFruits(){

        fruits = new ArrayList<Fruits>();



        // create array list class field where albums will be stored
        fruits = new ArrayList<Fruits>();

        try {
            // scan data file line-by-line
            File albumDataFile = new File("res/Fruits");
            Scanner scanner = new Scanner(albumDataFile);
            int ranking = 1;
            while (scanner.hasNextLine()){
                //System.out.println("while loop");

                String str = scanner.nextLine();
                Scanner lineScanner = new Scanner(str);
                lineScanner.useDelimiter("#");
                // scan data files line by separating text between #

                // first 4 data values are always present in each line
                String name = lineScanner.next();
                String size = lineScanner.next();
                int calories = lineScanner.nextInt();
                lineScanner.nextInt();
                double fat = lineScanner.nextDouble();
                lineScanner.nextInt();
                int sodium = lineScanner.nextInt();
                lineScanner.nextInt();
                int potassium = lineScanner.nextInt();
                lineScanner.nextInt();
                int carbs = lineScanner.nextInt();
                lineScanner.nextInt();
                int fiber = lineScanner.nextInt();
                lineScanner.nextInt();
                int sugar = lineScanner.nextInt();
                int protein = lineScanner.nextInt();
                int vitaminA = lineScanner.nextInt();
                int vitaminC = lineScanner.nextInt();
                int calcium = lineScanner.nextInt();
                int iron = lineScanner.nextInt();

                Fruits newFruit = new Fruits(name,size,calories,fat,sodium,potassium,carbs,fiber,sugar,protein,vitaminA,vitaminC,calcium,iron);
                fruits.add(newFruit);
                ranking = ranking + 1;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }




    public int getPotassium() {
        return potassium;
    }

    public void setPotassium(int potassium) {
        this.potassium = potassium;
    }

    public int getFiber() {
        return fiber;
    }

    public void setFiber(int fiber) {
        this.fiber = fiber;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getCalcium() {
        return calcium;
    }

    public void setCalcium(int calcium) {
        this.calcium = calcium;
    }

    public int getIron() {
        return iron;
    }

    public void setIron(int iron) {
        this.iron = iron;
    }

    public int getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(int vitaminA) {
        this.vitaminA = vitaminA;
    }

    public int getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(int vitaminC) {
        this.vitaminC = vitaminC;
    }

    public void describe() {
        System.out.println("A serving of " + this.getServingSize() + " " + this.getName() + " has " + this.getCalories() + " calories, " + this.getTotalFat() + " grams fat, and " + this.getCarbs() + " grams of carbs.");
    }


    static void describeFruits() {
        //if (fruits.size() == 0) {
            // read the albums from file
            readFruits();
        //}

        for (int i = 0; i < fruits.size(); i++) {
            fruits.get(i).describe();
        }

        // Example of how to use forEach() instead of for loop
        // albums.forEach((album) -> album.describe());
    }


}
