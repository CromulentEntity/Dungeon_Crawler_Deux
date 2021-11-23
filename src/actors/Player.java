// The Player. Does things a person would do.

package src.actors;

import java.util.Scanner;

import src.Bag;
import src.ConsoleHelper;
import src.items.Weapon;

public class Player extends Actor {
    private static final int STARTINGHEALTH = 100;
    private static final int STARTINGARMOR = 5;
    private static final int STARTINGMANA = 100;
    private static final int BASEDAMAGE = 5;
    private static final int EXPVALUE = 0;
    private static final int[] STARTINGLOCATION = {0, 0};
    private Weapon weapon;
    private int experience;
    private int experienceToNextLevel;
    private int level;
    private Bag bag;

    // Constructor
    public Player(String name) {
        super(name, STARTINGHEALTH, STARTINGARMOR, STARTINGMANA, BASEDAMAGE, EXPVALUE, STARTINGLOCATION);
        this.experience = 0;
        this.experienceToNextLevel = 100;
        this.level = 1;
        this.bag = new Bag();
        this.weapon = new Weapon("Bronze Dagger", "We all gotta start somewhere.", 0, 15, "Hand");
        bag.addWeaponToBag(new Weapon("Sord..", "Unspeakably shitty sword.", 0, 7, "Hand"));
    }

    // General Methods
    public void gainExperience(int ammount) {
        System.out.println("You gain " + ammount + " experience.");
        experience += ammount;

        if (experience >= experienceToNextLevel) {
            levelUp();
        }
    }

    public void levelUp() {
        System.out.println("\nYou have reached level " + (level+1) + "!");
        experience = experience - experienceToNextLevel;
        level += 1;
        experienceToNextLevel += 100;

        // Increase Max Health & Heal
        int newMaxHealth = super.getMaxHealth() + 20;
        System.out.println("Max health has increased from " + super.getMaxHealth() + " to " + newMaxHealth + ".");
        super.setMaxHealth(newMaxHealth);
        super.setHealth(newMaxHealth);

        // Increase Max Mana & Set to Max
        int newMaxMana = super.getMaxMana() + 10;
        System.out.println("Max mana has increased from " + super.getMaxMana() + " to " + newMaxMana + ".");
        super.setMaxMana(newMaxMana);
        super.setMana(newMaxMana);

        // Increase Base Damage
        int newBaseDamage = super.getBaseDamage() + 2;
        System.out.println("Base damage has increased from " + super.getBaseDamage() + " to " + newBaseDamage + ".");
        super.setBaseDamage(newBaseDamage);
    }

    @Override
    public void attack(Actor targetActor) {
        if (weapon != null) { 
            int finalDamageValue = weapon.getDamage() - targetActor.getArmor();
            if (finalDamageValue <= 0) { finalDamageValue = 1; }
            System.out.println(getName() + " attacks the " + targetActor.getName() + " with their " + weapon.getName() + ", dealing " + finalDamageValue + " damage!");
            targetActor.loseHealth(finalDamageValue);

        } else {
            int finalDamageValue = BASEDAMAGE - targetActor.getArmor();
            if (finalDamageValue <= 0) { finalDamageValue = 1; }
            System.out.println(getName() + " attacks the " + targetActor.getName() + " with their bare hands, dealing " + finalDamageValue + " damage!");
            targetActor.loseHealth(finalDamageValue); 
        }
    }

    public void equipWeapon() {
        @SuppressWarnings("resource") //Can't close playerInput because it will kill System.in program-wide
        Scanner playerInput = new Scanner(System.in);

        if (weapon != null) {
            System.out.println("You are already holding a weapon. Remove that one first.\n");

        } else {
            System.out.println("You currently have the following weapons in your bag:");
            if (bag.getWeapons().isEmpty()) {
                System.out.println("Jack Shit");

            } else {
                for(int i = 0; i < bag.getWeapons().size(); i++) {
                    System.out.println((i+1) + ": " + bag.getWeapons().get(i).toString());
                }

                System.out.print("\nEnter the number corresponding to your desired choice: ");
                int chosenWeapon = playerInput.nextInt();
                
                ConsoleHelper.clear();
                
                System.out.println("You equip the " + bag.getWeapons().get(chosenWeapon-1).getName() + ".\n");
                weapon = bag.removeWeaponFromBag(chosenWeapon - 1);
            }
        }
    }

    public void removeWeapon() {
        if (weapon != null) {
            Weapon removedWeapon = weapon;
            weapon = null;
            bag.addWeaponToBag(removedWeapon);
            System.out.println("You store your weapon in your bag.\n");

        } else {
            System.out.println("You are not currently holding a weapon!\n");
        }
    }

    // Gets
    public int getExperience() {
        return experience;
    }
    public int getLevel() {
        return level;
    }
    public Bag getBag() {
        return bag;
    }

    // toString
    @Override
    public String toString() {
        String output = "== P L A Y E R   I N F O ==\n";
        output += super.toString();

        if (weapon != null) {
            output += "\nWeapon Damage: " + weapon.getDamage();
        }

        output += "\nExperience: " + this.experience + "/" + this.experienceToNextLevel +
                    "\nLevel: " + this.level;

        return output;
    }
}
