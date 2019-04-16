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
    public static Player player;
    
    public int health = 15;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
  
    }
    
    /**
     * @return Singleton object player 
     */  
    public static Player getPlayer(){
     
     if (player == null){
         player = new Player();
        }
        
        return player;
        
    }
     /**
     * @param itemName String name of item to get from inventory
     * Searches the player's inventory for an item Object
     */
    public Item getItem(String itemName){
        
        
        for(Item item : inventory){
         if (item.getName().equalsIgnoreCase(itemName)){
         return item;    
            }
        }
        
        return null;
        
    }
    /**
     * Attempts to eat an item from the player's inventory
     */
    public void eat(String _item){
        
        Item itemToEat = getItem(_item);
        
        if (itemToEat != null){
            
               itemToEat.eat();
               inventory.remove(itemToEat);
               
        }
        
    }
    /**
     * Attempts to use an item from the player's inventory
     */
    public void use(String _item){
     
     Item itemToUse = getItem(_item);
     if (itemToUse != null){
         itemToUse.use();
         inventory.remove(itemToUse);
        }
        
    }
    /**
     * @return weight Player's total carryWeight;
     */
    public int getTotalWeight() {
     
     int weight = inventory.stream().map(s -> s.getWeight())
     .reduce(0, (total, count) -> total + count);
     
     return weight;
        
    }
    /**
     * Add an item to the player's inventory
     * @param itemToAdd Item ojbect to add
     */
    public void addItem(Item itemToAdd) {
        inventory.add(itemToAdd);
        
        
        
    }
    /**
     * Print all items in the player's inventory, as well as the health stat;
     */
    public void printItems() {
        
        System.out.println("Health: " + health);
        System.out.println("Inventory: ");
        
        inventory.stream()
        .forEach(i -> System.out.println(i.getName()));
        
        System.out.println("Carry Weight: " + getTotalWeight());
        
    }

}
