package skyglide.Java_App_OOP;
import java.util.Scanner;

public class Java_OOP {
public static void main(String[] args) {

    /*

    Special main method for Taking From User's Data or Check it :
    OBJECTS : NEED FOR AHCIEVING (METHODS - DATA - OTHER CLASSES)
    GUI : THIS CODES MUST APPEAR IN BUTTON (Profile ==> Homepage ):
    DATABASE : NEED AT LEAST EACH VARIABLE IS INSERTED INTO TABLE BY MOHAMED

    */

   Scanner input = new Scanner(System.in);

   User_Data C = new User_Data();
   Flights C1 = new Flights();


   System.out.println("Welcome To Our Airlne System !");
   System.out.println();

   try {

    System.out.println("Do You Want To Register for Only 1 profile or more ? \n (1==>Only one Profile) (Any NO.==>More Profiles)");
    int y = input.nextInt();

    if ( y == 1 ) {

        System.out.println("Do You Want To Register with us ? (1=>Yes) (2=>No)");
        int x = input.nextInt();
        System.out.println();

    switch (x) {
        case 1:

        C.Data_Request(); // Method ==> Class : User_Data 
        System.out.println();
        
        break;
    
        default:
            break;
    }

    System.out.println("Do You Want To Check Your Data with us ? (1=>Yes) (2=>No)");
    int x1 = input.nextInt();
    System.out.println();

    
    switch (x1) {
        case 1:

        C.Show_Data(); // Method ==> Class : User_Data 

        System.out.println();
        
        break;
    
        default:
            break;
    }
        
    } else {
        System.out.println("Enter How Many Accounts ?");
        int y1 = input.nextInt();
        
        User_Data c1 [] = new User_Data[y1];

        for (int i = 0; i < c1.length; i++) {

        System.out.println("Enter Your Name : " + "for no :" + (i+1) );
        String z1 = input.next(); // Passing (z1) Value For DataBase
        c1[i] = new User_Data();
        c1[i].setName(z1);

        System.out.println("Enter Your Phone : " + "for no :" + (i+1) );
        Double z2 = input.nextDouble(); // Passing (z2) Value For DataBase
        c1[i] = new User_Data();
        c1[i].setPhone(z2);

        System.out.println("Enter Your Email : " + "for no :" + (i+1) );
        String z3 = input.next(); // Passing (z3) Value For DataBase
        c1[i] = new User_Data();
        c1[i].setEmail(z3);

        System.out.println("Enter Your Address : " + "for no :" + (i+1) );
        String z4 = input.next(); // Passing (z4) Value For DataBase
        c1[i] = new User_Data();
        c1[i].setAddress(z4);

        System.out.println();
        System.out.println("______________________________");

            
        }

    }
 
   } catch (Exception e) {

    System.out.println("Something went wrong !");

   }


   for (int i = 0; i < 1; i++) {

    try {
    
      System.out.println("Do You Want To Check List For Available Countries or Their Prices ??");
      System.out.println();
      System.out.println("(1==> Yes)");
      int y1 = input.nextInt();
  
      System.out.println();
  
      if ( y1 == 1) {
  
          System.out.println("(1==> Countries) (2==> Countries_Prices)");
          int x2 = input.nextInt();
  
          System.out.println();
  
          switch (x2) {
              case 1:
  
              C.Show_Countries();
  
              System.out.println();
      
                  break;
                  case 2 :
  
                   C.Show_Countries_Price();
  
                   System.out.println();
          
              default:
                  break;
          }
          System.out.println("Do You Want To Go Back ??");
          System.out.println("(1 ==> Yes) (Any No ==> No)");
          int z = input.nextInt();

          if (z == 1) {

             break; 
            }
            System.out.println();
      }
      
    } catch (Exception e) {
  
      System.out.println("Something went wrong !"); 
    }
   }
 
 
   for (int i = 0; i < 1; i++) {
    
   

  try {
    
     System.out.println("Do You Want To Check FLights ?? (1 ==> Yes) (2 ==> No)");
     int y2 = input.nextInt();

     if ( y2 == 1) {

        System.out.println("Do You Want To Book Only one Flight Or More ??");
        System.out.println("(1 ==> Only One)( Any No. ==> More)");
        int x2 = input.nextInt();
        System.out.println();

        switch (x2) {

            case 1 : C1.Flights_Managment_Airlne();
            System.out.println();

              
              break;
        
            default:
                break;
        }

        System.out.println("Do You Want To Go Back ??");
        System.out.println("(1 ==> Yes) (Any No ==> No)");
        int z = input.nextInt();

        if (z == 1) {

           break; 
          }
          System.out.println();
     }
    
  } catch (Exception e) {
    System.out.println("Something went wrong");
  }
 }

 
 try {} catch (Exception e)  {}

 finally {

  System.out.println("We Hope We Have service You We will Waiting For You Again !! \n");
  System.out.println("You Have Exit Our System");
  input.close();

  }
  }
}


