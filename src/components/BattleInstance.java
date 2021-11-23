package src.components;

import java.util.Scanner;

import src.ConsoleHelper;
import src.actors.Actor;

public class BattleInstance {
    Actor player;
    Actor[] enemies;
    int turn;

    // Constructor
    public BattleInstance(Actor player, Actor[] enemies) {
        this.player = player;
        this.enemies = enemies;
        this.turn = 0;
    }

    // General Methods
    public boolean battle() {
        while(player.getHealth() > 0 && enemies.length > 0)  {
            turn();
        }

        return (player.getHealth() > 0);
    }

    public void turn() {
        @SuppressWarnings("resource") // Can't close playerInput because it will kill System.in program-wide
        Scanner playerInput = new Scanner(System.in);
        
        if (turn == 0) {
            // Player does things
            System.out.println("It is your turn.\n");
            String[] choiceList = {"Attack"};
            ConsoleHelper.printChoices(choiceList);
            
            String rawInput = playerInput.nextLine();

            switch (rawInput) {
                case "1":
                    ConsoleHelper.clear();
                    Actor target = chooseTarget();
                    System.out.println("You swing at the " + target.getName() + ", dealing ??? damage!");
                    player.attack(target);
                    // Remove enemy from list if dead.
                    advanceTurn();
                    break;
                
                default:
                    ConsoleHelper.clear();
                    System.out.println("That is not a valid input! Hiss!\n");
                    break;
            }

        } else {
            // Enemies do things
            enemies[turn-1].attack(player);
            advanceTurn();
        }
    }

    private void advanceTurn() {
        if (turn < enemies.length) { turn++; }
        else { turn = 0; }
    }

    private Actor chooseTarget() {
        @SuppressWarnings("resource") //Can't close playerInput because it will kill System.in program-wide
        Scanner playerInput = new Scanner(System.in);
        int rawInput;

        for (int i = 0; i < enemies.length; i++) {
            System.out.println((i+1) + ". " + enemies[i].getName());
        }

        System.out.print("Choose a target: ");
        rawInput = playerInput.nextInt();

        return enemies[rawInput-1];
        
    }
}
