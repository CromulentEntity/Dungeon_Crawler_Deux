/* Entry point for the program.
 * 
 * TODO:
 * Learn what a string builder is
 */

package src;

import src.actors.Player;
import src.components.MainMenuComponent;

public class Main {
    public static void main(String[] args) {
        Map map = initializeMap();
        Player player = initializePlayer();
        boolean exit = false;

        ConsoleHelper.clear();

        while(!exit) {
            exit = MainMenuComponent.actionSelect(map, player);
        }
    }

    public static Player initializePlayer() {
        ConsoleHelper.clear();

        System.out.print("Please enter your name: ");
        String playerName = ConsoleHelper.getStringInput();

        return new Player(playerName);
    }

    public static Map initializeMap() {
        ConsoleHelper.clear();

        System.out.print("Please enter your desired map width: ");
        int mapXLength = ConsoleHelper.getPositiveIntFromPlayer();

        System.out.print("Please enter your desired map height: ");
        int mapYLength = ConsoleHelper.getPositiveIntFromPlayer();

        return new Map(mapXLength, mapYLength);
    }
}
