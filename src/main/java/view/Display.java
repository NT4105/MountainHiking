package view;

import models.Student;
import java.util.HashMap;

public class Display {
    public void displayRegisteredList(HashMap<String, Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students have registered yet.");
            return;
        }

        System.out.println("Registered Students:");
        System.out.println(
                "--------------------------------------------------------------------------------------------------");
        System.out.printf("%-12s | %-20s | %-12s | %-25s | %-9s | %s%n",
                "Student ID", "Name", "Phone", "Email", "Peak Code", "Fee");
        System.out.println(
                "--------------------------------------------------------------------------------------------------");

        for (Student student : students.values()) {
            System.out.printf("%-12s | %-20s | %-12s | %-25s | %-9s | %,d%n",
                    student.getId(),
                    student.getName(),
                    student.getPhone(),
                    student.getEmail(),
                    student.getMountainCode(),
                    (long) student.getTutionFee());
        }
        System.out.println(
                "--------------------------------------------------------------------------------------------------");
    }
}