package controller;

import view.Display;

public class DisplayInfoController extends BaseController {
    private Display display;

    public DisplayInfoController() {
        super();
        this.display = new Display();
    }

    public void displayInfo() {
        if (students.isEmpty()) {
            System.out.println("No registration data available.");
            return;
        }
        System.out.println("\nRegistered Students List:");
        System.out.println("------------------------");
        display.displayRegisteredList(students);
        System.out.println("------------------------");
    }
}
