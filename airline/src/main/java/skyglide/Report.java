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
    private Label Label;

    @FXML
    private Label Label2;

    @FXML
    private Pane Left_Pane;

    @FXML
    private Pane Moving_Line;

    @FXML
    private Pane Small_Pane;


    @FXML
    void Back(ActionEvent event) throws IOException{

         Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
         
         stage.setTitle("SkgyGlide");
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
        translate.setByX(190);
        translate.play();        

        TranslateTransition translate1 = new TranslateTransition();
        translate1.setNode(Label);
        translate1.setDuration(Duration.millis(1500));
        translate1.setByY(80);
        translate1.play();        
        
        TranslateTransition translate2 = new TranslateTransition();
        translate2.setNode(Moving_Line);
        translate2.setDuration(Duration.millis(1000));
        translate2.setByY(85);
        translate2.play();        

        TranslateTransition translate3 = new TranslateTransition();
        translate3.setNode(Small_Pane);
        translate3.setDuration(Duration.millis(1400));
        translate3.setByX(380);
        translate3.play();        
    }

}
