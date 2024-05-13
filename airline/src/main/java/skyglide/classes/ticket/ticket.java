package skyglide.classes.ticket;

public class ticket {
    private String ticketNumber;
    private String flight;
    private String passenger;
    private String seatNumber;
    private int price;

    public ticket(String ticketNumber , String flight , String passenger , String seatNumber , int price){
        this.ticketNumber = ticketNumber;
        this.flight = flight;
        this.passenger = passenger;
        this.seatNumber = seatNumber;
        this.price = price;}

        public void setTicketNumber (String ticketNumber) {
            this.ticketNumber = ticketNumber;
        }

        public void setFlight (String flight){
        this.flight = flight;
        }

        public void setPassenger(String passenger){
        this.passenger = passenger;
        }

        public void setSeatNumber(String seatNumber){
        this.seatNumber = seatNumber ;
        }

        public void setPrice(int price){
        this.price = price;
        }

        public String getTicketNumber(){
            return ticketNumber;
        }

        public String getFlight(){
            return flight;
        }

        public String getPassenger(){
            return passenger;
        }

        public String getSeatNumber(){
            return seatNumber;
        }

        public int getPrice(){
            return price;
        }
    }