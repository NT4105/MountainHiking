package view;

public class Menu {
    public void MainMenu() {
        System.out.println("+----------------Main Menu----------------+");
        System.out.println("| 1. New Registration                     |");
        System.out.println("| 2. Update Registration Information      |");
        System.out.println("| 3. Display Registered List              |");
        System.out.println("| 4. Delete Registration Information      |");
        System.out.println("| 5. Search Participants by Name          |");
        System.out.println("| 6. Filter Data by Campus                |");
        System.out.println("| 7. Statistics of Registration           |");
        System.out.println("| 8. Save to File                         |");
        System.out.println("| 9. Exit the program                     |");
        System.out.println("+-----------------------------------------+");
    }

    public void RegisterMenu() {
        System.out.println("+---------------New Registration---------------+");
    }

    public void UpdateMenu() {
        System.out.println("+---------------Update Menu----------------+");
        System.out.println("| Enter student ID to update information   |");
        System.out.println("|                                          |");
        System.out.println("+------------------------------------------+");
    }

}
