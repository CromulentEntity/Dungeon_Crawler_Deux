// A rock tile on the map. Blocks movement.

package src.tiles;

public class Rock extends Tile {
    static final String ICON = "■";
    static final boolean ISSOLID = true;
    static final boolean ISLOCKED = false;
    
    // Constructor
    public Rock () {
        super(ICON, ISSOLID, ISLOCKED);
    }

}
