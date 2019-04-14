import java.util.ArrayList;

/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
