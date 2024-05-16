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
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Report implements Initializable {
    @FXML
    private Button Back;
    @FXML
    private Button submit;
    @FXML
    private Label Label;
    @FXML
    private Label Label2;
    @FXML
    private Label Label3;
    @FXML
    private Pane Left_Pane;
    @FXML
    private Pane Moving_Line;
    @FXML
    private Pane Small_Pane;
    @FXML
    private TextArea TA;

    public Report() {}
    

    @FXML
    void Back(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("HomePage.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("SkyGlide");
        stage.setX(200.0);
        stage.setY(5.0);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            TranslateTransition translate = new TranslateTransition();
            translate.setNode(this.Left_Pane);
            translate.setDuration(Duration.millis(1000.0));
            translate.setByX(186.0);
            translate.play();
    
            TranslateTransition translate1 = new TranslateTransition();
            translate1.setNode(this.Label);
            translate1.setDuration(Duration.millis(1500.0));
            translate1.setByY(110.0);
            translate1.play();
    
            TranslateTransition translate2 = new TranslateTransition();
            translate2.setNode(this.Moving_Line);
            translate2.setDuration(Duration.millis(1000.0));
            translate2.setByY(85.0);
            translate2.play();
    
            TranslateTransition translate3 = new TranslateTransition();
            translate3.setNode(this.Small_Pane);
            translate3.setDuration(Duration.millis(1400.0));
            translate3.setByX(379.0);
            translate3.play();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
}
}