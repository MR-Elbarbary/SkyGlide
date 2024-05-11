package skyglide.Java_App_OOP;

import java.util.ArrayList;
import java.util.Scanner;
public class User_Data extends Collecting_Data {

    Scanner input = new Scanner(System.in);
    
    // Attributes for User's Data :

    private String Name ;
    private String Address ;
    private String email ;
    private double PassportNumber ;
    private double Phone ;

    // Constructors According to User's Fields :

    public User_Data() {
    }    

    public User_Data(String name, double passportNumber, double phone) {
        this.Name = name;
        this.PassportNumber = passportNumber;
        this.Phone = phone;
    }

    public User_Data(String name, String address, String email, double passportNumber, double phone) {
        this.Name = name;
        this.Address = address;
        this.email = email;
        this.PassportNumber = passportNumber;
        this.Phone = phone;
    }

    // Setters And Getters For User's Data :

    public String getName() { return Name; }

    public void setName(String name) {Name = name;}

    public String getAddress() {return Address;}

    public void setAddress(String address) {Address = address;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public double getPassportNumber() {return PassportNumber;}

    public void setPassportNumber(double passportNumber) {PassportNumber = passportNumber;}

    public double getPhone() {return Phone;}

    public void setPhone(double phone) {Phone = phone;}

    // --------------------------------------------------------------------------------------------------------
    // Asking User his Data  :

    public void Data_Request () {

        System.out.println("Enter Your Name :");
        String x1 = input.next(); // Passing (x1) Value For DataBase
        setName(x1);

        System.out.println("Enter Your Phone :");
        int x2 = input.nextInt(); // Passing (x2) Value For DataBase
        setPhone(x2);
         
        System.out.println("Enter Your Email :");
        String x3 = input.next(); // Passing (x3) Value For DataBase
        setEmail(x3);

        System.out.println("Enter Your Address :");
        String x4 = input.next(); // Passing (x4) Value For DataBase
        setAddress(x4);

    }

    // Showing Data For User :

    public void Show_Data () {

        System.out.println("Data :");
        System.out.println("________________");
        System.out.println();
        
        System.out.println("Username :" + getName());
        System.out.println("Phone :" + getPhone());
        System.out.println("Email :" + getEmail());
        System.out.println("Address :" + getAddress());

        System.out.println();
        System.out.println("________________");
    }   

    // Availiable Countries :

    @Override
    public void Show_Countries() {

        String [] Countries = {

            "United States","Qatar","Yemen","Oman","Andorra","Zimbabwe","United Kingdom",
            "Japan","Vanuatu","Dominication","Germany","Russia","Hungary","Portugal",
            "Rwanda","Denmark","Estonia","Finland","Ireland","Iran","Lithuania",
            "Timor-Leste","Belgium","Luxembourg","China","Belize","Djibouti",
            "Azerbaijan","Uzbekistan","Liechtenstein","Nicaragua","Brazil",
            "Algeria","Netherlands","Poland","Sweden","France","Australia",
            "Singapore","San Marino","Jamaica","Jordan","Italy","Tukiye",
            "Bulgaria","Austria","Belarus","Albania","Armenia","Czechia",
            
               };

               System.out.println("Available Countries");
               System.out.println();

        for (int i = 0; i < Countries.length; i++) {

            System.out.println("Country :" + Countries[i]);
            System.out.println("- - - - - - - - - - ");
            
        }

    }

    // Availiable Countries_Prices :

    @Override
    public void Show_Countries_Price() {

        String [] Countries = {

            "United States","Qatar","Yemen","Oman","Andorra","Zimbabwe","United Kingdom",
            "Japan","Vanuatu","Dominication","Germany","Russia","Hungary","Portugal",
            "Rwanda","Denmark","Estonia","Finland","Ireland","Iran","Lithuania",
            "Timor-Leste","Belgium","Luxembourg","China","Belize","Djibouti",
            "Azerbaijan","Uzbekistan","Liechtenstein","Nicaragua","Brazil",
            "Algeria","Netherlands","Poland","Sweden","France","Australia",
            "Singapore","San Marino","Jamaica","Jordan","Italy","Tukiye",
            "Bulgaria","Austria","Belarus","Albania","Armenia","Czechia",
            
               };
                Integer [] Prices = {

        50000,10000,34000,2000,60000,9000,8000,49990,30000,
        35000,29000,19000,40000,70000,89000,25000,56000,
        12000,40000,50000,14000,25000,65000,24000,18000,
        55000,80000,12000,40000,60000,55000,25000,90000,
        50000,14000,59999,46000,75000,9000,66000,29999,
        40000,54000,25000,42000,45000,12000,5000,20000,80000

           };

        ArrayList <Integer []> X = new ArrayList<>();
        X.add(Prices);

        for (int i = 0; i < Countries.length; i++) {

            System.out.println("Country no " + (i+1) + " : "  + Countries[i] + "\n" +

            "It's Price : " + Prices[i] + "\n" +

            "----------------------------------------------"
            );
        }
    }
           
           
    
}
