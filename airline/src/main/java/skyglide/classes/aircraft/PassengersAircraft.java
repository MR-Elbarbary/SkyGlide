package skyglide.classes.aircraft;

import skyglide.classes.cabin.Cabin;

public abstract class PassengersAircraft extends Aircraft {
    public PassengersAircraft(int id,String name, int capacity, double price) {
        super(id,name, capacity, price);
        //TODO Auto-generated constructor stub
    }
    private Cabin cabin;
    public void setCabin(Cabin cabin) {
        this.cabin = cabin;
    }
    public Cabin getCabin() {
        return cabin;
    }
}