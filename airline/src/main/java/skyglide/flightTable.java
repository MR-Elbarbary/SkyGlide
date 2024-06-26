package skyglide;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.util.Duration;
import skyglide.classes.DatabaseConnection;
import skyglide.classes.airport.Airport;
import skyglide.classes.flight.flight;

public class flightTable implements Initializable{

    /*
    Controlling Variables Giving It's FX:ID
    Controller Class For DataBase Managment System (Connected To FXML Files)
    */

    @FXML
    private Button Back;

    @FXML
    private Pane Left_Pane;

    @FXML
    private Pane Main_Page;

    @FXML
    private Pane Show_Page;

    @FXML
    private Pane Small_Pane;

    @FXML
    private Button adminTable;

    @FXML
    private Button aircraftTable;

    @FXML
    private Button airportsTable;

    @FXML
    private Button flightsTable;

    @FXML
    private Button usersTable;

    @FXML
    private TableColumn<flight, Double> priceColumn;

    @FXML
    private TableColumn<flight, Integer> idColumn;

    @FXML
    private TableColumn<flight, String> departureColumn;

    @FXML
    private TableColumn<flight, String> arrivalColumn;

    @FXML
    private TableColumn<flight, String> dateColumn;

    @FXML
    private TableView<flight> Table;

    @FXML
    private ComboBox<String> departurec;

    @FXML
    private ComboBox<String> arrivalc;

    @FXML
    private TextField pricef;

    @FXML
    private TextField datef;

    @FXML
    private Button add;

    @FXML
    private Button edit;

    @FXML
    private Button remove;


    ObservableList<flight> flights = FXCollections.observableArrayList();


    // Buttons For Interactiing With Users :

    @FXML
    void Back(ActionEvent event) throws IOException{

         Parent root = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
         stage.setTitle("SkyGlide");
         stage.setX(200);
         stage.setY(5);
         stage.setScene(scene);
         stage.show();

    }

    @FXML
    void showadmin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminTable.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setX(200);
        stage.setY(5);
        stage.show();
    }

    @FXML
    void showusers(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DataBase_Managment_System.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setX(200);
        stage.setY(5);
        stage.show();
    }

    @FXML
    void showairports(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("airportTable.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setX(200);
        stage.setY(5);
        stage.show();
    }

    @FXML
    void showaircrafts(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("aircraftTable.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setX(200);
        stage.setY(5);
        stage.show();
    }

    @FXML
    void showflights(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("flightTable.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setX(200);
        stage.setY(5);
        stage.show();
    }

    @FXML
    private void add(ActionEvent event) throws IOException {

        String arrival = arrivalc.getSelectionModel().getSelectedItem();
        String departure = departurec.getSelectionModel().getSelectedItem();
        double price;
        String date;
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        int departureID = databaseConnection.getAirportIdByName(departure);
        int arrivalID = databaseConnection.getAirportIdByName(arrival);

        try {
            date = datef.getText();
            price = Double.parseDouble(pricef.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid number for price.");
            alert.showAndWait();
            return;
        }

        if (arrival.isEmpty() || departure.isEmpty() || date.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
        }
        else{
            databaseConnection.addflight(price, arrivalID, departureID, date);
            refreshtable();
        }
    }

    @FXML
    private void remove(ActionEvent event) throws IOException{

        flight selectedrow = Table.getSelectionModel().getSelectedItem();

        if (selectedrow == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please select an airport to delete.");
            alert.showAndWait();
            return;
        }

        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        databaseConnection.deleteflight(selectedrow.getId());
        refreshtable();
    }

    @FXML
    private void clean() {

        pricef.setText(null);
        datef.setText(null);
    }

    @FXML
    private void edit(ActionEvent event) throws IOException {

    flight selectedrow = Table.getSelectionModel().getSelectedItem();

    if (selectedrow == null) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Please select a Flight to Edit.");
        alert.showAndWait();
        return;
    }

        String arrival = arrivalc.getSelectionModel().getSelectedItem();
        String departure = departurec.getSelectionModel().getSelectedItem();
        double price;
        String date;
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        int departureID = databaseConnection.getAirportIdByName(departure);
        int arrivalID = databaseConnection.getAirportIdByName(arrival);

        try {
            date = datef.getText();
            price = Double.parseDouble(pricef.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid number for price.");
            alert.showAndWait();
            return;
        }

        if (arrival.isEmpty() || departure.isEmpty() || date.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
        }
        else{
            databaseConnection.editflight(selectedrow.getId(), price, arrivalID, departureID, date);
            refreshtable();
        }
}

    @FXML
    private void refreshtable() throws IOException {

        flights.clear();
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        flights = databaseConnection.getAllFlights(); // Implement this method in DatabaseConnection
        Table.setItems(flights);
    }

    private void load() {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        departureColumn.setCellValueFactory(new PropertyValueFactory<>("departure"));
        arrivalColumn.setCellValueFactory(new PropertyValueFactory<>("arrival"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Load data from the database and populate the table
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        flights = databaseConnection.getAllFlights(); // Implement this method in DatabaseConnection
        Table.setItems(flights);
    }
     // Strating For Window open Action Animations :

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        load();

        Table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                pricef.setText(String.valueOf(newSelection.getPrice()));
                datef.setText(newSelection.getDate());
            }
        });

        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        List<String> airportNames = databaseConnection.getAllAirportNames();

        departurec.getItems().addAll(airportNames);
        arrivalc.getItems().addAll(airportNames);

        TranslateTransition translate = new TranslateTransition();
        translate.setNode(Left_Pane);
        translate.setDuration(Duration.millis(1000));
        translate.setByX(180);
        translate.play();

        TranslateTransition translate1 = new TranslateTransition();
        translate1.setNode(adminTable);
        translate1.setDuration(Duration.millis(1400));
        translate1.setByX(20);
        translate1.play();

        TranslateTransition translate2 = new TranslateTransition();
        translate2.setNode(usersTable);
        translate2.setDuration(Duration.millis(1500));
        translate2.setByX(20);
        translate2.play();

        TranslateTransition translate3 = new TranslateTransition();
        translate3.setNode(aircraftTable);
        translate3.setDuration(Duration.millis(1600));
        translate3.setByX(20);
        translate3.play();

        TranslateTransition translate4 = new TranslateTransition();
        translate4.setNode(airportsTable);
        translate4.setDuration(Duration.millis(1600));
        translate4.setByX(20);
        translate4.play();

        TranslateTransition translate5 = new TranslateTransition();
        translate5.setNode(flightsTable);
        translate5.setDuration(Duration.millis(1600));
        translate5.setByX(20);
        translate5.play();

        TranslateTransition translate6 = new TranslateTransition();
        translate6.setNode(Small_Pane);
        translate6.setDuration(Duration.millis(2000));
        translate6.setByX(75);
        translate6.play();

    }

}