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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sample.ClientController.InFromServer;
import static sample.ClientController.OutToServer;

public class LogInFXML implements Initializable {

    private String UserID;
    private String Password;

    @FXML
    private TextField userid;
    @FXML
    private PasswordField userpassword;
    @FXML
    private Label infostatus;

    
    @FXML
    private void SignInButton(ActionEvent event) throws IOException {
        System.out.println("Logging In");
        UserID = userid.getText();
        Password = userpassword.getText();

        OutToServer.writeBytes("login"+'\n');
        OutToServer.writeBytes(UserID + '\n');
        OutToServer.writeBytes(Password + '\n');

        if(InFromServer.readLine().equals("Logging In")){
            try {
                infostatus.setText("Login Successful");

                Stage stage = new Stage();
                Pane root = FXMLLoader.load(getClass().getResource("FXMLAfterLogIn.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

                ((Node)(event.getSource())).getScene().getWindow().hide();
            } catch (IOException ex) {
                Logger.getLogger(LogInFXML.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
            infostatus.setText("Invalid ID or Password");

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public void SignUpButton(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("SignUpNew.fxml"));
        Stage primaryStage=new Stage();
        primaryStage.setTitle("Sign Up Page");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

}
