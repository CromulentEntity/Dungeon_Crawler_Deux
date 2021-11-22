// A room tile on the map. Allows movement if unlocked.

package src.tiles;

public class Room extends Tile {
    static final String ICON = "□";
    static final boolean ISSOLID = false;

    // Constructor
    public Room(boolean isLocked) {
        super(ICON, ISSOLID, isLocked);
    }
    
}
