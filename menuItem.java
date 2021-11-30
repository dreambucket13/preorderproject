/*************************
 * menuItem.java
 * represents a menu item in a restaurant reservation and preorder app
 * @author Chris Carmine
 * @version 1.0
 ***********************/

public class menuItem {

    protected String itemDesc;
    protected double price;
    protected boolean verifiable = true; //default to verifiable
    protected String category;

    public menuItem(){

        category = "No category";
        itemDesc = "No description";
        price = 0.00;

    }

    public menuItem(String c, String i, double p){

        category = c;
        itemDesc = i;
        price = p;

    }

    public menuItem(String i){

        //constructor for free items
        itemDesc = i;

    }

    public String getItemDesc(){

        return itemDesc;
    }

    public String getCategory(){
        return category;
    }

    public double getItemPrice(){

        return price;
    }

    public boolean isVerifiable(){

        return verifiable;
    }

    public String toString(){

        return category + ", " + itemDesc + ", $" + String.format("%.2f",price);

    }
    
}
