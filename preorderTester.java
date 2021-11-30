/*************************
 * preorderTester.java
 * executable for testing a restaurant reservation and preorder app
 * @author Chris Carmine
 * @version 1.0
 ***********************/

public class preorderTester {

    public static void main(String args[]){

        String method;
        String crit; //criteria
        double dcrit;
        boolean bcrit;
        final double tol = .0001;

        //test menuItem
        menuItem test = new menuItem();

        method = "menuItem get category";
        crit = "No category";
        if (test.getCategory().equals(crit)){
            System.out.printf("%s Pass%n",method);
        } else {
            System.out.printf("%s FAIL%n",method);
        }

        method = "menuItem get description";
        crit = "No description";
        if (test.getItemDesc().equals(crit)){
            System.out.printf("%s Pass%n",method);
        } else {
            System.out.printf("%s FAIL%n",method);
        }

        method = "menuItem get price";
        dcrit = 0.0;
        if (Math.abs(test.getItemPrice()-dcrit)<=tol){
            System.out.printf("%s Pass%n",method);
        } else {
            System.out.printf("%s FAIL%n",method);
        }

        method = "menuItem isVerifiable";
        bcrit = true;
        if (test.isVerifiable() == bcrit){
            System.out.printf("%s Pass%n",method);
        } else {
            System.out.printf("%s FAIL%n",method);
        }

        //test orderItem

        menuItem testOrderMenuItem = new menuItem("App","Fries",4.99);
        orderItem testOrder = new orderItem(testOrderMenuItem,3);

        method = "orderItem toString";
        crit = "Fries, qty 3, sub total $14.97";
        if (testOrder.toString().equals(crit)){
            System.out.printf("%s Pass%n",method);
        } else {
            System.out.printf("%s FAIL%n",method);
        }

        method = "orderItem verifyAge";
        bcrit = false;
        testOrder.verifyAge(false);
        if (testOrder.isVerified() == bcrit){
            System.out.printf("%s Pass%n",method);
        } else {
            System.out.printf("%s FAIL%n",method);
        }

        //test food
        food foodTest = new food("category","item",1.00,"diet");

        method = "food isVerifiable";
        bcrit = false;
        if (foodTest.isVerifiable() == bcrit){
            System.out.printf("%s Pass%n",method);
        } else {
            System.out.printf("%s FAIL%n",method);
        }

        method = "food toString";
        crit = "category, item, $1.00 diet";
        if (foodTest.toString().equals(crit)){
            System.out.printf("%s Pass%n",method);
        } else {
            System.out.printf("%s FAIL%n",method);
        }

        //test alcohol
        alcohol alcoholTest = new alcohol("category","item",1.00, 5.0);

        method = "alcohol isVerifiable";
        bcrit = true;
        if (alcoholTest.isVerifiable() == bcrit){
            System.out.printf("%s Pass%n",method);
        } else {
            System.out.printf("%s FAIL%n",method);
        }

        method = "alcohol toString";
        crit = "category, item, ABV: 5.0, $1.00";
        if (alcoholTest.toString().equals(crit)){
            System.out.printf("%s Pass%n",method);
        } else {
            System.out.printf("%s FAIL%n",method);
        }

        //test seating
        seating seatingTest = new seating("booster");

        method = "seating isVerifiable";
        bcrit = false;
        if (seatingTest.isVerifiable() == bcrit){
            System.out.printf("%s Pass%n",method);
        } else {
            System.out.printf("%s FAIL%n",method);
        }

        method = "seating toString";
        crit = "booster";
        if (seatingTest.toString().equals(crit)){
            System.out.printf("%s Pass%n",method);
        } else {
            System.out.printf("%s FAIL%n",method);
        }

        //test restaurant
        restaurant restTest = new restaurant("test");

        method = "restaurant getMenu";
        if (restTest.getMenu().isEmpty()){
            System.out.printf("%s Pass%n",method);
        } else {
            System.out.printf("%s FAIL%n",method);
        }

        method = "restaurant reserveSlot";
        restTest.reserveSlot(0);
        if (restTest.getTimes()[0][1].equals("Reserved") ){
            System.out.printf("%s Pass%n",method);
        } else {
            System.out.printf("%s FAIL%n",method);
        }
    }
    
}
