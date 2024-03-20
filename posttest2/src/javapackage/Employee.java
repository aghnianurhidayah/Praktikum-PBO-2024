package javapackage;

public class Employee {
    private String id;
    private String username;
    private String password;
    private String name;

    public Employee(String id, String username, String password, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public String getIdEmployee() {
        return id;
    }

    public String getUnameEmployee() {
        return username;
    }

    public String getPwEmployee() {
        return password;
    }

    public String getNameEmployee() {
        return name;
    }

    public void setIdEmployee(String id) {
        this.id = id;
    }

    public void getUnameEmployee(String uname) {
        this.username = uname;
    }

    public void getPwEmployee(String pw) {
        this.password = pw;
    }

    public void getNameEmployee(String name) {
        this.name = name;
    }
}
