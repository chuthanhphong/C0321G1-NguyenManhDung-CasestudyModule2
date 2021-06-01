package manager;

import common.NameCustomerComparator;
import common.ValidateCustomer;
import common.WriteAndReadFunc;
import model.*;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ManagerCustomer {
    ValidateCustomer validateCustomer = new ValidateCustomer();
    WriteAndReadFunc writeReadFile = new WriteAndReadFunc();

    public void addNewCustomer() throws Exception {
        Scanner sc = new Scanner(System.in);
        String name, dateOfBirth, email, typeCustomer, address, gender, id, phoneNumber;
        do {
            System.out.print("\t\tName: ");
            name = sc.nextLine().trim();
            if (!validateCustomer.validateName(name)) {
                System.out.println("---LỖI: Tên Khách hàng phải in hoa ký tự đầu tiên trong mỗi từ---");
                continue;
            }
            break;
        } while (true);
        do {
            System.out.print("\t\tDate of Birth (dd/mm/YYYY): ");
            dateOfBirth = sc.nextLine().trim();
            if (!validateCustomer.validateDateOfBirth(dateOfBirth)) {
                System.out.println("---LỖI: Năm sinh phải >1900 và nhỏ hơn năm hiện tại 18 năm, đúng định dạng dd/mm/yyyy---");
                continue;
            }
            break;
        } while (true);
        do {
            System.out.print("\t\tGender: ");
            gender = sc.nextLine().trim();
            if (!validateCustomer.validateGender(gender)) {
                System.out.println("---LỖI: Giới tính chỉ chấp nhận Male, Female hoặc Unknow");
                continue;
            }
            break;
        } while (true);
        do {
            System.out.print("\t\tID: ");
            id = sc.nextLine().trim();
            if (!validateCustomer.validateID(id)) {
                System.out.println("---LỖI: Id Card phải có 9 chữ số và theo định dạng XXX XXX XXX");
                continue;
            }
            List<Customer> list = writeReadFile.readCustomersFile();
            boolean isContinue = false;
            for (Customer customer:list){
                if (customer.getId().equals(id)){
                    System.out.println("---LỖI: Id Card đã tồn tại");
                    isContinue = true;
                    break;
                }
            }
            if (!isContinue) {
                break;
            }
        } while (true);
        do {
            System.out.print("\t\tPhone Number: ");
            phoneNumber = sc.nextLine().trim();
            if (!validateCustomer.validatePhoneNumber(phoneNumber)) {
                System.out.println("---LỖI: SĐT phải là 10 chữ số viết liền nhau");
                continue;
            }
            break;
        } while (true);
        do {
            System.out.print("\t\tEmail: ");
            email = sc.nextLine().trim();
            if (!validateCustomer.validateEmail(email)) {
                System.out.println("---LỖI: Email phải đúng định dạng abc@abc.abc");
                continue;
            }
            break;
        } while (true);

        System.out.print("\t\tType of Customer: ");
        typeCustomer = sc.nextLine();
        System.out.print("\t\tAddress: ");
        address = sc.nextLine();
        System.out.print("\t\tDịch vụ sử dụng: 1.Villa \t2.House \t3.Room\t");
        Services serviceUsing = null;
        do {
            try {
                int choice = Integer.parseInt(sc.nextLine());
                ManagerService managerService = new ManagerService();
                switch (choice) {
                    case 1:
                        managerService.showAllVillas();
                        List<Villa> listVilla = writeReadFile.readVillasFile();
                        int numberOfVilla = listVilla.size();
                        System.out.print("Chọn Villa số: ");
                        int chooseVilla;
                        do {
                            chooseVilla = Integer.parseInt(sc.nextLine());
                        } while (chooseVilla <= 0 || chooseVilla > numberOfVilla);
                        serviceUsing = (Services) listVilla.get(chooseVilla - 1);
                        break;
                    case 2:
                        managerService.showAllHouses();
                        List<House> listHouse = writeReadFile.readHousesFile();
                        int numberOfHouse = listHouse.size();
                        System.out.print("Chọn House số: ");
                        int chooseHouse;
                        do {
                            chooseHouse = Integer.parseInt(sc.nextLine());
                        } while (chooseHouse <= 0 || chooseHouse > numberOfHouse);
                        serviceUsing = (Services) listHouse.get(chooseHouse - 1);
                        break;
                    case 3:
                        managerService.showAllRooms();
                        List<Room> listRoom = writeReadFile.readRoomsFile();
                        int numberOfRoom = listRoom.size();
                        System.out.print("Chọn Room số: ");
                        int chooseRoom;
                        do {
                            chooseRoom = Integer.parseInt(sc.nextLine());
                        } while (chooseRoom <= 0 || chooseRoom > numberOfRoom);
                        serviceUsing = (Services) listRoom.get(chooseRoom - 1);
                        break;
                    default:
                        System.out.println("---LỖI: Chọn 1 hoặc 2 hoặc 3!---");
                }
            } catch (NumberFormatException e) {
                System.out.println("---LỖI: Vui lòng nhập kí tự---");
            }
        } while (serviceUsing == null);
        Customer customer = new Customer(name, dateOfBirth, gender, id, phoneNumber, email, typeCustomer, address, serviceUsing);
        writeReadFile.writeToCSVFile(customer);
    }

    public void showInforAllCustomer() {
        List<Customer> list = writeReadFile.readCustomersFile();
        Collections.sort(list, new NameCustomerComparator());
        for (int i=0; i<list.size()-1; i++) {
            for (int j=i+1; j<list.size(); j++) {
                if (list.get(i).getName().equals(list.get(j).getName())){
                    if (list.get(i).compareDateOfBirthAcsending(list.get(j)) == 1){
                        Collections.swap(list,i,j);
                    }
                }else {
                    i = j-1;
                    break;
                }
            }
        }
        int i = 1;
        for (Customer customer : list) {
            System.out.print(i++ + ".\t");
            customer.showInfo();
            System.out.println();
        }
    }
}
