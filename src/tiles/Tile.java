package src.tiles;

public class Tile {
    private String icon;
    private String activeIcon;
    private boolean isSolid;
    private boolean isPassable;
    private boolean isLocked;

    // Constructor
    public Tile(String icon, boolean isSolid, boolean isLocked) {
        this.icon = icon;
        this.activeIcon = icon;
        this.isSolid = isSolid;
        this.isLocked = isLocked;
        this.isPassable = updateIsPassable();
    }

    // General Methods
    private boolean updateIsPassable() {
        return (!isSolid && !isLocked);
    }

    public boolean tileCanBeEntered() {
        // System.out.println("Debug!! isSolid = " + isSolid + ", isPassable = " + isPassable + ", isLocked: " + isLocked);
        
        if (isPassable) {
            return true;

        } else if (isSolid) {
            System.out.println("There is nothing in that direction but solid rock.\n");
            return false;

        } else if (isLocked) {
            System.out.println("A locked door stands in your way.\n");
            return false;

        } else {
            System.out.println("You just found a pathing bug!\n");
            return false;
        }
    }

    public void isPlayerPresent(boolean playerIsPresent) {
        if (playerIsPresent) {
            activeIcon = "▲";
        } else {
            activeIcon = icon;
        }
    }

    // Gets
    public String getActiveIcon() {
        return activeIcon;
    }
    public boolean getIsPassable() {
        return isPassable;
    }
    public boolean getIsSolid() {
        return isSolid;
    }
    public boolean getIsLocked() {
        return isLocked;
    }

    // Sets
    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
        this.isPassable = updateIsPassable();
    }
    public void setIsSolid(boolean isSolid) {
        this.isSolid = isSolid;
        this.isPassable = updateIsPassable();
    }
}
