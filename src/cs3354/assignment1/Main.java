package cs3354.assignment1;
import java.util.Objects;
import java.util.Scanner;
import java.io.*;
/*******************************************************************************
 *
 *
 *
 ******************************************************************************/
public class Main {

    public static void main(String[] args) {

        // Define Main class member variables.
        boolean loopMenu = true;
        int skuFind;
        int menuChoice;
        int itemSku;
        int itemQuantity;
        double itemPrice;
        String itemTitle;
        final String FILE_NAME = "inventoryRecord.txt";
        Inventory storeInventory = new Inventory();

        /*
            Create a new input file instance, a new input object instance,
            and attempt to read in an object from the file. If it fails simply
            create a new "Inventory" object to store items to.
        */
        try {
            FileInputStream fileIN = new FileInputStream(FILE_NAME);
            ObjectInputStream objectIN= new ObjectInputStream(fileIN);
            storeInventory = (Inventory) objectIN.readObject();
            fileIN.close();

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            System.out.println("ERROR! There is a problem with file input from"
            + FILE_NAME + ".");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR! Class not found on input from file named"
                    + FILE_NAME + ".");
        }

        // Loop menu with inventory control options.
        do {
            System.out.println();
            System.out.println("Big Bob's Video Store Inventory Menu");
            System.out.println();
            System.out.println("1. Add Movie");
            System.out.println("2. Remove Movie");
            System.out.println("3. Find Movie by SKU");
            System.out.println("4. Display Current Inventory");
            System.out.println("5. Quit Program");
            System.out.println();
            System.out.print("Enter choice: ");
            Scanner inputMenu = new Scanner(System.in);
            menuChoice = inputMenu.nextInt();

            switch(menuChoice){
                case 1:

                    // Prompt for new DVD from user.
                    System.out.println("-- Add A New Movie --");
                    System.out.println();

                    // Get SKU of movie from user.
                    Scanner inputOne = new Scanner(System.in);
                    System.out.print("Enter SKU: ");
                    itemSku = inputOne.nextInt();

                    // Get Title of movie from user.
                    System.out.println();
                    Scanner inputTwo = new Scanner(System.in);
                    System.out.print("Enter Title: ");
                    itemTitle = inputTwo.nextLine();

                    // Get Price of movie from user.
                    System.out.println();
                    Scanner inputThree = new Scanner(System.in);
                    System.out.print("Enter Price: $");
                    itemPrice = inputThree.nextDouble();

                    // Get Quantity of movie from user.
                    System.out.println();
                    Scanner inputFour= new Scanner(System.in);
                    System.out.print("Enter Quantity: ");
                    itemQuantity = inputFour.nextInt();

                    // Create a new ItemDVD object and add it to the store's
                    // current inventory list.
                    ItemDVD new_dvd = new ItemDVD(itemSku, itemTitle, itemPrice,
                            itemQuantity);
                    storeInventory.addItem(new_dvd);
                    break;

                case 2:

                    // Prompt for DVD to find from user.
                    System.out.println("-- Remove Movie by SKU --");
                    System.out.println();
                    System.out.print("Enter SKU of Movie to remove: ");
                    Scanner inputFive = new Scanner(System.in);
                    skuFind = inputFive.nextInt();
                    storeInventory.removeItem(skuFind);
                    break;

                case 3:

                    // Prompt for DVD to find from user.
                    System.out.println("-- Lookup Movie by SKU --");
                    System.out.println();
                    System.out.print("Enter SKU of Movie to Find: ");
                    Scanner inputSix = new Scanner(System.in);
                    skuFind = inputSix.nextInt();
                    storeInventory.displayItem(skuFind);
                    break;

                case 4:

                    // Display current inventory list.
                    System.out.println();
                    storeInventory.displayInventory();
                    break;

                case 5:

                    System.out.println("Thanks For the Inventory! Have a " +
                            "great day");
                    loopMenu = false;
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid Option! Please choose 1. 2. " +
                            "3. 4. or 5.");
            }

        } while(loopMenu);

        /*
            Create a new output file instance, a new output object instance,
            and attempt to write an object to the file. If it fails simply
            create a new "Inventory" object to store items to.
        */
        try {
            FileOutputStream fileOUT = new FileOutputStream(FILE_NAME);
            ObjectOutputStream objectOUT = new ObjectOutputStream(fileOUT);
            objectOUT.writeObject(storeInventory);
            fileOUT.close();
        } catch (IOException e) {
            System.out.println("ERROR! There is a problem writing to "
                    + FILE_NAME + ".");;
        }
    }
}
