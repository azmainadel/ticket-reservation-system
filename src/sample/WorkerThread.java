package sample;

import java.io.*;
import java.net.Socket;

public class WorkerThread implements Runnable {
    private static Socket ConnectionSocket = null;
    private final int ID;

    public WorkerThread(Socket s, int i) {
        this.ConnectionSocket = s;
        this.ID = i;
    }

    @Override
    public void run() {
        String Key1, Key2;
        String Option;
        String NameFile, MailFile, IDFile, PassFile, CardFile, PhoneFile, DOBFile;
        String IDCheck, PassCheck, CardCheck;
        String BRoute, BTime, BDate, BSeat;
        String TName, TDate, TSeat;
        String STime, SDate, SSection;

        try {
            DataOutputStream OutToServer = new DataOutputStream(ConnectionSocket.getOutputStream());
            BufferedReader InFromServer = new BufferedReader(new InputStreamReader(ConnectionSocket.getInputStream()));

            Key1 = InFromServer.readLine();
            System.out.println(Key1);

            if (Key1.equals("login")) {
                IDCheck = InFromServer.readLine();
                PassCheck = InFromServer.readLine();

                //System.out.println("inside");

                //System.out.println(IDCheck + "    " + PassCheck);

                FileReader FR = new FileReader("F:\\My Codes\\TRS\\" + IDCheck + ".txt");
                BufferedReader BR = new BufferedReader(FR);

                NameFile = BR.readLine();
                MailFile = BR.readLine();
                IDFile = BR.readLine();
                PassFile = BR.readLine();
                CardFile = BR.readLine();
                PhoneFile = BR.readLine();
                DOBFile = BR.readLine();

                BR.close();

                System.out.println(IDFile + PassFile);

                if (IDCheck.equals(IDFile) && PassCheck.equals(PassFile)) {
                    OutToServer.writeBytes("ok" + '\n');

                    Option = InFromServer.readLine();

                    if (Option.equals("Bus")) {
                        BRoute = InFromServer.readLine();
                        BTime = InFromServer.readLine();
                        BDate = InFromServer.readLine();
                        BSeat = InFromServer.readLine();

                        String LogFile = "";

                        if (BRoute.equals("BograToDhaka")) {
                            if (BTime.equals("10AM")) {
                                if (BDate.equals("9June")) LogFile = "BograToDhaka_10AM_9June";
                                if (BDate.equals("10June")) LogFile = "BograToDhaka_10AM_10June";
                            }
                            if (BTime.equals("4PM")) {
                                if (BDate.equals("9June")) LogFile = "BograToDhaka_4PM_9June";
                                if (BDate.equals("10June")) LogFile = "BograToDhaka_4PM_10June";
                            }
                        }

                        if (BRoute.equals("DhakaToBogra")) {
                            if (BTime.equals("10AM")) {
                                if (BDate.equals("9June")) LogFile = "DhakaToBogra_10AM_9June";
                                if (BDate.equals("10June")) LogFile = "DhakaToBogra_10AM_10June";
                            }
                            if (BTime.equals("4PM")) {
                                if (BDate.equals("9June")) LogFile = "DhakaToBogra_4PM_9June";
                                if (BDate.equals("10June")) LogFile = "DhakaToBogra_4PM_10June";
                            }
                        }

                        if (BRoute.equals("DhakaToChittagong")) {
                            if (BTime.equals("10AM")) {
                                if (BDate.equals("9June")) LogFile = "DhakaToChittagong_10AM_9June";
                                if (BDate.equals("10June")) LogFile = "DhakaToChittagong_10AM_10June";
                            }
                            if (BTime.equals("4PM")) {
                                if (BDate.equals("9June")) LogFile = "DhakaToChittagong_4PM_9June";
                                if (BDate.equals("10June")) LogFile = "DhakaToChittagong_4PM_10June";
                            }
                        }

                        System.out.println(LogFile);

                        FileReader BusFile = new FileReader("F:\\My Codes\\TRS\\" + LogFile + ".txt");
                        BufferedReader BusRead = new BufferedReader(BusFile);

                        String p;
                        int flag = 1;

                        p = BusRead.readLine();

                        while (p != null) {
                            if (p.equals(BSeat)) {
                                flag = 0;
                                break;
                            }
                            System.out.println(p + " " + BSeat);
                            p = BusRead.readLine();
                        }
                        BusRead.close();
                        ;

                        if (flag == 1) {
                            OutToServer.writeBytes("ok" + '\n');

                            FileWriter FW1 = new FileWriter(IDFile + ".txt", true);
                            PrintWriter IDLogWriter = new PrintWriter(FW1);

                            IDLogWriter.println("            Bus Log            ");
                            IDLogWriter.println(BRoute);
                            IDLogWriter.println(BTime);
                            IDLogWriter.println(BDate);
                            IDLogWriter.println(BSeat);

                            IDLogWriter.close();

                            FileWriter FW2 = new FileWriter(LogFile + ".txt", true);
                            PrintWriter DataLogWriter = new PrintWriter(FW2);

                            DataLogWriter.println(BSeat);

                            DataLogWriter.close();
                        } else OutToServer.writeBytes(" " + '\n');

                    }


                    if (Option.equals("Train")) {
                        TName = InFromServer.readLine();
                        TDate = InFromServer.readLine();
                        TSeat = InFromServer.readLine();

                        String LogFile = "";

                        if (TName.equals("SubarnaExpress")) {
                            if (TDate.equals("9June")) LogFile = "SubarnaExpress_9June";
                            if (TDate.equals("10June")) LogFile = "SubarnaExpress_10June";
                        }

                        if (TName.equals("LaalmoniExpress")) {
                            if (TDate.equals("9June")) LogFile = "LaalmoniExpress_9June";
                            if (TDate.equals("10June")) LogFile = "LaalmoniExpress_10June";
                        }

                        if (TName.equals("MoitreeExpress")) {
                            if (TDate.equals("9June")) LogFile = "MoitreeExpress_9June";
                            if (TDate.equals("10June")) LogFile = "MoitreeExpress_10June";
                        }


                        System.out.println(LogFile);

                        FileReader TrainFile = new FileReader("F:\\My Codes\\TRS\\" + LogFile + ".txt");
                        BufferedReader TrainRead = new BufferedReader(TrainFile);

                        String p;
                        int flag = 1;

                        p = TrainRead.readLine();

                        while (p != null) {
                            if (p.equals(TSeat)) {
                                flag = 0;
                                break;
                            }
                            System.out.println(p + " " + TSeat);
                            p = TrainRead.readLine();
                        }
                        TrainRead.close();
                        ;

                        if (flag == 1) {
                            OutToServer.writeBytes("ok" + '\n');

                            FileWriter FW1 = new FileWriter(IDFile + ".txt", true);
                            PrintWriter IDLogWriter = new PrintWriter(FW1);

                            IDLogWriter.println("            Train Log            ");
                            IDLogWriter.println(TName);
                            IDLogWriter.println(TDate);
                            IDLogWriter.println(TSeat);

                            IDLogWriter.close();

                            FileWriter FW2 = new FileWriter(LogFile + ".txt", true);
                            PrintWriter DataLogWriter = new PrintWriter(FW2);

                            DataLogWriter.println(TSeat);

                            DataLogWriter.close();
                        } else OutToServer.writeBytes(" " + '\n');

                    }


                    if (Option.equals("Theatre")) {
                        STime = InFromServer.readLine();
                        SDate = InFromServer.readLine();
                        SSection = InFromServer.readLine();

                        String LogFile = "";

                        if (STime.equals("6PM")) {
                            if (SDate.equals("9June")) LogFile = "Show_6PM_9June";
                            if (SDate.equals("10June")) LogFile = "Show_6PM_10June";
                        }

                        if (STime.equals("10PM")) {
                            if (SDate.equals("9June")) LogFile = "Show_10PM_9June";
                            if (SDate.equals("10June")) LogFile = "Show_10PM_10June";
                        }

                        System.out.println(LogFile);

                        FileReader TheatreFile = new FileReader("F:\\My Codes\\TRS\\" + LogFile + ".txt");
                        BufferedReader TheatreRead = new BufferedReader(TheatreFile);

                        String p;
                        int flag = 1;

                        p = TheatreRead.readLine();

                        while (p != null) {
                            if (p.equals(SSection)) {
                                flag = 0;
                                break;
                            }
                            System.out.println(p + " " + SSection);
                            p = TheatreRead.readLine();
                        }
                        TheatreRead.close();
                        ;

                        if (flag == 1) {
                            OutToServer.writeBytes("ok" + '\n');

                            FileWriter FW1 = new FileWriter(IDFile + ".txt", true);
                            PrintWriter IDLogWriter = new PrintWriter(FW1);

                            IDLogWriter.println("            Theatre Log            ");
                            IDLogWriter.println(STime);
                            IDLogWriter.println(SDate);
                            IDLogWriter.println(SSection);

                            IDLogWriter.close();

                            FileWriter FW2 = new FileWriter(LogFile + ".txt", true);
                            PrintWriter DataLogWriter = new PrintWriter(FW2);

                            DataLogWriter.println(SSection);

                            DataLogWriter.close();
                        } else OutToServer.writeBytes(" " + '\n');

                    }

                    CardCheck = InFromServer.readLine();

                    if (CardCheck.equals(CardFile)) {
                        OutToServer.writeBytes("ok" + '\n');
                    } else OutToServer.writeBytes(" " + '\n');

                } else OutToServer.writeBytes(" " + '\n');

                Key2 = InFromServer.readLine();

                System.out.println(Key2);

                if (Key2.equals("ok")) {
                    String q;
                    FileReader FRNew = new FileReader("F:\\My Codes\\TRS\\" + IDFile + ".txt");
                    BufferedReader BRNew = new BufferedReader(FRNew);

                    q = BRNew.readLine();

                    while (q != null) {
                        System.out.println(q);
                        OutToServer.writeBytes(q + '\n');
                        q = BRNew.readLine();
                    }
                    OutToServer.writeBytes("end" + '\n');

                    BRNew.close();
                }

            }

            if (Key1.equals("SignUp")) {

                NameFile = InFromServer.readLine();
                MailFile = InFromServer.readLine();
                IDFile = InFromServer.readLine();
                PassFile = InFromServer.readLine();
                CardFile = InFromServer.readLine();
                PhoneFile = InFromServer.readLine();
                DOBFile = InFromServer.readLine();

                System.out.println(IDFile);

                PrintWriter PW = new PrintWriter(IDFile + ".txt");

                PW.println(NameFile);
                PW.println(MailFile);
                PW.println(IDFile);
                PW.println(PassFile);
                PW.println(CardFile);
                PW.println(PhoneFile);
                PW.println(DOBFile);

                PW.close();

            }

        } catch (Exception e) {

        }

    }

}
