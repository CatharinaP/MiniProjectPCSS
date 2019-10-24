import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class HandleASession implements Runnable, Constants {
private Socket role1; // a connected socket
private Socket role2;

public HandleASession(Socket role1, Socket role2){
    this.role1 = role1;
    this.role2 = role2;
}

    public void run() {
try {
    // create data input and output streams
    DataInputStream inputFromClient1 = new DataInputStream(role1.getInputStream());
    DataInputStream inputFromClient2 = new DataInputStream(role2.getInputStream());

    DataOutputStream OutputToClient1 = new DataOutputStream(role1.getOutputStream());
    DataOutputStream OutputToClient2 = new DataOutputStream(role2.getOutputStream());

    // for serving the client
    while (true){

        

        // receive request to play

        // assign character

        // if 2 people in 1 room, start the game

        // received turing = true
        // send message




        // data exchange between the client and server

        // based on information from client 1, send the message to client 2

      //  String messageFromClient1 = inputFromClient1.readString();

       // OutputToClient2.writeString(messageFromClient1);

    }

} catch (IOException e) {
    e.printStackTrace();
}
    }
    }