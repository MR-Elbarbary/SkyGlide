package skyglide;

import java.io.IOError;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import skyglide.classes.DatabaseConnection;

public class adduser {

    @FXML
    private Button save;

    @FXML
    private TextField username;

    @FXML
    private TextField useremail;

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

}