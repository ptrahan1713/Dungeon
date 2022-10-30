import java.util.Random;

/**
 * The class for the items in the Encounter
 * 
 * @author Patrick Trahan
 */
public class Item extends Encounter
{
    private Random rand;
    private String item;
    
    /**
     * creates the item
     */
    public Item()
    {
        super();
    }
    
    /**
     * Randomly picks an item and returns the item
     * 
     * @return 
     */
    public String items()
    {
        System.out.print("You walked into a Cell with ");
        
        rand = new Random();
        int randItem = rand.nextInt(4);
        
        switch(randItem)
        {
            case 0:
                System.out.println("a black sword");
                item = "sword";
                break;
            case 1:
                System.out.println("a health potion");
                item = "potion";
                break;
            case 2:
                System.out.println("a piece of armor");
                item = "armor";
                break;
            default:
                System.out.println("an old item");
                System.out.println("Unfortunately it's no longer usable");
                break;
        }
        return item;
    }
}
