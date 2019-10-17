import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class HandleASession implements Runnable, Constants {
private Socket socket; // a connected socket

public HandleASession(Socket socket){
    this.socket = socket;
}

    public void run() {
try {
    // create data input and output streams
    DataInputStream inputFromClient1 = new DataInputStream(socket.getInputStream());
    DataInputStream inputFromClient2 = new DataInputStream(socket.getInnputStream());

    DataOutputStream OutputToClient1 = new DataOutputStream(socket.getOutputStream());
    DataOutputStream OutputToClient2 = new DataOUtputStream(socket.getOUtputStream());

    // for serving the client
    while (true){
        // data exchange between the client and server

        // based on information from client 1, send the message to client 2

        string messageFromClient1 = inputFromClient1.readString();

        outputToClient2.writeString();

    }

} catch (IOException e) {
    e.printStackTrace();
}
    }
    }
