package javaclass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);
    static ArrayList<medicine> med = new ArrayList<>();
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    static LocalDateTime now = LocalDateTime.now();

    public static void con() {
        System.out.print("\nPress \"ENTER\" to back...");
        in.nextLine();
    }

    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws Exception {
        int numofmed = 1;

        while (true) {
            cls();
            System.out.println("=======================================");
            System.out.println("        Pharmacy Management System     ");
            System.out.println("=======================================");
            System.out.println("1. Add Medicine");
            System.out.println("2. Show Medicine");
            System.out.println("3. Update Medicine");
            System.out.println("4. Delete Medicine");
            System.out.println("0. Exit Program");
            System.out.println("=======================================");
            System.out.print("Input Menu : ");
            String input = in.nextLine();

            if (input.equals("1")) {
                cls();
                System.out.println("=======================================");
                System.out.println("              Add Medicine             ");
                System.out.println("=======================================");
                System.out.print("Name     : ");
                String med_name = in.nextLine();
                System.out.print("Quantity : ");
                int qty = in.nextInt();
                in.nextLine();
                System.out.print("Type     : ");
                String type = in.nextLine();
                System.out.print("Price    : ");
                int price = in.nextInt();
                in.nextLine();
                System.out.print("Company  : ");
                String comp = in.nextLine();
                String id = "MED" + Integer.toString(numofmed);
                medicine new_med = new medicine(id, med_name, qty, type, price, comp, dtf.format(now));
                med.add(new_med);
                numofmed++;
                System.out.println("=======================================");
                System.out.println("Item added successfully!");
                con();
            } else if (input.equals("2")) {
                cls();
                System.out.println("=======================================");
                System.out.println("            Show Medicines              ");
                System.out.println("=======================================");
                for (int i = 0; i < med.size(); i++) {
                    System.out.println("ID       : " + med.get(i).id);
                    System.out.println("Name     : " + med.get(i).name);
                    System.out.println("Quantity : " + med.get(i).quantity);
                    System.out.println("Type     : " + med.get(i).type);
                    System.out.println("Price    : " + med.get(i).price);
                    System.out.println("Company  : " + med.get(i).company);
                    System.out.println("Date     : " + med.get(i).date_input);
                    System.out.println("=======================================");
                }
                con();
            } else if (input.equals("3")) {
                cls();
                System.out.println("=======================================");
                System.out.println("            Upadate Medicine            ");
                System.out.println("=======================================");
                System.out.print("Med ID   : ");
                String temp = in.nextLine();
                int i;
                for (i = 0; i < med.size(); i++) {
                    if (temp.equals(med.get(i).id)) {
                        System.out.println("=======================================");
                        System.out.print("Name     : ");
                        String med_name = in.nextLine();
                        System.out.print("Quantity : ");
                        int qty = in.nextInt();
                        in.nextLine();
                        System.out.print("Type     : ");
                        String type = in.nextLine();
                        System.out.print("Price    : ");
                        int price = in.nextInt();
                        in.nextLine();
                        System.out.print("Company  : ");
                        String comp = in.nextLine();
                        medicine new_med = new medicine(temp, med_name, qty, type, price, comp, dtf.format(now));
                        med.set(i, new_med);
                        System.out.println("=======================================");
                        System.out.println("Item changed successfully!");
                        break;
                    }
                }
                if (i == med.size()) {
                    System.out.println("Invalid ID");
                }
                con();
            } else if (input.equals("4")) {
                cls();
                System.out.println("=======================================");
                System.out.println("            Delete Medicine             ");
                System.out.println("=======================================");
                System.out.print("Med ID   : ");
                String temp = in.nextLine();
                int i;
                for (i = 0; i < med.size(); i++) {
                    if (temp.equals(med.get(i).id)) {
                        med.remove(i);
                        System.out.println("=======================================");
                        System.out.println("Item deleted successfully!");
                        break;
                    }
                }
                if (i == med.size()) {
                    System.out.println("Invalid ID");
                }
                con();
            } else if (input.equals("0")) {
                System.out.println("Program Ended");
                break;
            }
        }
    }
}
