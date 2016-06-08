/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.smartcardio.Card;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.ClientController.InFromServer;
import static sample.ClientController.OutToServer;


public class BookingCompleteFXML implements Initializable {

    private String CreditUser,CreditServer;

    @FXML
    private Button Confirm;
    @FXML
    private Button Finish;
    @FXML
    private PasswordField CardInput;
    @FXML
    private Label CardStatus;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ConfirmButton(ActionEvent event) throws InterruptedException {
        CreditUser = CardInput.getText();

        try {
            OutToServer.writeBytes(CreditUser +'\n');
            CreditServer = InFromServer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(CreditServer);

        if(CreditServer.equals("ok")){
            CardStatus.setText("Ticket Booked!");
        }
        else{
            CardStatus.setText("Invalid Card No.");
        }

    }


    @FXML
    private void FinishButton(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

}
