package skyglide;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Dashboard implements Initializable{

    @FXML
    private Button Back;

    @FXML
    private Pane Left_Pane;

    @FXML
    private Pane Main_Page;

    @FXML
    void Back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Airlne App");
        stage.setX(200);
        stage.setY(5);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        TranslateTransition translate = new TranslateTransition();
        translate.setNode(Left_Pane);
        translate.setDuration(Duration.millis(1000));
        translate.setByX(170);
        translate.play();        

        
    
    }

}
