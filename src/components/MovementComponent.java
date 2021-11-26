// Handles movement through the map for whatever entities need it.

package src.components;

import src.ConsoleHelper;
import src.Map;
import src.tiles.Tile;

public class MovementComponent {

    // General Methods
    public int[] moveActor(int currentXCoordinate, int currentYCoordinate, Map map) {
        int newXCoordinate;
        int newYCoordinate;

        ConsoleHelper.clear();
        System.out.println(map.toString());
        
        // Find out what the player would like to do
        String query = "What direction would you like to move?";
        String[] possibleAnswers = {"North", "South", "East", "West"};
        String playerInput = ConsoleHelper.queryPlayer(query, possibleAnswers);

        ConsoleHelper.clear();

        switch(playerInput) {
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
