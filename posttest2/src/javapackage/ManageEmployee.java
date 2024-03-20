package javapackage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ManageEmployee {

    StoreRecord List = new StoreRecord();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime now = LocalDateTime.now();

    void menu() {
        while (true) {
            App.cls();
            System.out.println("=======================================");
            System.out.println("           Manage Employees            ");
            System.out.println("=======================================");
            System.out.println("1. Add Employee");
            System.out.println("2. Show Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("0. Back to Main Menu");
            System.out.println("=======================================");
            System.out.print("Input Menu : ");
            String input = App.in.nextLine();

            if (input.equals("1")) {
                App.cls();
                add();
                App.con();
            } else if (input.equals("2")) {
                App.cls();
                read();
                App.con();
            } else if (input.equals("3")) {
                App.cls();
                update();
                App.con();
            } else if (input.equals("4")) {
                App.cls();
                delete();
                App.con();
            } else if (input.equals("0")) {
                System.out.println("Program Ended");
                break;
            }
        }
    }

    void add() {
        System.out.println("=======================================");
        System.out.println("              Add Employee             ");
        System.out.println("=======================================");
        System.out.print("ID        : ");
        String emp_id = App.in.nextLine();
        System.out.print("Name      : ");
        String emp_name = App.in.nextLine();
        System.out.print("Username  : ");
        String emp_uname = App.in.nextLine();
        System.out.print("Password  : ");
        String emp_pw = App.in.nextLine();

        Employee emp = new Employee(emp_id, emp_name, emp_pw, emp_uname);
        emp.setIdEmployee(emp_id);
        emp.getNameEmployee(emp_uname);
        emp.getUnameEmployee(emp_uname);
        emp.getPwEmployee(emp_pw);
        List.employeeList.add(emp);
        System.out.println("=======================================");
        System.out.println("Item added successfully!");
    }

    void read() {
        System.out.println("=======================================");
        System.out.println("            Show Employees             ");
        System.out.println("=======================================");
        for (int i = 0; i < List.employeeList.size(); i++) {
            Employee getEmp = List.employeeList.get(i);
            System.out.println("ID       : " + getEmp.getIdEmployee());
            System.out.println("Name     : " + getEmp.getNameEmployee());
            System.out.println("Username : " + getEmp.getUnameEmployee());
            System.out.println("Password : " + getEmp.getPwEmployee());
            System.out.println("=======================================");
        }
    }

    void update() {
        System.out.println("=======================================");
        System.out.println("           Upadate Employee            ");
        System.out.println("=======================================");
        System.out.print("Employee ID   : ");
        String temp = App.in.nextLine();
        int i;
        for (i = 0; i < List.employeeList.size(); i++) {
            Employee getEmp = List.employeeList.get(i);
            if (temp.equals(getEmp.getIdEmployee())) {
                System.out.println("=======================================");
                String emp_id = App.in.nextLine();
                System.out.print("Name      : ");
                String emp_name = App.in.nextLine();
                System.out.print("Username  : ");
                String emp_uname = App.in.nextLine();
                System.out.print("Password  : ");
                String emp_pw = App.in.nextLine();        

                Employee new_emp = new Employee(emp_id, emp_name, emp_pw, emp_uname);
                new_emp.setIdEmployee(emp_id);
                new_emp.getNameEmployee(emp_uname);
                new_emp.getUnameEmployee(emp_uname);
                new_emp.getPwEmployee(emp_pw);
                List.employeeList.set(i, new_emp);
                System.out.println("=======================================");
                System.out.println("Item changed successfully!");
                break;
            }
        }
        if (i == List.employeeList.size()) {
            System.out.println("Invalid ID");
        }
    }

    void delete() {
        System.out.println("=======================================");
        System.out.println("            Delete Employee            ");
        System.out.println("=======================================");
        System.out.print("Employee ID   : ");
        String temp = App.in.nextLine();
        int i;
        int isDelete = 0;
        for (i = 0; i < List.employeeList.size(); i++) {
            Employee getEmp = List.employeeList.get(i);
            if (temp.equals(getEmp.getIdEmployee())) {
                List.employeeList.remove(i);
                System.out.println("=======================================");
                System.out.println("Item deleted successfully!");
                isDelete = 1;
                break;
            }
        }
        if (isDelete != 1) {
            if (i == List.employeeList.size()){
                System.out.println("Invalid ID");
            }
        }

    }
}
