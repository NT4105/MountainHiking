package controller;

import view.Display;
import models.Student;
import validation.StudentValidator;

public class SearchMenuController extends BaseController {
    private Display display;

    public SearchMenuController() {
        super();
        this.display = new Display();
    }

    public void displaySearchMenu() {
        try {
            while (true) {
                System.out.println("[1] Search by Student Name");
                System.out.println("[0] Back to Main Menu");
                int choice = getValidChoice(0, 1);
                if (choice == 1) {
                    searchStudentByName();
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

    private void searchStudentByName() {
        String name;
        do {
            System.out.print("Enter student name to search: ");
            name = scanner.nextLine().trim();
        } while (!StudentValidator.isValidName(name));

        boolean found = false;
        for (Student student : students.values()) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println("Matching Student:");
                display.displayStudentInfo(student);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No one matches the search criteria.");
        }
    }
}
