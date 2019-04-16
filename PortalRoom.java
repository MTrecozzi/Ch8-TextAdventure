
/**
 * Write a description of class PortalRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PortalRoom extends Room
{
    // instance variables - replace the example below with your own
    boolean activePortal = true;

    /**
     * Constructor for objects of class PortalRoom
     */
    
    public PortalRoom(String _title){
     super(_title);   
    }
    
    public void enter(){
        
        System.out.println("You Won! Type 'quit' to quit, or head west to continue exploring.");
        
    }
    
    
    
    public boolean hasPortal(){
        return activePortal;
    }

}
