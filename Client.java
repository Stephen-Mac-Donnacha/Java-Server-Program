import java.io.*;
import java.net.*;

//Java class to represent a client object, returns a string from the server
public class Client {
    public static void main(String args[]) throws IOException {
        Socket sock;

        //pass in the country as the first arg, the server as the second and the port as the 3rd
        String country = args[0];
        String server = args[1];
        int portNum = Integer.parseInt(args[2]);

        sock = new Socket(server,portNum);

        // Get I/O streams from the socket
        // DataInputStream readLine() method has been deprecated so use BufferedReader instead
        BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        PrintStream out = new PrintStream(sock.getOutputStream() );

        out.println(country);

        String fromServer = in.readLine();

        //print out the result of the query, i.e. the capital city of the country
        System.out.println("The capital city of " + " " + country +" " + "is :"  + fromServer);

        out.flush();
        sock.close();
    }
}
