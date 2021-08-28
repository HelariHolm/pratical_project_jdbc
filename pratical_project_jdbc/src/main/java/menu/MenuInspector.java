package menu;

import model.CustomerExample;
import model.Inspector;
import persistence.RepositoryCustomer;
import persistence.RepositoryInspector;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class MenuInspector {

    RepositoryInspector repositoryInspector = new RepositoryInspector();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List all inspectors");
        System.out.println("2: Find inspector by ID");
        System.out.println("3: Update licence expiry date");
        System.out.println("4: Insert new inspector's firstName");
        System.out.println("5: Insert new inspector's lastName");
        System.out.println("6: Insert new inspector's licenceExpiry");
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
                    menuListAllInspectors(input);
                    break;
                case 2:
                    menuFindInspectorById(input);
                    break;
                case 3:
                    menuUpdateInspectorLicenceExpiry(input);
                    break;
                case 4:
                    menuInsertNewInspectorFirstName(input);
                    break;
                case 5:
                    menuInsertNewInspectorLastName(input);
                    break;
                case 6:
                    menuSetInspectorsLicenceExpiry(input);
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



    private void menuListAllInspectors(Scanner input) {
        List<Inspector> listAllInspectors = repositoryInspector.listAllInspectors();

        if (listAllInspectors.size() > 0) {
            System.out.println("\nList of Inspectors:");
            for (Inspector insp : listAllInspectors) {
                System.out.println(insp.toString());
            }
        } else {
            System.out.println("\nNo inspectors registered\n");
            menuOptions(input);
        }
    }

    private void menuFindInspectorById(Scanner input) {
        System.out.println("Type the inspector ID");
        int id = input.nextInt();

        Inspector result = repositoryInspector.findById(id);
        if (result == null) {
            System.out.println("\nInspector not found!\n");
        } else {
            System.out.println(result);
        }
        menuOptions(input);
    }

    private void menuUpdateInspectorLicenceExpiry(Scanner input) {
        System.out.println("Type the inspector ID");
        int id = input.nextInt();

        Inspector result = repositoryInspector.findById(id);
        if (result == null) {
            System.out.println("\nInspector not found!\n");
            menuOptions(input);
        } else {
            System.out.println("Type the new licence expiry date:");
            String expiry = input.next();
            repositoryInspector.updateInspectorLicenceExpiry(expiry, id);
        }
        menuOptions(input);
    }

    private void menuInsertNewInspectorFirstName(Scanner input) {
        System.out.println("Type new inspector's firstName (3-20ch, no special ch or numbers):");
        String firstName = input.next();
        //regular expression
        if (firstName.matches("^[A-Za-z]{3,20}")) {
            repositoryInspector.insertNewFirstName(firstName);
            System.out.println("Insertion was successful!");
        } else {
            System.out.println("Name does not comply with given parameters!");
        }
    }

    private void menuInsertNewInspectorLastName(Scanner input) {
        System.out.println("Type new inspector's lastName (3-30ch, no special ch or numbers):");
        String lastName = input.next();
        //regular expression
        if (lastName.matches("^[A-Za-z]{3,30}")) {
            repositoryInspector.insertNewLastName(lastName);
            System.out.println("Insertion was successful!");
        } else {
            System.out.println("Name does not comply with given parameters!");
        }
    }

    private void menuSetInspectorsLicenceExpiry(Scanner input) {
        System.out.println("Type new inspector's licenceExpiry date (format yyyy-MM-dd):");
        String licenceExpiry = input.next();
        //regular expression
        repositoryInspector.setInspectorsLicenceExpiry(licenceExpiry);
    }

//    private void menuListActiveCustomers() {
//         System.out.println("Total: " + repositoryCustomer.getTotalCustomerActives());
//    }
//
//    private void menuListActiveAndNotActiveCustomers() {
//        List<Object[]> obj = repositoryCustomer.getTotalCustomerActivesAndNotActives();
//        Object result[] = obj.get(0);
//            System.out.println("Total customers active: " + result[0] +" "+ result[1]);
//            //System.out.println("Total customers not active: " + obj[1]);
//    }
//
//    private void menuUpdatePhoneNumberByCustomerId(Scanner scanner) {
//        System.out.println("User id: ");
//        int id = scanner.nextInt();
//        Customer result = repositoryCustomer.findCustomerById(id);
//
//        if (result != null) {
//            System.out.println("New phone number: ");
//            String phoneNumber = scanner.next();
//            repositoryCustomer.updatePhoneNumberByCustomerId(id, phoneNumber);
//
//        } else {
//            System.out.println("User not found");
//            menuOptions(scanner);
//        }
//    }
}
