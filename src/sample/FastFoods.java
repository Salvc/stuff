package sample;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FastFoods extends Food implements Serializable {

    static private ObservableList<FastFoods> fastFoods = FXCollections.observableArrayList();

    transient private final SimpleIntegerProperty transFat = new SimpleIntegerProperty();
    transient private final SimpleIntegerProperty saturatedFat = new SimpleIntegerProperty();
    transient private final SimpleStringProperty chainName = new SimpleStringProperty("");

     public FastFoods(String name, int servingSize, int calories, int fat, int sodium, int carbs, int transFat, int saturatedFat, String chainName){
         super(name,servingSize,calories,fat,sodium,carbs);

         setTransFat(transFat);
         setSaturatedFat(saturatedFat);
         setChainName(chainName);


     }

     public static ObservableList<FastFoods> getFastFoodsList() {
         return fastFoods;
     }

     public int getTransFat() {
         return transFat.get();
     }

     public void setTransFat(int transFat) {
         this.transFat.set(transFat);
     }

     public int getSaturatedFat() {
         return saturatedFat.get();
     }

     public void setSaturatedFat(int saturatedFat) {
         this.saturatedFat.set(saturatedFat);
     }

     public String getChainName() {
         return chainName.get();
     }

     public void setChainName(String chainName) {
         this.chainName.set(chainName);
     }



    static void readFastFoods(){
     if (fastFoods != null){
       return;
     }
    fastFoods = FXCollections.observableArrayList();

     try {
         File FastFoodsDataFile = new File("res/FastFoods");
         Scanner scanner = new Scanner(FastFoodsDataFile);


         int ranking = 1;
         while (scanner.hasNextLine()) {
             String str = scanner.nextLine();
             Scanner lineScanner = new Scanner(str);
             lineScanner.useDelimiter("#");

             String chainName = lineScanner.next();
             String name = lineScanner.next();
             int servingSize = lineScanner.nextInt();
             int calories = lineScanner.nextInt();
             int fat = (int)lineScanner.nextDouble();
             int saturatedFat = (int)lineScanner.nextDouble();

             int transFat = (int)lineScanner.nextDouble();
             int carbs = lineScanner.nextInt();
             int sodium = lineScanner.nextInt();

             FastFoods newFastFoods = new FastFoods(name,  servingSize,  calories,  fat,  sodium,
              carbs,  transFat,  saturatedFat,  chainName);
             fastFoods.add(newFastFoods);
         }
     } catch(Exception ex) {
             ex.printStackTrace();
     }

    }

    public String m(int a){

         if(a == -1){
             return ("Unknown");
         }else {
             return "" + a;
         }



    }

    public void describe() {
         System.out.println( this.getChainName() + " has the serving of " + this.getServingSize() +" grams of " + this.getName() + " has " + m(this.getCalories()) + " calories, "
                 + m((int)this.getTotalFat()) + " grams of fat, and " + m(this.getCarbs()) + " grams of carbs. As well as, " +  m(this.getTransFat()) + " grams of trans fat and " + m(this.getSaturatedFat())
                 + " grams of saturated fat.");
    }

    static void describeFastFoods() {

    if (fastFoods == null) {
            readFastFoods();
        }

        for (int i = 0; i < fastFoods.size(); i++) {
            fastFoods.get(i).describe();
        }

    }


    static int getAmount() {
        readFastFoods();
         return fastFoods.size();
    }

    static FastFoods getFastFood(int i) {
        readFastFoods();
        return fastFoods.get(i);
    }

    static void importFastFoods(File dataFile){

        try {
            Scanner scanner = new Scanner(dataFile);


            int ranking = 1;
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                Scanner lineScanner = new Scanner(str);
                lineScanner.useDelimiter("#");

                String chainName = lineScanner.next();
                String name = lineScanner.next();
                int servingSize = lineScanner.nextInt();
                int calories = lineScanner.nextInt();
                int fat = (int)lineScanner.nextDouble();
                int saturatedFat = (int)lineScanner.nextDouble();

                int transFat = (int)lineScanner.nextDouble();
                int carbs = lineScanner.nextInt();
                int sodium = lineScanner.nextInt();

                FastFoods newFastFoods = new FastFoods(name,  servingSize,  calories,  fat,  sodium,
                        carbs,  transFat,  saturatedFat,  chainName);
                fastFoods.add(newFastFoods);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }
    static void addFastFood() {
        fastFoods.add(new FastFoods( "", 0, 0, 0, 0,0, 0, 0 , ""));
    }

    static void deleteFastFood(FastFoods fastFood) {
        fastFoods.remove(fastFood);
    }

}