package cs3354.assignment1;
import java.io.Serializable;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Locale;
/*******************************************************************************
 @author Alexander Maxwell
 Date: 02/01/2017
 @version 1.0
 @since 1.0
 Class Name: Inventory
 Description: <p> The Inventory class defines an inventory. It is designed to
 interact with and object of the "ItemDVD" class. Items maybe added or removed,
 and an individual items information may be displayed, or a current list of
 item's in the inventory maybe listed as a table.
 </p>
 ******************************************************************************/
public class Inventory implements Serializable {


    // Define Inventory class member variables
    private ArrayList <ItemDVD> currentInventory = new ArrayList<ItemDVD>();

    // Define Inventory class default constructor.
    public Inventory(){}

    /*
    Method: addItem
    Type: Boolean
    Description: Adds a new ItemDVD object to the current Inventory object's
    inventory list.
    Param: @param ItemDVD class object, which is a unique DVD to add to
    inventory.
    Return: @return Adds passed object to Inventory object's array list.
    Returns <CODE>True</CODE> if the item was added successfully, and returns
    <CODE>False</CODE> if the item was added unsuccessfully.
     */
    public boolean addItem (ItemDVD new_dvd) {

        /*
            Check current inventory to see if SKU of new movie matches the SKU
            of a movie already in the inventory. If it does then display and
            error to the user, otherwise add the move to the inventory.
        */

        for (int index = 0; index < currentInventory.size(); index++) {

            ItemDVD currentDVD = currentInventory.get(index);

            // Checks to see if the new item's SKU already exists.
            if (currentDVD.getSku() == new_dvd.getSku()) {
                System.out.println();
                System.out.println("ERROR! The SKU '" + new_dvd.getSku() +
                        "' is already in use. Please select a different SKU " +
                        "and try again.");
                return false;
            }
        }
        /*
            Validate the format of the price. If it's "0" then display an error,
            otherwise check to see if decimal portion of the price  has more
            than two places, if it does then display an error. Furthermore,
            validate the quantity and determine if it's less than or equal to
            "0", if it is then display an error.
        */

        // Convert price from double to string to check decimal portion.
        String currentPrice = Double.toString(new_dvd.getPrice());
        int locationDecimal = currentPrice.indexOf('.');
        String decimalPortion = currentPrice.substring(locationDecimal + 1);

        if (new_dvd.getPrice() <= 0){
            System.out.println();
            System.out.println("ERROR! Price cannot be $0.00. Minimum price" +
                    "$0.01");
                return false;
        } else if (decimalPortion.length() > 2 || decimalPortion.length() < 2){
            System.out.println();
            System.out.println("ERROR! Invalid price. Price must be formatted "
                    + "in the form #.##");
            return false;
        } else if (new_dvd.getQuantity() <= 0){
            System.out.println();
            System.out.println("ERROR! Invalid quantity. Quantity must be " +
                    "greater than 0.");
            return false;
        } else {
            return currentInventory.add(new_dvd);
        }
    }
    /*
    Method: removeItem
    Type: Boolean
    Description: Removes a ItemDVD object from the current Inventory if it
    exists in the inventory.
    Param: @param (int) Unique SKU of item to be removed.
    Return: @return Returns <CODE>True</CODE> if an item was successfully
    removed, and returns <CODE>False</CODE> if the item was not found in the
    inventory.
     */
    public boolean removeItem (int sku){
        // Define method specific variables.
        ItemDVD currentDVD;

        // Search for Arraylist position of item in inventory by sku.
        for (int index = 0; index < currentInventory.size(); index++){

            currentDVD = currentInventory.get(index);

            if(currentDVD.getSku() == sku){
                currentInventory.remove(index);
                return true;
            }
        }
        return false;
    }
    /*
    Method: displayItem
    Type: Void
    Description: Displays an item in the inventory based on SKU. It search for
    the item first. If it finds it then it's displayed, and if the item cannot
    be found then an error message is displayed.
    Param: @param (int) Unique SKU of item to be displayed.
    Return: None.
     */
    public void displayItem (int sku){
        // Define method specific variables.
        ItemDVD currentDVD = new ItemDVD();
        boolean itemFound = false;

        // Search for Arraylist position of item in inventory by sku.
        for (int index = 0; index < currentInventory.size(); index++) {
            currentDVD = currentInventory.get(index);

            if(currentDVD.getSku() == sku){
                itemFound = true;
                break;
            }
        }

        // Display item if it's found or display error if item is not found.
        if(itemFound){
            System.out.println();
            System.out.println("SKU: " + currentDVD.getSku());
            System.out.println();
            System.out.println("Title: " + currentDVD.getTitle());
            System.out.println();
            System.out.println("Price: $" + currentDVD.getPrice());
            System.out.println();
            System.out.println("Quantity: " + currentDVD.getQuantity());
        } else {
            System.out.println();
            System.out.println("ERROR! The SKU '" + sku + "' not found! " +
                    "Please check your SKU and try again.");
        }
    }
    /*
    Method: displayInventory
    Type: Void
    Description: Displays the current inventory in a table unsorted in the
    order: sku, quantity, price, title.
    Param: None
    Return: None.
     */
    public void displayInventory(){
        // Define method specific variables.
        ItemDVD currentDVD;
        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter =
                NumberFormat.getCurrencyInstance(locale);

        if (currentInventory.size() <= 0){
            System.out.println("ERROR! There's no inventory to display.");
        } else {
            System.out.format("%1$-10s %2$-15s %3$-15s %4$-15s %n", "SKU",
                    "Quantity", "Price", "Title");
            System.out.println();
            for (int index = 0; index < currentInventory.size(); index++) {
                currentDVD = currentInventory.get(index);

                System.out.format("%1$-10s %2$-15s %3$-15s %4$-15s %n",
                        currentDVD.getSku(), currentDVD.getQuantity(),
                        currencyFormatter.format(currentDVD.getPrice()),
                        currentDVD.getTitle());
            }
        }
    }
}
