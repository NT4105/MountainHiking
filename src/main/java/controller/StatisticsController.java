package controller;

import models.Student;
import view.Display;
import java.util.HashMap;

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

        // Create maps to store statistics
        HashMap<String, Integer> participantCount = new HashMap<>();
        HashMap<String, Double> totalCost = new HashMap<>();

        // Calculate statistics
        for (Student student : students.values()) {
            String mountainCode = student.getMountainCode();
            participantCount.merge(mountainCode, 1, Integer::sum);
            totalCost.merge(mountainCode, student.getTutionFee(), Double::sum);
        }

        System.out.println("Statistics of Registration by Mountain Peak:");
        display.displayStatistics(students);
    }
}
