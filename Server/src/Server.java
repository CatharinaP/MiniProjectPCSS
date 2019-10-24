import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class Server  implements Constants {

    public static void main(String[] args) {

        int clientNo = 0;
        int port = 7500;

        Thread thread = new Thread(() -> {

            try {
                ServerSocket server = new ServerSocket(port);
                System.out.println("Server is running");

                while (true) {
                    Socket socket = server.accept();

                    clientNo++;

                    new Thread(new HandleASession(socket)).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();
    }
}
