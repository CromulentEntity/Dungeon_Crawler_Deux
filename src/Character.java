package src;
public class Character {
    private String name;
    private int health;
    private int maxHealth;
    private int mana;
    private int maxMana;
    private int baseDamage;

    // Constructor
    public Character(String name, int maxHealth, int maxMana, int baseDamage) {
        this.name = name;
        this.health = maxHealth;
        this.maxHealth = maxHealth;
        this.mana = maxMana;
        this.maxMana = maxMana;
        this.baseDamage = baseDamage;
    }

    // Everything else
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

    // Sets
    public void setHealth(int health) {
        this.health = health;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public String toString() {
        String output = "\nName: " + name +
            "\nHealth: " + health + "/" + maxHealth +
            "\nMana: " + mana + "/" + maxMana +
            "\nDamage: " + baseDamage;

        return output;
    }
}
