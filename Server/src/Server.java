import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server implements Constants {

    public static void main(String[] args){
        new Thread(()-> {
            int clientNo = 0;

            try{
                ServerSocket serverSocket = new ServerSocket(7500);
                System.out.println("MultiThreadServer started");

                while (true){
                    Socket socket = serverSocket.accept();
                    clientNo++;

                    InetAddress inetAddress = socket.getInetAddress();
                    System.out.println("Client no " + clientNo);
                    System.out.println("host name " + inetAddress.getHostName());
                    System.out.println("IP address " + inetAddress.getHostAddress());

                    new Thread(new HandleASession(socket)).start();
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        }).start();
    }
}
