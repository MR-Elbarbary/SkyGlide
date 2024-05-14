package skyglide;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import skyglide.classes.DatabaseConnection;
import skyglide.classes.user.User;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class Login {
    @FXML
    private TextField usernameField;

    @FXML
    private Button Back;

    @FXML
    private PasswordField passwordField;

    @FXML
    void Return_Back_Previous_Page(ActionEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setX(350);
        stage.setY(130);
        stage.show();

    }
    
    public void login(ActionEvent event) throws IOException{
        String username = usernameField.getText();
        String password = passwordField.getText();
    
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
    
        // Check if the username and password are valid for admin login
        if (databaseConnection.isValidAdmin(username, password)) {
            // Admin login successful
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("DataBase_Managment_System.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) usernameField.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Open admin dashboard or perform admin-specific actions
            System.out.println("Admin login successful");
        } else if (databaseConnection.isValidUser(username, password)) {
            databaseConnection.logUser(username, password);
            Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("SkyGlide");
            stage.setX(200);
            stage.setY(5);
            stage.setScene(scene);
            stage.show();
            // User login successful
            // Open user dashboard or perform user-specific actions
            System.out.println("User login successful");
        } else {
            // Invalid login credentials
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password");
            alert.showAndWait();
        }
        
    }
    public void initialize(URL location, ResourceBundle resources) {
        User.logout();
    }
}
