package controller;

import view.Display;

public class DisplayInfoController extends BaseController {
    private Display display;

    public DisplayInfoController() {
        super();
        this.display = new Display();
    }

    public void displayInfo() {
        display.displayRegisteredList(students);
    }
}
