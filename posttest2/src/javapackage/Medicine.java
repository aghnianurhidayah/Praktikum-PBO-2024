package javapackage;

public class Medicine {
    private String id;
    private String name;
    private int quantity;
    private String type;
    private int price;
    private String date_input;

    public Medicine(String id, String name, int quantity, String type, int price, String date) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.type = type;
        this.price = price;
        this.date_input = date;
    }

    public Medicine(){
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return quantity;
    }

    public void setQty(int qty) {
        this.quantity = qty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date_input;
    }

    public void setDate(String date) {
        this.date_input = date;
    }

}
