import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Class Room - a room in an adventure game.
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Matthew Trecozzi
 * @version 4/14/19
 */

public class Room 
{
    private String title;
    private String description;
    private String initialDescription;
    private HashMap<String, Room> exits;        // stores exits of this room.
    int xPos;
    int yPos;
    
    public ArrayList<Item> collectibles = new ArrayList<Item>();   
    private String extraDetails;
    
    public boolean visited = false;

    /**
     * Create a room titled "title". Initially, it has
     * no exits. "title" is the room's official name.
     * @param title The room's title.
     */
    public Room(String title) 
    {
        this.title = title;
        exits = new HashMap<>();
    }
    /**
     * blank constructor overload
     */
    public Room() {
     exits = new HashMap<>();   
    }
    
    
    /**
     * Called when the player attempts the enter comamnd while in this room
     */
    public void enter(){
     System.out.println("There is no where to enter further in this room.");   
    }
    
    /**
     * Returns the room's offical name
     * @return the String value of the room's title
     */
    public String getTitle() {
        return this.title;
    }
    
    /**
     * @param _item Item to add to the room
     * Adds an Item to this room's collectibles's collection;
     */
    public void addItem(Item _item) {
     collectibles.add(_item);   
    }
    /**
     * @return Returns whether or not the room has a portal;
     */
    public boolean hasPorta(){
        return false;
    }
    
    /**
     * takes an item from the collectibles array at index 0
     */
    public Item takeItem() {
     return collectibles.get(0);   
    }
    
    /**
     * Gets the sole item in a room if there is only one;
     */
    public Item getItem() {
        if (collectibles.size() == 1){
             return collectibles.get(0);
        }
       else return null;
    }
    
    /**
     * @param itemName String name of the item to search the collection for
     * @return returns the specfic item from the collection;
     */
    public Item getItem(String itemName) {
        
        for (Item item : collectibles) {
            
            if (itemName.equalsIgnoreCase(item.getName())) {
                return item;
            }
            
        }
        
        return null;
        
    }
    
    /**
     * Removes an item form the collection;
     */
    public void removeItem() {
        collectibles.set(0, null);
    }
    
    
    /**
     * Set the Details String of the room for when a player uses the look command
     * @param extraDetails When using the look command in a room, prompt the player with this string
     */
    public void setextraDetails(String extraDetails) {
        this.extraDetails = extraDetails;
    }
    /**
     * Prints the resposne to the user's look command in this room;
     */
    public void printLookDetails(){
     System.out.println("You search the room thoroughly, you find...");
     
     for(Item item : collectibles){
         item.printLookString();
        }
        
        if (this.extraDetails != null){
         System.out.println(this.extraDetails); 
        }
    }
    
    /**
     * Set the coordinates of this room;
     */
    public void setCoordinates(int x, int y) {
        xPos = x;
        yPos = y;
    }
    /**
     * Set the description of the room that reads as a first impression
     */
    public void setInitialDescription(String desc) {
        
        this.initialDescription = desc;
    }
    /**
     * Print the room's first impression String
     */
    public void printInitialDescription(){
        
        if (initialDescription != null) {
            System.out.println(initialDescription); 
        }
        
       
    }
    
    /**
     * @return xPosition
     */
    public int getX() {
     return this.xPos;   
    }
    /**
     * @return yPosition
     */
    public int getY() {
     return this.yPos;   
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    /**
     * Set the room's description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * print the room's description
     */
    public void printDescription(){
     System.out.println(getDescription());   
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    /**
     * Print the room's exits
     */
    public void printExits() {
     System.out.println(getExitString());   
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

