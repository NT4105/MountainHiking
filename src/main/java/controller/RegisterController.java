package controller;

import models.Student;
import models.Mountain;
import validation.StudentValidator;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
                menu.RegisterMenu();
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
        hasUnsavedChanges = true;
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
        // Display mountain list first
        System.out.println("\nAvailable Mountain Codes:");
        System.out.println("------------------------");
        // Read MountainList.csv before
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/MountainList.csv"))) {
            // Skip header
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", 3); // Split only first 2 commas
                if (values.length >= 2) {
                    String code = values[0].trim();
                    String mountain = values[1].trim();
                    System.out.printf("MT%02d - %s%n", Integer.parseInt(code), mountain);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading mountain list: " + e.getMessage());
        }
        System.out.println("------------------------");
        String mountainCode;
        do {
            System.out.print("\nEnter mountain code (1-13): ");
            mountainCode = scanner.nextLine();
        } while (!StudentValidator.isValidMountainCode(mountainCode));
        return Mountain.formatMountainCode(mountainCode);
    }

    private double calculateTuitionFee(String phone) {
        return StudentValidator.isViettelOrVNPT(phone) ? BASE_FEE * (1 - DISCOUNT) : BASE_FEE;
    }
}
