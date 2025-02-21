package controller;

import models.Student;
import view.Display;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StatisticsController extends BaseController {
    private Display display;

    public StatisticsController() {
        super();
        this.display = new Display();
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
        HashMap<String, String> mountainNames = loadMountainNames();

        // Calculate statistics using mountain names
        for (Student student : students.values()) {
            String mountainCode = student.getMountainCode();
            // Get mountain name from the code (e.g., MT01 -> Ham Rong Mountain)
            String mountainName = mountainNames.getOrDefault(mountainCode, "Unknown Mountain");

            participantCount.merge(mountainName, 1, Integer::sum);
            totalCost.merge(mountainName, student.getTutionFee(), Double::sum);
        }

        System.out.println("\nRegistration Statistics by Mountain:");
        System.out.println("------------------------");
        display.displayStatistics(participantCount, totalCost);
        System.out.println("------------------------");
    }

    private HashMap<String, String> loadMountainNames() {
        HashMap<String, String> mountainNames = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/MountainList.csv"))) {
            // Skip header
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", 3);
                if (values.length >= 2) {
                    // Format the code to match the stored format (e.g., 1 -> MT01)
                    String code = String.format("MT%02d", Integer.parseInt(values[0].trim()));
                    String mountainName = values[1].trim();
                    mountainNames.put(code, mountainName);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading mountain list: " + e.getMessage());
        }
        return mountainNames;
    }
}
