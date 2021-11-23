// Actor superclass, defines characteristics that entities such as players or enemies will use or re-implement.

package src.actors;

import src.Map;
import src.components.MovementComponent;

public class Actor {
    private String name;
    private int health;
    private int armor;
    private int maxHealth;
    private int mana;
    private int maxMana;
    private int baseDamage;
    private int expValue;
    private int[] location; // Current X,Y coordinates on the map. Default is 0,0.
    private MovementComponent movementComponent;

    // Constructor
    public Actor(String name, int maxHealth, int armor, int maxMana, int baseDamage, int expValue, int[] location) {
        this.name = name;
        this.health = maxHealth;
        this.armor = armor;
        this.maxHealth = maxHealth;
        this.mana = maxMana;
        this.maxMana = maxMana;
        this.baseDamage = baseDamage;
        this.expValue = expValue;
        this.location = location;
        this.movementComponent = new MovementComponent();
    }

    // General Methods
    public void move(Map map) {
        location = movementComponent.moveActor(location[0], location[1], map);
    }

    public void loseHealth(int damage) {
        health = health - damage;
    }

    public void gainHealth(int healing) {
        int healthAfterHealing = health + healing;
        
        if (healthAfterHealing <= maxHealth) { health = healthAfterHealing; }
        else { health = maxHealth; }
    }

    public void attack(Actor targetActor) {
        int finalDamageValue = baseDamage - targetActor.getArmor();
        if (finalDamageValue <= 0) { finalDamageValue = 1; }
        System.out.println(name + " attacks " + targetActor.getName() + ", dealing " + finalDamageValue + " damage!");
        targetActor.loseHealth(finalDamageValue);
    }

    // Gets
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public int getArmor() {
        return armor;
    }
    public int getMana() {
        return mana;
    }
    public int getMaxMana() {
        return maxMana;
    }
    public int getBaseDamage() {
        return baseDamage;
    }
    public int getExpValue() {
        return expValue;
    }
    public int[] getLocation() {
        return location;
    }

    // Sets
    public void setHealth(int health) {
        this.health = health;
    }
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }
    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }
    public void setLocation(int xDirection, int yDirection) {
        this.location[0] = xDirection;
        this.location[1] = yDirection;
    }

    // toString
    @Override
    public String toString() {
        String output = "Name: " + name +
            "\nHealth: " + health + "/" + maxHealth +
            "\nMana: " + mana + "/" + maxMana +
            "\nArmor: " + armor +
            "\nDamage: " + baseDamage +
            "\nCoordinates - X: " + location[0] + " Y: " + location[1];

        return output;
    }
}
