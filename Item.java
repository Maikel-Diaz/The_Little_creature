
/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String itemDescription;
    private int itemWeight;

    /**
     * Constructor for objects of class Item
     */
    public Item(String description, int weight)
    {
        // initialise instance variables
        itemDescription = description;
        itemWeight = weight;
    }
    
    public String getItemDescription()
    {
        return itemDescription;
    }
    
    public void setItemDescription(String newItemDescription)
    {
        itemDescription = newItemDescription;
    }
    
    public int getItemWeight()
    {
        return itemWeight;
    }
    
    public void setItemWeight(int newItemWeight)
    {
        itemWeight = newItemWeight;
    }
    
    public String getInformation()
    {
        return "Item: " + getItemDescription() + " weight: " + getItemWeight() + "\n";
    }
}
