package javapackage;

import java.util.ArrayList;

import medpackage.*;

public class Admin {
    private ArrayList<Employee> employeeList = new ArrayList<>();
    private ArrayList<Account> accList = new ArrayList<>();

    public ArrayList<Employee> getEmployees() {
        return employeeList;
    }

    public ArrayList<Account> getAccounts() {
        return accList;
    }

    int numofemp = 1;

    public void menu_emp() {
        while (true) {
            App.cls();
            System.out
                    .println("=======================================================================================");
            System.out
                    .println("                                    Manage Employees                                   ");
            System.out
                    .println("=======================================================================================");
            System.out.println("1. Add Employee");
            System.out.println("2. Show Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("0. Back");
            System.out
                    .println("=======================================================================================");
            System.out.print("Input Menu : ");
            String input = App.in.nextLine();

            if (input.equals("1")) {
                App.cls();
                add_emp();
            } else if (input.equals("2")) {
                App.cls();
                read_emp();
                App.con();
            } else if (input.equals("3")) {
                App.cls();
                update_emp();
                App.con();
            } else if (input.equals("4")) {
                App.cls();
                delete_emp();
                App.con();
            } else if (input.equals("0")) {
                break;
            }
        }
    }

    public void add_emp() {
        App.cls();
        System.out.println("=======================================================================================");
        System.out.println("                                      Add Employee                                     ");
        System.out.println("=======================================================================================");
        System.out.print("Name      : ");
        String emp_name = App.in.nextLine();
        System.out.print("Age       : ");
        int emp_age = App.in.nextInt();
        System.out.print("Salary    : Rp.");
        float emp_salary = App.in.nextFloat();
        App.in.nextLine();
        System.out.print("Username  : ");
        String emp_uname = App.in.nextLine();
        int i;
        for (i = 0; i < employeeList.size(); i++) {
            Employee getEmp = employeeList.get(i);
            if (emp_uname.equals(getEmp.getUsername())) {
                System.out.println(
                        "=======================================================================================");
                System.out.println("Employee added failed! Username has already in use.");
                App.con();
                break;
            }
        }
        if (i == employeeList.size()) {
            System.out.print("Password  : ");
            String emp_pw = App.in.nextLine();
            String emp_id = "EMP" + Integer.toString(numofemp);

            Account acc = new Account(emp_uname, emp_pw, false);
            Employee emp = new Employee(emp_uname, emp_pw, emp_id, false, emp_name, emp_age, emp_salary);
            emp.setIdEmp(emp_id);
            emp.setNameEmp(emp_name);
            emp.setAgeEmp(emp_age);
            emp.setSalaryEmp(emp_salary);
            employeeList.add(emp);
            accList.add(acc);
            numofemp++;
            System.out
                    .println("=======================================================================================");
            System.out.println("Employee added successfully!");
            App.con();
        }
    }

    public void read_emp() {
        App.cls();
        System.out.println("=======================================================================================");
        System.out.println("                                     Show Employees                                    ");
        System.out.println("=======================================================================================");
        if (employeeList.isEmpty()) {
            System.out.println("Data is empty");
        } else {
            System.out
                    .println("=======================================================================================");
            System.out
                    .println("|   ID   |         Name          | Age |    Salary    |    Username    |   Password   |");
            System.out
                    .println("=======================================================================================");
            for (Employee getEmp : employeeList) {
                System.out.printf("|%-8s", getEmp.getIdEmp());
                System.out.printf("|%-23s", getEmp.getNameEmp());
                System.out.printf("|%-5s", getEmp.getAgeEmp());
                System.out.printf("|%-14s", "Rp." + getEmp.getSalaryEmp());
                System.out.printf("|%-16s", getEmp.getUsername());
                System.out.printf("|%-14s", getEmp.getPassword());
                System.out.print("|\n");
            }
            System.out
                    .println("=======================================================================================");
        }
    }

    public void update_emp() {
        System.out.println("=======================================================================================");
        System.out.println("                                    Update Employee                                   ");
        System.out.println("=======================================================================================");
        System.out.print("Employee ID   : ");
        String temp = App.in.nextLine();
        int i;
        for (i = 0; i < employeeList.size(); i++) {
            Employee getEmp = employeeList.get(i);
            if (temp.equals(getEmp.getIdEmp())) {
                System.out.println(
                        "=======================================================================================");
                System.out.print("Name      : ");
                String emp_name = App.in.nextLine();
                System.out.print("Age       : ");
                int emp_age = App.in.nextInt();
                System.out.print("Salary    : Rp.");
                float emp_salary = App.in.nextFloat();
                App.in.nextLine();
                System.out.print("Username  : ");
                String emp_uname = App.in.nextLine();
                System.out.print("Password  : ");
                String emp_pw = App.in.nextLine();

                Account new_acc = new Account(emp_uname, emp_pw, false);
                Employee new_emp = new Employee(emp_uname, emp_pw, temp, false, emp_name, emp_age, emp_salary);
                new_emp.setIdEmp(temp);
                new_emp.setNameEmp(emp_name);
                new_emp.setAgeEmp(emp_age);
                new_emp.setSalaryEmp(emp_salary);
                employeeList.set(i, new_emp);
                accList.set(i + 1, new_acc);
                System.out.println(
                        "=======================================================================================");
                System.out.println("Employee changed successfully!");
                break;
            }
        }
        if (i == employeeList.size()) {
            System.out.println("Invalid ID");
        }
    }

    public void delete_emp() {
        System.out.println("=======================================================================================");
        System.out.println("                                   Delete Employee                                     ");
        System.out.println("=======================================================================================");
        System.out.print("Employee ID   : ");
        String temp = App.in.nextLine();
        int i;
        int isDelete = 0;
        for (i = 0; i < employeeList.size(); i++) {
            Employee getEmp = employeeList.get(i);
            if (temp.equals(getEmp.getIdEmp())) {
                for (int j = 0; j < accList.size(); j++) {
                    Account getAcc = accList.get(j);
                    if (getEmp.getUsername().equals(getAcc.getUsername())) {
                        employeeList.remove(i);
                        accList.remove(j);
                        System.out.println(
                                "=======================================================================================");
                        System.out.println("Employee deleted successfully!");
                        isDelete = 1;
                        break;
                    }
                }
            }
        }
        if (isDelete != 1) {
            if (i == employeeList.size()) {
                System.out.println("Invalid ID");
            }
        }
    }

    public void printReport(ArrayList<Employee> employeeList, ArrayList<Medicine> medicineList) {
        int totalofstok = 0;
        System.out.println("=======================================================================================");
        System.out.println("                                    Admin Reports                                       ");
        System.out.println("=======================================================================================");
        System.out.println("Total of Employees          : " + employeeList.size());
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Total of Medicine           : " + medicineList.size());
        for (Medicine getMed : medicineList) {
            totalofstok = totalofstok + getMed.getStok();
        }
        System.out.println("Total of Stok               : " + totalofstok);
        System.out.println("=======================================================================================");
    }

    public void printReport(ArrayList<Medicine> medicineList) {
        int totalofstok = 0;
        System.out.println("=======================================================================================");
        System.out.println("                                   Employee Reports                                    ");
        System.out.println("=======================================================================================");
        System.out.println("Total of Medicine           : " + medicineList.size());
        for (Medicine getMed : medicineList) {
            totalofstok = totalofstok + getMed.getStok();
        }
        System.out.println("Total of Stok               : " + totalofstok);
        System.out.println("=======================================================================================");
    }
}
