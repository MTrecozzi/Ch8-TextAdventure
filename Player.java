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
    
    public int health = 15;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
  
    }
    
    public Item getItem(String itemName){
        
        
        for(Item item : inventory){
         if (item.getName().equalsIgnoreCase(itemName)){
         return item;    
            }
        }
        
        return null;
        
    }
    
    public int getTotalWeight() {
     
     int weight = inventory.stream().map(s -> s.getWeight())
     .reduce(0, (total, count) -> total + count);
     
     return weight;
        
    }
    
    public void addItem(Item itemToAdd) {
        inventory.add(itemToAdd);
        
    }
    
    public void printItems() {
        
        System.out.println("Health: " + health);
        System.out.println("Inventory: ");
        
        inventory.stream()
        .forEach(i -> System.out.println(i.getName()));
        
        System.out.println("Carry Weight: " + getTotalWeight());
        
    }

}
