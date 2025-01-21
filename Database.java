import java.io.*;
import java.util.*;

public class Database {
    public static List<Map<String, String>> readCatalog(String filePath) {
        List<Map<String, String>> catalog = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String[] headers = reader.readLine().split(",");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, String> item = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    item.put(headers[i], values[i]);
                }
                catalog.add(item);
            }
        } catch (IOException e) {
            System.out.println("Error reading the database: " + e.getMessage());
        }
        return catalog;
    }

    public static void saveCatalog(String filePath, List<Map<String, String>> catalog) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            if (!catalog.isEmpty()) {
                writer.write(String.join(",", catalog.get(0).keySet()));
                writer.newLine();
                for (Map<String, String> item : catalog) {
                    writer.write(String.join(",", item.values()));
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving the database: " + e.getMessage());
        }
    }
}
