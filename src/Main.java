/* Entry point for the program.
 * 
 * TODO:
 * Learn what a string builder is
 */

package src;
import java.util.Scanner;

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
        @SuppressWarnings("resource") //Can't close playerInput because it will kill System.in program-wide
        Scanner playerInput = new Scanner(System.in);
        String playerName;

        ConsoleHelper.clear();

        System.out.print("Please enter your name: ");
        playerName = playerInput.nextLine();

        return new Player(playerName);
    }

    public static Map initializeMap() {
        @SuppressWarnings("resource") //Can't close playerInput because it will kill System.in program-wide
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
