package tcp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
public class TcpClientString {
    public static void main(String[] args) {
        final String serverAddress = "localhost";
        final int portNumber = 12345;
        try {
            // Connect to the server
            Socket socket = new Socket(serverAddress, portNumber);
            System.out.println("Connected to server: " + socket);
            // Create input and output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            // Send a string to the server
            String message = "Hello, World!";
            System.out.println("Sending to server: " + message);
            output.println(message);
            // Receive the reversed string from the server
            String reversedString = input.readLine();
            System.out.println("Received from server: " + reversedString);
            // Close the connections
            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

