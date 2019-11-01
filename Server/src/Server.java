import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{

    public static void main(String[] args){
        new Thread(()-> {
            //used to show how many clients that are playing
            int clientNo = 0;
         //the port used to connect to the server, the number could be between 1025 - 65536
        int port = 7500;

             try {
                 //Creates a socket to connect to the client, through the port
                ServerSocket serverSocket = new ServerSocket(port);
                System.out.println("Server is running");


                while (true){
                    //Accept the first player
                    Socket player1 = serverSocket.accept();
                    clientNo++;
                    System.out.println("Client 1 connected");

                    InetAddress inetAddress1 = player1.getInetAddress();
                    System.out.println("Client no " + clientNo);
                    System.out.println("host name " + inetAddress1.getHostName());
                    System.out.println("IP address " + inetAddress1.getHostAddress());

                    //Accept the second player
                    Socket player2 = serverSocket.accept();
                    System.out.println("Client 2 connected");

                    InetAddress inetAddress2 = player2.getInetAddress();
                    System.out.println("Client no " + clientNo);
                    System.out.println("host name " + inetAddress2.getHostName());
                    System.out.println("IP address " + inetAddress2.getHostAddress());

                    //creates a thread of HandleASession when two players are available
                    new Thread(new HandleASession(player1, player2)).start();
                    System.out.println("Thread created");

                }
            } catch (IOException e) {
                System.err.println(e);
            }
        }).start();
    }
}
