package src;
public class Item {
    private String name;
    private String description;
    private int value;

    // Constructor
    public Item (String name, String description, int value) {
        this.name = name;
        this.description = description;
        this.value = value;
    }

    // Gets
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getValue() {
        return value;
    }
    
}
