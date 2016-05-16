package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller{

    //ObservableList<String> GenderChoiceList = FXCollections.observableArrayList("Male","Female","Other");

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

    /*@FXML
    private ChoiceBox GenderChoiceBox;

    @FXML
    private void initialize(){
        GenderChoiceBox.setValue("Male");
        GenderChoiceBox.setItems(GenderChoiceList);

    }*/

}
