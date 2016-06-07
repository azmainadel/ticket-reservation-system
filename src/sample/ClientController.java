package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientController extends Application {
    public static Socket ClientSocket = null;
    public static DataOutputStream OutToServer = null;
    public static BufferedReader InFromServer = null;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        primaryStage.setTitle("Ticket Reservation System Demo");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        try{
            ClientSocket = new Socket("localhost",1234);
            OutToServer = new DataOutputStream(ClientSocket.getOutputStream());
            InFromServer = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));
        } catch (IOException ex){
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE,null,ex);
        }

        launch(args);
    }
}
