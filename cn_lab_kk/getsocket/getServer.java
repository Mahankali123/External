package getsocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
class getServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8087);
            System.out.println("Server listening on port 8087...");
            // Accept incoming connections
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connection accepted from: " + clientSocket.getInetAddress());
            // Demonstrate getsockname()
            System.out.println("Server socket local address: " + serverSocket.getLocalSocketAddress());
            // Demonstrate getpeername()
            System.out.println("Client socket remote address: " + clientSocket.getRemoteSocketAddress());
            // Demonstrate setsockopt() and getsockopt()
            clientSocket.setTcpNoDelay(true); // Disabling Nagle's algorithm
            System.out.println("TCP No Delay option: " + clientSocket.getTcpNoDelay());
            // Read data using readv()
            InputStream inputStream = clientSocket.getInputStream();
            byte[] buffer1 = new byte[5];
            byte[] buffer2 = new byte[5];
            int bytesRead = inputStream.read(buffer1);
            bytesRead += inputStream.read(buffer2);
            System.out.println("Data read using readv(): " + new String(buffer1) + new String(buffer2));
            // Write data using writev()
            OutputStream outputStream = clientSocket.getOutputStream();
            byte[] data1 = "Hello".getBytes();
            byte[] data2 = "World".getBytes();
            outputStream.write(data1);
            outputStream.write(data2);
            System.out.println("Data written using writev(): Hello World");
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}