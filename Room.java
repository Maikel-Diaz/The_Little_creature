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
 * @author  Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    private String description;
    private Item itemRoom;

    private HashMap<String, Room> exits;
    private ArrayList<Item> listaDeObjetos;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        listaDeObjetos = new ArrayList<Item>();
        exits = new HashMap<>();
        
    }

    /**
     * Define the exits of this room.
     */
    public void setExit(String direction, Room nextRoom)
    {
        exits.put(direction, nextRoom);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Devuleve la direccion correspondiente.
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

    /**
     * Return a description of the room's exits.
     * For example: "Exits: north east west"
     * @ return A description of the available exits.
     */
    public String getExitString()
    {
        Set<String> directions = exits.keySet();
        String descriptionReturn = "Exit ";
        for(String direction : directions){
            descriptionReturn = descriptionReturn + direction + "  ";
        }
        return descriptionReturn;
    }

    /**
     * Return a long description of this room, of the form:
     * You are in the 'name of room'
     * Exits: north west southwest
     * @return A description of the room, including exits.
     */
    public String getLongDescription()
    {
        String datos = "";
        datos = "You are " + description + ". " + "\n" + "OH! Here is something, " + getItem() + "\n" + getExitString();
        
        return datos;
    }
    
    /**
     * Metodo para añadir objetos.
     */
    public void addItem(String itemDescription , int itemWeight)
    {
        Item itemNew = new Item(itemDescription ,itemWeight);
        listaDeObjetos.add(itemNew);
    }
    
    public String getItem()
    {
        String item = "";
        if(listaDeObjetos.size() == 0){
            item = "There aren't objects.";
        }
        else{
            for(Item objects : listaDeObjetos){
                item += objects.getInformation();
            }
        }
        return item;
    }

}
