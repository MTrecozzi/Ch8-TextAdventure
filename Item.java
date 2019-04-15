
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{   // Completing the Item Class
    private String name;
    private int itemWeight;
    private String takeString;

    /**
     * Constructor for objects of class Item
     */
    public Item(String _name)
    {
        // initialise instance variables
       this.name = _name;
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
