package javapackage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import medpackage.*;

public class App {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime now = LocalDateTime.now();
    public static Scanner in = new Scanner(System.in);
    public static Medicine med = new Medicine();
    public static Employee emp = new Employee();
    public static boolean isLogged = false;
    public static Admin new_admin = new Admin();
    public static Account new_acc = new Account();

    public static void con() {
        System.out.print("\nPress \"ENTER\" to back...");
        in.nextLine();
    }

    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void menuAdmin() {
        while (true) {
            cls();
            System.out
                    .println("=======================================================================================");
            System.out
                    .println("                                      Admin Page                                       ");
            System.out
                    .println("=======================================================================================");
            System.out.println("1. Manage Employee");
            System.out.println("2. Manage Medicine");
            System.out.println("3. Report");
            System.out.println("0. Logout");
            System.out
                    .println("=======================================================================================");
            System.out.print("Input Menu : ");
            String input = in.nextLine();
            if (input.equals("1")) {
                new_admin.menu_emp();
            } else if (input.equals("2")) {
                emp.menu_med();
            } else if (input.equals("3")) {
                cls();
                new_admin.printReport(new_admin.getEmployees(), emp.medList);
                con();
            } else if (input.equals("0")) {
                isLogged = true;
                break;
            } else {
                try {
                    System.out.println("Invalid Input");
                    Thread.sleep(1000);
                    continue;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void menuEmp(){
        while (true) {
            cls();
            System.out
                    .println("=======================================================================================");
            System.out
                    .println("                                     Employee Page                                     ");
            System.out
                    .println("=======================================================================================");
            System.out.println("1. Manage Medicine");
            System.out.println("2. Report");
            System.out.println("0. Logout");
            System.out
                    .println("=======================================================================================");
            System.out.print("Input Menu : ");
            String input = in.nextLine();
            if (input.equals("1")) {
                emp.menu_med();   
            } else if (input.equals("2")) {
                cls();
                new_admin.printReport(emp.medList);
                con();
            } else if (input.equals("0")) {
                isLogged = true;
                break;
            } else {
                try {
                    System.out.println("Invalid Input");
                    Thread.sleep(1000);
                    continue;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void login() {
        while (true) {
            if (isLogged == false) {
                cls();
                System.out.println(
                        "=======================================================================================");
                System.out.println(
                        "                                        Login                                          ");
                System.out.println(
                        "=======================================================================================");
                System.out.print("Enter Username: ");
                String uname = in.nextLine();
                System.out.print("Enter Password: ");
                String pw = in.nextLine();
                System.out.println(
                        "=======================================================================================");

                boolean find = false;
                for (Account acc : new_admin.getAccounts()) {
                    if (uname.equals(acc.getUsername()) && pw.equals(acc.getPassword())) {
                        try {
                            System.out.println("Login Successfully!");
                            Thread.sleep(1000);
                            if (acc.getRole() == true) {
                                menuAdmin();
                            } else {
                                menuEmp();
                            }
                            find = true;
                            break;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (find == false) {
                    try {
                        System.out.println("Invalid Account!");
                        Thread.sleep(1000);
                        break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Account admin = new Account("admin", "admin123", true);
        new_admin.getAccounts().add(admin);
        while (true) {
            isLogged = false;
            cls();
            System.out
                    .println("=======================================================================================");
            System.out
                    .println("                                Pharmacy Management System                             ");
            System.out
                    .println("=======================================================================================");
            System.out.println("1. Login ");
            System.out.println("0. Exit Program");
            System.out
                    .println("=======================================================================================");
            System.out.print("Input Menu : ");
            String input = in.nextLine();

            if (input.equals("1")) {
                login();
            } else if (input.equals("0")) {
                System.out.println("Program Ended");
                break;
            }
        }
    }
}
