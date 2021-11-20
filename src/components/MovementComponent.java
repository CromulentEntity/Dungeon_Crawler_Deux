/* TODO:
 * An instance of this should be contained within each character that moves, not the other way around as it currently is.
*/ 

package src.components;

import java.util.Scanner;

import src.ConsoleHelper;
import src.Map;
import src.characters.Character;
import src.tiles.Tile;

public class MovementComponent {
    Character character;
    Map map;

    public MovementComponent(Character character, Map map) {
        this.character = character;
        this.map = map;
    }

    public void moveCharacter() {
        Scanner playerInput = new Scanner(System.in);
        int currentXCoordinate = character.getLocation()[0];
        int currentYCoordinate = character.getLocation()[1];
        int newXCoordinate;
        int newYCoordinate;

        ConsoleHelper.clear();

        System.out.print(map.toString());
        System.out.println("\nWhat direction would you like to move?");
        String[] choiceList = {"North", "South", "East", "West"};
        ConsoleHelper.printChoices(choiceList);

        String direction = playerInput.nextLine();

        ConsoleHelper.clear();

        switch(direction) {
            case "1":
                newXCoordinate = currentXCoordinate;
                newYCoordinate = currentYCoordinate - 1;
                checkCollisions(newXCoordinate, currentXCoordinate, newYCoordinate, currentYCoordinate, "North");
                break;

            case "2":
                newXCoordinate = currentXCoordinate;
                newYCoordinate = currentYCoordinate + 1;
                checkCollisions(newXCoordinate, currentXCoordinate, newYCoordinate, currentYCoordinate, "South");
                break;

            case "3":
                newXCoordinate = currentXCoordinate + 1;
                newYCoordinate = currentYCoordinate;
                checkCollisions(newXCoordinate, currentXCoordinate, newYCoordinate, currentYCoordinate, "East");
                break;
                
            case "4":
                newXCoordinate = currentXCoordinate - 1;
                newYCoordinate = currentXCoordinate;
                checkCollisions(newXCoordinate, currentXCoordinate, newYCoordinate, currentYCoordinate, "West");
                break;

            default:
                System.out.println("That is not a valid input! Hiss!\n"); 
                moveCharacter();
                break;
        }
    }

    public void checkCollisions(int newXCoordinate, int currentXCoordinate, int newYCoordinate, int currentYCoordinate, String direction) {
        if (newXCoordinate >= 0 && newXCoordinate < map.getMap()[0].length) {
            if (newYCoordinate >=0 && newYCoordinate < map.getMap().length) {
                Tile currentTile = map.getMap()[currentYCoordinate][currentXCoordinate];
                Tile newTile = map.getMap()[newYCoordinate][newXCoordinate];

                if (newTile.tileCanBeEntered()) {
                    System.out.println("You move to the " + direction + ".\n");
                    character.setLocation(newXCoordinate, newYCoordinate);
                    currentTile.isPlayerPresent(false);
                    newTile.isPlayerPresent(true);

                }
                
            } else { System.out.println("That location lies outside of the map.\n") ;}
        } else { System.out.println("That location lies outside of the map.\n") ;}
    }
}
