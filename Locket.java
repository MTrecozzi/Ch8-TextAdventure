
/**
 * The Locket class is an extension of Item with a special 'use' functionality
 *
 * @author Matthew Trecozzi
 * @version 4/15/19
 */
public class Locket extends Item
{
    


    /**
     * Constructor for objects of class Locket
     */
    public Locket(String _name)
    {
       
       super(_name);
       
    }
    /**
     * When used by the player, have the Game object randomly teleport them to a completely random room;
     */
    public void use() {
        
        Game.getGame().randomlyTeleport();
        
    }
}
