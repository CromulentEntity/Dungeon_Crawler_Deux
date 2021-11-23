// A rock tile on the map. Blocks movement.

package src.tiles;

public class Rock extends Tile {
    private static final String ICON = "■";
    private static final boolean ISSOLID = true;
    private static final boolean ISLOCKED = false;
    
    // Constructor
    public Rock () {
        super(ICON, ISSOLID, ISLOCKED);
    }

}
