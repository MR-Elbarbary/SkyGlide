package skyglide.classes.ticket;

public class ticket {
    private int id;
    private int user_id;
    private int flight_id;
    private double price;

    public ticket(int id , int user_id , int flight_id , Double price){
        setId(id);
        setUser_id(user_id);
        setFlight_id(flight_id);
        setPrice(price);
    }
    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public int getFlight_id() {
        return flight_id;
    }
    public int getId() {
        return id;
    }
    public double getPrice() {
        return price;
    }
    public int getUser_id() {
        return user_id;
    }
}