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

public class BookingTheatreSeatFXML implements Initializable {

    private String SectionNameTheatre;

    @FXML
    private Label TheatreStatus;
    @FXML
    private RadioButton TheatreSection1;
    @FXML
    private RadioButton TheatreSection2;
    @FXML
    private RadioButton TheatreSecion3;
    @FXML
    private RadioButton TheatreSection4;
    @FXML
    private RadioButton TheatreSection5;
    @FXML
    private Button BookTheatre;


    @FXML
    public void Sec1(ActionEvent event){
        SectionNameTheatre = "Sec1";
    }
    @FXML
    public void Sec2(ActionEvent event){
        SectionNameTheatre = "Sec2";
    }
    @FXML
    public void Sec3(ActionEvent event){
        SectionNameTheatre = "Sec3";
    }
    @FXML
    public void Sec4(ActionEvent event){
        SectionNameTheatre = "Sec4";
    }
    @FXML
    public void Sec5(ActionEvent event){
        SectionNameTheatre = "Sec5";
    }



    @FXML
    private void BookTheatreButton(ActionEvent event) throws IOException {

        OutToServer.writeBytes(SectionNameTheatre +'\n');
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
            TheatreStatus.setText("Section Filled Up");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
