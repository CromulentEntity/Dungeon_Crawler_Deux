/* TODO:
 * Use better data structures for some things (e.g. Linked List in backpack)
 * Figure out why the Scanners break when closed properly
 * Learn what a string builder is
 * Make a battle dialogue
 * Write tests (e.g. Unequip starting weapon, Equip spare weapon, make sure spare weapon is equip and starting weapon is in bag)
 * Movement component to get movement code out of Main.java?
 * Main menu class to get main menu code out of Main.java?
 * 
*/

package src;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player = initializePlayer();
        Map map = initializeMap();
        boolean exit = false;

        ConsoleHelper.clear();

        while(!exit) {
            exit = actionSelect(map, player);
        }
        
    }

    public static Player initializePlayer() {
        Scanner playerInput = new Scanner(System.in);
        String playerName;

        ConsoleHelper.clear();

        System.out.print("Please enter your name: ");
        playerName = playerInput.nextLine();

        return new Player(playerName);
    }

    public static Map initializeMap() {
        Scanner playerInput = new Scanner(System.in);
        int mapXLength;
        int mapYLength;

        ConsoleHelper.clear();

        System.out.print("Please enter your desired map width: ");
        mapXLength = playerInput.nextInt();

        System.out.print("Please enter your desired map height: ");
        mapYLength = playerInput.nextInt();

        return new Map(mapXLength, mapYLength);

    }

    public static boolean actionSelect(Map map, Player player) {
        MovementComponent playerMovement = new MovementComponent(player, map);
        Scanner playerInput = new Scanner(System.in);
        String rawInput;
        String[] choiceList = {"View Bag Contents", "Move", "Display Player Information", "Display Map", "Equip Weapon", "Unequip Weapon", "Exit"};
        ConsoleHelper.printChoices(choiceList);

        rawInput = playerInput.nextLine();

        switch (rawInput) {
            case "1":
                ConsoleHelper.displayInfoScreen( new String[]{player.getBag().toString()} );
                return false;

            case "2":
                ConsoleHelper.clear();
                playerMovement.moveCharacter();
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
