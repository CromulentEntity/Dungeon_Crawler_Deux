// Goblin creature.

package src.actors;

public class Goblin extends Actor {
    private static final String NAME = "Goblin";
    private static final int HEALTH = 20;
    private static final int ARMOR = 5;
    private static final int MANA = 0;
    private static final int BASEDAMAGE = 10;
    private static final int EXPVALUE = 50;
    private static final int[] STARTINGLOCATION = {3, 3};
    
    // Constructor
    public Goblin() {
        super(NAME, HEALTH, ARMOR, MANA, BASEDAMAGE, EXPVALUE, STARTINGLOCATION);
    }
}
