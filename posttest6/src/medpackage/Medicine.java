package medpackage;

public abstract class Medicine {
    protected String id;
    protected String name;
    protected int stok;
    protected int price;
    protected String date_input;

    public Medicine(String id, String name, int stok, int price, String date) {
        this.id = id;
        this.name = name;
        this.stok = stok;
        this.price = price;
        this.date_input = date;
    }

    public Medicine(){

    }

    public abstract String getId();

    public abstract String getName();

    public abstract int getStok();

    public abstract int getPrice();

    public abstract String getDate();

    public void display() {
        System.out.printf("|%-8s", this.getId());
        System.out.printf("|%-22s", this.getName());
        System.out.printf("|%-13s", "Rp."+this.getPrice());
        System.out.printf("|%-10s", this.getStok());
    }
}
