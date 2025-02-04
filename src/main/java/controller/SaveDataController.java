package controller;

import models.Student;
import java.io.*;

public class SaveDataController extends BaseController {
    private static final String FILE_PATH = "src/main/resources/registrations.dat";

    public SaveDataController() {
        super();
    }

    public void displaySaveDataMenu() {
        try {
            while (true) {
                System.out.println("[1] Save Registration Data");
                System.out.println("[0] Back to Main Menu");
                int choice = getValidChoice(0, 1);
                if (choice == 1) {
                    saveRegistrationData();
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

    public void saveRegistrationData() {
        if (students.isEmpty()) {
            System.out.println("No registration data to save.");
            return;
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(students);
            System.out.println("Registration data has been successfully saved to " + FILE_PATH);
            hasUnsavedChanges = false; // Reset the flag after successful save
        } catch (IOException e) {
            System.out.println("Error saving registration data: " + e.getMessage());
        }
    }
}