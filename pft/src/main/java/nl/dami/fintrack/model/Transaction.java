package nl.dami.fintrack.model;

public class Transaction {
    private String id;
    private String userId;
    private double amount;
    private String type;
    private String category;
    private String description;
    private String date;

    public Transaction(String id, String userId, double amount, String type, String category, String description, String date){
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    public String getId(){ return id;}
    public String getUserId(){ return userId;}
    public double getAmount(){ return amount;}
    public String getType(){ return type;}
    public String getCategory(){ return category;}
    public String getDescription(){ return description;}
    public String getDate(){ return date;}
}
