import java.io.*;
import java.net.*;

public class PingServer {
    public static void main(String[] a) throws IOException {
        String line1;
        int i;
        System.out.println("PingServer");
        try {
            ServerSocket serSoc = new ServerSocket(9999);
            Socket soc = serSoc.accept();
            BufferedReader socIn = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintStream socOut = new PrintStream(soc.getOutputStream());

            for (i = 0; i < 4; i++) {
                line1 = socIn.readLine();
                System.out.println("Pinged by client");
                socOut.println(line1 + " reply from host: bytes=3 time<1ms TTL=128");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
