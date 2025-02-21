package controller;

import view.Display;
import validation.StudentValidator;
import models.Student;
import java.util.HashMap;

public class FilterMenuController extends BaseController {
    private Display display;

    public FilterMenuController() {
        super();
        this.display = new Display();
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
        if (students.isEmpty()) {
            System.out.println("No registration data available.");
            return;
        }

        String campusCode;
        do {
            System.out.print("Enter Campus Code to filter (e.g., CE, DE, HE, SE, QE): ");
            campusCode = scanner.nextLine().trim().toUpperCase();
        } while (!StudentValidator.isValidCampusCode(campusCode));

        HashMap<String, Student> filteredStudents = new HashMap<>();
        for (Student student : students.values()) {
            if (student.getId().startsWith(campusCode)) {
                filteredStudents.put(student.getId(), student);
            }
        }

        if (filteredStudents.isEmpty()) {
            System.out.println("No students have registered under this campus.");
            return;
        }

        System.out.println("Registered Students Under " + campusCode + " Campus (" + campusCode + ")");
        display.displayRegisteredList(filteredStudents);
        System.out.println("------------------------");
    }

}
