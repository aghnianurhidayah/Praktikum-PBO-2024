package medpackage;

public class Syrup extends Medicine {
    private String type;
    private int ml;

    public Syrup(String id, String name, int stok, int price, String date, int ml) {
        super(id, name, stok, price, date);
        this.type = "Syrup";
        this.ml = ml;
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

    public int getMl() {
        return ml;
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("|%-12s", this.getType());
        System.out.printf("|%-15s", this.getMl() + " ml");
        System.out.print("|\n");
    }
}
