package skyglide;

import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import skyglide.classes.DatabaseConnection;
import skyglide.classes.user.User;

public class adminmain {

    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<User, Integer> idColumn;

    @FXML
    private TableColumn<User, String> nameColumn;

    @FXML
    private TableColumn<User, String> passwordColumn;

    @FXML
    private Button Back;


    public void initialize() {
        load();
    }

    private void load() {
        
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));

        // Load data from the database and populate the table
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        List<User> users = databaseConnection.getAllUsers(); // Implement this method in DatabaseConnection
        userTable.getItems().addAll(users);
    }

    @FXML
    void Back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setX(330);
        stage.setY(90);
        stage.show();

    }
}