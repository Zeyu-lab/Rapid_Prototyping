import java.util.*;

public class Frontend {
    public static int displayMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nCatalog Management System");
        System.out.println("1. View Items");
        System.out.println("2. Add Item");
        System.out.println("3. Edit Item");
        System.out.println("4. Save and Exit");
        System.out.print("Select an option: ");
        return scanner.nextInt();
    }

    public static void displayCatalog(List<Map<String, String>> catalog) {
        System.out.println("\nCatalog Items:");
        if (catalog.isEmpty()) {
            System.out.println("No items to display.");
            return;
        }
        for (Map<String, String> item : catalog) {
            System.out.println("ID: " + item.get("ID"));
            System.out.println("Name: " + item.get("Name"));
            System.out.println("Description: " + item.get("Description"));
            System.out.println("---------------------");
        }
    }
}
