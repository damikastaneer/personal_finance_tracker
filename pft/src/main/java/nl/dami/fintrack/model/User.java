package nl.dami.fintrack.model;

public class User {
    private String id;
    private String f_name;
    private String l_name;
    private String username;
    private String email;
    private String passwordHash;

    public User(String id, String f_name, String l_name, String username, String email, String passwordhash){
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordhash;

    }

    public String getId(){
        return id;
    }

    public String getFirstName(){return f_name;}

    public String getLastName(){return l_name;}

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
