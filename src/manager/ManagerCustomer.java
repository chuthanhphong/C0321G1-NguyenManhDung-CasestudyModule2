package manager;

import common.NameCustomerComparator;
import common.ValidateCustomer;
import common.WriteAndReadFunc;
import model.*;

import java.util.*;

public class ManagerCustomer {
    ValidateCustomer validateCustomer = new ValidateCustomer();
    WriteAndReadFunc writeReadFile = new WriteAndReadFunc();

    public void addNewCustomer() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String name, dateOfBirth, email, typeCustomer, address, gender, id, phoneNumber;
        do {
            System.out.print("\t\tName: ");
            name = sc.nextLine().trim();
            if (!validateCustomer.validateName(name)) {
                System.err.println("---Tên Khách hàng phải in hoa ký tự đầu tiên trong mỗi từ---");
                Thread.sleep(250);
                continue;
            }
            break;
        } while (true);
        do {
            System.out.print("\t\tDate of Birth (dd/mm/YYYY): ");
            dateOfBirth = sc.nextLine().trim();
            if (!validateCustomer.validateDateOfBirth(dateOfBirth)) {
                continue;
            }
            break;
        } while (true);
        do {
            System.out.print("\t\tGender: ");
            gender = sc.nextLine().trim();
            if (!validateCustomer.validateGender(gender)) {
                System.err.println("---Giới tính chỉ chấp nhận Male, Female hoặc Unknown---");
                Thread.sleep(250);
                continue;
            }
            break;
        } while (true);
        do {
            System.out.print("\t\tID: ");
            id = sc.nextLine().trim();
            if (!validateCustomer.validateID(id)) {
                System.err.println("---Id Card phải có 9 chữ số và theo định dạng XXX XXX XXX---");
                Thread.sleep(250);
                continue;
            }
            List<Customer> list = writeReadFile.readCustomersFile();
            boolean isContinue = false;
            for (Customer customer : list) {
                if (customer.getId().equals(id)) {
                    System.err.println("---Id Card đã tồn tại---");
                    isContinue = true;
                    Thread.sleep(250);
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
                System.err.println("---SĐT phải là 10 chữ số viết liền nhau---");
                Thread.sleep(250);
                continue;
            }
            break;
        } while (true);
        do {
            System.out.print("\t\tEmail: ");
            email = sc.nextLine().trim();
            if (!validateCustomer.validateEmail(email)) {
                System.err.println("---Email phải đúng định dạng abc@abc.abc---");
                Thread.sleep(250);
                continue;
            }
            break;
        } while (true);

        do {
            System.out.print("\t\tType of Customer: ");
            typeCustomer = sc.nextLine();
            if (!validateCustomer.validateTypeOfCustomer(typeCustomer)) {
                System.err.println("---Kiểu khách hàng là 1 trong các loại: Diamond, Platinium, Gold, Silver, Member---");
                Thread.sleep(250);
                continue;
            }
            break;
        } while (true);
        System.out.print("\t\tAddress: ");
        address = sc.nextLine();
        Customer customer = new Customer(name, dateOfBirth, gender, id, phoneNumber, email, typeCustomer, address);
        List<Customer> list = new ArrayList<>();
        list.add(customer);
        writeReadFile.writeToCSVFile(list, true);
    }

    public List<Customer> showInforAllCustomer() {
        List<Customer> list = writeReadFile.readCustomersFile();
        //Sắp xếp danh sách Customer
        Collections.sort(list, new NameCustomerComparator());
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getName().equals(list.get(j).getName())) {
                    if (list.get(i).compareDateOfBirthAcsending(list.get(j)) == 1) {
                        Collections.swap(list, i, j);
                    }
                } else {
                    i = j - 1;
                    break;
                }
            }
        }
        //In ra màn hình
        int i = 1;
        for (Customer customer : list) {
            System.out.print(i++ + ".\t");
            customer.showInfo();
            System.out.println();
        }
        return list;
    }

    public Customer selectCustomerFromFile() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Customer List-----");
        int indexOfCustomer; //vị trí của khách hàng trong danh sách hiển thị
        List<Customer> customerList = writeReadFile.readCustomersFile();
        //danh sách các Customer đã book phòng
        Map map = writeReadFile.readBookingCsv();
        //không hiển thị các Customer đã book phòng
        customerList.removeIf(o -> map.containsValue(o.getId()));
        if (customerList.size() == 0) {
            System.err.println("---Không còn Customer nào khả dụng---");
            Thread.sleep(250);
            return null;
        } else {
            Collections.sort(customerList, new NameCustomerComparator());
            for (int i = 0; i < customerList.size() - 1; i++) {
                for (int j = i + 1; j < customerList.size(); j++) {
                    if (customerList.get(i).getName().equals(customerList.get(j).getName())) {
                        if (customerList.get(i).compareDateOfBirthAcsending(customerList.get(j)) == 1) {
                            Collections.swap(customerList, i, j);
                        }
                    } else {
                        i = j - 1;
                        break;
                    }
                }
            }
            //In ra màn hình
            int i = 1;
            for (Customer customer : customerList) {
                System.out.print(i++ + ".\t");
                customer.showInfo();
                System.out.println();
            }
        }
        do {
            try {
                Thread.sleep(250);
                System.out.print("Chọn khách hàng: ");
                indexOfCustomer = Integer.parseInt(sc.nextLine());
                if (indexOfCustomer <= 0 || indexOfCustomer > customerList.size() + 1) {
                    System.err.println("---Vui lòng chọn khách hàng trong danh sách---");
                    Thread.sleep(250);
                    continue;
                }
                return customerList.get(indexOfCustomer - 1);
            } catch (NumberFormatException | InterruptedException e) {
                System.err.println("---Nhập đúng định dạng là 1 số---");
            } catch (IndexOutOfBoundsException e) {
                System.err.println("---Vui lòng chọn trong danh sách---");
            }
        } while (true);

    }
}
