
/*************************
 * food.java
 * represents a food item in a restaurant reservation and preorder app
 * @author Chris Carmine
 * @version 1.0
 ***********************/

public class food extends menuItem{
    
    String diet;

    public food(String c, String i, double p, String d){

        super(c,i,p);
        verifiable = false;
        diet = d; //vegetarian, vegan, nut free, no restriction...
  

    }

    public food(){

        verifiable = false;
        category = "NONE";
        itemDesc = "NONE";
        diet = "NONE";
        price = 0.00;

    }

    public String toString(){

        return category + ", " + itemDesc + ", $" + String.format("%.2f",price) + " " + diet;

    }



}
