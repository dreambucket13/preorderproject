
/*************************
 * alcohol.java
 * represents an alcoholic menu item in a restaurant reservation and preorder app
 * @author Chris Carmine
 * @version 1.0
 ***********************/

public class alcohol extends menuItem{
    
    double abv;

    public alcohol(String c, String i, double p, double a){

        super(c,i,p);
        verifiable = true;
        abv = a;

    }

    public alcohol(){

        verifiable = true;
        category = "NONE";
        itemDesc = "NONE";
        abv = 0.0;
        price = 0.00;

    }
    public String toString(){

        return category + ", " + itemDesc + ", ABV: " + abv + ", $" + String.format("%.2f",price);

    }


}
