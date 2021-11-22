package src;

import src.tiles.Rock;
import src.tiles.Room;
import src.tiles.Tile;

public class Map {
    private Tile[][] map;
    private int xDimensions;
    private int yDimensions;

    // Constructor
    public Map(int xDimensions, int yDimensions) {
        this.xDimensions = xDimensions;
        this.yDimensions = yDimensions;
        generateMap();
        map[0][0].isPlayerPresent(true);
    }
    
    // General Methods
    private void generateMap() {
        map = new Tile[][] {
            {new Room(false), new Rock(), new Rock(), new Rock()},
            {new Room(false), new Rock(), new Room(false), new Rock()},
            {new Room(false), new Room(false), new Room(false), new Room(false)},
            {new Rock(), new Rock(), new Rock(), new Room(false)}};
    }

    // Gets
    public Tile[][] getMap() {
        return map;
    }

    // toString
    @Override
    public String toString() {
        String output = "== M A P ==\n";
        for(int y = 0; y < map.length; y++) {
            for(int x = 0; x < map[0].length; x++) {
                output += map[y][x].getActiveIcon() + " ";
            }
            output += "\n";
        }

        return output;
    }
}
