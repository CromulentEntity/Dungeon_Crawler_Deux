package src.actors;

public class Goblin extends Actor {
    static final String NAME = "Goblin";
    static final int HEALTH = 20;
    static final int MANA = 0;
    static final int BASEDAMAGE = 2;
    static final int[] STARTINGLOCATION = {3, 3};
    
    // Constructor
    public Goblin() {
        super(NAME, HEALTH, MANA, BASEDAMAGE, STARTINGLOCATION);
    }
}
