/**
 * A class for procedurally generating other key classes such as Rooms and Items
 *
 * @author Matthew Trecozzi
 * @version 4/14/19
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
     * Generates and returns a randomized Starting Room;
     */
    public static Room getStartingRoom() {
        
        Room startingRoom = new Room();
        
        startingRoom.setDescription("Reach a new height in an unfamiliar lair...");
        startingRoom.setExit("east", Generator.getRandomRoom());
        
        return startingRoom;
        
    }
    /**
     * Will be developed to generate a new map to explore, complete with and an exit, loot, and enemies
     */
    // Needs to be moved to a Map Class;
    public static void generateMappedRoom() {
        
        
        // convert direction into 
        
        
    }
    
    /**
     * Will be developed to generate a random Room object;
     */
    public static Room getRandomRoom() {
        
        Room randomRoom = new Room();
        randomRoom.setDescription("This is a boring room");
        
        return randomRoom;    
    }
}
