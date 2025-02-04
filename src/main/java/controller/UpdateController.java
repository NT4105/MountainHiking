package controller;

import models.Student;
import validation.StudentValidator;
import java.util.HashMap;

public class UpdateController extends BaseController {
    private final HashMap<String, Student> students;

    public UpdateController(HashMap<String, Student> students) {
        super();
        this.students = students;
    }

    public void displayUpdateMenu() {
        try {
            while (true) {
                System.out.println("[1] Update Registration Information");
                System.out.println("[0] Back to Main Menu");
                int choice = getValidChoice(0, 1);
                if (choice == 1) {
                    updateStudentInfo();
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

    private void updateStudentInfo() {
        String id;
        do {
            System.out.print("Enter student ID to update: ");
            id = scanner.nextLine().trim();
        } while (!StudentValidator.isValidId(id, students));

        if (!id.isEmpty() && StudentValidator.isValidId(id, students)) {
            Student student = students.get(id);
            if (student == null) {
                System.out.println("This student has not registered yet!.");
                return;
            }

            updateStudentInfo(student);
            System.out.println("Student information updated successfully!");
        }
    }

    private void updateStudentInfo(Student student) {
        // Update name
        System.out.print("Enter new name (or press Enter to keep current: " + student.getName() + "): ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty() && StudentValidator.isValidName(name)) {
            student.setName(name);
            hasUnsavedChanges = true;
        }

        // Update phone
        System.out.print("Enter new phone (or press Enter to keep current: " + student.getPhone() + "): ");
        String phone = scanner.nextLine().trim();
        if (!phone.isEmpty() && StudentValidator.isValidPhone(phone)) {
            student.setPhone(phone);
            hasUnsavedChanges = true;
        }

        // Update email
        System.out.print("Enter new email (or press Enter to keep current: " + student.getEmail() + "): ");
        String email = scanner.nextLine().trim();
        if (!email.isEmpty() && StudentValidator.isValidEmail(email)) {
            student.setEmail(email);
            hasUnsavedChanges = true;
        }

        // Update mountain code
        System.out
                .print("Enter new mountain code (or press Enter to keep current: " + student.getMountainCode() + "): ");
        String mountainCode = scanner.nextLine().trim();
        if (!mountainCode.isEmpty() && StudentValidator.isValidMountainCode(mountainCode)) {
            student.setMountainCode(mountainCode);
            hasUnsavedChanges = true;
        }
    }
}