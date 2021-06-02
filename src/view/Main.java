package view;

import controller.MainController;

import java.util.Scanner;

public class Main {
    static final int ADD_SERVICE = 1;
    static final int SHOW_SERVICE = 2;
    static final int ADD_CUSTOMER = 3;
    static final int SHOW_CUSTOMER = 4;
    static final int ADD_BOOKING = 5;
    static final int SHOW_EMPLOYEE = 6;
    static final int EXIT = 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                //Hiển thị MENU chức năng
                MainController.displayMainMenu();
                //chọn chức năng
                System.out.print("Choose function: ");
                int chucNang = Integer.parseInt(sc.nextLine());
                switch (chucNang) {
                    case ADD_SERVICE:
                        MainController.addNewServies();
                        break;
                    case SHOW_SERVICE:
                        MainController.showServices();
                        break;
                    case ADD_CUSTOMER:
                        MainController.addNewCustomer();
                        break;
                    case SHOW_CUSTOMER:
                        MainController.showCustomers();
                        break;
                    case ADD_BOOKING:
                        MainController.addNewBooking();
                        break;
                    case SHOW_EMPLOYEE:
                        MainController.showEmployee();
                        break;
                    case EXIT:
                        System.exit(1);
                    default:
                        System.err.println("Please choose function in the MENU");
                }
            } catch (NumberFormatException | InterruptedException e) {
                System.err.println("Invalid input! Please type A NUMBER!");
            }
        } while (true);
    }
}
