package skyglide;

import java.io.IOException;
import javafx.fxml.FXML;
import java.sql.*;

public class register {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}