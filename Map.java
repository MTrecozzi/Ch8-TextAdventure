import java.util.Random;
/**
 * The map class stores a specific [][] of Rooms, used to organize the game world in 2D space and provide room management.
 *
 * @author Matthew Trecozzi
 * @version 4/14/19
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
    
    /**
     * Set the Exits of all room's within the rooms[][];
     */
    public void setExits() {
        
        for (int x = 0; x < roomSize; x++) {
            
            for (int y = 0; y < roomSize; y++) {
                
                setExit(x , y);
                
            }
            
        }
        
    }
    /**
     * Set the exit of a specific room
     */
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
    /**
     * @return returnRoom Returns a random Room
     */
    public Room returnRandomRoom(){
        
        Room returnRoom = null;
        Random rand = new Random();
        do {
            
            int x = rand.nextInt(roomSize);
            int y = rand.nextInt(roomSize);
            
            returnRoom = getRoom(x, y);
            
        } while (returnRoom == null);
        
        return returnRoom;
        
    }
    /**
     * @return room Returns the room at a specific point in the rooms[][], returns null if no rooms are found
     */
    public Room getRoom(int x, int y) {
        
        if (x >= 0 && y >= 0) {
          return rooms[x][y];  
        } else return null;
        
        
    }
}
