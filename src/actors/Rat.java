// A Rat. Why does it have so much mana?

package src.actors;

public class Rat extends Actor{
    static final String NAME = "Rat";
    static final int HEALTH = 6;
    static final int ARMOR = 0;
    static final int MANA = 1200;
    static final int BASEDAMAGE = 1;
    static final int[] STARTINGLOCATION = {2, 2};

    // Constructor
    public Rat() {
        super(NAME, HEALTH, ARMOR, MANA, BASEDAMAGE, STARTINGLOCATION);
    }
}
