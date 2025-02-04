package controller;

import models.Student;
import validation.StudentValidator;
import view.Display;

public class DeleteInfoController extends BaseController {
    private Display display;

    public DeleteInfoController() {
        super();
        this.display = new Display();
    }

    public void displayDeleteMenu() {
        try {
            while (true) {
                System.out.println("[1] Delete Registration Information");
                System.out.println("[0] Back to Main Menu");
                int choice = getValidChoice(0, 1);
                if (choice == 1) {
                    deleteStudentInfo();
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

    private void deleteStudentInfo() {
        String id;
        do {
            System.out.print("Enter student ID to delete: ");
            id = scanner.nextLine().trim();
        } while (!StudentValidator.isValidId(id, students));

        Student student = students.get(id);
        if (student == null) {
            System.out.println("This student has not registered yet.");
            return;
        }

        // Display student information before deletion
        display.displayStudentInfo(student);

        // Confirm deletion
        System.out.print("Are you sure you want to delete this registration? (Y/N): ");
        String confirmation = scanner.nextLine().trim().toUpperCase();

        if (confirmation.equals("Y")) {
            students.remove(id);
            System.out.println("The registration has been successfully deleted.");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
}
