package controller;

import models.Student;
import java.io.*;
import java.util.HashMap;

public class ReadDataController extends BaseController {
    private static final String FILE_PATH = "src/main/resources/registrations.dat";

    public static HashMap<String, Student> readRegistrationData() {
        HashMap<String, Student> loadedStudents = new HashMap<>();
        File file = new File(FILE_PATH);
        
        if (!file.exists()) {
            System.out.println("No existing registration data found.");
            return loadedStudents;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            loadedStudents = (HashMap<String, Student>) ois.readObject();
            System.out.println("Registration data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading registration data: " + e.getMessage());
        }

        return loadedStudents;
    }
}
