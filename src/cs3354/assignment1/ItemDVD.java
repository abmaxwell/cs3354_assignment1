package cs3354.assignment1;

/*******************************************************************************
 @author Alexander Maxwell
 Date: 02/01/2017
 @version 1.0
 Class Name: ItemDVD
 Description: <p> This class defines what a "DVD" item is including SKU, Title,
 Price, and Quantity. It provides a constructor to initialize each
 parameter in addition to the normal setters and getters to set specific
 descriptors. </p>
 //@param sku a unique identifier to differentiate the DVD.
 //@param title the specific title of DVD.
 //@param price the current price of the DVD.
 //@param quantity the current quantity stock of the DVD.

 ******************************************************************************/

public class ItemDVD {

    // Define ItemDVD class member variables.
    private int sku;
    private String title;
    private double price;
    private int quantity;

    // Define ItemDVD class constructors including default and initializer.

    // Default
    public ItemDVD(){
        sku = 0;
        title = "";
        price = 0.00;
        quantity = 0;
    }

    // Initializer
    public ItemDVD(int sku, String title, double price, int quantity){
        this.sku = sku;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    // Define ItemDVD class methods including setter's, getter's, and mutator's.

    // Setters
    public void setSku(int sku) {
        this.sku = sku;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getters
    public int getSku() {
        return sku;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
