package menu;

import model.Inspection;
import model.Inspector;
import persistence.RepositoryInspection;


import java.util.List;
import java.util.Scanner;

public class MenuInspection {

    RepositoryInspection repositoryInspection = new RepositoryInspection();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List all inspections by inspector's firstName");
        System.out.println("2: ");
        System.out.println("3: ");
        System.out.println("4: ");
        System.out.println("5: ");
        System.out.println("100 - Return to Main Menu");
        System.out.println("\n/***************************************************/");
        return input.nextInt();
    }

    protected void menuChoice(Scanner input) {

        int userChoice;
        do {
            userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    menuListAllInspectionsByInspector(input);
                    break;
                case 2:
                    break;
                case 3:
                    break;
//                case 4:
//                    menuListActiveAndNotActiveCustomers();
//                    break;
//                case 5:
//                    menuUpdatePhoneNumberByCustomerId(input);
//                    break;
                case 100:
                    MainMenu.getMainMenu();
                    break;
                default:
                    System.out.println("\nSorry, please enter valid Option");
                    menuOptions(input);
                    break;
            }// End of switch statement
        } while (userChoice != 100);
    }

    private void menuListAllInspectionsByInspector(Scanner input) {
        System.out.println("Type the Inspector's firstName");
        String firstName = input.next();

        List<Inspection> result = repositoryInspection.listAllInspectionsByInspector(firstName);
        if (result == null) {
            System.out.println("\nInspections not found for this Inspector!\n");
        } else {
            System.out.println(result);
            menuOptions(input);
        }
    }



}
