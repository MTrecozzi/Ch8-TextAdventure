import java.util.ArrayList;

/**
 * The player is the central unit that navigates a map and interacts with the world
 *
 * @author Matthew Trecozzi
 * @version 4/14/19
 */
public class Player
{
    // instance variables - replace the example below with your own
    ArrayList<Item> inventory = new ArrayList<>();

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
  
    }
    
    public void addItem(Item itemToAdd) {
        inventory.add(itemToAdd);
        
    }
    
    public void printItems() {
        
        System.out.println("Inventory: ");
        
        inventory.stream()
        .forEach(i -> System.out.println(i.getName()));
        
    }

}
