
import java.util.Random;
import java.util.Scanner;

/**
 * This is blueprint for the Dungeon game
 *
 * @author Patrick Trahan
 */
public class Dungeon implements DungeonInterface
{

    private Scanner scnr = new Scanner(System.in);
    private Random rand = new Random();
    private Cell startCell;
    private Cell character;
    private int size = 0;
    private String move;
    private String answer;
    private int randFight = 0;
    private int floor = 1;

    /**
     * This is the intro text for the game.
     */
    public void intro()
    {
        System.out.println("Welcome Black Swordsman...\n");
        System.out.println("There is an apocalypse happening and only you can stop it");
        System.out.println("You can enter cells to fight mobs or maybe even an apostle(which is a boss)");
        System.out.println("Level yourself up and climb the dungeon");
        System.out.println("so you can end this apocalypse");
        System.out.println("Good luck our fellow Black swordsman... \n");
    }

    /**
     * The method to run the whole game
     */
    @Override
    public void game()
    {
        intro();
        
        System.out.println("Welcome to floor 1\n");
        
        while (true)
        {
            setup();
            move();
        }
    }

    /**
     * Creates the layout of the dungeon
     */
    public void setup()
    {
        for (int i = 0; i <= 8; i++)
        {
            addCell();
        }
        searchCharacter();
    }

    /**
     * Searches for where the character is in the linked list
     */
    public void searchCharacter()
    {
        Cell temp = startCell;

        //This will loop until the cell is character
        while (!"x".equals(temp.getSymbol()))
        {
            temp = temp.getNext();
        }

        character = temp;
    }

    /**
     * Asks the user where they want to move in the linked list
     */
    public void move()
    {
        boolean correct = false;
        
        System.out.println();
        
        printDungeon();

        //loops to make sure the answer is a valid response
        while (!correct)
        {
            System.out.println("\nDo you want to move left or right?");
            System.out.print("Enter left or right: ");
            move = scnr.next();

            move = move.toLowerCase();

            switch (move)
            {
                case "left":
                    moveLeft();
                    correct = true;
                    break;
                case "right":
                    moveRight();
                    correct = true;
                    break;
                default:
                    System.out.println("\nError input is invalid!");
                    System.out.println("Try again");
                    break;
            }
        }
    }

    /**
     * This method adds a cell to the Dungeon. With a starting cell and increase
     * the other ones
     */
    public void addCell()
    {
        if (startCell == null)
        {
            //creates the first cell if there are no other cells
            startCell = new Cell(getSize());
        } else
        {
            //stays one behind the temp Cell
            Cell previous = startCell;

            Cell temp = startCell.getNext();

            //loops until temp is null
            while (temp != null)
            {
                previous = temp;
                temp = temp.getNext();
            }
            //creates the temp Cell
            temp = new Cell(getSize());

            //connects the temp to the next Cell
            previous.setNext(temp);

            //connects previous as the previous Cell
            temp.setPrevious(previous);

            //connects the temp as previous to the starting Cell
            startCell.setPrevious(temp);
        }
        size++;
    }

    /**
     * This will allow the user to move to the right cell
     */
    public void moveRight()
    {
        if (" ".equals(character.getNext().getSymbol()))
        {
            System.out.println("\nThe Cell you are entering is empty");
            System.out.println("Take a breather, you'll need it");
            
            removeIndex(1);
        } else
        {
            System.out.println("\nThe Cell you are entering has a " + character.getNext().getSymbol());

            if ("apostle".equals(character.getNext().getSymbol()) || "mob".equals(character.getNext().getSymbol()))
            {
                boolean correct = false;

                while (!correct)
                {
                    System.out.println("\nDo you have to run or fight?");
                    System.out.print("Enter (run or fight): ");

                    answer = scnr.next();
                    answer = answer.toLowerCase();

                    switch (answer)
                    {
                        case "fight":
                            System.out.println("\nGood luck in your fight");
                            Cell enemy = character.getNext();
                            correct = true;
                            fight(enemy);
                            break;
                        case "run":
                            System.out.println("\nYou have taken " + character.getNext().getAttack(floor) + " damage");
                            character.setHealth(character.getNext().getAttack(floor));
                            correct = true;
                            break;
                        default:
                            System.out.println("\nThe input you entered is invalid");
                            System.out.println("Try again");
                            break;
                    }
                }
                removeIndex(1);
            } else if ("exit".equals(character.getNext().getSymbol()))
            {
                exit();
            } else
            {
                character.getNext().item(character);
                removeIndex(1);
            }
        }
        
        move();
    }

    /**
     * This will allow the user to move to the left cell
     */
    public void moveLeft()
    {
        if (" ".equals(character.getPrevious().getSymbol()))
        {
            System.out.println("\nThe Cell you are entering is empty");
            System.out.println("Take a breather, you'll need it");

            removeIndex(getSize() - 1);
        } else
        {
            System.out.println("\nThe Cell you are entering has a " + character.getPrevious().getSymbol());

            if ("apostle".equals(character.getPrevious().getSymbol()) || "mob".equals(character.getPrevious().getSymbol()))
            {
                boolean correct = false;

                while (!correct)
                {
                    Cell enemy = character.getPrevious();

                    System.out.println("\nDo you have to run or fight?");
                    System.out.print("Enter (run or fight): ");

                    answer = scnr.next();
                    answer = answer.toLowerCase();

                    switch (answer)
                    {
                        case "fight":
                            correct = true;
                            fight(enemy);
                            break;
                        case "run":
                            correct = true;
                            System.out.println("\nYou have taken " + enemy.getAttack(floor) + " damage");
                            character.setHealth(enemy.getAttack(floor));
                            break;
                        default:
                            System.out.println("\nThe input you entered is invalid");
                            System.out.println("Try again");
                            break;
                    }
                }
                removeIndex(getSize() - 1);
            } else if ("exit".equals(character.getPrevious().getSymbol()))
            {
                exit();
            } else
            {
                character.getPrevious().item(character);
                removeIndex(getSize() - 1);
            }
        }

        move();
    }

    /**
     * Resets everything in the game set everything to null or 0 then call setup
     */
    public void exit()
    {
        floor++;
        
        System.out.println("\nWelcome to floor " + floor);

        //resets all of the values;
        character = null;
        startCell = null;
        size = 0;

        //restarts the dungeon
        setup();
    }

    /**
     * This is the battle method
     *
     * @param enemy - the cell of the enemy
     */
    public void fight(Cell enemy)
    {
        boolean battleOver = false;
        int damage;

        while (!battleOver)
        {
            randFight = rand.nextInt(2);

            // 50/50 chance of character or enemy attacking first
            if (randFight < 1)
            {
                if (character.getAttack(floor) > enemy.getDefense(floor))
                {
                    damage = character.getAttack(floor) - enemy.getDefense(floor);
                    System.out.println("\nCongrats you did " + damage + " to the " + enemy.getSymbol() + " attack!");

                    enemy.setHealth(damage);

                    if (enemy.getHealth() <= 0)
                    {
                        battleOver = true;
                    } else
                    {
                        System.out.println("\nThe " + enemy.getSymbol() + "'s health is now " + enemy.getHealth());
                        System.out.println();
                    }
                } else
                {
                    System.out.println("\nYou have done no damage to the " + enemy.getSymbol());
                }

                enemy.setDefense(2);
            } else
            {
                if (enemy.getAttack(floor) > character.getDefense(floor))
                {
                    damage = enemy.getAttack(floor) - character.getDefense(floor);

                    System.out.println("\nUnfortunately you have taken " + damage + " from an " + enemy.getSymbol());

                    character.setHealth(damage);

                    System.out.println("\nYour health is now " + character.getHealth());
                } else
                {
                    System.out.println("\nYou defended against the " + enemy.getSymbol() + "'s attack");
                }

                character.setDefense(2);
            }
        }
    }

    /**
     * Returns the size of the list
     *
     * @return
     */
    public int getSize()
    {
        return size;
    }

    /**
     * Prints the dungeon and makes sure you are at the center of the list of
     * cells
     */
    public void printDungeon()
    {
        Cell forward = null;
        Cell back = null;
        int count = 1;
        int middle = 0;
        int odd = 0;

        //this will be the variables to print the rest of the Dungeon
        back = character.getPrevious();
        forward = character.getNext();

        if (getSize() % 2 != 0)
        {
            middle = getSize() / 2;
        } else
        {
            middle = getSize() / 2;
            odd = middle - 1;
        }

        //this will loop to the end of the linked list so it will print correctly
        while (count != middle)
        {
            back = back.getPrevious();
            count++;
        }

        //resets count
        count = 0;

        //prints the Cells before the character
        while (count != middle)
        {
            System.out.print("[" + back.getSymbol() + "] ");
            back = back.getNext();
            count++;
        }

        //resets the counter
        count = 0;

        System.out.print("[" + character.getSymbol() + "] ");

        if (odd > 0)
        {
            while (count != odd)
            {
                System.out.print("[" + forward.getSymbol() + "] ");
                forward = forward.getNext();
                count++;
            }
        } else
        {
            while (count != middle)
            {
                System.out.print("[" + forward.getSymbol() + "] ");
                forward = forward.getNext();
                count++;
            }
        }

        System.out.println();
    }

    /**
     * Removes the last cell of the list
     */
    public void removeEnd()
    {
        Cell temp = character;
        int setter = 0;

        //previous is for the list before temp
        Cell previous = null;

        //loops till temp is null
        while (setter != getSize() - 1)
        {
            //looks at the next cell in temp to see if null
            if (temp.getNext() == null)
            {
                //if there is anything in the list the next cell will be null
                //removing the last cell
                if (previous == null)
                {
                    temp = null;
                }
            } else
            {
                previous = temp;
            }
            temp = temp.getNext();

            setter++;
        }
        //This will link the new last list to the first one
        previous.setNext(character);
        character.setPrevious(previous);
        size--;
    }

    /**
     * Removes the first cell in the list
     */
    public void removeHead()
    {
        int count = 0;
        Cell temp = null;
        if (startCell != null)
        {
            startCell = startCell.getNext();
        }

        temp = startCell;

        //this will loop until you get to the last list 
        while (count != (getSize() - 2))
        {
            temp = temp.getNext();
            count++;
        }

        //connects the last list to the first
        temp.setNext(character);
        character.setPrevious(temp);
        size--;
    }

    /**
     * Removes a cell at the index the user gives it
     *
     * @param index - is the value of which cell is being removed
     */
    public void removeIndex(int index)
    {
        int count = 0;
        Cell temp = character;

        /**
         * For the if and else if statements it either calls the removeHead,
         * removeEnd, or tells the user it is out of Bounds
         */
        if (index == 0)
        {
            removeHead();
        } else if ((index >= size) || (index < 0))
        {
            System.out.println("Index is outside of the range for Linked List");
        } else if (index == (size - 1))
        {
            removeEnd();
        } else
        {
            //goes till you are 1 before the cell you want to remove
            while (count != (index - 1))
            {
                //move to the next cell
                temp = temp.getNext();

                //add 1 to counts value
                count++;
            }

            /**
             * First you get 2 cells ahead and set it to the next cell in the
             * list This will connect the links
             */
            temp.setNext(temp.getNext().getNext());
            temp.getNext().setPrevious(temp);
            size--;
        }
    }
}
