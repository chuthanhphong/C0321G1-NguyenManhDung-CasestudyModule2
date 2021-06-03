package manager;

import common.ValidateService;
import common.WriteAndReadFunc;
import model.House;
import model.Room;
import model.Villa;

import java.util.*;

public class ManagerService {
    ValidateService validate = new ValidateService();
    WriteAndReadFunc writeReadFile = new WriteAndReadFunc();

    //Thêm villa vào file villas.csv
    public void addVilla() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Add New Villa-----");
        try {
            Thread.sleep(250);
            //id
            String addId;
            do {
                System.out.print("\tID: ");

                addId = sc.nextLine();
                if (!validate.validateId(addId, "villa")) {
                    System.err.println("LỖI: Định dạng ID không hợp lệ");
                    Thread.sleep(250);
                    continue;
                }
                if (writeReadFile.isIdExist(addId, "villas.csv")) {
                    System.err.println("ID đã tồn tại!");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
            //serviceName
            String addServiceName;
            do {
                System.out.print("\tTên dịch vụ: ");
                addServiceName = sc.nextLine();
                if (!validate.validateServiceName(addServiceName)) {
                    System.err.println("LỖI: Định dạng Tên Dịch Vụ không hợp lệ");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
            //Area
            float addArea;
            do {
                System.out.print("\tDiện tích Villa (m2): ");
                addArea = Float.parseFloat(sc.nextLine());
                if (!validate.validateArea(addArea)) {
                    System.err.println("LỖI: Diện Tích Sử Dụng phải lớn hơn 30");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
            //maxPeople
            int addMaxPeople;
            do {
                System.out.print("\tSố người tối đa: ");
                addMaxPeople = Integer.parseInt(sc.nextLine());
                if (!validate.validateMaxPeople(addMaxPeople)) {
                    System.err.println("LỖI: Số Người Tối Đa phải lớn hơn 0 và bé hơn 20");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
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
                if (!validate.validatePrice(addPrice)) {
                    System.err.println("LỖI: Giá Tiền không hợp lệ");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
            //typeOfRoom
            String addTypeOfRoom;
            do {
                System.out.print("\tLoại phòng: ");
                addTypeOfRoom = sc.nextLine();
                if (!validate.validateTypeOfRoom(addTypeOfRoom)) {
                    System.err.println("LỖI: Loại Phòng không hợp lệ");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
            //swimmingPool
            float addSwimmingPoolArea;
            do {
                System.out.print("\tDiện tích bể bơi (m2): ");
                addSwimmingPoolArea = Float.parseFloat(sc.nextLine());
                if (!validate.validateSwimmingPool(addSwimmingPoolArea)) {
                    System.err.println("LỖI: Diện Tích Bể Bơi không hợp lệ");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
            //floors
            int addFloors;
            do {
                System.out.print("\tSố tầng: ");
                addFloors = Integer.parseInt(sc.nextLine());
                if (!validate.validateFloors(addFloors)) {
                    System.err.println("LỖI: Số Tầng không hợp lệ");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
            System.out.print("\tCác tiện ích khác: ");
            String addUtilityDescription = sc.nextLine();

            Villa addVilla = new Villa(addId, addServiceName, addArea, addPrice, addMaxPeople, addRentType, addRentTime, addTypeOfRoom, addUtilityDescription, addSwimmingPoolArea, addFloors);
            List<Villa> list = new ArrayList<>();
            list.add(addVilla);
            writeReadFile.writeToCSVFile(list, true);
        } catch (NumberFormatException | InterruptedException numberFormatException) {
            System.err.println("LỖI: Kiểm tra định dạng nhập vào!");
        }
    }

    //Thêm house vào file houses.csv
    public void addHouse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Add New House-----");
        try {
            Thread.sleep(250);
            //id
            String addId;
            do {
                System.out.print("\tID: ");
                addId = sc.nextLine();
                if (!validate.validateId(addId, "house")) {
                    System.err.println("LỖI: Định dạng ID không hợp lệ");
                    Thread.sleep(250);
                    continue;
                }
                if (writeReadFile.isIdExist(addId, "villas.csv")) {
                    System.err.println("ID đã tồn tại");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
            //serviceName
            String addServiceName;
            do {
                System.out.print("\tTên dịch vụ: ");
                addServiceName = sc.nextLine();
                if (!validate.validateServiceName(addServiceName)) {
                    System.err.println("LỖI: Định dạng Tên Dịch Vụ không hợp lệ");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
            //Area
            float addArea;
            do {
                System.out.print("\tDiện tích Villa (m2): ");
                addArea = Float.parseFloat(sc.nextLine());
                if (!validate.validateArea(addArea)) {
                    System.err.println("LỖI: Diện Tích Sử Dụng phải lớn hơn 30");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
            //maxPeople
            int addMaxPeople;
            do {
                System.out.print("\tSố người tối đa: ");
                addMaxPeople = Integer.parseInt(sc.nextLine());
                if (!validate.validateMaxPeople(addMaxPeople)) {
                    System.err.println("LỖI: Số Người Tối Đa phải lớn hơn 0 và bé hơn 20");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
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
                if (!validate.validatePrice(addPrice)) {
                    System.err.println("LỖI: Giá Tiền không hợp lệ");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
            //typeOfRoom
            String addTypeOfRoom;
            do {
                System.out.print("\tLoại phòng: ");
                addTypeOfRoom = sc.nextLine();
                if (!validate.validateTypeOfRoom(addTypeOfRoom)) {
                    System.err.println("LỖI: Loại Phòng không hợp lệ");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
            //floors
            int addFloors;
            do {
                System.out.print("\tSố tầng: ");
                addFloors = Integer.parseInt(sc.nextLine());
                if (!validate.validateFloors(addFloors)) {
                    System.err.println("LỖI: Số Tầng không hợp lệ");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
            System.out.print("\tCác tiện ích khác: ");
            String addUtilityDescription = sc.nextLine();

            House addHouse = new House(addId, addServiceName, addArea, addPrice, addMaxPeople, addRentType, addRentTime, addTypeOfRoom, addUtilityDescription, addFloors);
            List<House> list = new ArrayList<>();
            list.add(addHouse);
            writeReadFile.writeToCSVFile(list, true);
        } catch (NumberFormatException | InterruptedException numberFormatException) {
            System.err.println("LỖI: Kiểm tra định dạng nhập vào!");
        }
    }

    //Thêm room vào file rooms.csv
    public void addRoom() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Add New Room-----");
        try {
            Thread.sleep(250);
            //id
            String addId;
            do {
                System.out.print("\tID: ");
                addId = sc.nextLine();
                if (!validate.validateId(addId, "room")) {
                    System.err.println("LỖI: Định dạng ID không hợp lệ");
                    Thread.sleep(250);
                    continue;
                }
                if (writeReadFile.isIdExist(addId, "villas.csv")) {
                    System.err.println("ID đã tồn tại");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
            //serviceName
            String addServiceName;
            do {
                System.out.print("\tTên dịch vụ: ");
                addServiceName = sc.nextLine();
                if (!validate.validateServiceName(addServiceName)) {
                    System.err.println("LỖI: Định dạng Tên Dịch Vụ không hợp lệ");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
            //Area
            float addArea;
            do {
                System.out.print("\tDiện tích Villa (m2): ");
                addArea = Float.parseFloat(sc.nextLine());
                if (!validate.validateArea(addArea)) {
                    System.err.println("LỖI: Diện Tích Sử Dụng phải lớn hơn 30");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
            //maxPeople
            int addMaxPeople;
            do {
                System.out.print("\tSố người tối đa: ");
                addMaxPeople = Integer.parseInt(sc.nextLine());
                if (!validate.validateMaxPeople(addMaxPeople)) {
                    System.err.println("LỖI: Số Người Tối Đa phải lớn hơn 0 và bé hơn 20");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
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
                if (!validate.validatePrice(addPrice)) {
                    System.err.println("LỖI: Giá Tiền không hợp lệ");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
            //enclosedService
            String addEnclosedService;
            do {
                System.out.print("\tDịch vụ đi kèm: ");
                addEnclosedService = sc.nextLine();
                if (!validate.validateEnclosedService(addEnclosedService)) {
                    System.err.println("LỖI: Dịch Vụ Đi Kèm không hợp lệ");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
            //AmountService
            int addAmountService;
            do {
                System.out.print("\tSố lượng: ");
                addAmountService = Integer.parseInt(sc.nextLine());
                if (!validate.validateAmountService(addAmountService)) {
                    System.err.println("LỖI: Số Lượng Dịch Vụ Đi Kèm không hợp lệ");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
            //priceServiceRoom
            float addPriceService;
            do {
                System.out.print("\tGiá tiền dịch vụ phòng: ");
                addPriceService = Float.parseFloat(sc.nextLine());
                if (!validate.validatePrice(addPriceService)) {
                    System.err.println("LỖI: Giá Tiền Dịch Vụ Phòng không hợp lệ");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);

            Room addRoom = new Room(addId, addServiceName, addArea, addPrice, addMaxPeople, addRentType, addRentTime, addEnclosedService, addAmountService, addPriceService);
            List<Room> list = new ArrayList<>();
            list.add(addRoom);
            writeReadFile.writeToCSVFile(list, true);
        } catch (NumberFormatException | InterruptedException numberFormatException) {
            System.err.println("LỖI: Kiểm tra định dạng nhập vào!");
        }
    }

    //Show all Villas
    public List<Villa> showAllVillas() {
        System.out.println("-------Villas-------");
        List<Villa> list = writeReadFile.readVillasFile();
        int i = 1;
        for (Villa o : list) {
            System.out.print(i++ + ".\t");
            o.showInfo();
        }
        return list;
    }

    //Show all Houses
    public List<House> showAllHouses() {
        System.out.println("-------Houses-------");
        List<House> list = writeReadFile.readHousesFile();
        int i = 1;
        for (House o : list) {
            System.out.print(i++ + ".\t");
            o.showInfo();
        }
        return list;
    }

    //Show all Rooms
    public List<Room> showAllRooms() {
        System.out.println("-------Rooms-------");
        List<Room> list = writeReadFile.readRoomsFile();
        int i = 1;
        for (Room o : list) {
            System.out.print(i++ + ".\t");
            o.showInfo();
        }
        return list;
    }

    //Show all Name Villa Not Duplicate
    public TreeSet<String> showVillasNotDuplicateName() {
        System.out.println("---Danh sách tên các Villa không trùng nhau---");
        List<Villa> list = writeReadFile.readVillasFile();
        TreeSet<String> nameVilla = new TreeSet<>();
        for (Villa o : list) {
            if (!nameVilla.contains(o.getServiceName())) {
                nameVilla.add(o.getServiceName());
            }
        }
        int i = 1;
        for (String name : nameVilla) {
            System.out.println("\t" + (i++) + ". " + name);
        }
        return nameVilla;
    }

    //Show all Name House Not Duplicate
    public TreeSet<String> showHousesNotDuplicateName() {
        System.out.println("---Danh sách tên các House không trùng nhau---");
        List<House> list = writeReadFile.readHousesFile();
        TreeSet<String> nameHouse = new TreeSet<>();
        for (House o : list) {
            if (!nameHouse.contains(o.getServiceName())) {
                nameHouse.add(o.getServiceName());
            }
        }
        int i = 1;
        for (String name : nameHouse) {
            System.out.println("\t" + (i++) + ". " + name);
        }
        return nameHouse;
    }

    //Show all Name Room Not Duplicate
    public TreeSet<String> showRoomsNotDuplicateName() {
        System.out.println("---Danh sách tên các Room không trùng nhau---");
        List<Room> list = writeReadFile.readRoomsFile();
        TreeSet<String> nameRoom = new TreeSet<>();
        for (Room o : list) {
            if (!nameRoom.contains(o.getServiceName())) {
                nameRoom.add(o.getServiceName());
            }
        }
        int i = 1;
        for (String name : nameRoom) {
            System.out.println("\t" + (i++) + ". " + name);
        }
        return nameRoom;
    }

    public Villa bookVilla() {
        Scanner sc = new Scanner(System.in);
        int indexOfService; //vị trí của service muốn book trong danh sách hiển thị
        List<Villa> serviceList = showVillaToBook();
        if (serviceList.size() == 0) return null;
        do {
            try {
                Thread.sleep(250);
                System.out.println("Chọn Villa để đặt phòng: ");
                indexOfService = Integer.parseInt(sc.nextLine());
                if (indexOfService <= 0 || indexOfService > serviceList.size()) {
                    System.err.println("---Chọn Villa có trong danh sách---");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } catch (NumberFormatException | InterruptedException e) {
                System.err.println("---Nhập đúng định dạng là 1 số---");
            }
        } while (true);
        return serviceList.get(indexOfService - 1);
    }

    public House bookHouse() {
        Scanner sc = new Scanner(System.in);
        int indexOfService; //vị trí của service muốn book trong danh sách hiển thị
        List<House> serviceList = showHouseToBook();
        if (serviceList.size() == 0) return null;
        do {
            try {
                Thread.sleep(250);
                System.out.println("Chọn House để đặt phòng: ");
                indexOfService = Integer.parseInt(sc.nextLine());
                if (indexOfService <= 0 || indexOfService > serviceList.size()) {
                    System.err.println("---Chọn House có trong danh sách---");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } catch (NumberFormatException | InterruptedException e) {
                System.err.println("---Nhập đúng định dạng là 1 số---");
            }
        } while (true);
        return serviceList.get(indexOfService - 1);
    }

    public Room bookRoom() {
        Scanner sc = new Scanner(System.in);
        int indexOfService; //vị trí của service muốn book trong danh sách hiển thị
        List<Room> serviceList = showRoomToBook();
        if (serviceList.size() == 0) return null;
        do {
            try {
                Thread.sleep(250);
                System.out.println("Chọn Room để đặt phòng: ");
                indexOfService = Integer.parseInt(sc.nextLine());
                if (indexOfService <= 0 || indexOfService > serviceList.size()) {
                    System.err.println("---Chọn Room có trong danh sách---");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } catch (NumberFormatException | InterruptedException e) {
                System.err.println("---Nhập đúng định dạng là 1 số---");
            }
        } while (true);
        return serviceList.get(indexOfService - 1);
    }

    public List<Villa> showVillaToBook() {
        System.out.println("---Danh sách Villas khả dụng---");
        //Map lưu trữ id dịch vụ và id người dùng đã đặt phòng
        Map map = writeReadFile.readBookingCsv();
        List<Villa> list = writeReadFile.readVillasFile();
        list.removeIf(o -> map.containsKey(o.getId()));

        int i = 1;
        for (Villa o : list) {
            System.out.print(i++ + ".\t");
            o.showInfo();
        }
        return list;
    }

    public List<House> showHouseToBook() {
        System.out.println("---Danh sách Houses khả dụng---");
        //Map lưu trữ id dịch vụ và id người dùng đã đặt phòng
        Map map = writeReadFile.readBookingCsv();
        List<House> list = writeReadFile.readHousesFile();
        list.removeIf(o -> map.containsKey(o.getId()));

        int i = 1;
        for (House o : list) {
            System.out.print(i++ + ".\t");
            o.showInfo();
        }
        return list;
    }

    public List<Room> showRoomToBook() {
        System.out.println("---Danh sách Rooms khả dụng---");
        //Map lưu trữ id dịch vụ và id người dùng đã đặt phòng
        Map map = writeReadFile.readBookingCsv();
        List<Room> list = writeReadFile.readRoomsFile();
        list.removeIf(o -> map.containsKey(o.getId()));

        int i = 1;
        for (Room o : list) {
            System.out.print(i++ + ".\t");
            o.showInfo();
        }
        return list;
    }
}
