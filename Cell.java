/**
 * the class for all of the cells in the dungeon
 * 
 * @author Patrick Trahan
 */
public class Cell
{
    private Cell nextCell;
    private Cell previous;
    private Encounter encounter;
    private String symbol;
    private String item;
    private int number;
    
    /**
     * This will construct the cells and create the encounter
     * 
     * @param userNum - is the size of the Linked List
     */
    public Cell(int userNum)
    {
        encounter = new Encounter();
        encounter.setEncounter(userNum);
        setSymbol();
    }
    
    /**
     * Returns the next cell
     * @return 
     */
    public Cell getNext()
    {
        return nextCell;
    }
    
    /**
     * Sets the next Cell in the list
     * 
     * @param userNext - is an object Cell
     */
    public void setNext(Cell userNext)
    {
        nextCell = userNext;
    }
    
    /**
     * Sets the previous Cell in the list
     * 
     * @return the previous cell 
     */
    public Cell getPrevious()
    {
        return previous;
    }
    
    /**
     * Sets the previous Cell in the list
     * 
     * @param userPrevious is an object Cell
     */
    public void setPrevious(Cell userPrevious)
    {
        previous = userPrevious;
    }
    
    /**
     * Returns the encounter for the cell
     * 
     * @return 
     */
    public Encounter getEncounter()
    {
        return encounter;
    }
    
    /**
     * Gets the attack with respect to the symbol of the encounter
     * 
     * @return 
     */
    public int getAttack(int floor)
    {
        switch(symbol)
        {
            case "apostle":
                return encounter.getAttack(symbol) + (floor * 2);
            case "mob":
                return encounter.getAttack(symbol) + floor;
        }
        return encounter.getAttack(symbol);
    }
    
    /**
     * Gets the defense with respect to the symbol of the encounter
     * 
     * @return 
     */
    public int getDefense(int floor)
    {
        switch(symbol)
        {
            case "apostle":
                return encounter.getDefense(symbol) + (floor * 2);
            case "mob":
                return encounter.getDefense(symbol) + floor;
        }
        return encounter.getDefense(symbol);
    }
    
    /**
     * Returns the health
     * 
     * @return 
     */
    public int getHealth()
    {
        return encounter.getHealth(symbol);
    }
    
    /**
     * Returns the speed
     * 
     * @return 
     */
    public int getSpeed()
    {
        return encounter.getSpeed(symbol);
    }
    
    /**
     * Changes the health of the encounter
     * 
     * @param damage - is the amount of damage that it has taken
     */
    public void setHealth(int damage)
    {
        encounter.setHealth(damage, symbol);
    }
    
    /**
     * Changes the defense stat of the encounter 
     * 
     * @param damage - is the amount that the defense is changing
     */
    public void setDefense(int damage)
    {
        encounter.setDefense(symbol, damage);
    }
    
    /**
     * Calls the item and sees what item is in the cell
     * 
     * @param character - the cell the character is in
     */
    public void item(Cell character)
    {
        item = encounter.item();
        
        if(item != null)
        {
            character.getEncounter().setItem(item);
        }
    }
    
    /**
     * Sets the symbol of the encounter 
     */
    public void setSymbol()
    {
        symbol = encounter.getIcon();
    }
    
    /**
     * Returns the icon of the encounter 
     * 
     * @return 
     */
    public String getSymbol()
    {
        return symbol;
    }
}
