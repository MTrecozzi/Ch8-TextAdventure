
/**
 * Write a description of class Map here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Map
{
    // instance variables - replace the example below with your own
    String name;
    private int roomSize = 10;
    Room[][] rooms = new Room[roomSize][roomSize];
    
    int currentXPos = 0;
    int currentYPos = 0;
    
    Room currentRoom = getRoom(1, 0);

    /**
     * Constructor for objects of class Map
     */
    public Map(String name)
    {
        this.name = name;
    }
    
    
    public void setExits() {
        
        for (int x = 0; x < roomSize; x++) {
            
            for (int y = 0; y < roomSize; y++) {
                
                setExit(x , y);
                
            }
            
        }
        
    }
    
    public void setExit(int x, int y) {
        
        Room roomToSet = rooms[x][y];
        
        if (getRoom(x, y) == null) {
         return;   
        }
     
        // if room to the right is not null
        if (getRoom(x + 1, y) != null) {
            // set rooms exit east to the room to the right
            roomToSet.setExit("east", this.getRoom(x + 1, y));
        }
             
        // if room to the left is not null
        if (getRoom(x - 1, y) != null) {
            // set rooms exit west to the room to the left
            roomToSet.setExit("west", this.getRoom(x - 1, y));
        }
        
        if (getRoom(x, y + 1) != null) {
            // set rooms exit north to room above
            roomToSet.setExit("north", this.getRoom(x, y + 1));
        }
        
        if (getRoom(x, y - 1) != null) {
            // set rooms exit north to room above
            roomToSet.setExit("south", this.getRoom(x, y - 1));
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setRoom(Room room, int x, int y)
    {
        // put your code here
        if (x >= 0 && y >= 0) {
            rooms[x][y] = room;
        }
        
    }
    
    public Room getRoom(int x, int y) {
        
        if (x >= 0 && y >= 0) {
          return rooms[x][y];  
        } else return null;
        
        
    }
}
