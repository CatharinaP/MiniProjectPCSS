package com.example.rotate4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        Scanner input = new Scanner (System.in);
        boolean connect = true;

        try {
            Socket s = new Socket("localhost", 7500);
            System.out.println("Connected to server");


            DataInputStream inputStream = new DataInputStream(s.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());

            while (connect){
                System.out.print("While connected...");
            }
        } catch (IOException ex){
            System.out.println("ex");
        }

    }
}
