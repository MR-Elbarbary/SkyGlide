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
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Report implements Initializable{

    @FXML
    private Button Back;

    @FXML
    private Label Label1;

    @FXML
    private Pane Left_Pane;

    @FXML
    private Pane Main_Pane;

    @FXML
    private Pane Small_Line;

    @FXML
    private Button Submit;

    @FXML
    void Back(ActionEvent event) throws IOException {

         Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);

         stage.setTitle("Login");
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
        translate.setByX(180);
        translate.play();

        TranslateTransition translate1 = new TranslateTransition();
        translate1.setNode(Label1);
        translate1.setDuration(Duration.millis(1500));
        translate1.setByY(80);
        translate1.play();

        TranslateTransition translate2 = new TranslateTransition();
        translate2.setNode(Small_Line);
        translate2.setDuration(Duration.millis(1200));
        translate2.setByY(90);
        translate2.play();

        TranslateTransition translate3 = new TranslateTransition();
        translate3.setNode(Submit);
        translate3.setDuration(Duration.millis(1500));
        translate3.setByX(-150);
        translate3.play();
    }

}
