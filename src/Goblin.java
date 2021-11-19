package src;

public class Goblin extends Character {
    static final String NAME = "Goblin";
    static final int HEALTH = 20;
    static final int MANA = 0;
    static final int BASEDAMAGE = 2;
    static final int[] STARTINGLOCATION = {3, 3};
    
    public Goblin() {
        super(NAME, HEALTH, MANA, BASEDAMAGE, STARTINGLOCATION);
    }
}
