import java.util.*;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    private String description;

    private HashMap<String, Room> exits;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     * @param up The up exit.
     * @param down The down exit.
     */
    public void setExits(Room north, Room east, Room south, Room west, Room up, Room down, Room southeast, Room northwest) 
    {
        if(north != null)
            exits.put("north", north);
        if(east != null)
            exits.put("east", east);
        if(south != null)
            exits.put("south", south);
        if(west != null)
            exits.put("west", west);
        if(up != null)
            exits.put("up", up);
        if(down != null)
            exits.put("down", down);
        if(southeast != null)
            exits.put("southeast", southeast);
        if(northwest != null)
            exits.put("northwest", northwest);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * 
     */
    public Room getExit(String direction)
    {
        Room roomReturned = null;
        if(direction.equals("north")){
            roomReturned = exits.get("north");
        }
        if(direction.equals("east")){
            roomReturned = exits.get("east");
        }
        if(direction.equals("south")){
            roomReturned = exits.get("south");
        }
        if(direction.equals("west")){
            roomReturned = exits.get("west");
        }
        if(direction.equals("up")){
            roomReturned = exits.get("up");
        }
        if(direction.equals("down")){
            roomReturned = exits.get("down");
        }
        if(direction.equals("southeast")){
            roomReturned = exits.get("southeast");
        }
        if(direction.equals("northwest")){
            roomReturned = exits.get("northwest");
        }
        return roomReturned;
    }

    /**
     * Return a description of the room's exits.
     * For example: "Exits: north east west"
     *
     * @ return A description of the available exits.
     */
    public String getExitString()
    {
        String descriptionReturn = "";
        if(exits.get("north") != null) {
            descriptionReturn = descriptionReturn + "north ";
        }
        if(exits.get("east") != null) {
            descriptionReturn = descriptionReturn + "east ";
        }
        if(exits.get("south") != null) {
            descriptionReturn = descriptionReturn + "south ";
        }
        if(exits.get("west") != null) {
            descriptionReturn = descriptionReturn + "west ";
        }
        if(exits.get("up") != null) {
            descriptionReturn = descriptionReturn + "up ";
        }
        if(exits.get("down") != null) {
            descriptionReturn = descriptionReturn + "down ";
        }
        if(exits.get("southeast") != null) {
            descriptionReturn = descriptionReturn + "southeast ";
        }
        if(exits.get("northwest") != null) {
            descriptionReturn = descriptionReturn + "northwest ";
        }
        return descriptionReturn;
    }

}
