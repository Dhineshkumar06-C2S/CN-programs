import java.net.*;
import java.io.*;

public class ChatServer {
    public static void main(String[] args) {
        try {
            String line;
            ServerSocket ss = new ServerSocket(9000);
            System.out.println("Chat server started on port 9000");

            Socket soc = ss.accept();
            BufferedReader socIn = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintStream socOut = new PrintStream(soc.getOutputStream());

            while (true) {
                line = socIn.readLine();
                if (line != null) {
                    socOut.println(line);
                } else {
                    break;
                }
            }

            socIn.close();
            socOut.close();
            soc.close();
            ss.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
