/**
 *  This class is the main class of the "Dungeon Swell" application. 
 *  "Dungeon Swell" is a text adventure game with various features.
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

import java.util.Stack;

import java.util.HashMap;
import java.util.ArrayList;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    
    // to be offload to level class
    private HashMap<Integer, String> rooms = new HashMap<>();
    
    // Change to singlton system, refrence old canvas project
    private Player player;
    private Map homeMap;
    
    private Stack<Room> previousRooms = new Stack<>();

        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        player = Player.getPlayer();
        createHomeMap();
        parser = new Parser();
        
        // RandomizeMap();
    }
    
    public static void main () {
        
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
        armory.setInitialDescription("A desolate armory, it hasn't been used in years by the looks of it.");
        armory.setDescription("The walls are of heavy stone, there are anvils and tools for smithing.");
        
        Item shield = new Item("Shield", "You take the shield and carry it with you", 5);
        shield.setLookDetails("a 'Shield' reinforced with Steel");
        armory.addItem(shield);
        homeMap.setRoom(armory, 0,0);
        
        Room bladeSmithy = new Room ("The Abandoned Blade Smithy");
        bladeSmithy.setDescription("Rusted blades adorn the abandoned weapons site");
        homeMap.setRoom(bladeSmithy, 2,0);
        
        Room prisonCell = new Room("The Darkened Cell");
        prisonCell.setDescription("Empty prison cells fill the area, many of them broken and shattered.");
        homeMap.setRoom(prisonCell, 1,1);
        
        Room torchRoom = new Room("The Kindled Room");
        torchRoom.setDescription("Fiery torches line the walls");
        homeMap.setRoom(torchRoom, 2,1);
        
        Room longHall = new Room("The Endless Hall");
        longHall.setDescription("The hall protrudes north seemingly endlessly...");
        homeMap.setRoom(longHall, 2, 2);
        
        Room diningRoom = new Room("The Dilapidated Banquet");
        diningRoom.setDescription("A banquet hall is abandoned by its long lost proprietors");
        HealingItem apple = new HealingItem("Apple", 10);
        apple.setLookDetails("A mystical looking 'apple'.");
        diningRoom.addItem(apple);
        
        homeMap.setRoom(diningRoom, 2,3);
        
        Room cellar = new Room("The Cellar, Lost To Time");
        cellar.setDescription("The room eminates an ancient, primordial aura");
        homeMap.setRoom(cellar, 2,4);
        
        Room furnace = new Room("The Raging Furnace");
        furnace.setDescription("A roaring furnace lights the desolate attic");
        homeMap.setRoom(furnace, 1,4);
        
        Room treasureHold =  new Room("An ancient room of antiquated valuables");
        treasureHold.setDescription("Gold and other valuables shine brightly, many ornate pieces are too large to carry");
        homeMap.setRoom(treasureHold, 0, 4);
        
        Room lightWell = new Room("The Lightwell");
        lightWell.setInitialDescription("You come across another Well, however this one shines and shimmers");
        lightWell.setDescription("The second well fills you with home and urges you east");
        homeMap.setRoom(lightWell, 3, 4);
        
        Room enchanter = new Room("A room for enchanting objects and forging great power");
        homeMap.setRoom(enchanter, 4, 4);
        
        Room quarters = new Room("Resting Quarters");
        quarters.setDescription("A place to reflect and breathe for a moment");
        quarters.addItem(new Item ("Pillow"));
        homeMap.setRoom(quarters, 5, 4);
        
        Room lightGate = new Room("The Shimmering Gate");
        lightGate.setDescription("Beyond this door lies a blinding prescence, you feel a great unknown before you.");
        homeMap.setRoom(lightGate, 6,4);
        
        Room portalRoom = new Room("The Infinum Portal");
        portalRoom.setDescription("A staggering portal lies in front of you, will you enter?");
        homeMap.setRoom(portalRoom, 7,4);
                
        // Call our current map to set the exits of all rooms within its rooms[][] in accordance to their position;
        homeMap.setExits();
        //
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
        
        System.out.println("These words will guide you along the way");
        parser.showCommands();
        
        
        
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
        String subjectWord = command.getSecondWord();

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
                if (currentRoom.collectibles.size() > 0){
                 currentRoom.printLookDetails();   
                } else System.out.println("You find no meaningful details");
                break;
            case TAKE:
            
                if (subjectWord != null) {
                    
                    Item itemCheck = currentRoom.getItem(subjectWord);
                    if (itemCheck != null) {
                     
                        
                     if (itemCheck.takeString != null) {
                        itemCheck.printTakeString(); 
                    } else System.out.println("You take the item");
                        
                     player.addItem(itemCheck);
                     player.printItems();
                     
                     // need to remove item from room
                     
                     currentRoom.collectibles.remove(itemCheck);
                     
                    }
                }
                else if (subjectWord == null){
                    
                    Item itemCheck = currentRoom.getItem();
                    
                    // turn into get item method
                    if (itemCheck != null) {
                     
                     
                     itemCheck.printTakeString();   
                     
                     player.addItem(itemCheck);
                     player.printItems();
                     
                     // need to remove item from room
                     
                     currentRoom.collectibles.remove(itemCheck);
                        
                    }
                    
                } else 
                System.out.println("Nothing to take");
                break;   
                case BACK:
                
                System.out.println("You retrace your steps...");
                // sets current Room to the previous room, and refreshes the stack
                
                if (previousRooms.size() > 0){
                    loadRoom(previousRooms.pop());
                } else {
                 System.out.println("but you could not gain any sense of direction");   
                }
                   
                break;
                
                case EAT:
                
                if (subjectWord != null){
                    
                    
                    player.eat(subjectWord);
                    
                }
                
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
            
            previousRooms.push(currentRoom);
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
    
    private void loadRoom(Room nextRoom){
        
        currentRoom = nextRoom;
        System.out.println("You arrive in " + currentRoom.getTitle());
        
        if (!currentRoom.visited) {
              currentRoom.printInitialDescription();
              currentRoom.visited = true;
            }
            
            currentRoom.printDescription();
            currentRoom.printExits();
        
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
