package menu;

import util.DBUtil;

import java.util.Scanner;

public class SubMenuOptions {

    private MenuCustomer menuCustomer;
    private MenuInspector menuInspector;
    private MenuInspection menuInspection;
    private MenuStatistics menuStatistics;

    public SubMenuOptions() {
        this.menuInspector = new MenuInspector();
        this.menuInspection = new MenuInspection();
        this.menuStatistics = new MenuStatistics();
    }


    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the menu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: Sub Menu - Inspector");
        System.out.println("2: Sub Menu - Inspection");
        System.out.println("3: Sub Menu - Statistics");
        System.out.println("4: Sub Menu - <NAME>");
        System.out.println("100 - Quit");
        System.out.println("\n/***************************************************/");

        return input.nextInt();
    }

    public void menuChoice(Scanner input) {

        int userChoice;
        do {
            userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    this.menuInspector.menuChoice(input);
                    break;
                case 2:
                    this.menuInspection.menuChoice(input);
                    break;
                case 3:
                    this.menuStatistics.menuChoice(input);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 100:
                    input.close();
                    break;
                default:
                    System.out.println("\nSorry, please enter valid Option");
                    menuOptions(input);
                    break;
            }// End of switch statement
        } while (userChoice != 100);
        System.out.println("Closing system...");
        System.out.println("Thank you. Good Bye.");

    }




}
