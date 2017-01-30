package cs3354.assignment1;

import java.io.Serializable;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Locale;


/*******************************************************************************
 @author Alexander Maxwell
 Date: 02/01/2017
 @version 1.0
 Class Name: Inventory
 Description: <p> This class defines an inventory. It is designed to interact
 with "Item...." class instantiations. Items maybe added or removed, and an
 individual item information may be displayed or a current list of item's in
 the inventory maybe listed as a table.
 </p>


 ******************************************************************************/
public class Inventory implements Serializable {


    // Define Inventory class member variables
    private ArrayList <ItemDVD> currentInventory = new ArrayList<ItemDVD>();

    // Define Inventory class default constructor.
    public Inventory(){

    }


    /*
    Method: addItem
    Type: Boolean
    Description: Adds a new ItemDVD object to the current Inventory object's
    inventory list.
    Param: ItemDVD class object
    Return: Adds passed object to Inventory object's array list. Returns "True"
    if the item was added successfully, and return "False" if the item was added
    unsuccessfully.
     */
    public boolean addItem (ItemDVD new_dvd){
        return currentInventory.add(new_dvd);
    }
    /*
    Method: removeItem
    Type: Boolean
    Description: Removes a ItemDVD object from the current Inventory if it
    exists in the inventory.
    Param: SKU (int) of item to be removed.
    Return: Returns "True" if an item was successfully removed, and returns
    "False" if the item was not found in the inventory.
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
    Param: SKU (int) of item to be removed.
    Return: None.
     */
    public void displayItem (int sku){
        // Define method specific variables.
        ItemDVD currentDVD = new ItemDVD();
        boolean itemFound = false;
        int foundIndex;

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
            System.out.println("SKU: " + currentDVD.getSku());
            System.out.println("Title: " + currentDVD.getTitle());
            System.out.println("Price: $" + currentDVD.getPrice());
            System.out.println("Quantity: " + currentDVD.getQuantity());
        } else {
            System.out.println("ERROR! The SKU '" + sku + "' not found! " +
                    "Please check your SKU and try again.");
        }
    }
    /*
    Method: displayInventory
    Type: Void
    Description: Displays the current inventory in a table unsorted in the
    order: SKU   Quantity  Price  Title.
    Param: None
    Return: None.
     */
    public void displayInventory(){
        // Define method specific variables.
        ItemDVD currentDVD;
        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

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
