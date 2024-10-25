import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Tracert {

    public static void runSystemCommand(String command) {
        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s = "";
            while ((s = inputStream.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String IP = "192.168.31.221";
        runSystemCommand("tracert " + IP);
        java.util.Date date = new java.util.Date();
        System.out.println(date);
    }
}
