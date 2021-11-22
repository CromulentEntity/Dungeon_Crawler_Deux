// Seeing if the tile class would be better off generic

package src.tiles;

public class GenericTile<T> {
    private T type;

    // Sets
    public void setType(T type) {
        this.type = type;
    }

    // Gets
    public T getType() {
        return type;
    }
}
