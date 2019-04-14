
/**
 * Write a description of class Generator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.HashMap;
import java.util.Random;

public class Generator
{
    // instance variables - replace the example below with your own
    
    HashMap <Integer, String> directions;

    /**
     * Constructor for objects of class Generator
     */
    public Generator()
    {
        directions.put(0, "East");
        directions.put(1, "South");
        directions.put(2, "West");
        directions.put(3, "North");
        // initialise instance variables
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static Room getStartingRoom() {
        
        Room startingRoom = new Room();
        
        startingRoom.setDescription("Reach a new height in an unfamiliar lair...");
        startingRoom.setExit("east", Generator.getRandomRoom());
        
        return startingRoom;
        
    }
    
    // Needs to be moved to a Map Class;
    public static void generateMappedRoom(HashMap<Coords, Room> roomMap, Room thisRoom) {
        
        Coords pos = thisRoom.getCoordinates();
        
        Random rand = new Random();
        
        // EastCheck
        // SouthCheck
        // WestCheck
        // North Check
        
        // Generate a random valid number.
        
        int direction = rand.nextInt(4);
        // convert direction into 
        
        
    }
    
    
    public static Room getRandomRoom() {
        
        Room randomRoom = new Room();
        randomRoom.setDescription("This is a boring room");
        
        return randomRoom;    
    }
}
