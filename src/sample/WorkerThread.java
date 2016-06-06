package sample;

import java.net.Socket;

public class WorkerThread implements Runnable {
    static Socket ConnectionSocket = null;
    private final int ID;

    public WorkerThread(Socket s,int i){
        this.ConnectionSocket = s;
        this.ID = i;
    }

    @Override
    public void run(){

    }



}
