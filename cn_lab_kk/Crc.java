import java.util.Scanner;
public class Crc {
    public  static void sendTo(int m,int n,String msg,String crc,String encoded)
    {
        encoded += msg;
        for (int i = 1; i <= n - 1; i++) {
            encoded += '0';
        }
        System.err.println(encoded);
        for (int i = 0; i <=encoded.length() - n;) {
            for (int j = 0; j < n; j++) {
                encoded = encoded.substring(0, i + j) + (encoded.charAt(i + j) == crc.charAt(j) ? '0' : '1')+ encoded.substring(i + j + 1, encoded.length());
            }
            for (; i < encoded.length() && encoded.charAt(i) != '1'; i++);
        }
        System.out.println(encoded+" is encoded and send");
        System.out.println("Encoded Message : " + encoded.substring(m, encoded.length()));
        msg+=encoded.substring(m, encoded.length());
        receive(m,n,msg,crc);
    }
    public static void receive(int m,int n,String encoded,String crc)
    {
        for (int i = 0; i <=encoded.length() - n;) {
            for (int j = 0; j < n; j++) {
                encoded = encoded.substring(0, i + j) + (encoded.charAt(i + j) == crc.charAt(j) ? '0' : '1')+ encoded.substring(i + j + 1, encoded.length());
            }
            for (; i < encoded.length() && encoded.charAt(i) != '1'; i++);
        }
        System.out.println(encoded);
        for(int i=encoded.length()-crc.length();i<encoded.length();i++)
        {
            if(encoded.charAt(i)!='0')
            {
                System.out.println("err in data transfer");
                return;
            }
        }
        System.out.println("correct data");
    }
    public static void main(String[] args) {
        String msg, crc, encoded = "";
        Scanner sc = new Scanner(System.in);
        msg = sc.next();
        crc = sc.next();
        int m = msg.length();
        int n = crc.length();
        sendTo(m,n,msg,crc,encoded);
    }

}