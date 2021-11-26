// The main screen you'll be looking at. Perhaps "component" isn't the correct term?

package src.components;

import java.util.ArrayList;
import java.util.Scanner;

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
                ConsoleHelper.displayInfoScreen( new String[]{player.getBag().toString()} );
                return false;

            case "2":
                player.move(map);
                return false;

            case "3":
                ArrayList<Actor> enemies = new ArrayList<>();
                enemies.add(new Goblin());
                enemies.add(new Rat());
                BattleInstance battleInstance = new BattleInstance(player, enemies);
                return ( !battleInstance.battle() );

            case "4":
                ConsoleHelper.displayInfoScreen( new String[]{player.toString()} );
                return false;

            case "5":
                ConsoleHelper.displayInfoScreen( new String[] {map.toString(), 
                    ("Location - X: " + player.getLocation()[0] + " Y: " + player.getLocation()[1])});
                return false;

            case "6":
                player.equipWeapon();
                return false;

            case "7":
                player.removeWeapon();
                return false;

            case "8":
                System.out.println("Exiting the program, Nya!");
                return true;

            default:
                ConsoleHelper.invalidInputMessage();
                return false;
        }
    }
}
