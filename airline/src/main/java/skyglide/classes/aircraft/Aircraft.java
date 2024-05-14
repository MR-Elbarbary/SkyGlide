package skyglide.classes.aircraft;
public class Aircraft {
    private int id;
    private String name;
    private int capacity;
    private double price;

    public Aircraft(int id, String name, int capacity, double price){
        setId(id);
        setCapacity(capacity);
        setName(name);
        setPrice(price);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
}