
/**
 * Write a description of class Edible here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Edible extends Item
{
    // instance variables - replace the example below with your own
    
    public int healing;
    /**
     * Constructor for objects of class Edible
     */
    public Edible(String _name)
    {
        super(_name);
    }
    
    public Edible (String _name, int healingValue){
     super(_name);
     this.healing = healingValue;
    }
    
    public void eat() {
        System.out.println("You eat your " + this.name + ".");
        
    }
}
