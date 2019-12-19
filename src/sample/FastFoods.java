package sample;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class FastFoods extends Food implements Serializable {

    static private final long serialVersionUID = 2L;

    static private ObservableList<FastFoods> fastFoods = FXCollections.observableArrayList();

    transient private final SimpleIntegerProperty transFat = new SimpleIntegerProperty();
    transient private final SimpleIntegerProperty saturatedFat = new SimpleIntegerProperty();
    transient private final SimpleStringProperty chainName = new SimpleStringProperty("");
    transient private  Image myImage ;

     public FastFoods(String name, int servingSize, int calories, double fat, int sodium, int carbs, int transFat, int saturatedFat, String chainName, Image newImage){
         super(name,servingSize,calories,fat,sodium,carbs);

         setTransFat(transFat);
         setSaturatedFat(saturatedFat);
         setChainName(chainName);
         setMyImage(newImage);
     }

     public static ObservableList<FastFoods> getFastFoodsList() {
         return fastFoods;
     }

     public Image getMyImage()  {
         return myImage;
     }
     public void setMyImage(Image myImage)  {
         this.myImage = myImage;
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
              carbs,  transFat,  saturatedFat,  chainName, null);
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
                        carbs,  transFat,  saturatedFat,  chainName, null);
                fastFoods.add(newFastFoods);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }

    static void saveData(FileOutputStream file) {
        // serialize the program's data in this order:
        // 1. Number of albums in albums list
        // 2. Each individual album object
        // 3. The avatar image
        try {
            // Objects/values will be written to this object stream
            ObjectOutputStream out = new ObjectOutputStream(file);

            // 1. Save the number of albums in list
            out.writeInt(fastFoods.size());
            // 2. Save each album object
            for (int i = 0; i < fastFoods.size(); i = i + 1) {
                out.writeObject(fastFoods.get(i));
            }

            // Done saving; close the object stream
            out.close();
        } catch (Exception ex) {
            System.out.println("Save exception: ");
            ex.printStackTrace();
        }
    }

    static void restoreData(FileInputStream file) {
        // deserialize the program's data in this order:
        // 1. Number of albums in albums list
        // 2. Each individual album object
        // 3. The avatar image
        try {
            // Objects/values will be read from this object stream
            ObjectInputStream in = new ObjectInputStream(file);

            // 1. Restore the amount of albums in list
            int numberOfFastFoods = in.readInt();
            // 2. Restore each album object
            for (int i = 0; i < numberOfFastFoods; i = i + 1) {
                in.readObject();
            }

            // Done restoring data; close the object stream
            in.close();
        } catch (Exception ex) {
            System.out.println("Restore exception: ");
            ex.printStackTrace();
        }
    }
    private void writeObject(ObjectOutputStream outStream) throws IOException {
        // Do generic object write first
        outStream.defaultWriteObject();

        // Now write the 7 specific fields for an individual album object
        outStream.writeUTF(getChainName());
        outStream.writeUTF(getName());
        outStream.writeInt(getServingSize());
        outStream.writeInt(getCalories());
        outStream.writeDouble(getTotalFat());
        outStream.writeInt(getSodium());
        outStream.writeInt(getCarbs());
        outStream.writeInt(getTransFat());
        outStream.writeInt(getSaturatedFat());
        if (myImage != null) {
            outStream.writeLong(200L);
            ImageIO.write(SwingFXUtils.fromFXImage(myImage, null), "png", outStream);
            outStream.writeLong(300L);
        } else {
            outStream.writeLong(150L);
        }

    }

    private void readObject(ObjectInputStream inStream) throws IOException, ClassNotFoundException {
        // Do generic object read first
        inStream.defaultReadObject();
        // Now read the 7 specific fields for an individual album object
        String chainName = inStream.readUTF();
        String name = inStream.readUTF();
        int servingSize = inStream.readInt();
        int calories = inStream.readInt();
        double totalFat = inStream.readDouble();
        int sodium = inStream.readInt();
        int carbs = inStream.readInt();
        int transFat = inStream.readInt();
        int saturatedFat = inStream.readInt();

        long magicNumber = inStream.readLong();
        Image newImage = null;
        if (magicNumber != 150) {
            // 4. Restore the avatar
            newImage = SwingFXUtils.toFXImage(ImageIO.read(inStream), null);
            // 5. Read and ignore the long buffer between avatar image and end of file
            inStream.readLong();
        }

        // Now that we read all of the individual album's data, create the album and add it to the list
        FastFoods food = new FastFoods(name, servingSize, calories, totalFat, sodium, carbs, transFat, saturatedFat, chainName, newImage);
        fastFoods.add(food);
    }
    static void addFastFood() {
        fastFoods.add(new FastFoods( "", 0, 0, 0, 0,0, 0, 0 , "", null));
    }

    static void deleteFastFood(FastFoods fastFood) {
        fastFoods.remove(fastFood);
    }

}