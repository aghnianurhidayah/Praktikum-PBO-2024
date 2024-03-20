package javapackage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ManageMedicine extends StoreRecord {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime now = LocalDateTime.now();
    int numofmed = 1;

    void menu() {
        while (true) {
            App.cls();
            System.out.println("=======================================");
            System.out.println("           Manage Medicines            ");
            System.out.println("=======================================");
            System.out.println("1. Add Medicine");
            System.out.println("2. Show Medicine");
            System.out.println("3. Update Medicine");
            System.out.println("4. Delete Medicine");
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
        System.out.println("              Add Medicine             ");
        System.out.println("=======================================");
        System.out.print("Name     : ");
        String med_name = App.in.nextLine();
        System.out.print("Quantity : ");
        int qty = App.in.nextInt();
        App.in.nextLine();
        System.out.print("Type     : ");
        String type = App.in.nextLine();
        System.out.print("Price    : ");
        int price = App.in.nextInt();
        App.in.nextLine();
        String id = "MED" + Integer.toString(numofmed);

        Medicine med = new Medicine();
        med.setId(id);
        med.setName(med_name);
        med.setQty(qty);
        med.setType(type);
        med.setPrice(price);
        med.setDate(dtf.format(now));

        super.medList.add(med);
        numofmed++;
        System.out.println("=======================================");
        System.out.println("Item added successfully!");
    }

    void read() {
        System.out.println("=======================================");
        System.out.println("            Show Medicines             ");
        System.out.println("=======================================");
        for (int i = 0; i < super.medList.size(); i++) {
            Medicine getMed = super.medList.get(i);
            System.out.println("ID       : " + getMed.getId());
            System.out.println("Name     : " + getMed.getName());
            System.out.println("Quantity : " + getMed.getQty());
            System.out.println("Type     : " + getMed.getType());
            System.out.println("Price    : " + getMed.getPrice());
            System.out.println("Date     : " + getMed.getDate());
            System.out.println("=======================================");
        }
    }

    void update() {
        System.out.println("=======================================");
        System.out.println("            Upadate Medicine            ");
        System.out.println("=======================================");
        System.out.print("Med ID   : ");
        String temp = App.in.nextLine();
        int i;
        for (i = 0; i < super.medList.size(); i++) {
            Medicine getMed = super.medList.get(i);
            if (temp.equals(getMed.getId())) {
                System.out.println("=======================================");
                System.out.print("Name     : ");
                String med_name = App.in.nextLine();
                System.out.print("Quantity : ");
                int qty = App.in.nextInt();
                App.in.nextLine();
                System.out.print("Type     : ");
                String type = App.in.nextLine();
                System.out.print("Price    : ");
                int price = App.in.nextInt();
                App.in.nextLine();

                Medicine new_med = new Medicine();
                new_med.setId(temp);
                new_med.setName(med_name);
                new_med.setQty(qty);
                new_med.setType(type);
                new_med.setPrice(price);
                new_med.setDate(dtf.format(now));
                super.medList.set(i, new_med);
                System.out.println("=======================================");
                System.out.println("Item changed successfully!");
                break;
            }
        }
        if (i == super.medList.size()) {
            System.out.println("Invalid ID");
        }
    }

    void delete() {
        System.out.println("=======================================");
        System.out.println("            Delete Medicine             ");
        System.out.println("=======================================");
        System.out.print("Med ID   : ");
        String temp = App.in.nextLine();
        int i;
        int isDelete = 0;
        for (i = 0; i < super.medList.size(); i++) {
            Medicine getMed = super.medList.get(i);
            if (temp.equals(getMed.getId())) {
                super.medList.remove(i);
                System.out.println("=======================================");
                System.out.println("Item deleted successfully!");
                isDelete = 1;
                break;
            }
        }
        if (isDelete != 1) {
            if (i == super.medList.size()){
                System.out.println("Invalid ID");
            }
        }

    }
}
