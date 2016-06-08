/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;


public class BookingPageFXML implements Initializable {
    
    private String BusRoute,BusTime,BusDate;
    private String TrainName,TrainDate;
    private String ShowTime,ShowDate;

    @FXML
    private CheckBox Bog2Dha;
    @FXML
    private CheckBox Dha2Bog;
    @FXML
    private CheckBox Dha2Chi;
    @FXML
    private DatePicker dpBus;
    @FXML
    private CheckBox am10Bus;
    @FXML
    private CheckBox pm4Bus;
    @FXML
    private Button SelectSeatBus;
    @FXML
    private CheckBox Train1;
    @FXML
    private CheckBox Train2;
    @FXML
    private CheckBox Train3;
    @FXML
    private DatePicker dpTrain;
    @FXML
    private Button SelectSeatTrain;
    @FXML
    private CheckBox pm6Theatre;
    @FXML
    private CheckBox pm10Theatre;
    @FXML
    private DatePicker dpTheatre;
    @FXML
    private Button SelectSeatTheatre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    







    @FXML
    private void BograToDhaka(ActionEvent event) {
        BusRoute = "BograToDhaka";
    }

    @FXML
    private void DhakaToBogra(ActionEvent event) {
        BusRoute = "DhakaToBogra";
    }

    @FXML
    private void DhakaToChittagong(ActionEvent event) {
        BusRoute = "DhakaToChittagong";
    }

    @FXML
    private void DatePickedBus(ActionEvent event) {
         if(dpBus.getValue().toString().equals("2016-06-09")) BusDate = "9June";
        else if(dpBus.getValue().toString().equals("2016-06-10")) BusDate = "10June";
    }

    @FXML
    private void Bus10AM(ActionEvent event) {
        BusTime = "10AM";
    }

    @FXML
    private void Bus4PM(ActionEvent event) {
        BusTime = "4PM";
    }

    @FXML
    private void BusSelectSeat(ActionEvent event) {
        Pane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("BookingBusSeatNew.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(BookingPageFXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        System.out.println("Writing....");

        try {
            ClientController.OutToServer.writeBytes("Bus" + '\n');
            ClientController.OutToServer.writeBytes(BusRoute + '\n');
            ClientController.OutToServer.writeBytes(BusTime + '\n');
            ClientController.OutToServer.writeBytes(BusDate + '\n');

        } catch (Exception ex) {
            printStackTrace();
        }

        System.out.println(BusDate + BusRoute + BusTime);

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }








    @FXML
    private void Subarna(ActionEvent event) {
        TrainName = "SubarnaExpress";
    }

    @FXML
    private void Laalmoni(ActionEvent event) {
        TrainName = "LaalmoniExpress";
    }

    @FXML
    private void Moitree(ActionEvent event) {
        TrainName = "MoitreeExpress";
    }

    @FXML
    private void DatePickedTrain(ActionEvent event) {
         if(dpTrain.getValue().toString().equals("2016-06-09")) TrainDate = "9June";
        else if(dpTrain.getValue().toString().equals("2016-06-10")) TrainDate = "10June";
    }

    @FXML
    private void TrainSelectSeat(ActionEvent event) {
        Pane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("BookingTrainSeatNew.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(BookingPageFXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        System.out.println("Writing....");

        try {
            ClientController.OutToServer.writeBytes("Train" + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(TrainName + TrainDate);

        try {
            ClientController.OutToServer.writeBytes(TrainName + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ClientController.OutToServer.writeBytes(TrainDate+ '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }








    @FXML
    private void Theatre10PM(ActionEvent event) {
        ShowTime = "10PM";
    }
    @FXML
    private void Theatre6PM(ActionEvent event) {
        ShowTime = "6PM";
    }

    @FXML
    private void DatePickedTheatre(ActionEvent event) {
         if(dpTheatre.getValue().toString().equals("2016-06-09")) ShowDate = "9June";
         else if(dpTheatre.getValue().toString().equals("2016-06-10")) ShowDate = "10June";
    }

    @FXML
    private void TheatreSelectSeat(ActionEvent event) {
        Pane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("BookingTheatreSeatNew.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        System.out.println("Writing....");

        try {
            ClientController.OutToServer.writeBytes("Theatre" + '\n');
            ClientController.OutToServer.writeBytes(ShowDate + '\n');
            ClientController.OutToServer.writeBytes(ShowTime + '\n');

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(ShowTime + ShowDate);


        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
}
