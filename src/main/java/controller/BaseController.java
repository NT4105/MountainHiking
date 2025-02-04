package controller;

import java.util.Scanner;
import java.util.HashMap;
import models.Student;
import view.Menu;
import models.Mountain;

public abstract class BaseController {
    protected Menu menu;
    protected Scanner scanner;
    protected static HashMap<String, Student> students = new HashMap<>();
    protected static boolean hasUnsavedChanges = false;

    public BaseController() {
        this.menu = new Menu();
        this.scanner = new Scanner(System.in);
        Mountain.loadMountainCodes();
    }

    protected int getValidChoice(int min, int max) {
        int choice;
        do {
            System.out.print("Plase enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a valid number. Please try again.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice < min || choice > max) {
                System.out.println("Please enter a number between " + min + " and " + max);
            }
        } while (choice < min || choice > max);
        return choice;
    }

    protected boolean confirmBackToMain() {
        while (true) {
            System.out.print("Do you want to continue? (Y/N): ");
            String choice = scanner.nextLine().trim().toUpperCase();
            if (choice.equals("Y")) {
                return false; // Don't go back to main menu
            } else if (choice.equals("N")) {
                return true; // Go back to main menu
            }
            System.out.println("Please enter Y or N!");
        }
    }
}
