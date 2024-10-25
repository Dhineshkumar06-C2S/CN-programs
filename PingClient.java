import java.io.*;
import java.net.*;

public class PingClient {
    public static void main(String[] args) {
        int i;
        String remoteIP;
        try {
            BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the IP address: ");
            String ip = keyIn.readLine();
            Socket soc = new Socket(ip, 9999);
            BufferedReader socIn = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintStream socOut = new PrintStream(soc.getOutputStream());

            System.out.println("Pinging " + ip + " with 32 bytes of data");

            for (i = 0; i < 4; i++) {
                socOut.println(ip);
                remoteIP = socIn.readLine();
                if (remoteIP != null) {
                    Thread.sleep(2000);
                    System.out.println("Reply from " + remoteIP);
                } else {
                    Thread.sleep(2000);
                    System.out.println("Request timed out");
                }
            }
        } catch (IOException e) {
            System.out.println("Request timed out");
        } catch (InterruptedException e) {
            System.out.println("Request timed out");
        }
    }
}
