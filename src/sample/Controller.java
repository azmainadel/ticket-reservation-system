package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller{

    @FXML
    private Label lblstatus;
    @FXML
    private TextField userid;
    @FXML
    private TextField userpassword;

    public void HandleLogin(ActionEvent event){
        if(userid.getText().equals("azmain") && userpassword.getText().equals("pass")){
            lblstatus.setText("Login Successful");
        }
        else lblstatus.setText("Login Failed");
    }

    public void HandleSignUp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignUp2.fxml"));
        Stage primaryStage=new Stage();
        primaryStage.setTitle("Ticket Reservation System Demo");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }




}