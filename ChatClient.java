import java.net.*;
import java.io.*;

public class ChatClient {
    public static void main(String[] args) {
        try {
            String line;
            InetAddress ip = InetAddress.getLocalHost();
            Socket soc = new Socket(ip, 9000);
            BufferedReader socIn = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintStream socOut = new PrintStream(soc.getOutputStream());
            BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.print("Client: ");
                line = keyIn.readLine();
                socOut.println(line);
                System.out.println("Server: " + socIn.readLine());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
