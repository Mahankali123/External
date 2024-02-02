import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class UdpClientString
{
    public static void main(String[] args) {
        try{
            final String serverAddress = "localhost";
            final int serverPort = 8000;
            DatagramSocket clientsocket = new DatagramSocket();
            String msg = " hello ,udp server";
            byte[] sendData= msg.getBytes();
            InetAddress serverIpAddress = InetAddress.getByName(serverAddress);
            DatagramPacket sendpacket = new DatagramPacket(sendData,sendData.length,serverIpAddress,serverPort);
            clientsocket.send(sendpacket);
            byte[] rcvbuff=new byte[1024];
            DatagramPacket recvpacket = new DatagramPacket(rcvbuff, rcvbuff.length);
            clientsocket.receive(recvpacket);
            String reversedString = new String(recvpacket.getData(), 0, recvpacket.getLength());
            System.out.println(reversedString);

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}