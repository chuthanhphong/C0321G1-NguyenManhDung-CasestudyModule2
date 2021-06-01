package common;

import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadFunc<E> {

    //ghi vào file
    public void writeToCSVFile(E object) {
        try {
            String path;
            if (object instanceof Villa) {
                path = "src/data/villas.csv";
            } else if (object instanceof House) {
                path = "src/data/houses.csv";
            } else if (object instanceof Room) {
                path = "src/data/rooms.csv";
            } else if (object instanceof Customer) {
                path = "src/data/customers.csv";
            } else {
                System.out.println("Đối tượng phải là kiểu Villa, House, Room hoặc Customer");
                return;
            }
            //ghi vào file
            FileWriter fileWriter = new FileWriter(path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(object.toString() + "\n");
            bufferedWriter.close();
            System.out.println("Added to file successfully!");
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File doesn't exist!!!");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    //kiểm tra đã tồn tại ID hay chưa
    public boolean isIdExist(String id, String fileName) {
        switch (fileName) {
            case "villas.csv": {
                List<Villa> list = readVillasFile();
                for (Villa o : list) {
                    if (o.getId().equals(id)) {
                        System.err.println("\nID đã tồn tại!\n");
                        return true;
                    }
                }
                break;
            }
            case "houses.csv": {
                List<House> list = readHousesFile();
                for (House o : list) {
                    if (o.getId().equals(id)) {
                        System.err.println("\nID đã tồn tại!\n");
                        return true;
                    }
                }
                break;
            }
            case "rooms.csv": {
                List<Room> list = readRoomsFile();
                for (Room o : list) {
                    if (o.getId().equals(id)) {
                        System.err.println("\nID đã tồn tại!\n");
                        return true;
                    }
                }
                break;
            }
            case "customers.csv": {

            }
            default:
                System.err.println("\nTên File không tồn tại!\n");
                return true;
        }
        return false;
    }

    //show customers.csv
    public List<Customer> readCustomersFile() {
        final String PATH = "src/data/customers.csv";
        List<Customer> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\|");
                String id = words[words.length - 1];
                Services serviceUsing = (Services) searchServiceById(id);
                list.add(new Customer(words[0],words[1],words[2],words[3],words[4],words[5],words[6],words[7],serviceUsing));
            }
        } catch (
                FileNotFoundException e) {
            System.err.println("\nFile is not founded!!!\n");
        } catch (
                Exception e) {
            System.err.println("\nData of file is not correct!!!\n");
        }
        return list;
    }

    //đọc file villas.csv
    public List<Villa> readVillasFile() {
        final String PATH = "src/data/villas.csv";
        List<Villa> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\|");
                list.add(new Villa(words[0], words[1], Float.parseFloat(words[2]), Float.parseFloat(words[3]), Integer.parseInt(words[4]), words[5], Integer.parseInt(words[6]), words[7], words[8], Float.parseFloat(words[9]), Integer.parseInt(words[10])));
            }
        } catch (FileNotFoundException e) {
            System.err.println("\nFile is not founded!!!\n");
        } catch (Exception e) {
            System.err.println("\nData of file is not correct!!!\n");
        }
        return list;
    }

    //đọc file houses.csv
    public List<House> readHousesFile() {
        final String PATH = "src/data/houses.csv";
        List<House> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\|");
                list.add(new House(words[0], words[1], Float.parseFloat(words[2]), Float.parseFloat(words[3]), Integer.parseInt(words[4]), words[5], Integer.parseInt(words[6]), words[7], words[8], Integer.parseInt(words[9])));
            }
        } catch (FileNotFoundException e) {
            System.err.println("\nFile is not founded!!!\n");
        } catch (Exception e) {
            System.err.println("\nData of file is not correct!!!\n");
        }
        return list;
    }

    //đọc file rooms.csv
    public List<Room> readRoomsFile() {
        final String PATH = "src/data/rooms.csv";
        List<Room> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\|");
                list.add(new Room(words[0], words[1], Float.parseFloat(words[2]), Float.parseFloat(words[3]), Integer.parseInt(words[4]), words[5], Integer.parseInt(words[6]), words[7], Integer.parseInt(words[8]), Float.parseFloat(words[9])));
            }
        } catch (FileNotFoundException e) {
            System.err.println("\nFile is not founded!!!\n");
        } catch (Exception e) {
            System.err.println("\nData of file is not correct!!!\n");
        }
        return list;
    }

    //search by ID
    public E searchServiceById(String id) {
        String typeOfService = id.substring(0, 4);
        if (typeOfService.equals("SVVL")) {
            List<Villa> list = readVillasFile();
            for (Villa villa : list) {
                if (villa.getId().equals(id)) {
                    return (E) villa;
                }
            }
            return null;
        } else if (typeOfService.equals("SVHO")) {
            List<House> list = readHousesFile();
            for (House house : list) {
                if (house.getId().equals(id)) {
                    return (E) house;
                }
            }
            return null;
        } else if (typeOfService.equals("SVRO")) {
            List<Room> list = readRoomsFile();
            for (Room room : list) {
                if (room.getId().equals(id)) {
                    return (E) room;
                }
            }
            return null;
        } else {
            System.out.println("---LỖI: ID tìm kiếm không hợp lệ---");
            return null;
        }
    }
}
