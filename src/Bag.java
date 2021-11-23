// I see two ways of implementing this.
// The bag can be a single linked-list of node objects which contain whatever item.
// Or it can multiple linked lists / an array, each for a specific type of item.
// Lets start with that second one since I don't remember enough about linked lists or generics yet.

package src;
import java.util.ArrayList;

import src.items.Weapon;

public class Bag {
    private ArrayList<Weapon> weapons;

    // Constructor
    public Bag() {
        this.weapons = new ArrayList<>();
    }

    // General Methods
    public void addWeaponToBag(Weapon weapon) {
        weapons.add(weapon);
    }

    public Weapon removeWeaponFromBag(int weaponPosition) {
        return weapons.remove(weaponPosition);
    }

    // Gets
    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    // toString
    @Override
    public String toString() {
        String output = "== B A G ==\nWeapons:\n";
        for(int x = 0; x < weapons.size(); x++) {
            output += (weapons.get(x).toString());
        }

        return output;
    }
}
