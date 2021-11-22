/* TODO:
 * Try and seperate out more of the switch statement into other methods, particularly the ConsoleHelper
 *
*/

package src.components;

import java.util.Scanner;

import src.ConsoleHelper;
import src.Map;
import src.characters.Player;

public class MainMenuComponent {

    // Constructor
    private MainMenuComponent() {}

    // General Methods
    @SuppressWarnings("resource") //Can't close playerInput because it will kill System.in program-wide
    public static boolean actionSelect(Map map, Player player) {
        Scanner playerInput = new Scanner(System.in);
        String rawPlayerInput;

        // Present possible actions to the player
        String[] choiceList = {"View Bag Contents", "Move", "Display Player Information", "Display Map", "Equip Weapon", "Unequip Weapon", "Exit"};
        ConsoleHelper.printChoices(choiceList);

        // Let them pick what they would like to do from the list
        rawPlayerInput = playerInput.nextLine();

        // Handle their chosen action appropriately.
        switch (rawPlayerInput) {
            case "1":
                ConsoleHelper.displayInfoScreen( new String[]{player.getBag().toString()} );
                return false;

            case "2":
                ConsoleHelper.clear();
                player.move(map);
                return false;

            case "3":
                ConsoleHelper.displayInfoScreen( new String[]{player.toString()} );
                return false;

            case "4":
                ConsoleHelper.displayInfoScreen( new String[] {map.toString(), 
                    ("Location - X: " + player.getLocation()[0] + " Y: " + player.getLocation()[1] + "\n")});
                return false;

            case "5":
                ConsoleHelper.clear();
                player.equipWeapon();
                return false;

            case "6":
                ConsoleHelper.clear();
                player.removeWeapon();
                return false;

            case "7":
                ConsoleHelper.clear();
                System.out.println("Exiting the program, Nya!");
                return true;

            default:
                ConsoleHelper.invalidInputMessage();
                return false;
        }
    }
}
