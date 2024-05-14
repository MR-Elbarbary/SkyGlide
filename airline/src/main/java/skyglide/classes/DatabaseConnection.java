package skyglide.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import skyglide.classes.aircraft.Aircraft;
import skyglide.classes.airport.Airport;
import skyglide.classes.flight.flight;
import skyglide.classes.user.User;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:skyglide.db";
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean isValidAdmin(String username, String password) {
        String sql = "SELECT COUNT(*) FROM admins WHERE name = ? AND password = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isValidUser(String username, String password) {
        String sql = "SELECT COUNT(*) FROM Users WHERE name = ? AND password = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ObservableList<User> getAllUsers() {
    ObservableList<User> users = FXCollections.observableArrayList();
    String sql = "SELECT * FROM users";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("name");
            String password = rs.getString("password");
            String email = rs.getString("email");
            users.add(new User(id, username, password, email));
        }
    } catch (SQLException e) {
        e.printStackTrace();
        }
    return users;
    }

    public void adduser(String name, String password, String email){
        String sql = "INSERT INTO Users(name, email, password) VALUES(?, ?, ?)";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void logUser(String username, String password) {
        String query = "SELECT * FROM Users WHERE name = ? AND password = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                User.setLogedid(rs.getInt("id"));
                User.setLogedusername(rs.getString("name"));
                User.setLogedemail(rs.getString("email"));
                User.setLogedpassword(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        String sql = "DELETE FROM Users WHERE id =?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void updateUser(int id, String name, String password, String email) {
        String sql = "UPDATE Users SET name = ?, password = ?, email = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<User> getAlladmins() {
        ObservableList<User> users = FXCollections.observableArrayList();
        String sql = "SELECT * FROM admins";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("name");
                String password = rs.getString("password");
                String email = rs.getString("email");
                users.add(new User(id, username, password, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            }
        return users;
        }
    
        public void addadmin(String name, String password, String email){
            String sql = "INSERT INTO admins(name, email, password) VALUES(?, ?, ?)";
            try(PreparedStatement pstmt = connection.prepareStatement(sql)){
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, password);
                pstmt.executeUpdate();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    
        public void deleteadmin(int id) {
            String sql = "DELETE FROM admins WHERE id =?";
            try(PreparedStatement pstmt = connection.prepareStatement(sql)){
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    
        public void updateadmin(int id, String name, String password, String email) {
            String sql = "UPDATE admins SET name = ?, password = ?, email = ? WHERE id = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, name);
                pstmt.setString(2, password);
                pstmt.setString(3, email);
                pstmt.setInt(4, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void addairport(String name, String city, String country){
            String sql = "INSERT INTO Airports(name, city, country) VALUES(?, ?, ?)";
            try(PreparedStatement pstmt = connection.prepareStatement(sql)){
                pstmt.setString(1, name);
                pstmt.setString(2, city);
                pstmt.setString(3, country);
                pstmt.executeUpdate();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }

        public void deleteairport(int id){
            String sql = "DELETE FROM Airports WHERE id =?";
            try(PreparedStatement pstmt = connection.prepareStatement(sql)){
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }

        public void updateairports(int id, String name, String city, String country){
            String sql = "UPDATE Airports SET name = ?, city = ?, country = ? WHERE id = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, name);
                pstmt.setString(2, city);
                pstmt.setString(3, country);
                pstmt.setInt(4, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public ObservableList<Airport> getAllAirports() {
            ObservableList<Airport> airports = FXCollections.observableArrayList();
            String sql = "SELECT * FROM Airports";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String city = rs.getString("city");
                    String country = rs.getString("country");
                    airports.add(new Airport(id, name, city, country));
                }
            } catch (SQLException e) {
                e.printStackTrace();
                }
            return airports;
            }


            public void addaircraft(String name, int capacity, double price){
                String sql = "INSERT INTO Aircrafts(name, capacity, price) VALUES(?, ?, ?)";
                try(PreparedStatement pstmt = connection.prepareStatement(sql)){
                    pstmt.setString(1, name);
                    pstmt.setInt(2, capacity);
                    pstmt.setDouble(3, price);
                    pstmt.executeUpdate();
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            }

            public void deleteaircraft(int id){
                String sql = "DELETE FROM Aircrafts WHERE id =?";
                try(PreparedStatement pstmt = connection.prepareStatement(sql)){
                    pstmt.setInt(1, id);
                    pstmt.executeUpdate();
                } catch(SQLException e){
                    e.printStackTrace();
                }
            }

            public void updateaircrafts(int id, String name, int capacity, double price){
                String sql = "UPDATE Aircrafts SET name = ?, capacity = ?, price = ? WHERE id = ?";
                try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    pstmt.setString(1, name);
                    pstmt.setInt(2, capacity);
                    pstmt.setDouble(3, price);
                    pstmt.setInt(4, id);
                    pstmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            public ObservableList<Aircraft> getAllAircrafts() {
                ObservableList<Aircraft> aircrafts = FXCollections.observableArrayList();
                String sql = "SELECT * FROM Aircrafts";
                try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        int capacity = rs.getInt("capacity");
                        double price = rs.getDouble("price");
                        aircrafts.add(new Aircraft(id, name, capacity, price));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    }
                return aircrafts;
            }

            public int getAirportIdByName(String airportName) {
                int airportId = -1; // Default value if airport is not found
                String query = "SELECT id FROM Airports WHERE name = ?;";
                try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                    pstmt.setString(1, airportName);
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        airportId = rs.getInt("id");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return airportId;
            }

            public void addflight(double price, int arrival, int departure, String date){
                String sql = "INSERT INTO Flights(departure_airport_id, arrival_airport_id, departure_time, price) VALUES(?, ?, ?, ?)";
                try(PreparedStatement pstmt = connection.prepareStatement(sql)){
                    pstmt.setDouble(1, departure);
                    pstmt.setInt(2, arrival);
                    pstmt.setString(3, date);
                    pstmt.setDouble(4, price);
                    pstmt.executeUpdate();
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            }

            public void deleteflight(int id){
                String sql = "DELETE FROM Flights WHERE id =?";
                try(PreparedStatement pstmt = connection.prepareStatement(sql)){
                    pstmt.setInt(1, id);
                    pstmt.executeUpdate();
                } catch(SQLException e){
                    e.printStackTrace();
                }
            }

            public void editflight(int id, double price, int arrival, int departure, String date){
                String sql = "UPDATE Flights SET departure_airport_id = ?, arrival_airport_id = ?, departure_time = ?, price = ? WHERE id = ?";
                try(PreparedStatement pstmt = connection.prepareStatement(sql)){
                    pstmt.setString(3, date);
                    pstmt.setInt(2, arrival);
                    pstmt.setInt(1, departure);
                    pstmt.setDouble(4, price);
                    pstmt.setInt(5, id);
                    pstmt.executeUpdate();
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            }

            public ObservableList<flight> getAllFlights() {
                ObservableList<flight> flights = FXCollections.observableArrayList();
                String query = "SELECT * FROM Flights";
                try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        int departureAirportId = rs.getInt("departure_airport_id");
                        int arrivalAirportId = rs.getInt("arrival_airport_id");
                        String departureTime = rs.getString("departure_time");
                        int price = rs.getInt("price");
                        String departurename = getAirportNameById(departureAirportId);
                        String arrivalname = getAirportNameById(arrivalAirportId);
                        flight Flight = new flight(id, departurename, arrivalname, departureTime, price);
                        flights.add(Flight);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return flights;
            }

            public String getAirportNameById(int airportId) {
                String airportName = null;
                String query = "SELECT name FROM Airports WHERE id = ?";
                try (PreparedStatement pstmt = connection.prepareStatement(query)){
                    pstmt.setInt(1, airportId);
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        airportName = rs.getString("name");
                    }
                } catch(SQLException e) {
                    e.printStackTrace();
                }
                return airportName;
            }

            public List<String> getAllAirportNames() {
                List<String> airports = FXCollections.observableArrayList();
            String sql = "SELECT * FROM Airports";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("name");
                    airports.add(name);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                }
            return airports;
            }
            

}
