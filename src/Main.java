/* TODO:
 * Use better data structures for some things (e.g. Linked List in backpack)
 * Figure out why the Scanners break when closed properly
 * Learn what a string builder is
 * Make a battle dialogue
 * Write tests (e.g. Unequip starting weapon, Equip spare weapon, make sure spare weapon is equip and starting weapon is in bag)
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
            exit = MainMenuComponent.actionSelect(map, player);
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
}
