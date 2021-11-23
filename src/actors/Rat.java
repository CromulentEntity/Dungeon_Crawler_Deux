// A Rat. Why does it have so much mana?

package src.actors;

public class Rat extends Actor{
    private static final String NAME = "Rat";
    private static final int HEALTH = 6;
    private static final int ARMOR = 0;
    private static final int MANA = 1200;
    private static final int BASEDAMAGE = 1;
    private static final int[] STARTINGLOCATION = {2, 2};

    // Constructor
    public Rat() {
        super(NAME, HEALTH, ARMOR, MANA, BASEDAMAGE, STARTINGLOCATION);
    }
}
