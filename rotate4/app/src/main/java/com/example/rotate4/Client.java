package com.example.rotate4;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client extends AppCompatActivity {
    boolean connect = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        System.out.println("Class Client is working pls");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

          /*  try {
                System.out.println("Inside try");
                Socket s = new Socket("192.168.43.180", 7500);
                System.out.println("Connected to server");


                DataInputStream inputStream = new DataInputStream(s.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
                System.out.println("Data Streams established");


                while (connect) {
                    System.out.print("While connected...");
                    outputStream.writeDouble(1);
                    System.out.print("Sending double '1' to server for defining ");

                    outputStream.flush();

                    double character = inputStream.readDouble();
                    //double intelligens = inputStream.readDouble();



                    if (character == 10) {
                        // change the screen with intent
                        System.out.println("character 1 selected");
                        startwar();
                    }

                    if (character == 20) {
                        // change the screen with intent
                        System.out.println("character 2 selected");
                        startintel();
                    }

                    System.out.println("tData is " +tData);

                    tData = turing.isData();

                    if (tData == true){
                        System.out.println("Checked Data returned True");
                        outputStream.writeDouble(4);


                    } else{
                        System.out.println("Checked Data returned False");


                    }


                    System.out.println("Pre-end game check");
                    double endGame = inputStream.readDouble();
                    System.out.println("endGame data");
                    if (endGame == 5){

                        endScreen();
                        connect=false;
                    }



                }
            } catch (IOException ex) {
                System.out.println("ex");
            } */


        //Scanner input = new Scanner(System.in);


        Thread thread = new Thread(new clientThread());
        thread.start();

        /*try {
            System.out.println("Inside try");
            Socket s = new Socket("192.168.8.104", 7500);
            System.out.println("Connected to server");


            DataInputStream inputStream = new DataInputStream(s.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());

            while (connect) {
                System.out.print("While connected...");
                outputStream.writeDouble(1);
                System.out.print("Sending double '1' to server for defining ");

                double warOfficer = inputStream.readDouble();
                double intelligens = inputStream.readDouble();

                if (warOfficer == 10) {
                    // change the screen with intent
                    startwar();
                }

                if (intelligens == 20) {
                    // change the screen with intent
                    startintel();
                }


            }
        } catch (IOException ex) {
            System.out.println("ex");
        }*/

    }


   public class clientThread implements Runnable{

        @Override
        public void run() {
            try {

               // boolean tData = turing.isData();
                System.out.println("Inside try");
                Socket s = new Socket("192.168.43.180", 7500);
                System.out.println("Connected to server");


                DataInputStream inputStream = new DataInputStream(s.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
                System.out.println("Data Streams established");


                while (connect) {
                    System.out.print("While connected...");
                    outputStream.writeDouble(1);
                    System.out.print("Sending double '1' to server for defining ");

                    outputStream.flush();

                    double character = inputStream.readDouble();
                    //double intelligens = inputStream.readDouble();



                    if (character == 10) {
                        // change the screen with intent
                        System.out.println("character 1 selected");
                        startwar();
                    }

                    if (character == 20) {
                        // change the screen with intent
                        System.out.println("character 2 selected");
                        startintel();
                    }



                    while(character == 10){
                       final GlobalVar globalvar1 = (GlobalVar) getApplicationContext();
                       System.out.println("Status is " + globalvar1.getStatus());
                       System.out.println("while loop 2");
                      // tData = turing.isData();

                       if (globalvar1.getStatus() == true){
                           System.out.println("Checked Status returned True");
                           outputStream.writeDouble(4);

                       } else{
                           System.out.println("Checked Status returned False");
                       }
                        if ( globalvar1.getStatus() == true ) { break; }  }

                    System.out.println("Pre-end game check");
                    double endGame = inputStream.readDouble();
                    System.out.println("endGame data");
                    if (endGame == 5){
                        System.out.println("5 check");
                        endScreen();
                        connect=false;
                    }

                }
            } catch (IOException ex) {
                System.out.println("ex");
            }
        }
    }

    void startwar(){
        Intent intent = new Intent(this, DesktopWar.class);
        startActivity(intent);
    }

    void startintel(){
        Intent intent = new Intent(this,Desktop.class);
        startActivity(intent);
    }

    void endScreen(){
        Intent intent = new Intent(this,EndScreen.class);
        startActivity(intent);
    }
}
