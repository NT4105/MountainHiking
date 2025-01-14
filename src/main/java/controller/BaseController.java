package controller;

import java.util.Scanner;
import java.util.HashMap;
import models.Student;
import view.Menu;

public abstract class BaseController {
    protected Menu menu;
    protected Scanner scanner;
    protected static HashMap<String, Student> students = new HashMap<>();

    public BaseController() {
        this.menu = new Menu();
        this.scanner = new Scanner(System.in);
    }

    protected int getValidChoice(int min, int max) {
        int choice;
        do {
            System.out.print("Enter your choice: ");
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
}
