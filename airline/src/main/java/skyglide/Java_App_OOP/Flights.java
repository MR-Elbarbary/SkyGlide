package skyglide.Java_App_OOP;

import java.util.Scanner;

@SuppressWarnings("rawtypes")
public class Flights implements Airline , Comparable{

    Scanner input = new Scanner(System.in);
    
    // Attributes for Airlne :
    
    static double Available_Seats = 50 ;

    private String Countries ;
    private double Price ;

     // Constructors According to User's Fields :

    Flights () {}

    public Flights(Scanner input, String Countries, double Price) {

        this.input = input;
        this.Countries = Countries;
        this.Price = Price;

        // Available Seats :
        Available_Seats -- ;

    }


    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public static double getAvailable_Seats() {
        return Available_Seats;
    }

    public static void setAvailable_Seats(double available_Seats) {
        Available_Seats = available_Seats;
    }

    public String getCountries() {
        return Countries;
    }

    public void setCountries(String countries) {
        Countries = countries;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    @Override
    public String toString() {

        return     "Flights [input=" + input +
                   ", Countries=" + Countries +
                   ", Price=" + Price + "]";
    }

    // Mehtods :

    @Override
    public void Flights_Managment_Airlne() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Flights_Managment_Airlne'");
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

}
