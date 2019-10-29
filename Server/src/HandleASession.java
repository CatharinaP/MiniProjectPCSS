import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class HandleASession implements Runnable, Constants {
private Socket role1; // a connected socket
private Socket role2;
private Socket role3;
private Socket role4;

public HandleASession(Socket socket){
    this.role1 = role1;
    this.role2 = role2;
    this.role3 = role3;
    this.role4 = role4;
}

    public void run() {
try {
    // input streams for 4 clients

    DataInputStream inputFromClient1 = new DataInputStream(role1.getInputStream());
    DataInputStream inputFromClient2 = new DataInputStream(role2.getInputStream());

    DataInputStream inputFromClient3 = new DataInputStream(role3.getInputStream());
    DataInputStream inputFromClient4 = new DataInputStream(role4.getInputStream());

    // output streams for 4 clients

    DataOutputStream OutputToClient1 = new DataOutputStream(role1.getOutputStream());
    DataOutputStream OutputToClient2 = new DataOutputStream(role2.getOutputStream());

    DataOutputStream OutputToClient3 = new DataOutputStream(role3.getOutputStream());
    DataOutputStream OutputToClient4 = new DataOutputStream(role4.getOutputStream());

    // for serving the client
    while (true){
        double waiting = inputFromClient1.readDouble();
        System.out.println("Reading double");

        boolean playerFirst = inputFromClient1.readBoolean();
        boolean playerSecond = inputFromClient2.readBoolean();
        boolean playerThird = inputFromClient3.readBoolean();
        boolean playerForth = inputFromClient4.readBoolean();

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