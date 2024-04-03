package javapackage;

public class Account {
    protected String username;
    protected String password;
    protected boolean isAdmin;

    public Account (String username, String password, boolean isAdmin){
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public Account(){
        
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public boolean getRole(){
        return isAdmin;
    }

}
