/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Matthew Trecozzi
 * @version 4/14/19
 */

import java.util.HashMap;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    
    // to be offload to level class
    private HashMap<Integer, String> rooms = new HashMap<>();
    
    // Change to singlton system, refrence old canvas project
    private Player player = new Player();
    private Map homeMap;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {

        createHomeMap();
        parser = new Parser();
        
        // RandomizeMap();
    }
    
    public static void main (String[] args) {
        
        Game gameObject = new Game();
        gameObject.play();
        
    }
    /**
     * Create the initial map and link the exits of all rooms within; 
     */
    // Initialize the Home Map
    public void createHomeMap() {     
        // create Map for starting area
        homeMap = new Map("Mysterious Dungeon");
        
        // Create and initialize a room
        Room startingWell = new Room ("Mysterious Well");
        startingWell.setInitialDescription("You awake from a darkness, the space you're in contains a mysterious well");
        startingWell.setDescription("The room is vaguely lit with a blue menacing aura." + " A dark well sways lightly in the moonlight.");
        // Add it to the map.
        homeMap.setRoom(startingWell, 1,0);
        
        Room armory = new Room("The Armory");
        armory.setInitialDescription("You arrive in a desolate armory, it hasn't been used in years by the looks of it.");
        armory.setDescription("The abandoned armory of a dedicated smithy");
        armory.setLookDetails("You spot a Shield reinforced with Steel");
        homeMap.setRoom(armory, 0,0);
        
        Room bladeSmithy = new Room ("The Abandoned Blade Smithy");
        bladeSmithy.setDescription("A place where weapons of great power were forged");
        homeMap.setRoom(bladeSmithy, 2,0);
        
        Room prisonCell = new Room("The Darkened Cell");
        prisonCell.setDescription("A cell where beings of great power were traded, contained and stocked");
        homeMap.setRoom(prisonCell, 1,1);
        
        Room torchRoom = new Room("The Kindled Room");
        torchRoom.setDescription("A room is lit by fiery torches lining the walls");
        homeMap.setRoom(torchRoom, 2,1);
        
        Room longHall = new Room("The Endless Hall");
        longHall.setDescription("The hall protrudes north seemingly endlessly...");
        homeMap.setRoom(longHall, 2, 2);
        
        Room diningRoom = new Room("The Dilapidated Banquet");
        diningRoom.setDescription("A banquet hall is abandoned by its long lost proprietors");
        homeMap.setRoom(diningRoom, 2,3);
        
        Room cellar = new Room("The Cellar, Lost To Time");
        homeMap.setRoom(cellar, 2,4);
        
        Room furnace = new Room("A roaring furnace lights a desolate attic");
        homeMap.setRoom(furnace, 1,4);
        
        // Call our current map to set the exits of all rooms within its rooms[][];
        homeMap.setExits();
        this.currentRoom = startingWell;
        
        
        
        
    }



    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("You're in in an unfamiliar place...");
        System.out.println("It's barely lit well enough to see.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        
        
        
        currentRoom.printInitialDescription();
        currentRoom.visited = true;
        currentRoom.printDescription();
        currentRoom.printExits();
        
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
            case LOOK:
            if (currentRoom.getLookDetails() != null){
             System.out.println(currentRoom.getLookDetails());   
            } else System.out.println("You inspect the room, but find no meaningful details");
            break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("through a forgotten dungeon");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            
            currentRoom = nextRoom;
            System.out.println("You arrive in " + currentRoom.getTitle());
            
            if (!currentRoom.visited) {
              currentRoom.printInitialDescription();
              currentRoom.visited = true;
            }
            
            currentRoom.printDescription();
            currentRoom.printExits();

        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
