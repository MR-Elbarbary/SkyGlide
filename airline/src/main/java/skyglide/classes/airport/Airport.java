package skyglide.classes.airport;

public class Airport {
    private int id;
    private String name;
    private String city;
    private String country;

    public Airport(int id, String name, String city, String Country){
        setId(id);
        setName(name);
        setCity(city);
        setCountry(Country);
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}