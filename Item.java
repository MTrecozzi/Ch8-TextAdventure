
/**
 * An Item class that contains values for an Item's name and weight
 *
 * @author Matthew Trecozzi
 * @version 4/14/19
 */
public class Item
{   // Completing the Item Class
    protected String name; // the item's name
    protected int itemWeight; // the item's weight
    protected String takeString; // String to inform the player that they took the item.
    protected String lookString; // String that's displayed if this item is in the room when the player uses the look command.

    /**
     * Constructor for objects of class Item
     */
    public Item(String _name)
    {
        // initialise instance variables
       this.name = _name;
       this.itemWeight = 0;
    }
    /**
     * Call this method when the eat command is used on this object within the inventory;
     */
    public void eat(){
        System.out.println("You can't eat your " + this.name);
    }
    
    public void removeFromInventory(){
         Player.getPlayer().inventory.remove(this);
    }
    /**
     * Additional Overload Constructor
     */
    public Item(String _name, String _takeString, int _weight){
        this.name = _name;
        this.takeString = _takeString;
        this.itemWeight = _weight;
        
    }
    /**
     * Call this method when the use command is used on this object within the inventory;
     */
    public void use() {
        System.out.println("You can't use this");
    }
    /**
     * Set the details that read when you look for this item within a room
     */
    public void setLookDetails(String lookDetails){
        this.lookString =  lookDetails;
    }
    /**
     * Print the String that reads when you take this item
     */
    public void printTakeString(){
     System.out.println(this.takeString);   
    }
    /**
     * Print the String that reads when you see this item
     */
    public void printLookString() {
        
        if (this.lookString != null){
            System.out.println(this.lookString);  
        }
        
        else System.out.println("a " + this.name);
    }
    /**
     * @param _name Name of the item
     * @param _weight Weight of the item
     */
    public Item(String _name, int _weight){
     this.name = _name;
     this.itemWeight = _weight;
    }
    /**
     * @return name Returns this item's String name;
     */
    public String getName() {
     return this.name;   
    }
    /**
     * @return itemWeight The Item's weight
     */
    public int getWeight() {
        return this.itemWeight;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */

}
