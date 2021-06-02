package manager;

import model.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class TuHoSo {

    public static Stack<Employee> getAllEmployee(){
        final String PATH = "src/data/employee.csv";
        Stack<Employee> stack = new Stack<>();
        try {
            FileReader fileReader = new FileReader(PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while((line = bufferedReader.readLine()) != null){
                String[] words = line.split("\\|");
                Employee employee = new Employee(words[0], Integer.parseInt(words[1]), words[2]);
                stack.push(employee);
            }
            bufferedReader.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("---Không tìm thấy file!---");
        } catch (IOException ioException) {
            System.err.println("---Lỗi đọc file!---");
        }
        return stack;
    }

    public static void showAllEmployee(){
        Stack<Employee> stack = getAllEmployee();
        System.out.println("------Danh sách nhân viên------");
        while (!stack.empty()) {
            System.out.println(stack.pop().toString());
        }
    }

    public static void showListEmployee(Stack<Employee> stack){
        System.out.println("-----Nhân viên-----");
        while (!stack.empty()) {
            System.out.println(stack.pop().toString());
        }
    }

    public static Stack<Employee> searchByName(String name){
        Stack<Employee> allEmployee = getAllEmployee();
        Stack<Employee> result = new Stack<>();
        while (!allEmployee.empty()){
            Employee employee = allEmployee.pop();
            if (employee.getName().equals(name)){
                result.push(employee);
            }
        }
        return result;
    }

    public static Stack<Employee> searchByAge(int age){
        Stack<Employee> allEmployee = getAllEmployee();
        Stack<Employee> result = new Stack<>();
        while (!allEmployee.empty()){
            Employee employee = allEmployee.pop();
            if (employee.getAge() == age){
                result.push(employee);
            }
        }
        return result;
    }

    public static Stack<Employee> searchByAddress(String address){
        Stack<Employee> allEmployee = getAllEmployee();
        Stack<Employee> result = new Stack<>();
        while (!allEmployee.empty()){
            Employee employee = allEmployee.pop();
            if (employee.getAddress().equals(address)){
                result.push(employee);
            }
        }
        return result;
    }

    public static void showMenu(){
        System.out.println("---MENU EmployeeManager---");
        System.out.println("\t1. Show all employees");
        System.out.println("\t2. Search by name");
        System.out.println("\t3. Search by age");
        System.out.println("\t4. Search by address");
        System.out.println("\t5. Back to the menu");
    }
}
