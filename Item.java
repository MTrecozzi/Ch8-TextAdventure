
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{   // Completing the Item Class
    private String name; // the item's name
    private int itemWeight; // the item's weight
    private String takeString; // String to inform the player that they took the item.
    private String lookString; // String that's displayed if this item is in the room when the player uses the look command.

    /**
     * Constructor for objects of class Item
     */
    public Item(String _name)
    {
        // initialise instance variables
       this.name = _name;
       this.itemWeight = 0;
    }
    
    public Item(String _name, int _weight){
     this.name = _name;
     this.itemWeight = _weight;
    }
    
    public String getName() {
     return this.name;   
    }
    
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
