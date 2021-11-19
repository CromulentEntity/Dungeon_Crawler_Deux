package src;

import java.util.Scanner;

public class Player extends Character {
    private static final int STARTINGHEALTH = 100;
    private static final int STARTINGMANA = 100;
    private static final int BASEDAMAGE = 5;
    private static final int[] STARTINGLOCATION = {0, 0};
    private Weapon weapon;
    private int experience;
    private int level;
    private Bag bag;

    // Constructor
    public Player(String name) {
        super(name, STARTINGHEALTH, STARTINGMANA, BASEDAMAGE, STARTINGLOCATION);
        this.experience = 0;
        this.level = 1;
        this.bag = new Bag();
        this.weapon = new Weapon("Bronze Dagger", "We all gotta start somewhere.", 0, 10, "Hand");
        bag.addWeaponToBag(new Weapon("Sord..", "Unspeakably shitty sword.", 0, 6, "Hand"));
    }

    // Everything else
    public void gainExperience(int ammount) {
        this.experience += ammount;
    }

    @Override
    public void attack(Character targetCharacter) {
        if (weapon != null) { 
            System.out.println(getName() + " attacks " + targetCharacter.getName() + ", dealing " + weapon.getDamage() + " damage!");
            targetCharacter.loseHealth(weapon.getDamage());

        } else { 
            targetCharacter.loseHealth(BASEDAMAGE); 
        }
    }

    public void equipWeapon() {
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

    @Override
    public String toString() {
        String output = "== P L A Y E R   I N F O ==";
        output += super.toString();

        if (weapon != null) {
            output += "\nWeapon Damage: " + weapon.getDamage();
        }

        output += "\nExperience: " + this.experience + 
                    "\nLevel: " + this.level;

        return output;
    }
}
