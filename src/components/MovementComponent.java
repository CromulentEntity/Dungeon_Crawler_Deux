/* TODO:
 * An instance of this should be contained within each Actor that moves, not the other way around as it currently is.
 * Currently this class takes in the player object and the map object. To make the above changes, we can change the player object
 * input to instead be the x and y coordinates of the Actor (the only thing accessed from the player object in this class). Likewise,
 * the map should be replacable with the current games map length and width, and moving the call to "map.toString" out of this method
 * and placing it before the moveCharater() method call.
*/ 

package src.components;

import java.util.Scanner;

import src.ConsoleHelper;
import src.Map;
import src.tiles.Tile;

public class MovementComponent {

    // General Methods
    @SuppressWarnings("resource") //Can't close playerInput because it will kill System.in program-wide
    public int[] moveActor(int currentXCoordinate, int currentYCoordinate, Map map) {
        Scanner playerInput = new Scanner(System.in);
        int newXCoordinate;
        int newYCoordinate;

        ConsoleHelper.clear();

        // Move the following line out of this method. Insert it before each call to moveActor()
        // System.out.print(map.toString());
        System.out.println("\nWhat direction would you like to move?");
        String[] choiceList = {"North", "South", "East", "West"};
        ConsoleHelper.printChoices(choiceList);

        String direction = playerInput.nextLine();

        ConsoleHelper.clear();

        switch(direction) {
            case "1":
                newXCoordinate = currentXCoordinate;
                newYCoordinate = currentYCoordinate - 1;
                return checkCollisions(newXCoordinate, currentXCoordinate, newYCoordinate, currentYCoordinate, map, "North");

            case "2":
                newXCoordinate = currentXCoordinate;
                newYCoordinate = currentYCoordinate + 1;
                return checkCollisions(newXCoordinate, currentXCoordinate, newYCoordinate, currentYCoordinate, map, "South");

            case "3":
                newXCoordinate = currentXCoordinate + 1;
                newYCoordinate = currentYCoordinate;
                return checkCollisions(newXCoordinate, currentXCoordinate, newYCoordinate, currentYCoordinate, map, "East");
                
            case "4":
                newXCoordinate = currentXCoordinate - 1;
                newYCoordinate = currentXCoordinate;
                return checkCollisions(newXCoordinate, currentXCoordinate, newYCoordinate, currentYCoordinate, map, "West");

            default:
                System.out.println("That is not a valid input! Hiss!\n"); 
                return moveActor(currentXCoordinate, currentYCoordinate, map);
        }
    }

    private int[] checkCollisions(int newXCoordinate, int currentXCoordinate, int newYCoordinate, int currentYCoordinate, Map map, String direction) {

        if (newXCoordinate >= 0 && newXCoordinate < map.getMap()[0].length) {
        
            if (newYCoordinate >=0 && newYCoordinate < map.getMap().length) {
                Tile currentTile = map.getMap()[currentYCoordinate][currentXCoordinate];
                Tile newTile = map.getMap()[newYCoordinate][newXCoordinate];

                if (newTile.tileCanBeEntered()) {
                    System.out.println("You move to the " + direction + ".\n");
                    currentTile.isPlayerPresent(false);
                    newTile.isPlayerPresent(true);
                    return new int[] {newXCoordinate, newYCoordinate};
                }
                
            } else { System.out.println("That location lies outside of the map.\n"); }
        } else { System.out.println("That location lies outside of the map.\n"); }

        return new int[] {currentXCoordinate, currentYCoordinate};
    }
}
