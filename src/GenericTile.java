// Seeing if the tile class would be better off generic

package src;

public class GenericTile<T> {
    private T type;

    public void setType(T type) {
        this.type = type;
    }

    public T getType() {
        return type;
    }
}
