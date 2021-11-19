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
        ConsoleHelper.clear();
        Player player = initializePlayer();
        ConsoleHelper.clear();
        Map map = initializeMap();
        ConsoleHelper.clear();
        boolean exit = false;

        while(!exit) {
            exit = actionSelect(map, player);
        }
        
    }

    public static Player initializePlayer() {
        Scanner playerInput = new Scanner(System.in);
        String playerName;

        System.out.print("Please enter your name: ");
        playerName = playerInput.nextLine();

        return new Player(playerName);
    }

    public static Map initializeMap() {
        Scanner playerInput = new Scanner(System.in);
        int mapXLength;
        int mapYLength;

        System.out.print("Please enter your desired map width: ");
        mapXLength = playerInput.nextInt();

        System.out.print("Please enter your desired map height: ");
        mapYLength = playerInput.nextInt();

        return new Map(mapXLength, mapYLength);

    }

    public static boolean actionSelect(Map map, Player player) {
        Scanner playerInput = new Scanner(System.in);
        String rawInput;

        System.out.print(
            "1. View Bag Contents\n" +
            "2. Move\n" +
            "3. Display Player Information\n" +
            "4. Display Map\n" +
            "5. Equip Weapon\n" +
            "6. Unequip Weapon\n" + 
            "7. Exit\n" +
            "\nPlease choose an option: ");

        rawInput = playerInput.nextLine();

        switch (rawInput) {
            case "1":
                ConsoleHelper.clear();
                System.out.print(player.getBag().toString());
                ConsoleHelper.enterToContinue();
                return false;
            case "2":
                ConsoleHelper.clear();
                movePlayer(player, map);
                return false;
            case "3":
                ConsoleHelper.clear();
                System.out.print("== P L A Y E R   I N F O ==");
                System.out.println(player.toString());
                ConsoleHelper.enterToContinue();
                return false;
            case "4":
                ConsoleHelper.clear();
                System.out.print("== M A P ==");
                System.out.println(map.toString());
                System.out.println("Location - X: " + player.getLocation()[0] + " Y: " + player.getLocation()[1] + "\n");
                ConsoleHelper.enterToContinue();
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
                ConsoleHelper.clear();
                System.out.println("That is not a valid input! Hiss!\n");
                return false;
        }
    }

    // This is bad rn (update: improving)
    public static void movePlayer(Player player, Map map) {
        int playerXLocation = player.getLocation()[0];
        int playerYLocation = player.getLocation()[1];
        Scanner playerInput = new Scanner(System.in);
        String direction;
        
        ConsoleHelper.clear();
        System.out.print("== M A P ==");
        System.out.print(map.toString());
        System.out.println("\nWhat direction would you like to move?");
        System.out.println("1. North" +
                           "\n2. South" +
                           "\n3. East" +
                           "\n4. West");
        
        direction = playerInput.nextLine();
        ConsoleHelper.clear();
        
        final String OUTOFBOUNDSMESSAGE = "That location lies outside of the map.\n";

        switch(direction) {
            case "1":

                if (playerYLocation - 1 >= 0) {
                    Tile currentTile = map.getMap()[playerYLocation][playerXLocation];
                    Tile newTile = map.getMap()[playerYLocation - 1][playerXLocation];
                    
                    if (newTile.tileCanBeEntered()) {
                        System.out.println("You move to the North.\n");
                        player.setLocation(playerXLocation, playerYLocation - 1);
                        currentTile.isPlayerPresent(false);
                        newTile.isPlayerPresent(true);
                    }

                } else { System.out.println(OUTOFBOUNDSMESSAGE); }
                break;

            case "2":

                if (playerYLocation + 1 < map.getMap().length) {
                    Tile currentTile = map.getMap()[playerYLocation][playerXLocation];
                    Tile newTile = map.getMap()[playerYLocation + 1][playerXLocation];

                    if (newTile.tileCanBeEntered()) {
                        System.out.println("You move to the South.\n");
                        player.setLocation(playerXLocation, playerYLocation + 1);
                        currentTile.isPlayerPresent(false);
                        newTile.isPlayerPresent(true);
                    }

                } else { System.out.println(OUTOFBOUNDSMESSAGE); }
                break;

            case "3":

                if (playerXLocation + 1 < map.getMap()[0].length) {
                    Tile currentTile = map.getMap()[playerYLocation][playerXLocation];
                    Tile newTile = map.getMap()[playerYLocation][playerXLocation + 1];

                    if (newTile.tileCanBeEntered()) {
                        System.out.println("You move to the East.\n");
                        player.setLocation(playerXLocation + 1, playerYLocation);
                        currentTile.isPlayerPresent(false);
                        newTile.isPlayerPresent(true);
                    }

                } else { System.out.println(OUTOFBOUNDSMESSAGE); }
                break;

            case "4":

                if (playerXLocation - 1 >= 0) {
                    Tile currentTile = map.getMap()[playerYLocation][playerXLocation];
                    Tile newTile = map.getMap()[playerYLocation][playerXLocation - 1];

                    if (newTile.tileCanBeEntered()) {
                        System.out.println("You move to the West.\n");
                        player.setLocation(playerXLocation - 1, playerYLocation);
                        currentTile.isPlayerPresent(false);
                        newTile.isPlayerPresent(true);
                    }

                } else { System.out.println(OUTOFBOUNDSMESSAGE); }
                break;

            default:
                System.out.println("That is not a valid input! Hiss!\n"); 
                movePlayer(player, map);
                break;
        }
    }
}
