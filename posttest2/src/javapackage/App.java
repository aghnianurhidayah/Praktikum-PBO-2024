package javapackage;

import java.util.Scanner;

public class App {

    public static Scanner in = new Scanner(System.in);
    public static ManageMedicine manageMed = new ManageMedicine();  
    public static ManageEmployee manageEmp = new ManageEmployee();  

    public static void con() {
        System.out.print("\nPress \"ENTER\" to back...");
        in.nextLine();
    }

    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            cls();
            System.out.println("=======================================");
            System.out.println("        Pharmacy Management System     ");
            System.out.println("=======================================");
            System.out.println("1. Manage Medicine");
            System.out.println("2. Manage Employee");
            System.out.println("0. Exit Program");
            System.out.println("=======================================");
            System.out.print("Input Menu : ");
            String input = in.nextLine();

            if (input.equals("1")) {
                manageMed.menu();
            } else if (input.equals("2")) {
                manageEmp.menu();
            } else if (input.equals("0")) {
                System.out.println("Program Ended");
                break;
            }
        }
    }
}
