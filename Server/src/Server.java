import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

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
                    System.out.println("Client connected");

                    InetAddress inetAddress = socket.getInetAddress();
                    System.out.println("Client no " + clientNo);
                    System.out.println("host name " + inetAddress.getHostName());
                    System.out.println("IP address " + inetAddress.getHostAddress());


                    Socket player1;
                    Socket player2;
                    Socket player3;
                    Socket player4;
                    new Thread(new HandleASession(player1, player2, player3, player4)).start();

                }
            } catch (IOException e) {
                System.err.println(e);
            }
        }).start();
    }
}
