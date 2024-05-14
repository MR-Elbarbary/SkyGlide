package skyglide;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import skyglide.classes.DatabaseConnection;

public class adduser implements Initializable {

    @FXML
    private Label AddUser;

    @FXML
    private Pane Moving_Pane;

    @FXML
    private AnchorPane Main_Pane;

    @FXML
    private Button save;

    @FXML
    private TextField useremail;

    @FXML
    private TextField username;

    @FXML
    private TextField userpassword;

    @FXML
    void save(ActionEvent event) throws IOException {
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
        }
    }

    @FXML
    private void clean() {
        username.setText(null);
        userpassword.setText(null);
        useremail.setText(null);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(AddUser);
        translate.setDuration(Duration.millis(1100));
        translate.setByX(200);
        translate.play();

        TranslateTransition translate1 = new TranslateTransition();
        translate1.setNode(Moving_Pane);
        translate1.setDuration(Duration.millis(1500));
        translate1.setByX(200);
        translate1.play();
    }

}