package src.actors;

public class Goblin extends Actor {
    static final String NAME = "Goblin";
    static final int HEALTH = 20;
    static final int ARMOR = 5;
    static final int MANA = 0;
    static final int BASEDAMAGE = 10;
    static final int[] STARTINGLOCATION = {3, 3};
    
    // Constructor
    public Goblin() {
        super(NAME, HEALTH, ARMOR, MANA, BASEDAMAGE, STARTINGLOCATION);
    }
}
