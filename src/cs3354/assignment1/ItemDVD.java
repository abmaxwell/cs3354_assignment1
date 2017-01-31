package cs3354.assignment1;
import java.io.Serializable;

/*******************************************************************************
 @author Alexander Maxwell
 Date: 02/01/2017
 @version 1.0
 @since 1.0
 Class Name: ItemDVD
 Description: <p> This class defines what a "DVD" item is including SKU, Title,
 Price, and Quantity. It provides a constructor to initialize each
 parameter in addition to the normal setters and getters to set specific
 descriptors. </p>
 ******************************************************************************/

public class ItemDVD implements Serializable {

    // Define ItemDVD class member variables.
    private int sku;
    private String title;
    private double price;
    private int quantity;

    // Define ItemDVD class constructors including default and initializer.

    // Default constructor. Initializes each of the member variables.
    public ItemDVD(){
        sku = 0;
        title = "";
        price = 0.00;
        quantity = 0;
    }

    /*
    Overloaded constructor. Allows initialization each of the member variables
    by user.

    @param (int) SKU. The unique sku of the item.
    @param (String) Title. The title of the item.
    @param (double) Price. The specific price of the item in the format 0.00.
    @param (int) Quantity. The specific quantity of the item.
    */
    public ItemDVD(int sku, String title, double price, int quantity){
        this.sku = sku;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    // Define ItemDVD class methods including setter's, getter's, and mutator's.

    /*
        @param (int) SKU. Sets the unique sku of the item post instantiation.
    */
    public void setSku(int sku) {
        this.sku = sku;
    }
    /*
        @param (String) Title. Sets the title of the item post instantiation.
    */
    public void setTitle(String title) {
        this.title = title;
    }
    /*
        @param (double) Price. Sets the price of the item post instantiation.
    */
    public void setPrice(double price) {
        this.price = price;
    }
    /*
        @param (int) Quantity. Sets the quantity of the item post instantiation.
    */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /*
        @param (int) SKU. Gets the unique sku of the item post instantiation.
    */
    public int getSku() {
        return sku;
    }
    /*
        @param (String) Title. Getss the title of the item post instantiation.
    */
    public String getTitle() {
        return title;
    }
    /*
        @param (double) Price. Gets the price of the item post instantiation.
    */
    public double getPrice() {
        return price;
    }
    /*
        @param (int) Quantity. Gets the quantity of the item post instantiation.
    */
    public int getQuantity() {
        return quantity;
    }
}
