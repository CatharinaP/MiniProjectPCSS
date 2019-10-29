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
                    Socket player1 = serverSocket.accept();
                    clientNo++;
                    System.out.println("Client 1 connected");

                    InetAddress inetAddress1 = player1.getInetAddress();
                    System.out.println("Client no " + clientNo);
                    System.out.println("host name " + inetAddress1.getHostName());
                    System.out.println("IP address " + inetAddress1.getHostAddress());


                    Socket player2 = serverSocket.accept();
                    System.out.println("Client 2 connected");

                    InetAddress inetAddress2 = player2.getInetAddress();
                    System.out.println("Client no " + clientNo);
                    System.out.println("host name " + inetAddress2.getHostName());
                    System.out.println("IP address " + inetAddress2.getHostAddress());

                    new Thread(new HandleASession(player1, player2)).start();

                }
            } catch (IOException e) {
                System.err.println(e);
            }
        }).start();
    }
}
