package com.example.rotate4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        System.out.println("Class Client is working pls");
        Scanner input = new Scanner (System.in);
        boolean connect = true;

        try {
            Socket s = new Socket("localhost", 7500);
            System.out.println("Connected to server");


            DataInputStream inputStream = new DataInputStream(s.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());

            while (connect){
                System.out.print("While connected...");
                outputStream.writeDouble(1);
                System.out.print("Sending double '1' to server for defining ");

                double warOfficer = inputStream.readDouble();
                double intelligens = inputStream.readDouble();

                if (warOfficer == 10){
                    // change the screen with intent
                }

                if (intelligens == 20) {
                    // change the screen with intent
                }
                

            }
        } catch (IOException ex){
            System.out.println("ex");
        }

    }
}
