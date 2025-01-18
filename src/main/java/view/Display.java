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

        public void displayStudentInfo(Student student) {
                // Display student details
                System.out.println("\nStudent Details:");
                System.out.println("-----------------------------------------------------");
                System.out.printf("Student ID: %s%n", student.getId());
                System.out.printf("Name      : %s%n", student.getName());
                System.out.printf("Phone     : %s%n", student.getPhone());
                System.out.printf("Mountain  : %s%n", student.getMountainCode());
                System.out.printf("Fee       : %,d%n", (long) student.getTutionFee());
                System.out.println("-----------------------------------------------------");
        }
}