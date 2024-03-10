package javaclass;

// import java.time.LocalDateTime;

public class medicine {
    String id;
    String name;
    int quantity;
    String type;
    int price;
    String company;
    String date_input;

    public medicine(String id, String name, int quantity, String type, int price, String company, String date) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.type = type;
        this.price = price;
        this.company = company;
        this.date_input = date;
    }
}
