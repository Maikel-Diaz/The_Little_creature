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
 * @author  Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room loft, upstairsHallway, bedroom, upstairsBathroom, stairs, hallOfHouse, kitchen, exterior, livingRoom, downstairsHallway, diningRoom;
      
        // create the rooms
        loft = new Room("In the loft of the house");
        upstairsHallway = new Room("in the upstairs hallway");
        bedroom = new Room("in a bedroom");
        upstairsBathroom = new Room("in the upstairs bathroom");
        stairs = new Room("in the stairs");
        hallOfHouse = new Room("in the hall of house");
        kitchen = new Room("in the kitchen");
        exterior = new Room("Brilliant!, you left the house.");
        livingRoom = new Room("in the living room");
        downstairsHallway = new Room("in the downstairs hallway");
        diningRoom = new Room("in the dining room");
        // initialise room exits
        loft.setExit("down", upstairsHallway);
        upstairsHallway.setExit("east", stairs);
        upstairsHallway.setExit("south", upstairsBathroom);
        upstairsHallway.setExit("west", bedroom);
        upstairsHallway.setExit("up", loft);
        bedroom.setExit("east", upstairsHallway);
        upstairsBathroom.setExit("north", upstairsHallway);
        stairs.setExit("west", upstairsHallway);
        stairs.setExit("down", hallOfHouse);
        hallOfHouse.setExit("east", kitchen);
        hallOfHouse.setExit("south", exterior);
        hallOfHouse.setExit("west", livingRoom);
        hallOfHouse.setExit("up", stairs);
        kitchen.setExit("west", hallOfHouse);
        exterior.setExit("north", hallOfHouse);
        livingRoom.setExit("north", downstairsHallway);
        livingRoom.setExit("east", hallOfHouse);
        livingRoom.setExit("northwest", diningRoom);
        downstairsHallway.setExit("south", livingRoom);
        downstairsHallway.setExit("west", diningRoom);
        diningRoom.setExit("east", downstairsHallway);
        diningRoom.setExit("southeast", livingRoom);
        
        currentRoom = loft;  // start game outside
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
        System.out.println("Welcome to the little creature!");
        System.out.println("The little creature is a new entertaining, aventure game, about a small criature that lives in the loft of a house.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printLocationInfo();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
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
        System.out.println("inside the house");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
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
            printLocationInfo();
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
    
    /**
     * Guarda información que utilizan los metodos printWelcome y goRoom.
     */
    private void printLocationInfo()
    {
            System.out.println("You are " + currentRoom.getDescription());
            System.out.print(currentRoom.getExitString());
            System.out.println();
    }
}
