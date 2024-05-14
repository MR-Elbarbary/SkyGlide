package skyglide.classes.flight;

public class flight {
    private int id;
    private String departure;
    private String arrival;
    private String date; // You can use a String for date or use java.time.LocalDate
    private int price;

    public flight(int id, String departure, String arrival, String date, int price) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
        this.date = date;
        this.price = price;
    }
    public void setArrival(String arrival) {
        this.arrival = arrival;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setDeparture(String departure) {
        this.departure = departure;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getArrival() {
        return arrival;
    }
    public String getDate() {
        return date;
    }
    public String getDeparture() {
        return departure;
    }
    public int getId() {
        return id;
    }
    public int getPrice() {
        return price;
    }
}
