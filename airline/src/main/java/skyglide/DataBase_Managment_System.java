package skyglide;

import java.io.IOException;
import java.lang.System.Logger;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

    ObservableList<User> users = FXCollections.observableArrayList();


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

    }

    @FXML
    void showusers(ActionEvent event) throws IOException {

    }

    @FXML
    void showairports(ActionEvent event) throws IOException {

    }

    @FXML
    void showaircrafts(ActionEvent event) throws IOException {

    }

    @FXML
    void showflights(ActionEvent event) throws IOException {

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
