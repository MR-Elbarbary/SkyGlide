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



    @FXML
    void Back(ActionEvent event) throws IOException{

         Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
         stage.setTitle("SkyGlide");
         stage.setX(290);
         stage.setY(130);
         stage.setScene(scene);
         stage.show();

    }

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
        translate1.setByX(60);
        translate1.play();

        TranslateTransition translate2 = new TranslateTransition();
        translate2.setNode(Label2);
        translate2.setDuration(Duration.millis(1500));
        translate2.setByX(60);
        translate2.play();

        TranslateTransition translate3 = new TranslateTransition();
        translate3.setNode(Label3);
        translate3.setDuration(Duration.millis(1600));
        translate3.setByX(10);
        translate3.play();

    }

}
