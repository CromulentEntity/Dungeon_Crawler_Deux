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
            System.out.print("1. Attack\n" +
                             "Please choose an option: ");
            
            String rawInput = playerInput.nextLine();

            switch (rawInput) {
                case "1":
                    // Clear console
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    Character target = chooseTarget();

                    player.attack(target);
                    advanceTurn();
                    break;
                
                default:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    
                    System.out.println("That is not a valid input! Hiss!\n");
                    break;


            }
        } else {
            // Enemies do things
            for (int i = 0; i < enemies.length; i++) {
                enemies[i].attack(player);
            }
        }
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
