package medpackage;

public class Medicine {
    private String id;
    private String name;
    private int stok;
    private int price;
    private String date_input;

    public Medicine(String id, String name, int stok, int price, String date) {
        this.id = id;
        this.name = name;
        this.stok = stok;
        this.price = price;
        this.date_input = date;
    }

    public Medicine(){
        
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStok() {
        return stok;
    }

    public int getPrice() {
        return price;
    }

    public String getDate() {
        return date_input;
    }
}
