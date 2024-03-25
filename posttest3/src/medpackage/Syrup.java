package medpackage;

public class Syrup extends Medicine {
    private String type;
    private int ml;

    public Syrup(String id, String name, int stok, int price, String date, String type, int ml) {
        super(id, name, stok, price, date);
        this.type = type;
        this.ml = ml;
    }

    public String getType() {
        return type;
    }

    public int getMl() {
        return ml;
    }
}
