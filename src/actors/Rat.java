// A Rat. Why does it have so much mana?

package src.actors;

import java.util.concurrent.ThreadLocalRandom;

public class Rat extends Actor{
    private static final String NAME = "Rat";
    private static final int HEALTH = 6;
    private static final int ARMOR = 0;
    private static final int MANA = 1200;
    private static final int BASEDAMAGE = 1;
    private static final int EXPVALUE = 2;
    private static final int[] STARTINGLOCATION = {2, 2};

    // Constructor
    public Rat() {
        super(NAME, HEALTH, ARMOR, MANA, BASEDAMAGE, EXPVALUE, STARTINGLOCATION);
    }

    // General Methods
    public void attack(Actor targetActor) {
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 101); // Random number from 1 - 100
        if (randomNumber == 1) {
            gnaw(targetActor);
        } else {
            bite(targetActor);
        }
    }

    // Extremely powerful comedy attack
    private void gnaw(Actor targetActor) {
        if (super.getMana() >= 1200) {
            super.setMana(super.getMana() - 1200);
            System.out.println("The Rat channels an eternity of subjugation and torment. The world goes black. " + targetActor.getName() + 
                                " takes " + (targetActor.getHealth() - 1) + " damage. They are holding on by a thread.");
            targetActor.setHealth(1);

        } else {
            System.out.println("The Rat tries to channel its anger once more. Nothing happens.");
        }
    }

    // Regular attack
    private void bite(Actor targetActor) {
        super.attack(targetActor);
    }
}
