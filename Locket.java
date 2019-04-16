
/**
 * Write a description of class Locket here.
 *
 * @author (your name)
 * @version (a version number or a date)
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

    public void use() {
        
        Game.getGame().randomlyTeleport();
        
    }
}
