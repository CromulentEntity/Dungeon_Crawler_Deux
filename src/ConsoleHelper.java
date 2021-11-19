package src;

import java.util.Scanner;

public class ConsoleHelper {
    private static Scanner playerInput = new Scanner(System.in);

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void enterToContinue() {
        System.out.println("\nPress enter to continue.");
        playerInput.nextLine();
        clear();
    }
}
