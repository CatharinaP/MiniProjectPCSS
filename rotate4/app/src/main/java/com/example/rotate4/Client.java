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
    //used to define when the connection to the server is established
    boolean connect = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //disable the actionbar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        //starts the client thread
        Thread thread = new Thread(new clientThread());
        thread.start();


    }


    public class clientThread implements Runnable {

        @Override
        public void run() {
            try {
                //Creates a socket to connect to the server, through the port. The IP-address should be the same as the server's
                Socket s = new Socket("192.168.43.180", 7500);
                System.out.println("Connected to server");

                //define the input- and output-stream
                DataInputStream inputStream = new DataInputStream(s.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
                System.out.println("Data Streams established");

                // while the client is connected to the server it runs the while loop
                while (connect) {
                    //sending "1" to the server to register the player
                    outputStream.writeDouble(1);
                    outputStream.flush();

                    //receive a character. when receiving "10" the player gets assigned to the War officer.
                    // When receiving "20" the player gets assigned to the Intelligence officer
                    double character = inputStream.readDouble();
                    if (character == 10) {
                        System.out.println("character 1 selected");
                        startwar();
                    }

                    if (character == 20) {
                        System.out.println("character 2 selected");
                        startintel();
                    }

                    //Waiting for the first player to solve the puzzle, changing the boolean to true, and sending "4" to the server
                    while (character == 10) {
                        final GlobalVar globalvar1 = (GlobalVar) getApplicationContext();

                        if (globalvar1.getStatus() == true) {
                            System.out.println("Checked Status returned True");
                            outputStream.writeDouble(4);

                        } else {
                            System.out.println("Checked Status returned False");
                        }
                        if (globalvar1.getStatus() == true) {
                            break;
                        }
                    }

                    //Receiving "5" from the server, and sending the players to the EndScreen
                    double endGame = inputStream.readDouble();
                    if (endGame == 5) {
                        endScreen();
                        connect = false;
                    }

                }
            } catch (IOException ex) {
                System.out.println("ex");
            }
        }
    }

    //Functions to send players to different screens
    void startwar() {
        Intent intent = new Intent(this, DesktopWar.class);
        startActivity(intent);
    }

    void startintel() {
        Intent intent = new Intent(this, Desktop.class);
        startActivity(intent);
    }

    void endScreen() {
        Intent intent = new Intent(this, EndScreen.class);
        startActivity(intent);
    }
}
