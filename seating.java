/*************************
 * seating.java
 * represents a seating option (booster or high chair) in a restaurant reservation and preorder app
 * @author Chris Carmine
 * @version 1.0
 ***********************/

public class seating extends menuItem{
    
    static final double price = 0.00; //force price to 0 for all seating objects just in case


    public seating(String i){

        super(i);
        verifiable = false;
        itemDesc = i;
    
    }

    public seating(){

        verifiable = false;
        category = "NONE";
        itemDesc = "NONE";

    }

    public String toString(){

        return itemDesc;

    }

}
