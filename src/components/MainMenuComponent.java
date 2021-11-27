// The main screen you'll be looking at. Perhaps "component" isn't the correct term?

package src.components;

import java.util.ArrayList;

import src.ConsoleHelper;
import src.Map;
import src.actors.Actor;
import src.actors.Goblin;
import src.actors.Player;
import src.actors.Rat;

public class MainMenuComponent {

    // Constructor
    private MainMenuComponent() {}

    // General Methods
    public static boolean actionSelect(Map map, Player player) {

        // Find out what the player would like to do
        String query = "";
        String[] possibleAnswers = {"View Bag Contents", "Move", "Fight", "Display Player Information", "Display Map", "Equip Weapon", "Unequip Weapon", "Exit"};
        String playerInput = ConsoleHelper.queryPlayer(query, possibleAnswers);
        
        ConsoleHelper.clear();

        switch (playerInput) {
            case "1":
                viewBagContents(player);
                return false;

            case "2":
                move(map, player);
                return false;

            case "3":
                return fight(player);

            case "4":
                displayPlayerInformation(player);
                return false;

            case "5":
                displayMap(map, player);
                return false;

            case "6":
                equipWeapon(player);
                return false;

            case "7":
                removeWeapon(player);
                return false;

            case "8":
                exitProgram();
                return true;

            default:
                ConsoleHelper.invalidInputMessage();
                return false;
        }
    }

    private static void viewBagContents(Player player) {
        ConsoleHelper.displayInfoScreen( new String[]{player.getBag().toString()} );
    }

    private static void move(Map map, Player player) {
        player.move(map);
    }

    private static boolean fight(Player player) {
        ArrayList<Actor> enemies = new ArrayList<>();
        enemies.add(new Goblin());
        enemies.add(new Rat());
        BattleInstance battleInstance = new BattleInstance(player, enemies);
        return ( !battleInstance.battle() );
    }

    private static void displayPlayerInformation(Player player) {
        ConsoleHelper.displayInfoScreen( new String[]{player.toString()} );
    }

    private static void displayMap(Map map, Player player) {
        ConsoleHelper.displayInfoScreen( new String[] {map.toString(), 
            ("Location - X: " + player.getLocation()[0] + " Y: " + player.getLocation()[1])});
    }

    private static void equipWeapon(Player player) {
        player.equipWeapon();
    }

    private static void removeWeapon(Player player) {
        player.removeWeapon();
    }

    private static void exitProgram() {
        System.out.println("Exiting the program, Nya!");
    }
}
