package medpackage;

public class Capsule extends Medicine {
    private String type;
    private int mg;

    public Capsule(String id, String name, int stok, int price, String date, int mg) {
        super(id, name, stok, price, date);
        this.type = "Capsule";
        this.mg = mg;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getStok(){
        return stok;
    }

    public int getPrice(){
        return price;
    }

    public String getDate(){
        return date_input;
    }

    public String getType() {
        return type;
    }

    public int getMg() {
        return mg;
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("|%-12s", this.getType());
        System.out.printf("|%-15s", this.getMg() + " mg/capsule");
        System.out.print("|\n");
    }
}
