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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import skyglide.classes.DatabaseConnection;
import skyglide.classes.user.User;

public class DataBase_Managment_System implements Initializable{

    /*
    Controlling Variables Giving It's FX:ID
    Controller Class For DataBase Managment System (Connected To FXML Files)
    */

    @FXML
    private Button Back;

    @FXML
    private Label Label1;

    @FXML
    private Label Label2;

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
    private TableColumn<User, String> emailColumn;

    @FXML
    private TableColumn<User, Integer> idColumn;

    @FXML
    private TableColumn<User, String> nameColumn;

    @FXML
    private TableColumn<User, String> passwordColumn;

    @FXML
    private TableView<User> userTable;

    @FXML
    private TextField useremail;

    @FXML
    private TextField username;

    @FXML
    private TextField userpassword;

    @FXML
    private Button adduser;

    ObservableList<User> users = FXCollections.observableArrayList();


    // Buttons For Interactiing With Users :

    @FXML
    void Back(ActionEvent event) throws IOException{

         Parent root = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
         stage.setTitle("SkyGlide");
         stage.setScene(scene);
         stage.setX(200);
         stage.setY(5);
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
        Parent root = FXMLLoader.load(getClass().getResource("AircraftTable.fxml"));
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
    private void getaddview(MouseEvent event) throws IOException{
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("adduser.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void add(ActionEvent event) throws IOException {
        String name = username.getText();
        String password = userpassword.getText();
        String email = useremail.getText();

        if (name.isEmpty() || password.isEmpty() || email.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
        }
        else{
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            databaseConnection.adduser(name, password, email);
            clean();
            refreshtable(null);
        }
    }

    @FXML
    private void remove(ActionEvent event) throws IOException{
        User selectedUser = userTable.getSelectionModel().getSelectedItem();
    if (selectedUser == null) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Please select a user to delete.");
        alert.showAndWait();
        return;
    }

    DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
    databaseConnection.deleteUser(selectedUser.getId());
    refreshtable(null);
    }

    @FXML
    private void clean() {
        username.setText(null);
        userpassword.setText(null);
        useremail.setText(null);
    }

    @FXML
private void edit(ActionEvent event) throws IOException {
    User selectedUser = userTable.getSelectionModel().getSelectedItem();
    if (selectedUser == null) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Please select a user to Edit.");
        alert.showAndWait();
        return;
    }

    String name = username.getText();
    String password = userpassword.getText();
    String email = useremail.getText();

    if (name.isEmpty() || password.isEmpty() || email.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Please Fill All Data");
        alert.showAndWait();
    } else {
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        databaseConnection.updateUser(selectedUser.getId(), name, password, email);
        refreshtable(null);
    }
}

    @FXML
    private void refreshtable(MouseEvent event) throws IOException{
        users.clear();
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        users = databaseConnection.getAllUsers(); // Implement this method in DatabaseConnection
        userTable.setItems(users);

    }

    private void load() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Load data from the database and populate the table
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        users = databaseConnection.getAllUsers(); // Implement this method in DatabaseConnection
        userTable.setItems(users);
    }
     // Strating For Window open Action Animations :

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        load();

        userTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                username.setText(newSelection.getUsername());
                userpassword.setText(newSelection.getPassword());
                useremail.setText(newSelection.getEmail());
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
        translate6.setByX(90);
        translate6.play();

        TranslateTransition translate7 = new TranslateTransition();
        translate7.setNode(Label1);
        translate7.setDuration(Duration.millis(2000));
        translate7.setByX(120);
        translate7.play();

        TranslateTransition translate8 = new TranslateTransition();
        translate8.setNode(Label2);
        translate8.setDuration(Duration.millis(2000));
        translate8.setByX(160);
        translate8.play();


    }

}
