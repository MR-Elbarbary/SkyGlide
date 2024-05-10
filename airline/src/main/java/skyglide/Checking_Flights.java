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
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Checking_Flights implements Initializable {

    /*
    Controlling Variables Giving It's FX:ID
    Controller Class For Checking Flights (Connected To FXML Files)
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
    private Pane Line_Pane;

    @FXML
    private Pane Main_Page;

    @FXML
    private Pane Small_Pane;

    @FXML
    private Pane Source_Pane;
    

    // Buttons For Interactiing With Users :

    @FXML
    void Back(ActionEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setX(200);
        stage.setY(5);
        stage.show();


    }

    // Strating For Window open Action Animations :

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(Label1);
        translate.setDuration(Duration.millis(1500));
        translate.setByY(90);
        translate.play();
        
        TranslateTransition translate1 = new TranslateTransition();
        translate1.setNode(Line_Pane);
        translate1.setDuration(Duration.millis(900));
        translate1.setByY(100);
        translate1.play();   
        
        TranslateTransition translate2 = new TranslateTransition();
        translate2.setNode(Left_Pane);
        translate2.setDuration(Duration.millis(1000));
        translate2.setByX(150);
        translate2.play();   

        TranslateTransition translate3 = new TranslateTransition();
        translate3.setNode(Small_Pane);
        translate3.setDuration(Duration.millis(1200));
        translate3.setByX(145);
        translate3.play();   



    }
    
}
