package controller;

import models.Student;
import view.Menu;
import view.Display;

public class MainMenuController extends BaseController {

    public MainMenuController() {
        super();
    }

    public void displayMainMenu() {
        while (true) {
            menu.MainMenu();
            int choice = getValidChoice(0, 8);

            switch (choice) {
                case 1:
                    new RegisterController(students).displayRegisterMenu();
                    break;
                case 2:
                    new UpdateController(students).displayUpdateMenu();
                    break;
                case 3:
                    new DisplayInfoController().displayInfo();
                    break;
                case 4:
                    new DeleteInfoController().displayDeleteMenu();
                    break;
                case 5:
                    new SearchMenuController().displaySearchMenu();
                    break;
                case 6:
                    new FilterMenuController().displayFilterMenu();
                    break;
                case 7:
                    new StatisticsController().displayStatisticsMenu();
                    break;
                case 8:
                    new SaveDataController().displaySaveDataMenu();
                    break;
                case 0:
                    System.out.println("Exiting the application.");
                    System.exit(0);
                    break;
            }
        }
    }
}
