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

        int port = 7500;

             try {
                ServerSocket serverSocket = new ServerSocket(port);
                System.out.println("Server is running");


                while (true){
                    Socket socket = serverSocket.accept();
                    clientNo++;

                    InetAddress inetAddress = socket.getInetAddress();
                    System.out.println("Client no " + clientNo);
                    System.out.println("host name " + inetAddress.getHostName());
                    System.out.println("IP address " + inetAddress.getHostAddress());

                    new Thread(new HandleASession(socket, socket)).start();
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        }).start();
    }
}
