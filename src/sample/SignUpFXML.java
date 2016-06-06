package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.ClientController.OutToServer;

public class SignUpFXML implements Initializable {

    @FXML
    private TextField UserNameInput;
    @FXML
    private TextField UserEmailInput;
    @FXML
    private TextField UserIDInput;
    @FXML
    private PasswordField UserPasswordInput;
    @FXML
    private TextField UserCardInput;
    @FXML
    private TextField UserPhoneInput;
    @FXML
    private DatePicker UserDOB;
    @FXML
    private Button register;


    private String Name,Email,ID,Pass,Card,Phone,DOB;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void RegisterButton(ActionEvent event) {
        try {
            OutToServer.writeBytes("SignUp"+'\n');

            Name = UserNameInput.getText();
            Email = UserEmailInput.getText();
            ID = UserIDInput.getText();
            Pass = UserPasswordInput.getText();
            Card = UserCardInput.getText();
            Phone = UserPhoneInput.getText();
            DOB = UserDOB.getValue().toString();

            OutToServer.writeBytes(Name+'\n');
            OutToServer.writeBytes(Email+'\n');
            OutToServer.writeBytes(ID+'\n');
            OutToServer.writeBytes(Pass+'\n');
            OutToServer.writeBytes(Card+'\n');
            OutToServer.writeBytes(Phone+'\n');
            OutToServer.writeBytes(DOB+'\n');

        } catch (IOException e) {
            e.printStackTrace();
        }

        Pane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("SignUpSuccess.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

}
