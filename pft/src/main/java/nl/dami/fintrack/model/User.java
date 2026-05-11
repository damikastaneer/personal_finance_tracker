package nl.dami.fintrack.model;

public class User {
    private String id;
    private String username;
    private String email;
    private String passwordHash;

    public User(String id, String username, String email, String passwordhash){
        this.id = id;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordhash;

    }

    public String getId(){
        return id;
    }

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
