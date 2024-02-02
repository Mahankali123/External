package getsocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
public class getClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8087);
            // Demonstrate getsockname()
            System.out.println("Client socket local address: " + socket.getLocalSocketAddress());
            // Demonstrate getpeername()
            System.out.println("Server socket remote address: " + socket.getRemoteSocketAddress());
            // Demonstrate setsockopt() and getsockopt()
            socket.setTcpNoDelay(true); // Disabling Nagle's algorithm
            System.out.println("TCP No Delay option: " + socket.getTcpNoDelay());
            // Write data using writev()
            OutputStream outputStream = socket.getOutputStream();
            byte[] data1 = "Java".getBytes();
            byte[] data2 = "Socket".getBytes();
            outputStream.write(data1);
            outputStream.write(data2);
            System.out.println("Data written using writev(): Java Socket");
            // Read data using readv()
            InputStream inputStream = socket.getInputStream();
            byte[] buffer1 = new byte[4];
            byte[] buffer2 = new byte[6];
            int bytesRead = inputStream.read(buffer1);
            bytesRead += inputStream.read(buffer2);
            System.out.println("Data read using readv(): " + new String(buffer1) + new String(buffer2));
            // Close the socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
}
