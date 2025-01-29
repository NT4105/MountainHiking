package view;

import models.Student;
import java.util.HashMap;

public class Display {
        public void displayRegisteredList(HashMap<String, Student> students) {
                System.out.println(
                                "+------------+----------------------+---------------+--------------------------------+-----------+---------------+");
                System.out.printf("| %-10s | %-20s | %-13s | %-30s | %-9s | %-13s |%n",
                                "Student ID", "Name", "Phone", "Email", "Peak Code", "Fee");
                System.out.println(
                                "+------------+----------------------+---------------+--------------------------------+-----------+---------------+");

                for (Student student : students.values()) {
                        System.out.printf("| %-10s | %-20s | %-13s | %-30s | %-9s | %,13.2f |%n",
                                        student.getId(),
                                        student.getName(),
                                        student.getPhone(),
                                        student.getEmail(),
                                        student.getMountainCode(),
                                        student.getTutionFee());
                }
                System.out.println(
                                "+------------+----------------------+---------------+--------------------------------+-----------+---------------+");
        }

        public void displayStudentInfo(Student student) {
                System.out.println("+------------------------------------------+");
                System.out.printf("| Student ID: %-30s |%n", student.getId());
                System.out.printf("| Name      : %-30s |%n", student.getName());
                System.out.printf("| Phone     : %-30s |%n", student.getPhone());
                System.out.printf("| Email     : %-30s |%n", student.getEmail());
                System.out.printf("| Peak Code : %-30s |%n", student.getMountainCode());
                System.out.printf("| Fee       : %-,30.2f |%n", student.getTutionFee());
                System.out.println("+------------------------------------------+");
        }
}