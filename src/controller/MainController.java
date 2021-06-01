package controller;

import manager.ManagerCustomer;
import manager.ManagerService;
import model.Customer;

import java.util.List;
import java.util.Scanner;

public class MainController {
    static ManagerService service = new ManagerService();
    static ManagerCustomer customer = new ManagerCustomer();

    //1.Add service 2.Show service 3.Add customer 4.Show customer
    //5.Add booking 6.Show Employee 7.Exit
    public static void displayMainMenu() {
        System.out.println();
        int lengthOfFrame = 40;
        for (int i = 1; i <= lengthOfFrame; i++) {
            if (i == 19) {
                System.out.print("MENU");
                i = 22;
            } else {
                System.out.print("-");
            }
        }
        String str1 = "|\t1. Add New Services";
        System.out.print("\n" + str1);
        for (int i = str1.length() + 1; i < lengthOfFrame - 2; i++) {
            System.out.print(" ");
        }
        System.out.print("|");

        String str2 = "|\t2. Show Services";
        System.out.print("\n" + str2);
        for (int i = str2.length() + 1; i < lengthOfFrame - 2; i++) {
            System.out.print(" ");
        }
        System.out.print("|");

        String str3 = "|\t3. Add New Customer";
        System.out.print("\n" + str3);
        for (int i = str3.length() + 1; i < lengthOfFrame - 2; i++) {
            System.out.print(" ");
        }
        System.out.print("|");

        String str4 = "|\t4. Show Information of Customer";
        System.out.print("\n" + str4);
        for (int i = str4.length() + 1; i < lengthOfFrame - 2; i++) {
            System.out.print(" ");
        }
        System.out.print("|");

        String str5 = "|\t5. Add New Booking";
        System.out.print("\n" + str5);
        for (int i = str5.length() + 1; i < lengthOfFrame - 2; i++) {
            System.out.print(" ");
        }
        System.out.print("|");

        String str6 = "|\t6. Show Information of Employee";
        System.out.print("\n" + str6);
        for (int i = str6.length() + 1; i < lengthOfFrame - 2; i++) {
            System.out.print(" ");
        }
        System.out.print("|");

        String str7 = "|\t7. Exit";
        System.out.print("\n" + str7);
        for (int i = str7.length() + 1; i < lengthOfFrame - 2; i++) {
            System.out.print(" ");
        }
        System.out.println("|");

        for (int i = 1; i <= lengthOfFrame; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void addNewServies() {
        System.out.println("-----Add New Service-----");
        System.out.println("\t1. Add New Villa\n" +
                "\t2. Add New House\n" +
                "\t3. Add New Room\n" +
                "\t4. Back to menu\n");
        boolean isAddContinue;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        service.addVilla();
                        break;
                    case 2:
                        service.addHouse();
                        break;
                    case 3:
                        service.addRoom();
                        break;
                    case 4:
                        displayMainMenu();
                        break;
                    default:
                        System.out.println("Please choose function in the MENU!");
                        break;
                }
                isAddContinue = false;
            } catch (NumberFormatException numberFormatException) {
                System.err.println("Invalid input! Please type a number!");
                isAddContinue = true;
            }
        } while (isAddContinue);
    }

    public static void showServices() {
        System.out.println("-----Show Services-----");
        System.out.println( "\t1. Show all Villa\n" +
                            "\t2. Show all House\n" +
                            "\t3. Show all Room\n" +
                            "\t4. Show all Name Villa Not Duplicate\n" +
                            "\t5. Show all Name House Not Duplicate\n" +
                            "\t6. Show all Name Name Not Duplicate\n" +
                            "\t7. Back to menu\n");
        boolean isShowContinue;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        service.showAllVillas();
                        break;
                    case 2:
                        service.showAllHouses();
                        break;
                    case 3:
                        service.showAllRooms();
                        break;
                    case 4:
                        service.showVillasNotDuplicateName();
                        break;
                    case 5:
                        service.showHousesNotDuplicateName();
                        break;
                    case 6:
                        service.showRoomsNotDuplicateName();
                        break;
                    case 7:
                        displayMainMenu();
                        break;
                    default:
                        System.out.println("Please choose function in the MENU!");
                        break;
                }
                isShowContinue = false;
            } catch (NumberFormatException numberFormatException) {
                System.err.println("Invalid input! Please type a number!");
                isShowContinue = true;
            }
        } while (isShowContinue);
    }

    public static void addNewCustomer(){
        try {
            customer.addNewCustomer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void showCustomers(){
       try {
           customer.showInforAllCustomer();
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
