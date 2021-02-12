import java.io.*;
import java.net.*;

// Java class that handles a Client Object
public class ClientHandler implements Runnable{
    private Socket socket;

    //constructor for ClientHandler class
    public ClientHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            String query ="";

            //get the Output stream of the socket connected to the server
            PrintStream out = new PrintStream(socket.getOutputStream());

            //get the input
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //get the input from the client
            query = in.readLine();

            //send our query
            switch (query) {
                case "Ireland" -> out.println("Dublin");
                case "Germany" -> out.println("Berlin");
                case "Poland" -> out.println("Warsaw");
                case "Uzbekistan" -> out.println("Tashkent");
                default -> out.println("Unknown");
            }

            //close this connection
            socket.close();

        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
