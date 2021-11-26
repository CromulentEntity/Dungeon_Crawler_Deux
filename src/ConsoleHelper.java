// Collection of commonly used System.out type code bits.
// Helps keep menu elements consistent between classes and greatly reduces duplicate code.

package src;

import java.util.Scanner;

public class ConsoleHelper {
    private static Scanner playerInput = new Scanner(System.in);

    // Constructor
    private ConsoleHelper() {}

    // General Methods
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void enterToContinue() {
        System.out.println("\nPress enter to continue.");
        playerInput.nextLine();
        clear();
    }

    public static void displayInfoScreen(String[] info) {
        clear();
        for (int i = 0; i < info.length; i++) {
            System.out.println(info[i]);
        }
        enterToContinue();
    }

    public static void printChoices(String[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println((i+1) + ". " + list[i]);
        }

        System.out.print("\nPlease choose an option: ");
    }

    public static void invalidInputMessage() {
        clear();
        System.out.println("That is not a valid input! Hiss!\n");
    }

    public static String queryPlayer(String query, String[] possibleAnswers) {
        
        // Print query if not empty, then print possible choices
        if ( (!query.equals("")) ) { System.out.println(query); }
        printChoices(possibleAnswers);
        
        // Allow player to input their choice, convert to number if needed
        String playerAnswer = playerInput.nextLine();
        return getIndexFromString(playerAnswer, possibleAnswers);
    }

    private static String getIndexFromString(String playerAnswer, String[] listOfOptions) {
        for (int i = 0; i < listOfOptions.length; i++) {
            
            if (playerAnswer.equals(listOfOptions[i])) {
                return "" + i;
            }
        }

        return playerAnswer;
    }

    public static String getStringInput() {
        return playerInput.nextLine();
    }

    public static int getPositiveIntFromPlayer() {
        while (!playerInput.hasNextInt()) { 
            System.out.print("That wasn't a number, try again: ");
            playerInput.next();
        }

        int input = playerInput.nextInt();

        if (input > 0) {
            playerInput.nextLine(); // Consume newLine character following the int
            return input;
        } else {
            System.out.print("That number wasn't positive, try again: ");
            return getPositiveIntFromPlayer();
        }
    }
}
