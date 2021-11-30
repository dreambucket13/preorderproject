
/*************************
 * orderItem.java
 * represents a order item in a restaurant reservation and preorder app
 * @author Chris Carmine
 * @version 1.0
 ***********************/

public class orderItem{


//testing git
private int qty;
private double extPrice;
private menuItem selectedItem;
private static boolean ageVerified = false; //static variable - once 1 order has been age verified, no longer require verification

public orderItem(menuItem m, int q){
    
    selectedItem = m;
    qty = q;
    //somewhat of a dirty hack to get the float to 2 decimals, didn't want to convert to string here
    //https://mkyong.com/java/how-to-round-double-float-value-to-2-decimal-points-in-java/#mathround
    extPrice = Math.round(m.getItemPrice() * (double) qty * 100.0)/100.0; 
}


public void verifyAge(boolean t){

    ageVerified = t;

}

public menuItem getItem(){

    return selectedItem;
}

public boolean isVerified(){

    return ageVerified;

}

public double getExtPrice(){

    return extPrice;

}

public String toString(){

    return selectedItem.getItemDesc() + ", qty "+ qty + ", sub total $" + extPrice;

}



}//class
