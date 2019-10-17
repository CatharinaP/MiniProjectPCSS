import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class HandleASession implements Runnable, Constants {
private Socket socket1; // a connected socket
private Socket socket2;

public HandleASession(Socket socket1, Socket socket2){
    this.socket1 = socket1;
    this.socket2 = socket2;
}

    public void run() {
try {
    // create data input and output streams
    DataInputStream inputFromClient1 = new DataInputStream(socket1.getInputStream());
    DataInputStream inputFromClient2 = new DataInputStream(socket1.getInputStream());

    DataOutputStream OutputToClient1 = new DataOutputStream(socket2.getOutputStream());
    DataOutputStream OutputToClient2 = new DataOutputStream(socket2.getOutputStream());

    // for serving the client
    while (true){
        // data exchange between the client and server

        // based on information from client 1, send the message to client 2

        String messageFromClient1 = inputFromClient1.readString();

        OutputToClient2.writeString(messageFromClient1);

    }

} catch (IOException e) {
    e.printStackTrace();
}
    }
    }
