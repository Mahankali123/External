import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServerString {
    
    public static void main(String[] args) {
        try {
            DatagramSocket serversocket = new DatagramSocket(8000);
            System.out.println("listnening of port "+ 8000);
            byte[] recbuff= new byte[1024];
            while(true)
            {
                DatagramPacket receivepacket = new DatagramPacket(recbuff,recbuff.length);
                serversocket.receive(receivepacket);
                String clString=new String(receivepacket.getData(), 0, receivepacket.getLength());
                String revStringg = new StringBuilder(clString).reverse().toString();
                System.out.println("received from client "+clString);
                byte[] sndbuff =  revStringg.getBytes();
                DatagramPacket sendpacket = new DatagramPacket(sndbuff,sndbuff.length,receivepacket.getAddress(),receivepacket.getPort());
                serversocket.send(sendpacket);
                System.out.println("send to client"+revStringg);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
