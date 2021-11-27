// Goblin creature.

package src.actors;

import java.util.concurrent.ThreadLocalRandom;

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

    // General Methods
    @Override
    public void attack(Actor targetActor) {
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 11); // Random number from 1 - 10
        if (randomNumber <= 2) {
            shieldSlam(targetActor);
        } else {
            slash(targetActor);
        }
    }

    // Strong attack, ignores defence
    private void shieldSlam(Actor targetActor) {
        int damage = 15;
        System.out.println("The " + super.getName() + " smashes " + targetActor.getName() + " with it's shield, ignoring their defences and dealing " + damage + " damage!");
        targetActor.loseHealth(damage);
    }

    // Regular attack
    private void slash(Actor targetActor) {
        super.attack(targetActor);
    }
}
