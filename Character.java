/**
 * The class for the character encounter
 * 
 * @author Patrick Trahan
 */
public class Character extends Encounter
{
    private int attack = 30;
    private int defense = 30;
    private int health = 100;
    private int speed = 20;
    
    /**
     * Constructs the character class
     */
    public Character()
    {
        super();
    }
    
    /**
     * Returns the attack stat
     * 
     * @return 
     */
    public int getAttack()
    {
        return attack;
    }
    
    /**
     * Increases the attack stat
     * 
     * @param value - by this amount
     */
    public void setAttack(int value)
    {
        attack = attack + value;
    }
    
    /**
     * Returns the defense stat
     * 
     * @return 
     */
    public int getDefense()
    {
        return defense;
    }
    
    /**
     * Decreases the defense stat
     * 
     * @param number - by this amount
     */
    public void setDefense(int number)
    {
        defense = defense - number;
    }
    
    /**
     * Returns the health
     * 
     * @return 
     */
    public int getHealth()
    {
        return health;
    }
    
    /**
     * Increases health to a certain amount and max is 100
     * 
     * @param value - amount getting increased
     */
    public void incHealth(int value)
    {
        health = health + value;
        
        if(health > 100)
        {
            health = 100;
            System.out.println("You have hit max HP");
        }
    }
    
    /**
     * Increases defense by an amount
     * 
     * @param value - is the amount that is getting increased
     */
    public void incDefense(int value)
    {
        defense = defense + value;
    }
    
    /**
     * Returns the speed stat
     * 
     * @return 
     */
    public int getSpeed()
    {
        return speed;
    }
    
    /**
     * Changes the health of the character 
     * @param userDamage amount of damage taken to the character
     */
    public void setHealth(int userDamage)
    {
        health = health - userDamage;
        
        if(health <= 0)
        {
            System.out.println("You are DEAD");
            
            //since you are dead the game will end
            System.exit(0);
        }
    }
}
