package controller;

import common.WriteAndReadFunc;
import manager.ManagerCustomer;
import manager.ManagerService;
import model.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MainController {
    static ManagerService managerService = new ManagerService();
    static ManagerCustomer managerCustomer = new ManagerCustomer();

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
        boolean isAddContinue;
        do {
            try {
                System.out.println("-----Add New Service-----");
                System.out.println("\t1. Add New Villa\n" +
                        "\t2. Add New House\n" +
                        "\t3. Add New Room\n" +
                        "\t4. Back to menu\n");
                Thread.sleep(250);
                Scanner sc = new Scanner(System.in);
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        managerService.addVilla();
                        isAddContinue = false;
                        break;
                    case 2:
                        managerService.addHouse();
                        isAddContinue = false;
                        break;
                    case 3:
                        managerService.addRoom();
                        isAddContinue = false;
                        break;
                    case 4:
                        isAddContinue = false;
                        break;
                    default:
                        System.err.println("Please choose function in the MENU!");
                        isAddContinue = true;
                        break;
                }
            } catch (NumberFormatException | InterruptedException numberFormatException) {
                System.err.println("Invalid input! Please type a number!");
                isAddContinue = true;
            }
        } while (isAddContinue);
    }

    public static void showServices() {
        boolean isShowContinue;
        do {
            try {
                System.out.println("-----Show Services-----");
                System.out.println("\t1. Show all Villa\n" +
                        "\t2. Show all House\n" +
                        "\t3. Show all Room\n" +
                        "\t4. Show all Name Villa Not Duplicate\n" +
                        "\t5. Show all Name House Not Duplicate\n" +
                        "\t6. Show all Name Name Not Duplicate\n" +
                        "\t7. Back to menu\n");
                Scanner sc = new Scanner(System.in);
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        managerService.showAllVillas();
                        isShowContinue = false;
                        break;
                    case 2:
                        managerService.showAllHouses();
                        isShowContinue = false;
                        break;
                    case 3:
                        managerService.showAllRooms();
                        isShowContinue = false;
                        break;
                    case 4:
                        managerService.showVillasNotDuplicateName();
                        isShowContinue = false;
                        break;
                    case 5:
                        managerService.showHousesNotDuplicateName();
                        isShowContinue = false;
                        break;
                    case 6:
                        managerService.showRoomsNotDuplicateName();
                        isShowContinue = false;
                        break;
                    case 7:
                        isShowContinue = false;
                        break;
                    default:
                        System.err.println("Please choose function in the MENU!");
                        isShowContinue = true;
                        break;
                }
            } catch (NumberFormatException numberFormatException) {
                System.err.println("Invalid input! Please type a number!");
                isShowContinue = true;
            }
        } while (isShowContinue);
    }

    public static void addNewCustomer() {
        try {
            managerCustomer.addNewCustomer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showCustomers() {
        try {
            managerCustomer.showInforAllCustomer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addNewBooking() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        //Chọn khách hàng
        System.out.println("-----Customer List-----");
        int indexOfCustomer; //vị trí của khách hàng trong danh sách hiển thị
        Customer customer = managerCustomer.selectCustomerFromFile();
        if (customer == null){
            return;
        }
        //Chọn loại dịch vụ
        System.out.println("\nChọn loại dịch vụ muốn book: ");
        System.out.println("\t1. Booking Villa" +
                "\t2. Booking House" +
                "\t3. Booking Room");
        int chooseTypeOfService;
        do {
            try {
                Thread.sleep(250);
                chooseTypeOfService = Integer.parseInt(sc.nextLine());
                if (chooseTypeOfService < 1 || chooseTypeOfService > 3) {
                    System.err.println("---Vui lòng chọn chức năng trong Menu---");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } catch (NumberFormatException | InterruptedException e) {
                System.err.println("---Nhập đúng định dạng là 1 số---");
            }
        } while (true);

        //Đặt phòng
        WriteAndReadFunc writeAndReadFunc = new WriteAndReadFunc();
        switch (chooseTypeOfService) {
            case 1:
                Villa villaBooked = managerService.bookVilla();
                if (villaBooked == null) {
                    System.err.println("---Không còn Villa trống để đặt phòng---");
                    Thread.sleep(250);
                    return;
                }
                writeAndReadFunc.writeBookingCsv(villaBooked.getId(), customer.getId());
                customer.setServiceUsing(villaBooked);
                break;
            case 2:
                House houseBooked = managerService.bookHouse();
                if (houseBooked == null) {
                    System.err.println("---Không còn Villa trống để đặt phòng---");
                    Thread.sleep(250);
                    return;
                }
                writeAndReadFunc.writeBookingCsv(houseBooked.getId(), customer.getId());
                customer.setServiceUsing(houseBooked);
                break;
            case 3:
                Room roomBooked = managerService.bookRoom();
                if (roomBooked == null) {
                    System.err.println("---Không còn Villa trống để đặt phòng---");
                    Thread.sleep(250);
                    return;
                }
                writeAndReadFunc.writeBookingCsv(roomBooked.getId(), customer.getId());
                customer.setServiceUsing(roomBooked);
                break;
            default:
                System.err.println("---Chọn chức năng có trong Menu---");
        }
        customer.showInfo();
        //Ghi đè lại vào file Customer để thay đổi thuộc tính Dịch vụ đang sử dụng
        List<Customer> list = writeAndReadFunc.readCustomersFile();
        for (Customer o : list) {
            if (o.getId().equals(customer.getId())) {
                list.set(list.indexOf(o), customer);
            }
        }
        writeAndReadFunc.writeToCSVFile(list);
    }

    public static Map<Integer, Employee> showEmployee(){
        WriteAndReadFunc writeAndReadFunc = new WriteAndReadFunc();
        Map<Integer, Employee> map = writeAndReadFunc.readEmployeeFile();
        Set<Integer> set = map.keySet();
        for (Integer value : set){
            System.out.println(value + ". " + map.get(value).toString());
        }
        return map;
    }
}
