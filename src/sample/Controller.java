package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Label lblstatus;
    @FXML
    private TextField userid;
    @FXML
    private TextField userpassword;

    public void Login(ActionEvent event){
        if(userid.getText().equals("azmain") && userpassword.getText().equals("pass")){
            lblstatus.setText("Login Successful");
        }
        else lblstatus.setText("Login Failed");
    }

}
