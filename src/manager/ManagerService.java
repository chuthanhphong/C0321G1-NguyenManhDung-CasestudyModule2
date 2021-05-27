package manager;

import common.WriteAndReadFunc;
import model.House;
import model.Room;
import model.Villa;

import java.util.*;

public class ManagerService {

    //Thêm villa vào file villas.csv
    public void addVilla(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Add New Villa-----");
        try {
            System.out.print("\tID: ");
            String addIdVilla = sc.nextLine();
            if (WriteAndReadFunc.isIdExist(addIdVilla,"villas.csv")){
                return;
            }
            System.out.print("\tTên dịch vụ: ");
            String addServiceNameVilla = sc.nextLine();
            System.out.print("\tDiện tích Villa (m2): ");
            float addAreaVilla = Float.parseFloat(sc.nextLine());
            System.out.print("\tSố người tối đa: ");
            int addMaxPeopleVilla = Integer.parseInt(sc.nextLine());
            String addRentTypeVilla = null;
            do {
                System.out.println("\tHình thức thuê: ");
                System.out.println("\t\t1. Thuê theo năm");
                System.out.println("\t\t2. Thuê theo tháng");
                System.out.println("\t\t3. Thuê theo ngày");
                System.out.println("\t\t4. Thuê theo giờ");
                int chooseRentType = Integer.parseInt(sc.nextLine());
                switch (chooseRentType) {
                    case 1:
                        addRentTypeVilla = "năm";
                        break;
                    case 2:
                        addRentTypeVilla = "tháng";
                        break;
                    case 3:
                        addRentTypeVilla = "ngày";
                        break;
                    case 4:
                        addRentTypeVilla = "giờ";
                        break;
                }
            } while (addRentTypeVilla == null);
            System.out.print("\tThời gian thuê theo " + addRentTypeVilla + ": ");
            int addRentTime = Integer.parseInt(sc.nextLine());
            System.out.print("\tGiá tiền thuê theo " + addRentTypeVilla + ": ");
            float addPriceVilla = Float.parseFloat(sc.nextLine());
            System.out.print("\tLoại phòng: ");
            String addTypeOfRoomVilla = sc.nextLine();
            System.out.print("\tDiện tích bể bơi (m2): ");
            float addSwimmingPoolAreaVilla = Float.parseFloat(sc.nextLine());
            System.out.print("\tSố tầng: ");
            int addFloorsVilla = Integer.parseInt(sc.nextLine());
            System.out.print("\tCác tiện ích khác: ");
            String addUtilityDescriptionVilla = sc.nextLine();
            Villa addVilla = new Villa(addIdVilla, addServiceNameVilla, addAreaVilla,addPriceVilla, addMaxPeopleVilla, addRentTypeVilla,addRentTime ,addTypeOfRoomVilla, addUtilityDescriptionVilla, addSwimmingPoolAreaVilla, addFloorsVilla);
            WriteAndReadFunc.writeToCSVFile(addVilla);
        } catch (NumberFormatException numberFormatException) {
            System.err.println("Kiểm tra định dạng nhập vào!");
        }
    }

    //Thêm house vào file houses.csv
    public void addHouse(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Add New House-----");
        try {
            System.out.print("\tID: ");
            String addIdHouse = sc.nextLine();
            if (WriteAndReadFunc.isIdExist(addIdHouse,"houses.csv")){
                return;
            }
            System.out.print("\tTên dịch vụ: ");
            String addServiceNameHouse = sc.nextLine();
            System.out.print("\tDiện tích House (m2): ");
            float addAreaHouse = Float.parseFloat(sc.nextLine());
            System.out.print("\tSố người tối đa: ");
            int addMaxPeopleHouse = Integer.parseInt(sc.nextLine());
            String addRentTypeHouse = null;
            do {
                System.out.println("\tHình thức thuê: ");
                System.out.println("\t\t1. Thuê theo năm");
                System.out.println("\t\t2. Thuê theo tháng");
                System.out.println("\t\t3. Thuê theo ngày");
                System.out.println("\t\t4. Thuê theo giờ");
                int chooseRentType = Integer.parseInt(sc.nextLine());
                switch (chooseRentType) {
                    case 1:
                        addRentTypeHouse = "năm";
                        break;
                    case 2:
                        addRentTypeHouse = "tháng";
                        break;
                    case 3:
                        addRentTypeHouse = "ngày";
                        break;
                    case 4:
                        addRentTypeHouse = "giờ";
                        break;
                }
            } while (addRentTypeHouse == null);
            System.out.print("\tThời gian thuê theo " + addRentTypeHouse + ": ");
            int addRentTimeHouse = Integer.parseInt(sc.nextLine());
            System.out.print("\tGiá tiền thuê theo " + addRentTypeHouse + ": ");
            float addPriceHouse = Float.parseFloat(sc.nextLine());
            System.out.print("\tLoại phòng: ");
            String addTypeOfRoomHouse = sc.nextLine();
            System.out.print("\tSố tầng: ");
            int addFloorsHouse = Integer.parseInt(sc.nextLine());
            System.out.print("\tCác tiện ích khác: ");
            String addUtilityDescriptionHouse = sc.nextLine();
            House addHouse = new House(addIdHouse,addServiceNameHouse,addAreaHouse,addPriceHouse,addMaxPeopleHouse,addRentTypeHouse,addRentTimeHouse,addTypeOfRoomHouse,addUtilityDescriptionHouse,addFloorsHouse);
            WriteAndReadFunc.writeToCSVFile(addHouse);
        } catch (NumberFormatException numberFormatException) {
            System.err.println("Kiểm tra định dạng nhập vào!");
        }
    }

    //Thêm room vào file rooms.csv
    public void addRoom(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Add New Room-----");
        try {
            System.out.print("\tID: ");
            String addIdRoom = sc.nextLine();
            if (WriteAndReadFunc.isIdExist(addIdRoom,"rooms.csv")){
                return;
            }
            System.out.print("\tTên dịch vụ: ");
            String addServiceNameRoom = sc.nextLine();
            System.out.print("\tDiện tích House (m2): ");
            float addAreaRoom = Float.parseFloat(sc.nextLine());
            System.out.print("\tSố người tối đa: ");
            int addMaxPeopleRoom = Integer.parseInt(sc.nextLine());
            String addRentTypeRoom = null;
            do {
                System.out.println("\tHình thức thuê: ");
                System.out.println("\t\t1. Thuê theo năm");
                System.out.println("\t\t2. Thuê theo tháng");
                System.out.println("\t\t3. Thuê theo ngày");
                System.out.println("\t\t4. Thuê theo giờ");
                int chooseRentType = Integer.parseInt(sc.nextLine());
                switch (chooseRentType) {
                    case 1:
                        addRentTypeRoom = "năm";
                        break;
                    case 2:
                        addRentTypeRoom = "tháng";
                        break;
                    case 3:
                        addRentTypeRoom = "ngày";
                        break;
                    case 4:
                        addRentTypeRoom = "giờ";
                        break;
                }
            } while (addRentTypeRoom == null);
            System.out.print("\tThời gian thuê theo " + addRentTypeRoom + ": ");
            int addRentTimeRoom = Integer.parseInt(sc.nextLine());
            System.out.print("\tGiá tiền thuê theo " + addRentTypeRoom + ": ");
            float addPriceRoom = Float.parseFloat(sc.nextLine());
            System.out.print("\tDịch vụ đi kèm: ");
            String addEnclosedServiceRoom = sc.nextLine();
            System.out.print("\tSố lượng: ");
            int addAmountServiceRoom = Integer.parseInt(sc.nextLine());
            System.out.print("Giá tiền: ");
            float addPriceServiceRoom = Float.parseFloat(sc.nextLine());
            Room addRoom = new Room(addIdRoom,addServiceNameRoom,addAreaRoom,addPriceRoom,addMaxPeopleRoom,addRentTypeRoom,addRentTimeRoom,addEnclosedServiceRoom,addAmountServiceRoom,addPriceServiceRoom);
            WriteAndReadFunc.writeToCSVFile(addRoom);
        } catch (NumberFormatException numberFormatException) {
            System.err.println("Kiểm tra định dạng nhập vào!");
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
