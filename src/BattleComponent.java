package src;

import java.util.Scanner;

public class BattleComponent {
    Character player;
    Character[] enemies;
    int turn;

    // Constructor
    public BattleComponent(Character player, Character[] enemies) {
        this.player = player;
        this.enemies = enemies;
        this.turn = 0;
    }

    public boolean battle() {
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
                    Character target = chooseTarget();
                    player.attack(target);
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
        }

        // Temporary return statement for compiling purposes
        return true;
    }

    private void advanceTurn() {
        if (turn < enemies.length) { turn++; }
        else { turn = 0; }
    }

    private Character chooseTarget() {
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
