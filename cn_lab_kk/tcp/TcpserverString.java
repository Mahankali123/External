package tcp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class TcpserverString {
    public static void main(String[] args) {
        final int portNumber = 12345;
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Server is listening on port " + portNumber);
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket);
            // Create input and output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
            // Read the string from the client
            String clientString = input.readLine();
            System.out.println("Received from client: " + clientString);
            // Reverse the string
            String reversedString = new StringBuilder(clientString).reverse().toString();
            // Send the reversed string back to the client
            output.println(reversedString);
            System.out.println("Sent to client: " + reversedString);
            // Close the connections
            input.close();
            output.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

