import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HandleASession implements Runnable, Constants {
private Socket socket;

public HandleASession(Socket socket){
    this.socket = socket;
}
    @Override
    public void run() {
try {
    DataInputStream inputFromClient = new DataInputStream(
            socket.getInputStream());
    DataOutputStream OutputFromClient = new DataOutputStream(
            socket.getOutputStream());

} catch (IOException e) {
    e.printStackTrace();
}
    }
    }
