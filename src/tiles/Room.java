// A room tile on the map. Allows movement if unlocked.

package src.tiles;

public class Room extends Tile {

    // Constructor
    public Room(boolean isLocked) {
        super("□", false, isLocked);
    }
    
}
