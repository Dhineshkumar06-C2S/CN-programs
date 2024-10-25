import java.io.*;
import java.net.*;

public class FileServer {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket serSoc = new ServerSocket(1187);
            Socket soc = serSoc.accept();
            System.out.println("Connection established: " + soc);

            PrintStream socOut = new PrintStream(soc.getOutputStream());
            BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the text file name:");
            String fileName = keyIn.readLine();
            File f = new File(fileName);

            if (f.exists()) {
                BufferedReader fileIn = new BufferedReader(new FileReader(fileName));
                String line;

                while ((line = fileIn.readLine()) != null) {
                    socOut.println(line);
                }
                System.out.println("The file sent successfully");
                fileIn.close();
            } else {
                System.out.println("File does not exist");
            }

            socOut.close();
            soc.close();
            serSoc.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
