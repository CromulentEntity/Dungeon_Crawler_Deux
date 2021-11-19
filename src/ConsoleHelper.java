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
    }

    public static void invalidInputMessage() {
        clear();
        System.out.println("That is not a valid input! Hiss!\n");
    }
}
