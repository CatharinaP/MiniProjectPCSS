import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class HandleASession implements Runnable, Constants {
private Socket player1; // a connected socket
private Socket player2;
private Socket player3;
private Socket player4;

public HandleASession(Socket player1, Socket player2, Socket player3, Socket player4){
    this.player1 = player1;
    this.player2 = player2;
    this.player3 = player3;
    this.player4 = player4;
}

    public void run() {
try {
    // input streams for 4 clients

    DataInputStream inputFromClient1 = new DataInputStream(player1.getInputStream());
    DataInputStream inputFromClient2 = new DataInputStream(player2.getInputStream());

    DataInputStream inputFromClient3 = new DataInputStream(player3.getInputStream());
    DataInputStream inputFromClient4 = new DataInputStream(player4.getInputStream());

    // output streams for 4 clients

    DataOutputStream OutputToClient1 = new DataOutputStream(player1.getOutputStream());
    DataOutputStream OutputToClient2 = new DataOutputStream(player2.getOutputStream());

    DataOutputStream OutputToClient3 = new DataOutputStream(player3.getOutputStream());
    DataOutputStream OutputToClient4 = new DataOutputStream(player4.getOutputStream());

    // for serving the client
    //test
    while (true){
        // test //
        double waiting = inputFromClient1.readDouble();
        System.out.println("Reading double");
        // test //

        boolean playerFirst = inputFromClient1.readBoolean();
        System.out.println("Reading boolean playerFirst");

        boolean playerSecond = inputFromClient2.readBoolean();
        System.out.println("Reading boolean playerSecond");

        boolean playerThird = inputFromClient3.readBoolean();
        System.out.println("Reading boolean playerThird");

        boolean playerForth = inputFromClient4.readBoolean();
        System.out.println("Reading boolean playerForth");

        // receive request to play

        // assign character

        // if 2 people in 1 room, start the game

        if (playerFirst == true && playerSecond == true){
            // start the game in one specific room
            System.out.println("First and Second player have requested to play");

        }

        if (playerThird == true && playerForth == true){

            // start another game in another specific room
            System.out.println("Third and Forth player have requested to play");
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