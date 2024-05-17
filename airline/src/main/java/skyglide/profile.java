package skyglide;

import java.io.IOException;
import java.net.URL;
import java.sql.DatabaseMetaData;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import skyglide.classes.DatabaseConnection;
import skyglide.classes.ticket.ticket;
import skyglide.classes.user.User;

public class profile implements Initializable {

    @FXML
    private TableView<ticket> Table;

    @FXML
    private Label emaillable;

    @FXML
    private Button Back;

    @FXML
    private Pane Left_Pane;

    @FXML
    private Pane Underline;

    @FXML
    private Label My_Profile;

    @FXML
    private VBox Small_Table;


    @FXML
    private TableColumn<ticket, Integer> flightColumn;

    @FXML
    private TableColumn<ticket, Integer> idColumn;

    @FXML
    private Label idlable;

    @FXML
    private Label namelable;

    @FXML
    private Label passwordlable;

    @FXML
    private TableColumn<ticket, Double> priceColumn;

    @FXML
    private Button unbook;

    @FXML
    private TableColumn<ticket, Integer> userColumn;

    @FXML
    void back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
         stage.setTitle("SkgyGlide");
         stage.setX(200);
         stage.setY(5);
         stage.setScene(scene);
         stage.show();
    }

    @FXML
    void unbook(ActionEvent event) {
        ticket selectedTicket = Table.getSelectionModel().getSelectedItem();
    if (selectedTicket != null) {
        int ticketId = selectedTicket.getId();
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        databaseConnection.deleteTicket(ticketId); // Implement this method in DatabaseConnection
        Table.getItems().remove(selectedTicket); // Remove the selected item from the table
    }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        idlable.setText("ID: "+String.valueOf(User.getLogedid()));
        namelable.setText(User.getLogedusername());
        emaillable.setText("Email: "+User.getLogedemail());
        passwordlable.setText("Password: "+User.getLogedpassword());

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        flightColumn.setCellValueFactory(new PropertyValueFactory<>("flight_id"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        userColumn.setCellValueFactory(new PropertyValueFactory<>("user_id"));

        int userId = User.getLogedid();
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        ObservableList<ticket> tickets = databaseConnection.getTicketsByUserId(userId);
        Table.setItems(tickets);


        // Start With Animations :

        TranslateTransition translate = new TranslateTransition();
        translate.setNode(Left_Pane);
        translate.setDuration(Duration.millis(1000));
        translate.setByX(180);
        translate.play();        


        TranslateTransition translate1 = new TranslateTransition();
        translate1.setNode(My_Profile);
        translate1.setDuration(Duration.millis(1500));
        translate1.setByY(90);
        translate1.play();        


        TranslateTransition translate2 = new TranslateTransition();
        translate2.setNode(Small_Table);
        translate2.setDuration(Duration.millis(1500));
        translate2.setByY(200);
        translate2.play();        

        TranslateTransition translate3 = new TranslateTransition();
        translate3.setNode(Underline);
        translate3.setDuration(Duration.millis(1200));
        translate3.setByX(-250);
        translate3.play();        

    }

}