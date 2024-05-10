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

public class DataBase_Managment_System implements Initializable{

    /*
    Controlling Variables Giving It's FX:ID
    Controller Class For DataBase Managment System (Connected To FXML Files)
    */

   @FXML
    private Button Back;

    @FXML
    private Label Label2;

    @FXML
    private Label Label3;

    @FXML
    private Label Lable1;

    @FXML
    private Pane Left_Pane;

    @FXML
    private Pane Main_Page;

    @FXML
    private Pane Show_Page;

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

     // Strating For Window open Action Animations :

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        TranslateTransition translate = new TranslateTransition();
        translate.setNode(Left_Pane);
        translate.setDuration(Duration.millis(1000));
        translate.setByX(180);
        translate.play();

        TranslateTransition translate1 = new TranslateTransition();
        translate1.setNode(Lable1);
        translate1.setDuration(Duration.millis(1400));
        translate1.setByX(20);
        translate1.play();

        TranslateTransition translate2 = new TranslateTransition();
        translate2.setNode(Label2);
        translate2.setDuration(Duration.millis(1500));
        translate2.setByX(20);
        translate2.play();

        TranslateTransition translate3 = new TranslateTransition();
        translate3.setNode(Label3);
        translate3.setDuration(Duration.millis(1600));
        translate3.setByX(20);
        translate3.play();

    }

}
