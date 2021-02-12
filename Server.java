import java.net.Socket;
import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

// Java class to receive a client handler object and handle a request
public class Server {
    public static void main(String[] args){
        int backlog = 10;
        ExecutorService threadPool = Executors.newFixedThreadPool(backlog);
        int port = 4444; //port number

        Socket sock;
        try {

            ServerSocket serverSocket = new ServerSocket(port, backlog);
            //start the while loop for the server here
            while (true){
                //wait for next client connection
                sock = serverSocket.accept();

                //create and start handler for Client we just accepted
                ClientHandler cHandler = new ClientHandler(sock);
                threadPool.execute(cHandler);

            }
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
