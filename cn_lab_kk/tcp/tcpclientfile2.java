package tcp;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
public class tcpclientfile2 {
    public static void main(String[] args) {
        final String serverAddress = "localhost";
        final int portNumber = 12345;
        try {
            // Create a socket to connect to the server
            Socket socket = new Socket(serverAddress, portNumber);
            System.out.println("Connected to server: " + socket);
            // Create output stream to send the file
            OutputStream outputStream = socket.getOutputStream();
            // Create FileInputStream to read the file
            FileInputStream fileInputStream = new FileInputStream("file_to_send.txt");
            // Buffer for reading data
            byte[] buffer = new byte[1024];
            int bytesRead;
            // Read and send the file data
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("File sent.");
            // Close the connections
            fileInputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
