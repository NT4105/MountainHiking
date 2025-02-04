package controller;

public class ExitController extends BaseController {
    private SaveDataController saveDataController;

    public ExitController(SaveDataController saveDataController) {
        super();
        this.saveDataController = saveDataController;
    }

    public boolean confirmExit() {
        if (hasUnsavedChanges) {
            System.out.print("You have unsaved changes. Do you want to save before exiting? (Y/N): ");
            String response = scanner.nextLine().trim().toUpperCase();

            if (response.equals("Y")) {
                saveDataController.saveRegistrationData();
            } else if (response.equals("N")) {
                System.out.print("Are you sure you want to exit without saving? (Y/N): ");
                response = scanner.nextLine().trim().toUpperCase();
                if (!response.equals("Y")) {
                    return false;
                }
            } else {
                return false;
            }
        }

        System.out.println("Thank you for using the Mountain Hiking Challenge Registration System!");
        return true;
    }
}