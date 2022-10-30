/**
 * The boss class for the boss Encounter
 * 
 * @author Patrick Trahan
 */
public class Boss extends Encounter
{
    private int attack = 25;
    private int defense = 25;
    private int speed = 20;
    private int health = 110;
    
    /**
     * Constructs the boss 
     */
    public Boss()
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
     * increments the attack stat
     */
    public void setAttack()
    {
        attack++;
    }
    
    /**
     * increments the defense stat
     */
    public void addDefense()
    {
        defense++;
    }
    
    /**
     * resets the health
     */
    public void resetHealth()
    {
        health = 110;
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
     * Returns the speed stat
     * 
     * @return 
     */
    public int getSpeed()
    {
        return speed;
    }
    
    /**
     * Returns the health stat
     * 
     * @return 
     */
    public int getHealth()
    {
        return health;
    }
    
    /**
     * Changes the value for health
     * @param damage - the damage value taken
     */
    public void setHealth(int damage)
    {
        health = health - damage;
        
        if(health <= 0)
        {
            System.out.println("Congrats you have defeated the Apostle");
        }
    }
}
