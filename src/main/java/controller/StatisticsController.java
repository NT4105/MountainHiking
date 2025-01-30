package controller;

import models.Student;
import view.Display;

public class StatisticsController extends BaseController {
    private Display display;

    public StatisticsController() {
        super();
    }

    public void displayStatisticsMenu() {
        try {
            while (true) {
                System.out.println("[1] View Statistics by Mountain Peak");
                System.out.println("[0] Back to Main Menu");
                System.out.print("Enter your choice: ");
                int choice = getValidChoice(0, 1);
                if (choice == 1) {
                    displayStatistics();
                    if (confirmBackToMain()) {
                        return;
                    }
                } else if (choice == 0) {
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void displayStatistics() {
        if (students.isEmpty()) {
            System.out.println("No registration data available.");
            return;
        }

        System.out.println("Statistics of Registration by Mountain Peak:");
        display.displayStatistics(students);
    }
}
