
/*************************
 * restaurant.java
 * represents a restaurant in a restaurant reservation and preorder app
 * @author Chris Carmine
 * @version 1.0
 ***********************/
import java.util.ArrayList;

public class restaurant {
    
    private String name;
    private ArrayList<menuItem> menu;
    private String[][] timeSlot = {{"12PM","Open"},{"1PM","Open"},{"2PM","Open"},{"3PM","Open"},{"2PM","Open"},
                                   {"3PM","Open"},{"4PM","Open"},{"5PM","Open"},{"6PM","Reserved"},{"7PM","Open"},
                                   {"8PM","Open"},{"9PM","Open"}};

    public restaurant(String n){
        name = n;
        menu = new ArrayList<menuItem>();
    }
    

    public String[][] getTimes(){

        return timeSlot;

    }

    public String printSlot(int t){

        return timeSlot[t][0] + " " + timeSlot[t][1];
    }

    public void reserveSlot(int t) throws InternalError{

        if (timeSlot[t][1].equals("Open")){
            timeSlot[t][1] = "Reserved";
        } else {
            throw new InternalError();
        }

    }

    public void addMenuItem(menuItem item){
        menu.add(item);
    }

    public ArrayList<menuItem> getMenu(){

        return menu;

    }

    public String getName(){

        return name;

    }

    public menuItem getItem(int i){

        return menu.get(i);

    }



}
