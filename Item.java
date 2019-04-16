
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
    
    public void eat(){
        System.out.println("You can't eat your " + this.name);
    }
    
    public Item(String _name, String _takeString, int _weight){
        this.name = _name;
        this.takeString = _takeString;
        this.itemWeight = _weight;
        
    }
    
    public void use() {
        System.out.println("You can't use this");
    }
    
    public void setLookDetails(String lookDetails){
        this.lookString =  lookDetails;
    }
    
    public void printTakeString(){
     System.out.println(this.takeString);   
    }
    
    public void printLookString() {
        
        if (this.lookString != null){
            System.out.println(this.lookString);  
        }
        
        else System.out.println("a " + this.name);
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
