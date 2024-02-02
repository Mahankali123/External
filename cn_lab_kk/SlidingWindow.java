import java.util.Scanner;

public class SlidingWindow {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("ente the length of data");
        int n=sc.nextInt();
        int i=1;
        System.out.println("ente the size of window");
        int sz=sc.nextInt();
        int ack;
        while(true)
        {
            for(int j=0;j<sz;j++)
            {
                if(i>=n)
                {
                    System.out.println("all data send from sender");
                    break;
                }
                System.out.println("sending "+ i+" frame");
                i++;
                
            }
            System.out.println("enter ack");
            ack=sc.nextInt();
            i=ack;
            if(ack==n)
            {
                System.out.println("all data send and received by receiver");
                break;
            }

        }

    }
}
