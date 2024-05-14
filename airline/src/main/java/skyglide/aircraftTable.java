package skyglide;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.util.Duration;
import skyglide.classes.DatabaseConnection;
import skyglide.classes.aircraft.Aircraft;

public class aircraftTable implements Initializable{

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
    private TableColumn<Aircraft, Integer> capacityColumn;

    @FXML
    private TableColumn<Aircraft, Integer> idColumn;

    @FXML
    private TableColumn<Aircraft, String> nameColumn;

    @FXML
    private TableColumn<Aircraft, Double> priceColumn;

    @FXML
    private TableView<Aircraft> Table;

    @FXML
    private TextField capacityf;

    @FXML
    private TextField namef;

    @FXML
    private TextField pricef;

    @FXML
    private Button add;

    ObservableList<Aircraft> aircrafts = FXCollections.observableArrayList();


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
        stage.setX(350);
        stage.setY(130);
        stage.show();
    }

    @FXML
    void showusers(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DataBase_Managment_System.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setX(350);
        stage.setY(130);
        stage.show();
    }

    @FXML
    void showairports(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("airportTable.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setX(350);
        stage.setY(130);
        stage.show();
    }

    @FXML
    void showaircrafts(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AircraftTable.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setX(350);
        stage.setY(130);
        stage.show();
    }

    @FXML
    void showflights(ActionEvent event) throws IOException {

    }

    @FXML
    private void add(ActionEvent event) throws IOException {
        String name = namef.getText();
        int capacity ;
        double price ;

        try {
            capacity = Integer.parseInt(capacityf.getText());
            price = Double.parseDouble(pricef.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid number for capacity and price.");
            alert.showAndWait();
            return;
        }

        if (name.isEmpty() || capacity <= 0 || price <= 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
        }
        else{
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            databaseConnection.addaircraft(name, capacity, price);
            clean();
            refreshtable();
        }
    }

    @FXML
    private void remove(ActionEvent event) throws IOException{
        Aircraft selectedrow = Table.getSelectionModel().getSelectedItem();
        if (selectedrow == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please select an aircraft to delete.");
            alert.showAndWait();
            return;
        }

        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        databaseConnection.deleteairport(selectedrow.getId());
        refreshtable();
    }

    @FXML
    private void clean() {
        namef.setText(null);
        capacityf.setText(null);
        pricef.setText(null);
    }

    @FXML
    private void edit(ActionEvent event) throws IOException {
        Aircraft selectedrow = Table.getSelectionModel().getSelectedItem();
        if (selectedrow == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please select an aircraft to Edit.");
            alert.showAndWait();
            return;
        }

        String name = namef.getText();
        int capacity;
        double price;
        try {
            capacity = Integer.parseInt(capacityf.getText());
            price = Double.parseDouble(pricef.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid number for capacity and price.");
            alert.showAndWait();
            return;
        }

        if (name.isEmpty() || capacity <= 0 || price <= 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA AND NO NEGATIVE NUMBERS");
            alert.showAndWait();
        }
        else{
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            databaseConnection.updateaircrafts(selectedrow.getId(), name, capacity, price);
            refreshtable();
        }
    }

    @FXML
    private void refreshtable() throws IOException{
        aircrafts.clear();
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        aircrafts = databaseConnection.getAllAircrafts(); // Implement this method in DatabaseConnection
        Table.setItems(aircrafts);

    }

    private void load() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        capacityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        // Load data from the database and populate the table
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        aircrafts = databaseConnection.getAllAircrafts(); // Implement this method in DatabaseConnection
        Table.setItems(aircrafts);
    }
     // Strating For Window open Action Animations :

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        load();

        Table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                namef.setText(newSelection.getName());
                capacityf.setText(String.valueOf(newSelection.getCapacity()));
                pricef.setText(String.valueOf(newSelection.getPrice()));
            }
        });

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