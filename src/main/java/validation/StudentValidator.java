package validation;

import java.util.HashMap;
import java.util.regex.Pattern;
import models.Student;
import models.Mountain;

public class StudentValidator {
    private static final Pattern STUDENT_ID_PATTERN = Pattern.compile("^(SE|HE|DE|QE|CE)\\d{6}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile(
            "^(086|096|097|098|032|033|034|035|036|037|038|039|089|090|093|070|079|077|076|078|088|091|094|083|084|085|081|082|092|056|058|099|059)\\d{7}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    public static boolean isValidId(String id, HashMap<String, Student> students) {
        if (id.isEmpty()) {
            System.out.println("Student ID cannot be empty!");
            return false;
        }

        if (!STUDENT_ID_PATTERN.matcher(id).matches()) {
            System.out.println("Invalid ID format! Must start with SE, HE, DE, QE, or CE followed by 6 digits.");
            return false;
        }
        return true;
    }

    public static boolean isValidNewId(String id, HashMap<String, Student> students) {
        if (id.isEmpty()) {
            System.out.println("Student ID cannot be empty!");
            return false;
        }

        if (!STUDENT_ID_PATTERN.matcher(id).matches()) {
            System.out.println("Invalid ID format! Must start with SE, HE, DE, QE, or CE followed by 6 digits.");
            return false;
        }
        if (students.containsKey(id)) {
            System.out.println("Student ID already exists!");
            return false;
        }
        return true;
    }

    public static boolean isValidName(String name) {
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty!");
            return false;
        }
        if (name.length() < 2 || name.length() > 20) {
            System.out.println("Name must be between 2 and 20 characters!");
            return false;
        }
        return true;
    }

    public static boolean isValidPhone(String phone) {
        if (phone.isEmpty()) {
            System.out.println("Phone number cannot be empty!");
            return false;
        }

        if (phone.length() != 10) {
            System.out.println("Phone number must be 10 digits!");
            return false;
        }

        if (!PHONE_PATTERN.matcher(phone).matches()) {
            System.out.println("Invalid phone number! Must be a valid Vietnamese phone number.");
            return false;
        }
        return true;
    }

    public static boolean isValidEmail(String email) {
        if (email.isEmpty()) {
            System.out.println("Email cannot be empty!");
            return false;
        }

        if (!EMAIL_PATTERN.matcher(email).matches()) {
            System.out.println("Invalid email format!");
            return false;
        }
        return true;
    }

    public static boolean isValidMountainCode(String mountainCode) {
        if (mountainCode.isEmpty()) {
            System.out.println("Mountain code cannot be empty!");
            return false;
        }

        try {
            int number = Integer.parseInt(mountainCode.trim());
            String formattedCode = String.format("MT%02d", number);
            if (!Mountain.isValidMountainCode(formattedCode)) {
                System.out.println("Invalid mountain code! Please enter a valid number from the mountain list.");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
            return false;
        }
    }

    public static boolean isViettelOrVNPT(String phone) {
        String prefix = phone.substring(0, 3);
        return prefix.matches("^(086|096|097|098|032|033|034|035|036|037|038|039).*") || // Viettel
                prefix.matches("^(088|091|094|083|084|085|081|082).*"); // VNPT
    }

    public static boolean isValidCampusCode(String campusCode) {
        if (campusCode.isEmpty()) {
            System.out.println("Campus code cannot be empty!");
            return false;
        }
        if (campusCode.length() != 2) {
            System.out.println("Campus code must be 2 characters!");
            return false;
        }
        String upperCampusCode = campusCode.toUpperCase();
        if (!upperCampusCode.matches("^(CE|DE|HE|SE|QE)$")) {
            System.out.println(
                    "Invalid campus code! Must be one of: CE (Can Tho), DE (Da Nang), HE (Ha Noi), SE (Ho Chi Minh), QE (Quy Nhon)");
            return false;
        }
        return true;
    }
}