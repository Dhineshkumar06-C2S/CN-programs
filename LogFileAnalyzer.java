import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogFileAnalyzer {
    public static void main(String[] args) {
        String filePath = "access.log"; // Specify the path to your log file
        Map<String, Integer> urlCount = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String url = extractUrl(line);
                if (url != null) {
                    urlCount.put(url, urlCount.getOrDefault(url, 0) + 1);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading the log file: " + e.getMessage());
        }

        System.out.println("Frequently Visited Websites:");
        urlCount.entrySet().stream()
            .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " visits"));
    }

    private static String extractUrl(String logLine) {
        // Regex pattern to match the requested URL from the log line
        String regex = "\"GET (.+?) HTTP/1\\.1\"";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(logLine);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
