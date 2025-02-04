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
            int choice = getValidChoice(0, 9);

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
                case 9:
                    SaveDataController saveDataController = new SaveDataController();
                    ExitController exitController = new ExitController(saveDataController);
                    if (exitController.confirmExit()) {
                        System.exit(0);
                    }
                    break;
                case 0:
                    System.out.println("This function is not available.");
                    break;
                default:
                    System.out.println("This function is not available.");
            }
        }
    }
}
