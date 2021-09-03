package menu;

import model.ReportAllInspectionsByMonths;
import model.ReportPaymentsByMonth;
import persistence.RepositoryStatistics;

import java.util.List;
import java.util.Scanner;

public class MenuStatistics {

    RepositoryStatistics repositoryStatistics = new RepositoryStatistics();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List payments balance by month");
        System.out.println("2: Count Inspections by Inspector by month");
        System.out.println("3: Count Inspections by Inspector firstName");
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
                    menuSumPaymentsByMonth();
                    break;
                case 2:
                    menuCountInspectionsByMonth(input);
                    break;
                case 3:
                    menuCountInspectionsByInspector(input);
                    break;
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

    private void menuSumPaymentsByMonth() {
        List<ReportPaymentsByMonth> list = repositoryStatistics.paymentsByMonth();
        if (list != null && !list.isEmpty()) {
            for (ReportPaymentsByMonth report : list) {
                System.out.println("Total payments by month:");
                System.out.println(report.getMonth()
                        + "-" + report.getYear()
                        + " = " + report.getAmountSum()
                        + " euros");
            }
        } else {
            System.out.println("No balance to display");
        }
    }

    private void menuCountInspectionsByInspector(Scanner input) {
        System.out.println("Type the Inspector's name: ");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.next();
        List<ReportAllInspectionsByMonths> list = repositoryStatistics.inspectionsBySpecificInspector(firstName);
        if (list != null && !list.isEmpty()) {
            for (ReportAllInspectionsByMonths report : list) {
                System.out.println("Total inspections by inspector " + firstName + " monthly:");
                String word;
                if (report.getInspectionCount() == 1) {
                    word = "inspection";
                } else {word = "inspections";}
                System.out.println(report.getMonth()
                        + "-" + report.getYear()
                        + " - " +report.getFirstName()
                        + " - " + report.getInspectionCount()
                        + " " + word);
            }
        } else {
            System.out.println("No inspections to display");
        }
    }

    private void menuCountInspectionsByMonth(Scanner input) {
        System.out.println("Type the month's name: ");
        Scanner scanner = new Scanner(System.in);
        String month = scanner.next();
        List<ReportAllInspectionsByMonths> list = repositoryStatistics.inspectionsByMonths(month);
        if (list != null && !list.isEmpty()) {
            for (ReportAllInspectionsByMonths report : list) {
                System.out.println("Total inspections in " + month + ": ");
                String word;
                if (report.getInspectionCount() == 1) {
                    word = "inspection";
                } else {word = "inspections";}
                System.out.println(report.getYear()
                        + " - " + report.getFirstName()
                        + " - " + report.getInspectionCount()
                        + " " + word);
            }
        } else {
            System.out.println("No inspections to display");
        }

    }


}
