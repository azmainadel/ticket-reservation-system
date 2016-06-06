package sample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerController {

    public static void main(String[] args) {
        System.out.println("Server Started");

        ServerSocket WelcomeSocket;
        try {
            WelcomeSocket = new ServerSocket(1234);

            while(true)
            {
                Socket ConnectionSocket = WelcomeSocket.accept();
                WorkerThread workingthread = new WorkerThread(ConnectionSocket,1);
                Thread thread = new Thread(workingthread);
                thread.start();
            }

        } catch (IOException ex) {
            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
