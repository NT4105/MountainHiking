package controller;

import view.Display;
import validation.StudentValidator;
import models.Student;

public class FilterMenuController extends BaseController {
    private Display display;

    public FilterMenuController() {
        super();
    }

    public void displayFilterMenu() {
        try {
            while (true) {
                System.out.println("[1] Filter Data by Campus");
                System.out.println("[0] Back to Main Menu");
                int choice = getValidChoice(0, 1);
                if (choice == 1) {
                    filterByCampus();
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

    private void filterByCampus() {
        String campusCode;
        do {
            System.out.println("Enter Campus Code to filter (e.g., CE, DE, HE, SE, QE): ");
            campusCode = scanner.nextLine().trim();
        } while (!StudentValidator.isValidCampusCode(campusCode));

        if (students == null) {
            System.out.println("No students have registered under this campus.");
            return;
        }

        System.out.println("Registered Students Under " + campusCode + " Campus (" + campusCode + ")");
        display.displayRegisteredList(students);
    }

}
