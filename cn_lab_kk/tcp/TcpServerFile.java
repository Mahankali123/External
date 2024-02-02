package tcp;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class TcpServerFile {
    public static void main(String[] args) {
        final int portNumber = 12345;
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Server is listening on port " + portNumber);
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket);
            // Create input stream to receive the file
            InputStream inputStream = clientSocket.getInputStream();
            // Create FileOutputStream to write the file
            FileOutputStream fileOutputStream = new FileOutputStream("received_file.txt");
            // Buffer for reading data
            byte[] buffer = new byte[1024];
            int bytesRead;
            // Receive and write the file data
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("File received and saved.");
            // Close the connections
            fileOutputStream.close();
            inputStream.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
