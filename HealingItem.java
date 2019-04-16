
/**
 * Healing Item extends item and allows functionality for the item to be eaten.
 *
 * @author Matthew Trecozzi
 * @version 4/15/19
 */
public class HealingItem extends Item
{
    // instance variables - replace the example below with your own
    
    public int healing;
    /**
     * Constructor for objects of class Edible
     */
    public HealingItem(String _name)
    {
        super(_name);
    }
    /**
     * @param _name String Item's name
     * @param healingValue Integer total health restored
     * Creates a new healingItem
     */
    public HealingItem (String _name, int healingValue){
     super(_name);
     this.healing = healingValue;
    }
    
    /**
     * Eat's the item from the player's inventory
     * Heal's the player for the appropriate amount
     * Removes the item from the player's inventory
     */
    public void eat() {
        System.out.println("You eat your " + this.name + ".");
        Player.getPlayer().health += this.healing;
        Player.getPlayer().inventory.remove(this);
        Player.getPlayer().printItems();
    }
}
