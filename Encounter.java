import java.util.Random;

/**
 * This will create the encounters for every cell in the game
 *
 * @author Patrick Trahan
 */
public class Encounter
{
    private String icon;
    private Random rand;
    private Character character;
    private Exit exit;
    private Boss boss;
    private Item item;
    private Mob mob;
    
    /**
     * Creates the encounter class
     */
    public Encounter()
    {

    }
    
    /**
     * This will set the encounter for the cell
     *
     * @param types - is the certain size of the cells and is the counter for the encounters
     */
    public void setEncounter(int types)
    {
        rand = new Random();
        
        switch (types)
        {
            case 0:
            {
                //character encounter
                character = new Character();
                icon = "x";
                break;
            }
            case 1:
            {
                //exit encounter
                exit = new Exit();
                icon = "exit";
                break;
            }
            default:
                int randEncounter = rand.nextInt(4);
                switch (randEncounter)
                {
                    case 0:
                    {
                        //Boss encounter
                        boss = new Boss();
                        icon = "apostle";
                        break;
                    }
                    case 1:
                    {
                        //Item
                        item = new Item();
                        icon = "item";
                        break;
                    }
                    case 2:
                    {
                        //Mob
                        mob = new Mob();
                        icon = "mob";
                        break;
                    }

                    default:
                        //Empty encounter
                        icon = " ";
                        break;
                }
                break;
        }
    }
    
    /**
     * Returns the icon
     * 
     * @return 
     */
    public String getIcon()
    {
        return icon;
    }
    
    /**
     * Returns the attack stat
     * 
     * @param icon - icon for the encounter 
     * @return 
     */
    public int getAttack(String icon)
    {
        if(icon.equals("x"))
        {
            return character.getAttack();
        }
        else if(icon.equals("mob"))
        {
            return mob.getAttack();
        }
        return boss.getAttack();
    }
    
    /**
     * Returns the defense stat
     * 
     * @param icon - icon for the encounter
     * @return 
     */
    public int getDefense(String icon)
    {
        if(icon.equals("x"))
        {
            return character.getDefense();
        }
        else if(icon.equals("mob"))
        {
            return mob.getDefense();
        }
        return boss.getDefense();
    }
    
    /**
     * Return the speed stat
     * 
     * @param icon - icon for the encounter 
     * @return 
     */
    public int getSpeed(String icon)
    {
        if(icon.equals("x"))
        {
            return character.getSpeed();
        }
        else if(icon.equals("mob"))
        {
            return mob.getSpeed();
        }
        return boss.getSpeed();
    }
    
    /**
     * Returns the health stat
     * 
     * @param icon - icon for the encounter
     * @return 
     */
    public int getHealth(String icon)
    {
        if(icon.equals("x"))
        {
            return character.getHealth();
        }
        else if(icon.equals("mob"))
        {
            return mob.getHealth();
        }
        return boss.getHealth();
    }
    
    /**
     * Sets the defense stat
     * 
     * @param icon - icon for the encounter 
     * @param damage - amount of damage taken
     */
    public void setDefense(String icon, int damage)
    {
        switch (icon)
        {
            case "x":
                character.setDefense(damage);
                break;
            case "mob":
                mob.setDefense(damage);
                break;
            default:
                boss.setDefense(damage);
                break;
        }
    }
    
    /**
     * Sets the item to the character stats
     * 
     * @param icon - icon for the encounter 
     */
    public void setItem(String icon)
    {
        switch (icon)
        {
            case "sword":
                character.setAttack(2);
                System.out.println("\nYour attack increased to " + character.getAttack());
                break;
            case "potion":
                character.incHealth(5);
                System.out.println("\nYour health increased to " + character.getHealth());
                break;
            default:
                character.incDefense(2);
                System.out.println("\nYour defense increased to " + character.getDefense());
                break;
        }
    }
    
    /**
     * Changes the health stat for an encounter 
     * 
     * @param damage - amount of damage taken 
     * @param icon - icon for the encounter 
     */
    public void setHealth(int damage, String icon)
    {
        switch (icon)
        {
            case "x":
                character.setHealth(damage);
                break;
            case "mob":
                mob.setHealth(damage);
                break;
            default:
                boss.setHealth(damage);
                break;
        }
    }
    
    /**
     * Returns the icon
     * 
     * @return 
     */
    public String item()
    {
        return item.items();
    }
}
