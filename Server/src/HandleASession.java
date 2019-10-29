import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class HandleASession implements Runnable, Constants {
private Socket player1; // a connected socket
private Socket player2;

public HandleASession(Socket player1, Socket player2){
    this.player1 = player1;
    this.player2 = player2;
}


    public void run() {
try {
    // input streams for 2 clients
    // another commit

    DataInputStream inputFromClient1 = new DataInputStream(player1.getInputStream());
    DataInputStream inputFromClient2 = new DataInputStream(player2.getInputStream());


    // output streams for 2 clients

    DataOutputStream outputToClient1 = new DataOutputStream(player1.getOutputStream());
    DataOutputStream outputToClient2 = new DataOutputStream(player2.getOutputStream());


    // for serving the client
    while (true){
        // test //
        double waiting = inputFromClient1.readDouble();
        System.out.println("Reading double" + waiting);
        // test //

        // receive request to play

        double fromPlayerFirst = inputFromClient1.readDouble();
        System.out.println("Reading double playerFirst");

        double fromPlayerSecond = inputFromClient2.readDouble();
        System.out.println("Reading double playerSecond");

        // if 2 people in 1 room, start the game

        if (fromPlayerFirst == 1 && fromPlayerSecond == 2){
            // start the game in one specific room
            System.out.println("First and Second player have requested to play");

            // assigning character
            // sending to server "10" meaning player1 will be a War Officer
            outputToClient1.writeDouble(10);
            System.out.println("Player1 a War Officer");

            // assigning character
            // sending to server "20" meaning player2 will be an Intelligens
            outputToClient2.writeDouble(20);
            System.out.println("Player2 an Intelligens");

        }


        // received turing = true

        // send message

        // data exchange between the client and server

        // based on information from client 1, send the message to client 2

        //  String messageFromClient1 = inputFromClient1.readString();

       // OutputToClient2.writeString(messageFromClient1);

    }

    }    catch (IOException e) {
        e.printStackTrace();
     }
    }
}