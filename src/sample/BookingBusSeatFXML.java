package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.ClientController.InFromServer;
import static sample.ClientController.OutToServer;

public class BookingBusSeatFXML implements Initializable {

    private String SeatNameBus;

    @FXML
    private Label BusStatus;
    @FXML
    private RadioButton BusSeatA1;
    @FXML
    private RadioButton BusSeatA2;
    @FXML
    private RadioButton BusSeatB1;
    @FXML
    private RadioButton BusSeatB2;
    @FXML
    private RadioButton BusSeatC1;
    @FXML
    private RadioButton BusSeatC2;
    @FXML
    private RadioButton BusSeatD1;
    @FXML
    private RadioButton BusSeatD2;
    @FXML
    private RadioButton BusSeatE1;
    @FXML
    private RadioButton BusSeatE2;
    @FXML
    private RadioButton BusSeatF1;
    @FXML
    private RadioButton BusSeatF2;
    @FXML
    private Button BookBus;


    @FXML
    public void A1(ActionEvent event){
        SeatNameBus = "A1";
    }
    @FXML
    public void A2(ActionEvent event){
        SeatNameBus = "A2";
    }
    @FXML
    public void B1(ActionEvent event){
        SeatNameBus = "B1";
    }
    @FXML
    public void B2(ActionEvent event){
        SeatNameBus = "B2";
    }
    @FXML
    public void C1(ActionEvent event){
        SeatNameBus = "C1";
    }
    @FXML
    public void C2(ActionEvent event){
        SeatNameBus = "C2";
    }
    @FXML
    public void D1(ActionEvent event){
        SeatNameBus = "D1";
    }
    @FXML
    public void D2(ActionEvent event){
        SeatNameBus = "D2";
    }
    @FXML
    public void E1(ActionEvent event){
        SeatNameBus = "E1";
    }
    @FXML
    public void E2(ActionEvent event){
        SeatNameBus = "E2";
    }
    @FXML
    public void F1(ActionEvent event){
        SeatNameBus = "F1";
    }
    @FXML
    public void F2(ActionEvent event){
        SeatNameBus = "F2";
    }

    @FXML
    private void BookBusButton(ActionEvent event) throws IOException {

        OutToServer.writeBytes(SeatNameBus +'\n');
        String Messsage;
        Messsage = InFromServer.readLine();
        System.out.println(Messsage);

        if(Messsage.equals("ok")){
            Pane root = FXMLLoader.load(getClass().getResource("BookingComplete.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        else {
            BusStatus.setText("Not Available");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
