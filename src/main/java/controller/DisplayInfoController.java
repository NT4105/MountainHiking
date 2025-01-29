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
            System.out.println("No students have registered yet.");
            return;
        }
        System.out.println("Registered Students:");
        display.displayRegisteredList(students);
    }
}
