package skyglide.Java_App_OOP;

import java.util.ArrayList;
import java.util.Scanner;

public class Flights extends User_Data  implements Airline , Comparable{

    Scanner input = new Scanner(System.in);
    
    // Attributes for Airlne :
    
    static double Available_Seats = 50 ;

    private String Countries ;
    private double Price ;

     // Constructors According to User's Fields :

    Flights () {}
    
    public Flights(String name, String address, String email, double passportNumber, double phone,
     String countries, double price) {

        super(name, address, email, passportNumber, phone);
        
        this.Countries = countries;
        this.Price = price;

        Available_Seats -- ;
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
        return "Flights [Countries=" + Countries + ", Price=" + Price + ", getCountries()=" + getCountries()
                + ", getName()=" + getName() + ", getAddress()=" + getAddress() + ", getPrice()=" + getPrice()
                + ", getEmail()=" + getEmail() + ", getPhone()=" + getPhone() + "]";
    }


    // Mehtods :

    @Override
    public void Flights_Managment_Airlne() {
   
        String [] Countries_Starter_Postition = {

            "United States","Qatar","Yemen","Oman","Andorra","Zimbabwe","United Kingdom",
            "Japan","Vanuatu","Dominication","Germany","Russia","Hungary","Portugal",
            "Rwanda","Denmark","Estonia","Finland","Ireland","Iran","Lithuania",
            "Timor-Leste","Belgium","Luxembourg","China","Belize","Djibouti",
            "Azerbaijan","Uzbekistan","Liechtenstein","Nicaragua","Brazil",
            "Algeria","Netherlands","Poland","Sweden","France","Australia",
            "Singapore","San Marino","Jamaica","Jordan","Italy","Tukiye",
            "Bulgaria","Austria","Belarus","Albania","Armenia","Czechia",
            
               };
                 // Assuming Countries Final Positions :

                 ArrayList < String > X = new ArrayList<>();
                 
                 for (int i = 0 , j =49; i < Countries_Starter_Postition.length && j > Countries_Starter_Postition.length; i++ , j--) 
                 {

                    System.out.println(

                    X.add( "Flight no : " + (i+1) + "\n"+ 
                    "Departure Airport : " + Countries_Starter_Postition[i] + "Arrival Airport : " + Countries_Starter_Postition[j] )
                    );
                    System.out.println(X.get(i) + Countries_Starter_Postition[j]);
                    System.out.println("___________________________________");

                 }
                 System.out.println();
    }

   

    @Override
    public void Check_User_Data_And_Flights() {

    }

    
    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }


}
