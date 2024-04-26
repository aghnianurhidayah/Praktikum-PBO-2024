package medpackage;

public class Tablet extends Medicine {
    private String type;
    private int mg;

    public Tablet(String id, String name, int stok, int price, String date, int mg) {
        super(id, name, stok, price, date);
        this.type = "Tablet";
        this.mg = mg;
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
        System.out.printf("|%-15s", this.getMg() + " mg/tablet");
        System.out.print("|\n");
    }
}
