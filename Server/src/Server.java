
import javafx.application.Application;

abstract class Server extends Application implements Constants {

 //   private int sessionNo = 1;
    //  private int person = 0;
TextArea text = new TextArea();

    new Thread( () -> {
        try {
            ServerSocket serverSocket = new ServerSocket(100);
            Platform.runLater(() -> text.appendText(new Date() + ": Server started at socket 100/n"));

            // ready to create a session for every two player
            while (true) {
                Platform.runLater(() - > text.appendText(new Date() + ": Wait for players to join session " + sessionNo + 'n');
            });
        }
    }
}
}