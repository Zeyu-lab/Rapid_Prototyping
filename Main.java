import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filePath = "catalog.csv";
        List<Map<String, String>> catalog = Database.readCatalog(filePath);

        while (true) {
            int choice = Frontend.displayMenu();
            switch (choice) {
                case 1 -> Frontend.displayCatalog(catalog);
                case 2 -> Backend.addItem(catalog);
                case 3 -> Backend.editItem(catalog);
                case 4 -> {
                    Database.saveCatalog(filePath, catalog);
                    System.out.println("Changes saved. Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
