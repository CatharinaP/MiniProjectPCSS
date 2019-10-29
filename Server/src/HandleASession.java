import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class HandleASession implements Runnable, Constants {
private Socket player1; // a connected socket
private Socket player2;
private Socket player3;
private Socket player4;

public HandleASession(Socket player1, Socket player2){
    this.player1 = player1;
    this.player2 = player2;
    this.player3 = player3;
    this.player4 = player4;
}


    public void run() {
try {
    // input streams for 4 clients
    // another commit

    DataInputStream inputFromClient1 = new DataInputStream(player1.getInputStream());
    DataInputStream inputFromClient2 = new DataInputStream(player2.getInputStream());

    DataInputStream inputFromClient3 = new DataInputStream(player3.getInputStream());
    DataInputStream inputFromClient4 = new DataInputStream(player4.getInputStream());

    // output streams for 4 clients

    DataOutputStream outputToClient1 = new DataOutputStream(player1.getOutputStream());
    DataOutputStream outputToClient2 = new DataOutputStream(player2.getOutputStream());

    DataOutputStream outputToClient3 = new DataOutputStream(player3.getOutputStream());
    DataOutputStream outputToClient4 = new DataOutputStream(player4.getOutputStream());

    // for serving the client
    while (true){
        // test //
        double waiting = inputFromClient1.readDouble();
        System.out.println("Reading double");
        // test //

        // receive request to play

        double fromPlayerFirst = inputFromClient1.readDouble();
        System.out.println("Reading double playerFirst");

        double fromPlayerSecond = inputFromClient2.readDouble();
        System.out.println("Reading double playerSecond");

        double fromPlayerThird = inputFromClient3.readDouble();
        System.out.println("Reading double playerThird");

        double fromPlayerForth = inputFromClient4.readDouble();
        System.out.println("Reading double playerForth");

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

        if (fromPlayerThird == 3 && fromPlayerForth == 4){

            // start another game in another specific room
            System.out.println("Third and Forth player have requested to play");

            // assigning character
            // sending to server "10" meaning player1 will be a War Officer
            outputToClient3.writeDouble(10);
            System.out.println("Player3 a War Officer");

            // assigning character
            // sending to server "20" meaning player2 will be an Intelligens
            outputToClient4.writeDouble(20);
            System.out.println("Player4 an Intelligens");
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