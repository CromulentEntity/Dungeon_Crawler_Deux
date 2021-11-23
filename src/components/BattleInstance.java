package src.components;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

import src.ConsoleHelper;
import src.actors.Actor;
import src.actors.Player;

public class BattleInstance {
    Player player;
    ArrayList<Actor> enemies;
    int turn;

    // Constructor
    public BattleInstance(Player player, ArrayList<Actor> enemies) {
        this.player = player;
        this.enemies = enemies;
        this.turn = 0;
    }

    // General Methods
    // Returns true if you win, false if you lose
    public boolean battle() {
        while(player.getHealth() > 0 && !enemies.isEmpty())  {
            turn();
        }

        if (player.getHealth() > 0) {
            System.out.println("You emerge victorious!\n");
            return true;
        } else {
            System.out.println("You have been defeated....");
            return false;
        }

    }

    public void turn() {
        @SuppressWarnings("resource") // Can't close playerInput because it will kill System.in program-wide
        Scanner playerInput = new Scanner(System.in);
        
        if (turn == 0) {
            // Player does things
            System.out.println("It is your turn.\n");
            String[] choiceList = {"Attack", "Examine Enemies", "Equip New Weapon"};
            ConsoleHelper.printChoices(choiceList);
            
            String rawInput = playerInput.nextLine();

            switch (rawInput) {
                case "1":
                    ConsoleHelper.clear();
                    Actor target = chooseTarget();
                    ConsoleHelper.clear();
                    player.attack(target);
                    checkEnemyHealth(target);
                    advanceTurn();
                    break;

                case "2":
                    ConsoleHelper.clear();
                    Actor targetActor = chooseTarget();
                    ConsoleHelper.clear();
                    System.out.println(targetActor.toString());
                    ConsoleHelper.enterToContinue();
                    break;

                case "3":
                    ConsoleHelper.clear();
                    player.removeWeapon();
                    player.equipWeapon();
                    break;
                
                default:
                    ConsoleHelper.clear();
                    System.out.println("That is not a valid input! Hiss!\n");
                    break;
            }

        } else {
            // Enemies do things
            System.out.println("\nIt is the " + enemies.get(turn-1).getName() + "\'s turn.");
            enemies.get(turn-1).attack(player);
            advanceTurn();
        }
    }

    private void advanceTurn() {
        if (turn < enemies.size()) { turn++; }
        else { 
            turn = 0;
            ConsoleHelper.enterToContinue();
        }
    }

    private Actor chooseTarget() {
        @SuppressWarnings("resource") //Can't close playerInput because it will kill System.in program-wide
        Scanner playerInput = new Scanner(System.in);
        int rawInput;

        for (int i = 0; i < enemies.size(); i++) {
            System.out.println((i+1) + ". " + enemies.get(i).getName());
        }

        System.out.print("\nChoose a target: ");
        rawInput = playerInput.nextInt();

        return enemies.get(rawInput-1);
        
    }

    private void checkEnemyHealth(Actor enemyActor) {
        if (enemyActor.getHealth() <= 0) {
            System.out.println(enemyActor.getName() + " has perished!");
            int enemyActorIndex = enemies.indexOf(enemyActor);
            enemies.remove(enemyActorIndex);
        }
    }
}
