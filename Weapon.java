
/**
 * The Weapon Class is an extension of Item that includes a damage value
 *
 * @author Matthew Trecozzi
 * @version 4/15/19
 */
public class Weapon extends Item
{
    // instance variables - replace the example below with your own
    int damage;

    /**
     * Constructor for objects of class Weapon
     * @param name String for name Value
     * @param _damage Weapon's damage Value
     */
    public Weapon(String name, int _damage)
    {
        super(name);
        this.damage = _damage;
    }



}
