package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.ClientController.InFromServer;
import static sample.ClientController.OutToServer;

public class BookingTrainSeatFXML implements Initializable {
    private String SeatNameTrain;

    @FXML
    private Label TrainStatus;
    @FXML
    private RadioButton TrainSeat1;
    @FXML
    private RadioButton TrainSeat2;
    @FXML
    private RadioButton TrainSeat3;
    @FXML
    private RadioButton TrainSeat4;
    @FXML
    private RadioButton TrainSeat5;
    @FXML
    private RadioButton TrainSeat6;
    @FXML
    private RadioButton TrainSeat7;
    @FXML
    private RadioButton TrainSeat8;
    @FXML
    private RadioButton TrainSeat9;
    @FXML
    private RadioButton TrainSeat10;
    @FXML
    private RadioButton TrainSeat11;
    @FXML
    private RadioButton TrainSeat12;
    @FXML
    private RadioButton TrainSeat13;
    @FXML
    private RadioButton TrainSeat14;
    @FXML
    private RadioButton TrainSeat15;
    @FXML
    private RadioButton TrainSeat16;
    @FXML
    private RadioButton TrainSeat17;
    @FXML
    private RadioButton TrainSeat18;
    @FXML
    private Button BookTrain;


    @FXML
    public void T1(ActionEvent event){
        SeatNameTrain = "1";
    }
    @FXML
    public void T2(ActionEvent event){
        SeatNameTrain = "2";
    }
    @FXML
    public void T3(ActionEvent event){
        SeatNameTrain = "3";
    }
    @FXML
    public void T4(ActionEvent event){
        SeatNameTrain = "4";
    }
    @FXML
    public void T5(ActionEvent event){
        SeatNameTrain = "5";
    }
    @FXML
    public void T6(ActionEvent event){
        SeatNameTrain = "6";
    }
    @FXML
    public void T7(ActionEvent event){
        SeatNameTrain = "7";
    }
    @FXML
    public void T8(ActionEvent event){
        SeatNameTrain = "8";
    }
    @FXML
    public void T9(ActionEvent event){
        SeatNameTrain = "9";
    }
    @FXML
    public void T10(ActionEvent event){
        SeatNameTrain = "10";
    }
    @FXML
    public void T11(ActionEvent event){
        SeatNameTrain = "11";
    }
    @FXML
    public void T12(ActionEvent event){
        SeatNameTrain = "12";
    }
    @FXML
    public void T13(ActionEvent event){
        SeatNameTrain = "13";
    }
    @FXML
    public void T14(ActionEvent event){
        SeatNameTrain = "14";
    }
    @FXML
    public void T15(ActionEvent event){
        SeatNameTrain = "15";
    }
    @FXML
    public void T16(ActionEvent event){
        SeatNameTrain = "16";
    }
    @FXML
    public void T17(ActionEvent event){
        SeatNameTrain = "17";
    }
    @FXML
    public void T18(ActionEvent event){
        SeatNameTrain = "18";
    }


    @FXML
    private void BookTrainButton(ActionEvent event) throws IOException {

        OutToServer.writeBytes(SeatNameTrain +'\n');
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
            TrainStatus.setText("Not Available");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
