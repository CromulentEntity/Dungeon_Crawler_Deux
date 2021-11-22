package src.characters;

import src.Map;

public class Rat extends Character{
    static final String NAME = "Rat";
    static final int HEALTH = 6;
    static final int MANA = 1200;
    static final int BASEDAMAGE = 0;
    static final int[] STARTINGLOCATION = {2, 2};

    public Rat(Map map) {
        super(NAME, HEALTH, MANA, BASEDAMAGE, STARTINGLOCATION, map);
    }
}
