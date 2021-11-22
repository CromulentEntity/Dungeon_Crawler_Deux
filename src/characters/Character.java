package src.characters;

import src.Map;
import src.components.MovementComponent;

public class Character {
    private String name;
    private int health;
    private int maxHealth;
    private int mana;
    private int maxMana;
    private int baseDamage;
    private int[] location; // Current X,Y coordinates on the map. Default is 0,0.
    private MovementComponent movement;

    // Constructor
    public Character(String name, int maxHealth, int maxMana, int baseDamage, int[] location, Map map) {
        this.name = name;
        this.health = maxHealth;
        this.maxHealth = maxHealth;
        this.mana = maxMana;
        this.maxMana = maxMana;
        this.baseDamage = baseDamage;
        this.location = location;
        this.movement = new MovementComponent(map);
    }

    // Everything else
    public void move() {
        location = movement.moveCharacter(location[0], location[1]);
    }

    public void loseHealth(int damage) {
        health = health - damage;
    }

    public void gainHealth(int healing) {
        int healthAfterHealing = health + healing;
        
        if (healthAfterHealing <= maxHealth) { health = healthAfterHealing; }
        else { health = maxHealth; }
    }

    public void attack(Character targetCharacter) {
        System.out.println(name + " attacks " + targetCharacter.getName() + ", dealing " + baseDamage + " damage!");
        targetCharacter.loseHealth(baseDamage);
    }

    // Gets
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getMana() {
        return mana;
    }
    public int[] getLocation() {
        return location;
    }

    // Sets
    public void setHealth(int health) {
        this.health = health;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public void setLocation(int xDirection, int yDirection) {
        this.location[0] = xDirection;
        this.location[1] = yDirection;
    }

    @Override
    public String toString() {
        String output = "\nName: " + name +
            "\nHealth: " + health + "/" + maxHealth +
            "\nMana: " + mana + "/" + maxMana +
            "\nDamage: " + baseDamage +
            "\nCoordinates - X: " + location[0] + " Y: " + location[1];

        return output;
    }
}
