import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class HandleASession implements Runnable{
//create a socket for both players
private Socket player1;
private Socket player2;

public HandleASession(Socket player1, Socket player2){
    this.player1 = player1;
    this.player2 = player2;
}

    public void run() {
        try {
            // input streams for 2 players
            DataInputStream inputFromClient1 = new DataInputStream(player1.getInputStream());
            DataInputStream inputFromClient2 = new DataInputStream(player2.getInputStream());
            System.out.println("Establishing Input Streams");


            // output streams for 2 players
            DataOutputStream outputToClient1 = new DataOutputStream(player1.getOutputStream());
            DataOutputStream outputToClient2 = new DataOutputStream(player2.getOutputStream());
            System.out.println("Establishing Output Streams");


            // while the server is connected to the client it runs the while loop
            while (true){
                // receive request to play
                double fromPlayerFirst = inputFromClient1.readDouble();
                System.out.println("Reading double playerFirst");

                double fromPlayerSecond = inputFromClient2.readDouble();
                System.out.println("Reading double playerSecond");

                    // if the server receives input from two clients (fromPlayerFirst and fromPlayerSecond)
                    if (fromPlayerFirst == 1 && fromPlayerSecond == 1){
                        // assigning character
                        // sending to client "10" meaning player1 will be the War Officer
                        outputToClient1.writeDouble(10);
                        System.out.println("Player1 is the War Officer");

                        // assigning character
                         //sending to client "20" meaning player2 will be the Intelligence officer
                        outputToClient2.writeDouble(20);
                        System.out.println("Player2 is the Intelligence officer");

                        //when the war officer solve the puzzle the server will receive "4", and send "5" to both clients
                        double turing = inputFromClient1.readDouble();
                        if (turing == 4){
                            outputToClient1.writeDouble(5);
                            outputToClient2.writeDouble(5);

                        }
                        

                }
            }

            }    catch (IOException e) {
                e.printStackTrace();
             }
        }
}