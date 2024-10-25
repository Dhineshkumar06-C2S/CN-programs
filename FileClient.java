import java.io.*;
import java.net.*;

public class FileClient {
    public static void main(String[] args) throws IOException {
        try {
            Socket soc = new Socket(InetAddress.getLocalHost(), 1187);
            BufferedReader socIn = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            String input;
            
            while ((input = socIn.readLine()) != null) {
                System.out.println(input);
            }
            
            System.out.println("The file is received successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
