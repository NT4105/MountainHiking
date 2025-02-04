package controller;

import models.Student;
import models.Mountain;
import validation.StudentValidator;
import java.util.HashMap;

public class RegisterController extends BaseController {
    private final HashMap<String, Student> students;
    private final Mountain mountain;
    private static final double BASE_FEE = 6000000;
    private static final double DISCOUNT = 0.35;

    public RegisterController(HashMap<String, Student> students) {
        super();
        this.students = students;
        this.mountain = new Mountain();
    }

    public void displayRegisterMenu() {
        try {
            while (true) {
                System.out.println("[1] New Registration");
                System.out.println("[0] Back to Main Menu");
                int choice = getValidChoice(0, 1);
                if (choice == 1) {
                    registerStudent();
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

    private boolean registerStudent() {
        String id = inputId();
        String name = inputName();
        String phone = inputPhone();
        String email = inputEmail();
        String mountainCode = inputMountainCode();
        double tuitionFee = calculateTuitionFee(phone);

        Student student = new Student(id, name, phone, email, mountainCode, tuitionFee);
        students.put(id, student);
        if (students.containsKey(id)) {
            System.out.println("Student registered successfully!");
        } else {
            System.out.println("Student registration failed!");
        }
        return true;
    }

    private String inputId() {
        String id;
        do {
            System.out.print("Enter Student ID (e.g., SE123456): ");
            id = scanner.nextLine().toUpperCase();
        } while (!StudentValidator.isValidNewId(id, students));
        return id;
    }

    private String inputName() {
        String name;
        do {
            System.out.print("Enter student name (2-20 characters): ");
            name = scanner.nextLine().trim();
        } while (!StudentValidator.isValidName(name));
        return name;
    }

    private String inputPhone() {
        String phone;
        do {
            System.out.print("Enter phone number (10 digits): ");
            phone = scanner.nextLine();
        } while (!StudentValidator.isValidPhone(phone));
        return phone;
    }

    private String inputEmail() {
        String email;
        do {
            System.out.print("Enter email: ");
            email = scanner.nextLine();
        } while (!StudentValidator.isValidEmail(email));
        return email;
    }

    private String inputMountainCode() {
        String mountainCode;
        do {
            System.out.print("Enter mountain code: ");
            mountainCode = scanner.nextLine();
        } while (!StudentValidator.isValidMountainCode(mountainCode));
        return Mountain.formatMountainCode(mountainCode);
    }

    private double calculateTuitionFee(String phone) {
        return StudentValidator.isViettelOrVNPT(phone) ? BASE_FEE * (1 - DISCOUNT) : BASE_FEE;
    }
}
