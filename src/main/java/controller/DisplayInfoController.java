package controller;

import view.Display;

public class DisplayInfoController extends BaseController {
    private Display display;

    public DisplayInfoController() {
        super();
        this.display = new Display();
    }

    public void displayInfo() {
        while (true) {
            display.displayRegisteredList(students);

            String choice;
            do {
                System.out.print("Back to main menu? (Y/N): ");
                choice = scanner.nextLine().trim().toUpperCase();
                if (choice.equals("Y")) {
                    return;
                } else if (choice.equals("N")) {
                    break;
                }
                System.out.println("Please enter Y or N!");
            } while (!choice.equals("Y") && !choice.equals("N"));
        }
    }
}
