
/**
 * A subclass of Room, Portal Room allows you to use the enter command to enter the portal and win the game, if you're currently in this room.
 *
 * @author Matthew Trecozzi
 * @version 4/15/19
 */
public class PortalRoom extends Room
{
    // instance variables - replace the example below with your own
    boolean activePortal = true;

    /**
     * Constructor for objects of class PortalRoom
     * @param _title The title of the Room.
     */
    
    public PortalRoom(String _title){
     super(_title);   
    }
    /**
     * This method is called when the player attempts the 'enter' command while in this room
     * Entering the portal room wins the game.
     */
    public void enter(){
        
        System.out.println("You Won! Type 'quit' to quit, or head west to continue exploring.");
        
    }
    
    
    /**
     * @return Returns activePortal Whether or not the portal is active
     */
    public boolean hasPortal(){
        return activePortal;
    }

}
