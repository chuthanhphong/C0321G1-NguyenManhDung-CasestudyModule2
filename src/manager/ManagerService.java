package manager;

import common.Validate;
import common.WriteAndReadFunc;
import model.House;
import model.Room;
import model.Villa;

import java.util.*;

public class ManagerService {
    Validate validate = new Validate();
    //Thêm villa vào file villas.csv
    public void addVilla(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Add New Villa-----");
        try {
            //id
            String addId;
            do {
                System.out.print("\tID: ");
                addId = sc.nextLine();
                if (!validate.validateId(addId, "villa")){
                    System.out.println("LỖI: Định dạng ID không hợp lệ\n");
                    continue;
                }
                if (WriteAndReadFunc.isIdExist(addId, "villas.csv")) {
                    continue;
                }
                break;
            }while (true);
            //serviceName
            String addServiceName;
            do {
                System.out.print("\tTên dịch vụ: ");
                addServiceName = sc.nextLine();
                if (!validate.validateServiceName(addServiceName)){
                    System.out.println("LỖI: Định dạng Tên Dịch Vụ không hợp lệ\n");
                    continue;
                }
                break;
            }while (true);
            //Area
            float addArea;
            do {
                System.out.print("\tDiện tích Villa (m2): ");
                addArea = Float.parseFloat(sc.nextLine());
                if (!validate.validateArea(addArea)){
                    System.out.println("LỖI: Diện Tích Sử Dụng phải lớn hơn 30\n");
                    continue;
                }
                break;
            }while (true);
            //maxPeople
            int addMaxPeople;
            do {
                System.out.print("\tSố người tối đa: ");
                addMaxPeople = Integer.parseInt(sc.nextLine());
                if (!validate.validateMaxPeople(addMaxPeople)){
                    System.out.println("LỖI: Số Người Tối Đa phải lớn hơn 0 và bé hơn 20\n");
                    continue;
                }
                break;
            }while (true);
            //rentType
            String addRentType = null;
            do {
                System.out.println("\tHình thức thuê: ");
                System.out.println("\t\t1. Thuê theo năm");
                System.out.println("\t\t2. Thuê theo tháng");
                System.out.println("\t\t3. Thuê theo ngày");
                System.out.println("\t\t4. Thuê theo giờ");
                int chooseRentType = Integer.parseInt(sc.nextLine());
                switch (chooseRentType) {
                    case 1:
                        addRentType = "năm";
                        break;
                    case 2:
                        addRentType = "tháng";
                        break;
                    case 3:
                        addRentType = "ngày";
                        break;
                    case 4:
                        addRentType = "giờ";
                        break;
                }
            } while (addRentType == null);
            //rentTime
            System.out.print("\tThời gian thuê theo " + addRentType + ": ");
            int addRentTime = Integer.parseInt(sc.nextLine());
            //price
            float addPrice;
            do {
                System.out.print("\tGiá tiền thuê theo " + addRentType + ": ");
                addPrice = Float.parseFloat(sc.nextLine());
                if (!validate.validatePrice(addPrice)){
                    System.out.println("LỖI: Giá Tiền không hợp lệ\n");
                    continue;
                }
                break;
            }while (true);
            //typeOfRoom
            String addTypeOfRoom;
            do {
                System.out.print("\tLoại phòng: ");
                addTypeOfRoom = sc.nextLine();
                if (!validate.validateTypeOfRoom(addTypeOfRoom)){
                    System.out.println("LỖI: Loại Phòng không hợp lệ\n");
                    continue;
                }
                break;
            }while (true);
            //swimmingPool
            float addSwimmingPoolArea;
            do {
                System.out.print("\tDiện tích bể bơi (m2): ");
                addSwimmingPoolArea = Float.parseFloat(sc.nextLine());
                if (!validate.validateSwimmingPool(addSwimmingPoolArea)){
                    System.out.println("LỖI: Diện Tích Bể Bơi không hợp lệ\n");
                    continue;
                }
                break;
            }while (true);
            //floors
            int addFloors;
            do {
                System.out.print("\tSố tầng: ");
                addFloors = Integer.parseInt(sc.nextLine());
                if (!validate.validateFloors(addFloors)){
                    System.out.println("LỖI: Số Tầng không hợp lệ\n");
                    continue;
                }
                break;
            }while (true);
            System.out.print("\tCác tiện ích khác: ");
            String addUtilityDescription = sc.nextLine();

            Villa addVilla = new Villa(addId, addServiceName, addArea,addPrice, addMaxPeople, addRentType,addRentTime ,addTypeOfRoom, addUtilityDescription, addSwimmingPoolArea, addFloors);
            WriteAndReadFunc.writeToCSVFile(addVilla);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("LỖI: Kiểm tra định dạng nhập vào!\n");
        }
    }

    //Thêm house vào file houses.csv
    public void addHouse(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Add New House-----");
        try {
            //id
            String addId;
            do {
                System.out.print("\tID: ");
                addId = sc.nextLine();
                if (!validate.validateId(addId, "house")){
                    System.out.println("LỖI: Định dạng ID không hợp lệ\n");
                    continue;
                }
                if (WriteAndReadFunc.isIdExist(addId, "villas.csv")) {
                    continue;
                }
                break;
            }while (true);
            //serviceName
            String addServiceName;
            do {
                System.out.print("\tTên dịch vụ: ");
                addServiceName = sc.nextLine();
                if (!validate.validateServiceName(addServiceName)){
                    System.out.println("LỖI: Định dạng Tên Dịch Vụ không hợp lệ\n");
                    continue;
                }
                break;
            }while (true);
            //Area
            float addArea;
            do {
                System.out.print("\tDiện tích Villa (m2): ");
                addArea = Float.parseFloat(sc.nextLine());
                if (!validate.validateArea(addArea)){
                    System.out.println("LỖI: Diện Tích Sử Dụng phải lớn hơn 30\n");

                    continue;
                }
                break;
            }while (true);
            //maxPeople
            int addMaxPeople;
            do {
                System.out.print("\tSố người tối đa: ");
                addMaxPeople = Integer.parseInt(sc.nextLine());
                if (!validate.validateMaxPeople(addMaxPeople)){
                    System.out.println("LỖI: Số Người Tối Đa phải lớn hơn 0 và bé hơn 20\n");

                    continue;
                }
                break;
            }while (true);
            //rentType
            String addRentType = null;
            do {
                System.out.println("\tHình thức thuê: ");
                System.out.println("\t\t1. Thuê theo năm");
                System.out.println("\t\t2. Thuê theo tháng");
                System.out.println("\t\t3. Thuê theo ngày");
                System.out.println("\t\t4. Thuê theo giờ");
                int chooseRentType = Integer.parseInt(sc.nextLine());
                switch (chooseRentType) {
                    case 1:
                        addRentType = "năm";
                        break;
                    case 2:
                        addRentType = "tháng";
                        break;
                    case 3:
                        addRentType = "ngày";
                        break;
                    case 4:
                        addRentType = "giờ";
                        break;
                }
            } while (addRentType == null);
            //rentTime
            System.out.print("\tThời gian thuê theo " + addRentType + ": ");
            int addRentTime = Integer.parseInt(sc.nextLine());
            //price
            float addPrice;
            do {
                System.out.print("\tGiá tiền thuê theo " + addRentType + ": ");
                addPrice = Float.parseFloat(sc.nextLine());
                if (!validate.validatePrice(addPrice)){
                    System.out.println("LỖI: Giá Tiền không hợp lệ\n");
                    continue;
                }
                break;
            }while (true);
            //typeOfRoom
            String addTypeOfRoom;
            do {
                System.out.print("\tLoại phòng: ");
                addTypeOfRoom = sc.nextLine();
                if (!validate.validateTypeOfRoom(addTypeOfRoom)){
                    System.out.println("LỖI: Loại Phòng không hợp lệ\n");
                    continue;
                }
                break;
            }while (true);
            //floors
            int addFloors;
            do {
                System.out.print("\tSố tầng: ");
                addFloors = Integer.parseInt(sc.nextLine());
                if (!validate.validateFloors(addFloors)){
                    System.out.println("LỖI: Số Tầng không hợp lệ\n");
                    continue;
                }
                break;
            }while (true);
            System.out.print("\tCác tiện ích khác: ");
            String addUtilityDescription = sc.nextLine();

            House addHouse = new House(addId,addServiceName,addArea,addPrice,addMaxPeople,addRentType,addRentTime,addTypeOfRoom,addUtilityDescription,addFloors);
            WriteAndReadFunc.writeToCSVFile(addHouse);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("LỖI: Kiểm tra định dạng nhập vào!\n");
        }
    }

    //Thêm room vào file rooms.csv
    public void addRoom(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Add New Room-----");
        try {
            //id
            String addId;
            do {
                System.out.print("\tID: ");
                addId = sc.nextLine();
                if (!validate.validateId(addId, "room")){
                    System.out.println("LỖI: Định dạng ID không hợp lệ\n");
                    continue;
                }
                if (WriteAndReadFunc.isIdExist(addId, "villas.csv")) {
                    continue;
                }
                break;
            }while (true);
            //serviceName
            String addServiceName;
            do {
                System.out.print("\tTên dịch vụ: ");
                addServiceName = sc.nextLine();
                if (!validate.validateServiceName(addServiceName)){
                    System.out.println("LỖI: Định dạng Tên Dịch Vụ không hợp lệ\n");
                    continue;
                }
                break;
            }while (true);
            //Area
            float addArea;
            do {
                System.out.print("\tDiện tích Villa (m2): ");
                addArea = Float.parseFloat(sc.nextLine());
                if (!validate.validateArea(addArea)){
                    System.out.println("LỖI: Diện Tích Sử Dụng phải lớn hơn 30\n");

                    continue;
                }
                break;
            }while (true);
            //maxPeople
            int addMaxPeople;
            do {
                System.out.print("\tSố người tối đa: ");
                addMaxPeople = Integer.parseInt(sc.nextLine());
                if (!validate.validateMaxPeople(addMaxPeople)){
                    System.out.println("LỖI: Số Người Tối Đa phải lớn hơn 0 và bé hơn 20\n");
                    continue;
                }
                break;
            }while (true);
            //rentType
            String addRentType = null;
            do {
                System.out.println("\tHình thức thuê: ");
                System.out.println("\t\t1. Thuê theo năm");
                System.out.println("\t\t2. Thuê theo tháng");
                System.out.println("\t\t3. Thuê theo ngày");
                System.out.println("\t\t4. Thuê theo giờ");
                int chooseRentType = Integer.parseInt(sc.nextLine());
                switch (chooseRentType) {
                    case 1:
                        addRentType = "năm";
                        break;
                    case 2:
                        addRentType = "tháng";
                        break;
                    case 3:
                        addRentType = "ngày";
                        break;
                    case 4:
                        addRentType = "giờ";
                        break;
                }
            } while (addRentType == null);
            //rentTime
            System.out.print("\tThời gian thuê theo " + addRentType + ": ");
            int addRentTime = Integer.parseInt(sc.nextLine());
            //price
            float addPrice;
            do {
                System.out.print("\tGiá tiền thuê theo " + addRentType + ": ");
                addPrice = Float.parseFloat(sc.nextLine());
                if (!validate.validatePrice(addPrice)){
                    System.out.println("LỖI: Giá Tiền không hợp lệ\n");
                    continue;
                }
                break;
            }while (true);
            //enclosedService
            String addEnclosedService;
            do {
                System.out.print("\tDịch vụ đi kèm: ");
                addEnclosedService = sc.nextLine();
                if (!validate.validateEnclosedService(addEnclosedService)){
                    System.out.println("LỖI: Dịch Vụ Đi Kèm không hợp lệ\n");
                    continue;
                }
                break;
            }while (true);
            //AmountService
            int addAmountService;
            do {
                System.out.print("\tSố lượng: ");
                addAmountService = Integer.parseInt(sc.nextLine());
                if (!validate.validateAmountService(addAmountService)){
                    System.out.println("LỖI: Số Lượng Dịch Vụ Đi Kèm không hợp lệ\n");
                    continue;
                }
                break;
            }while (true);
            //priceServiceRoom
            float addPriceService;
            do {
                System.out.print("Giá tiền dịch vụ phòng: ");
                addPriceService = Float.parseFloat(sc.nextLine());
                if (!validate.validatePrice(addPriceService)){
                    System.out.println("LỖI: Giá Tiền Dịch Vụ Phòng không hợp lệ\n");
                    continue;
                }
                break;
            }while (true);

            Room addRoom = new Room(addId,addServiceName,addArea,addPrice,addMaxPeople,addRentType,addRentTime,addEnclosedService,addAmountService,addPriceService);
            WriteAndReadFunc.writeToCSVFile(addRoom);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("LỖI: Kiểm tra định dạng nhập vào!\n");
        }
    }

    //Show all Villas
    public void showAllVillas(){
        System.out.println("-------Villas-------");
        List<Villa> list = WriteAndReadFunc.readVillasFile();
        for (Villa o:list){
            o.showInfo();
            System.out.println();
        }
    }

    //Show all Houses
    public void showAllHouses(){
        System.out.println("-------Houses-------");
        List<House> list = WriteAndReadFunc.readHousesFile();
        for (House o:list){
            o.showInfo();
            System.out.println();
        }
    }

    //Show all Rooms
    public void showAllRooms(){
        System.out.println("-------Rooms-------");
        List<Room> list = WriteAndReadFunc.readRoomsFile();
        for (Room o:list){
            o.showInfo();
            System.out.println();
        }
    }

    //Show all Name Villa Not Duplicate
    public void showVillasNotDuplicateName(){
        System.out.println("---Villas Not Duplicate Name---");
        List<Villa> list = WriteAndReadFunc.readVillasFile();
        Stack<String> nameVilla = new Stack<>();
        for (Villa o : list){
            if (!nameVilla.contains(o.getServiceName())){
                nameVilla.push(o.getServiceName());
                o.showInfo();
            }
        }
    }

    //Show all Name House Not Duplicate
    public void showHousesNotDuplicateName(){
        System.out.println("---Houses Not Duplicate Name---");
        List<House> list = WriteAndReadFunc.readHousesFile();
        Stack<String> nameHouse = new Stack<>();
        for (House o : list){
            if (!nameHouse.contains(o.getServiceName())){
                nameHouse.push(o.getServiceName());
                o.showInfo();
            }
        }
    }

    //Show all Name Room Not Duplicate
    public void showRoomsNotDuplicateName(){
        System.out.println("---Rooms Not Duplicate Name---");
        List<Room> list = WriteAndReadFunc.readRoomsFile();
        Stack<String> nameRoom = new Stack<>();
        for (Room o : list){
            if (!nameRoom.contains(o.getServiceName())){
                nameRoom.push(o.getServiceName());
                o.showInfo();
            }
        }
    }
}
