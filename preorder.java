/*************************
 * preorder.java
 * main executable representing a restaurant reservation and preorder app
 * @author Chris Carmine
 * @version 1.0
 ***********************/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class preorder {

    public static void main(String[] args){

        //initalize the various restaurants

        restaurant PourHouse = new restaurant("Pour House");
        PourHouse.addMenuItem(new food("App","Mozzarella Sticks",8.99,"None"));
        PourHouse.addMenuItem(new food("App","Poutine",9.99,"None"));
        PourHouse.addMenuItem(new food("App","Edamame",9.99,"Vegan"));
        PourHouse.addMenuItem(new alcohol("Beer","Hazy IPA",5.99,6.7));
        PourHouse.addMenuItem(new alcohol("Beer","Pilsner",4.99,4.2));
        PourHouse.addMenuItem(new alcohol("Cocktail","Grapefruit Crush",9.99,9.9));
        PourHouse.addMenuItem(new seating("Booster"));
        PourHouse.addMenuItem(new seating("High Chair"));

        restaurant ChikFilA = new restaurant("ChikFilA");
        ChikFilA.addMenuItem(new food("App","Chicken Nuggets",4.99,"None"));
        ChikFilA.addMenuItem(new food("App","Fries",2.99,"None"));
        ChikFilA.addMenuItem(new food("Soft Drink","Milk",9.99,"None"));
        ChikFilA.addMenuItem(new seating("Booster"));
        ChikFilA.addMenuItem(new seating("High Chair"));

        //arraylist of restaurants
        ArrayList<restaurant> restaurants = new ArrayList<restaurant>();

        restaurants.add(PourHouse);
        restaurants.add(ChikFilA);

        int i = 1; //index for user selection
        System.out.println("Available restaurants:");
        for (restaurant r : restaurants){
            System.out.printf("%d: %s%n",i,r.getName());
            i++;
        }
        
        restaurant selectedRestaurant = null; //need to initialize, value set in try/catch
        Scanner input= new Scanner(System.in);

        //validate restuarant selection input
        boolean inputOK = false;
        while(!inputOK){

            try {
                System.out.println("Enter the number next to your restaurant:");
                selectedRestaurant = restaurants.get(Integer.parseInt(input.next())-1); 
                //parseInt and next (avoid nextLine) prevent infinite loops in VScode
                inputOK = true;
            } catch(NumberFormatException ex){
                inputOK = false;
                System.out.println("Please enter a number.");
            } catch(IndexOutOfBoundsException ex){
                inputOK = false;
                System.out.println("Restaurant not found.  Enter the number next to your restaurant:");
            } 
            
        }

        //validate input on selecting the time slot
        inputOK = false;
        int selectedTime=0;

        System.out.println("Please reserve a time by entering the number beside the slot:");
        while(!inputOK){

            //validate time reservation input
            try {
                for (int t=0;t<selectedRestaurant.getTimes().length;t++){
                    System.out.printf("%d: %s%n",t+1,selectedRestaurant.printSlot(t));
                }
                selectedTime = Integer.parseInt(input.next());
                selectedRestaurant.reserveSlot(selectedTime-1);
                inputOK = true;
            } catch(NumberFormatException ex){
                inputOK = false;
                System.out.println("Please enter a number.");
            } catch(IndexOutOfBoundsException ex){
                inputOK = false;
                System.out.println("Time slot not found.  Enter the number next to your desired time slot.");
            } 
            catch(InternalError ex){
                //reserveSlot throws internal error if the slot is already reserved
                inputOK = false;
                System.out.println("Time slot is unavailable, please try another.");
            } 
        }

        int item = 0;
        int qty=0;
        String cont = "y";
        String inputString;
        orderItem order = null;

        ArrayList<orderItem> totalOrder = new ArrayList<orderItem>();

        // main while loop for adding items

        while (cont.equals("y")){

            //print menu using polymorphism, include food, alcohol, seating

            i = 1; //selection index for user
            for (menuItem m : selectedRestaurant.getMenu()){
                System.out.printf("%d: %s%n",i,m.toString());
                i++;
            }
            //validate user input for item selection
            inputOK = false;
            while(!inputOK){
                try{
                    System.out.println("Enter the item you would like:");
                    inputString = input.next();
                    item = Integer.parseInt(inputString);
                    selectedRestaurant.getItem(item-1);
                    inputOK=true;
                }
                catch (IndexOutOfBoundsException ex){
                    System.out.println("Item could not be found");
                    inputOK = false;
                }
                 catch(NumberFormatException ex){
                    inputOK = false;
                    System.out.println("Please enter a number.");
                 }
            } 
            
            //validate quantity input
            inputOK = false;
            while(!inputOK){
                System.out.println("Enter the quantity:");
                inputString = input.next();

                try{
                    qty = Integer.parseInt(inputString);
                    inputOK = true;
                }
                catch (NumberFormatException ex){
                    inputOK = false;
                    System.out.println("Please enter a number.");
                }

                if (qty <= 0){
                    inputOK = false;
                    System.out.println("Quantity has to be at least 1!");
                } 

  
            }

        order = new orderItem(selectedRestaurant.getItem(item-1),qty);

        if (order.isVerified() || !order.getItem().isVerifiable()){
        totalOrder.add(order);
        } else {

            System.out.println("Your age must be verified to place this order. How fast was your first modem in kbps?");
            //validate age verification input
            try {
                if (Double.parseDouble(input.next())<= 56.6){
                    order.verifyAge(true);
                    System.out.println("Age verified, thank you!");
                }
            } 
            catch (InputMismatchException ex) {
                order.verifyAge(false);
            }
            catch (NumberFormatException ex) {
                order.verifyAge(false);
            }

            if (order.isVerified()){
                totalOrder.add(order);
            } else {
                System.out.println("Sorry, cannot verify age. Item not added.");
            }
        }


        //ask user to keep adding items or not
        System.out.println("Enter y to add more items.  Any other key to stop.");
        cont = input.next();

        
        }//input order while loop

        input.close();

        //print out final order details
        double totalCost = 0.0;

        System.out.printf("%s: %s%n",selectedRestaurant.getName(),selectedRestaurant.printSlot(selectedTime-1));
        System.out.println("Your total order:");
        for (orderItem o : totalOrder){
            totalCost = o.getExtPrice()+totalCost;
            System.out.println(o.toString());
        }

    
        System.out.printf("Your total preorder is $%.2f.  See you soon!%n",totalCost);

    } // main
    
} //class
