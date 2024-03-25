package javapackage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import medpackage.Capsule;
import medpackage.Medicine;
import medpackage.Tablet;
import medpackage.Syrup;

public class Employee extends Account {
    private String id;
    private String name;
    private int age;
    private float salary;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime now = LocalDateTime.now();
    ArrayList<Medicine> medList = new ArrayList<>();
    int numofmedtab = 1;
    int numofmedsy = 1;
    int numofmedcs = 1;

    public Employee(String username, String password, String id, boolean isAdmin, String name, int age, float salary) {
        super(username, password, isAdmin);
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee() {

    }

    public String getIdEmp() {
        return id;
    }

    public String getNameEmp() {
        return name;
    }

    public int getAgeEmp() {
        return age;
    }

    public float getSalaryEmp() {
        return salary;
    }

    public void setIdEmp(String id) {
        this.id = id;
    }

    public void setNameEmp(String name) {
        this.name = name;
    }

    public void setAgeEmp(int age) {
        this.age = age;
    }

    public void setSalaryEmp(float salary) {
        this.salary = salary;
    }

    public void menu_med() {
        while (true) {
            App.cls();
            System.out.println("=======================================================================================");
            System.out.println("                                    Manage Medicines                                   ");
            System.out.println("=======================================================================================");
            System.out.println("1. Add Medicine");
            System.out.println("2. Show Medicine");
            System.out.println("3. Update Medicine");
            System.out.println("4. Delete Medicine");
            System.out.println("0. Back");
            System.out
                    .println("=======================================================================================");
            System.out.print("Input Menu : ");
            String input = App.in.nextLine();

            if (input.equals("1")) {
                App.cls();
                add_med();
            } else if (input.equals("2")) {
                App.cls();
                read_med();
                App.con();
            } else if (input.equals("3")) {
                App.cls();
                update_med();
                App.con();
            } else if (input.equals("4")) {
                App.cls();
                delete_med();
                App.con();
            } else if (input.equals("0")) {
                App.isLogged = true;
                break;
            }
        }
    }

    void add_med() {
        while (true) {
            App.cls();
            System.out.println("=======================================================================================");
            System.out.println("                                      Add Medicine                                     ");
            System.out.println("=======================================================================================");
            System.out.println("1. Tablet");
            System.out.println("2. Syrup");
            System.out.println("3. Capsule");
            System.out.println("0. Back");
            System.out.println("=======================================================================================");
            System.out.print("Input type of med : ");
            String input = App.in.nextLine();
            if (input.equals("1")) {
                App.cls();
                add_med_tab();
                App.con();
            } else if (input.equals("2")) {
                App.cls();
                add_med_sy();
                App.con();
            } else if (input.equals("3")) {
                App.cls();
                add_med_cs();
                App.con();
            } else if (input.equals("0")) {
                break;
            }
        }
    }

    void add_med_tab() {
        System.out.println("=======================================================================================");
        System.out.println("                                       Add Tablet                                      ");
        System.out.println("=======================================================================================");
        System.out.print("Name     : ");
        String name = App.in.nextLine();
        System.out.print("Stok     : ");
        int stok = App.in.nextInt();
        System.out.print("Price    : ");
        int price = App.in.nextInt();
        System.out.print("mg       : ");
        int mg = App.in.nextInt();
        String id = "MEDT" + Integer.toString(numofmedtab);
        String date = dtf.format(now);

        Tablet med_tab = new Tablet(id, name, stok, price, date, "Tablet", mg);
        medList.add(med_tab);

        numofmedtab++;
        System.out.println("=======================================================================================");
        System.out.println("Item added successfully!");
        App.in.nextLine();
    }

    void add_med_sy() {
        System.out.println("=======================================================================================");
        System.out.println("                                        Add Syrup                                      ");
        System.out.println("=======================================================================================");
        System.out.print("Name     : ");
        String name = App.in.nextLine();
        System.out.print("Stok     : ");
        int stok = App.in.nextInt();
        System.out.print("Price    : ");
        int price = App.in.nextInt();
        System.out.print("ml       : ");
        int ml = App.in.nextInt();
        String id = "MEDS" + Integer.toString(numofmedsy);
        String date = dtf.format(now);

        Syrup med_sy = new Syrup(id, name, stok, price, date, "Syrup", ml);
        medList.add(med_sy);
        numofmedsy++;
        System.out.println("=======================================================================================");
        System.out.println("Item added successfully!");
        App.in.nextLine();
    }

    void add_med_cs() {
        System.out.println("=======================================================================================");
        System.out.println("                                      Add Capsule                                      ");
        System.out.println("=======================================================================================");
        System.out.print("Name     : ");
        String name = App.in.nextLine();
        System.out.print("Stok     : ");
        int stok = App.in.nextInt();
        System.out.print("Price    : ");
        int price = App.in.nextInt();
        System.out.print("mg       : ");
        int mg = App.in.nextInt();
        String id = "MEDC" + Integer.toString(numofmedcs);
        String date = dtf.format(now);

        Capsule med_cs = new Capsule(id, name, stok, price, date, "Capsule", mg);
        medList.add(med_cs);
        numofmedcs++;
        System.out.println("=======================================================================================");
        System.out.println("Item added successfully!");
        App.in.nextLine();
    }

    void read_med() {
        System.out.println("=======================================================================================");
        System.out.println("                                    Show Medicines                                     ");
        System.out.println("=======================================================================================");
        if (medList.isEmpty()) {
            System.out.println("Data is empty");
        } else {
            System.out.println("=======================================================================================");
            System.out.println("|   ID   |         Name         |    Type    |    Content    |    Price    |   Stok   |");
            System.out.println("=======================================================================================");
                for (Medicine getMed : medList){
                    System.out.printf("|%-8s", getMed.getId());
                    System.out.printf("|%-22s", getMed.getName());
                    if (getMed.getId().contains("MEDT")) {
                        Tablet tab = (Tablet) getMed;
                        System.out.printf("|%-12s", tab.getType());
                        System.out.printf("|%-15s", tab.getMg() + " mg/tablet");
                    } else if (getMed.getId().contains("MEDS")) {
                        Syrup sy = (Syrup) getMed;
                        System.out.printf("|%-12s", sy.getType());
                        System.out.printf("|%-15s", sy.getMl() + " ml");
                    } else if (getMed.getId().contains("MEDC")) {
                        Capsule sy = (Capsule) getMed;
                        System.out.printf("|%-12s", sy.getType());
                        System.out.printf("|%-15s", sy.getMg() + " mg/capsule");
                    }
                    System.out.printf("|%-13s", getMed.getPrice());
                    System.out.printf("|%-10s", getMed.getStok());
                    System.out.print("|\n");
                }
                System.out.println("=======================================================================================");
        }
    }

    void update_med() {
        System.out.println("=======================================================================================");
        System.out.println("                                    Update Medicine                                    ");
        System.out.println("=======================================================================================");
        System.out.print("Med ID : ");
        String temp = App.in.nextLine();
        int i;
        for (i = 0; i < medList.size(); i++) {
            Medicine getMed = medList.get(i);
            if (temp.equals(getMed.getId())) {
                System.out.println("=======================================================================================");
                System.out.print("Name     : ");
                String name = App.in.nextLine();
                System.out.print("Stok     : ");
                int stok = App.in.nextInt();
                System.out.print("Price    : ");
                int price = App.in.nextInt();
                if (getMed.getId().contains("MEDT")) {
                    System.out.print("mg       : ");
                    int mg = App.in.nextInt();
                    Tablet new_tab = new Tablet(getMed.getId(), name, stok, price, getMed.getDate(), "Tablet", mg);
                    medList.set(i, new_tab);
                } else if (getMed.getId().contains("MEDS")) {
                    System.out.print("ml       : ");
                    int ml = App.in.nextInt();
                    Syrup new_sy = new Syrup(getMed.getId(), name, stok, price, getMed.getDate(), "Tablet", ml);
                    medList.set(i, new_sy);
                }
                System.out.println("=======================================");
                System.out.println("Item changed successfully!");
                App.in.nextLine();
                break;
            }
        }
        if (i == medList.size()) {
            System.out.println("Invalid ID");
        }
    }

    void delete_med() {
        System.out.println("=======================================================================================");
        System.out.println("                                    Delete Medicine                                    ");
        System.out.println("=======================================================================================");
        System.out.print("Med ID   : ");
        String temp = App.in.nextLine();
        int i;
        int isDelete = 0;
        for (i = 0; i < medList.size(); i++) {
            Medicine getMed = medList.get(i);
            if (temp.equals(getMed.getId())) {
                medList.remove(i);
                System.out.println(
                        "=======================================================================================");
                System.out.println("Item deleted successfully!");
                isDelete = 1;
                break;
            }
        }
        if (isDelete != 1) {
            if (i == medList.size()) {
                System.out.println("Invalid ID");
            }
        }

    }
}
