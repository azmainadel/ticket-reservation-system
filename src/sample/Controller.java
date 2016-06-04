package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
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

    public void Login(ActionEvent event) throws IOException{
        if(userid.getText().equals("azmain") && userpassword.getText().equals("pass")){
            lblstatus.setText("Login Successful");
        }
        else lblstatus.setText("Login Failed");
    }
    public void SignUp(ActionEvent event) throws IOException {
        Scene signup = new Scene();
        signup.
    }



}
