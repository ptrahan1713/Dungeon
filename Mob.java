/**
 * The class for the mobs
 * 
 * @author Patrick Trahan 
 */
public class Mob extends Encounter
{
    private int attack = 20;
    private int defense = 20;
    private int speed = 20;
    private int health = 80;
    
    /**
     * Constructs the mob
     */
    public Mob()
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
     * Returns the defense stat
     * 
     * @return 
     */
    public int getDefense()
    {
        return defense;
    }
    
    /**
     * Changes the defense stat
     * 
     * @param number - amount being changed
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
     * resets health
     */
    public void resetHealth()
    {
        health = 90;
    }
    
    /**
     * Sets the health value
     * @param damage - value of the damage that the mob takes
     */
    public void setHealth(int damage)
    {
        health = health - damage;
        
        if(health <= 0)
        {
            System.out.println("Congrats you killed the goblin");
        }
    }
}
