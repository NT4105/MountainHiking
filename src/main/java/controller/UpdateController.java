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
        while (true) {
            menu.UpdateMenu();
            System.out.print("Enter student ID to update (or 0 to return): ");
            String studentId = scanner.nextLine().toUpperCase();

            if (studentId.equals("0")) {
                break;
            }

            Student student = students.get(studentId);
            if (student == null) {
                System.out.println("This student has not registered yet.");
                continue;
            }

            updateStudentInfo(student);
            System.out.println("Student information updated successfully!");
            break;
        }
    }

    private void updateStudentInfo(Student student) {
        // Update name
        System.out.print("Enter new name (or press Enter to keep current: " + student.getName() + "): ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty() && StudentValidator.isValidName(name)) {
            student.setName(name);
        }

        // Update phone
        System.out.print("Enter new phone (or press Enter to keep current: " + student.getPhone() + "): ");
        String phone = scanner.nextLine().trim();
        if (!phone.isEmpty() && StudentValidator.isValidPhone(phone)) {
            student.setPhone(phone);
        }

        // Update email
        System.out.print("Enter new email (or press Enter to keep current: " + student.getEmail() + "): ");
        String email = scanner.nextLine().trim();
        if (!email.isEmpty() && StudentValidator.isValidEmail(email)) {
            student.setEmail(email);
        }

        // Update mountain code
        System.out
                .print("Enter new mountain code (or press Enter to keep current: " + student.getMountainCode() + "): ");
        String mountainCode = scanner.nextLine().trim();
        if (!mountainCode.isEmpty() && StudentValidator.isValidMountainCode(mountainCode)) {
            student.setMountainCode(mountainCode);
        }
    }
}