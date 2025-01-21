import java.util.*;

public class Backend {
    public static void addItem(List<Map<String, String>> catalog) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Description: ");
        String description = scanner.nextLine();

        if (id.isEmpty() || name.isEmpty() || description.isEmpty()) {
            System.out.println("Error: All fields are required.");
            return;
        }

        Map<String, String> newItem = new HashMap<>();
        newItem.put("ID", id);
        newItem.put("Name", name);
        newItem.put("Description", description);
        catalog.add(newItem);
        System.out.println("Item added successfully.");
    }

    public static void editItem(List<Map<String, String>> catalog) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the item to edit: ");
        String id = scanner.nextLine();

        Map<String, String> itemToEdit = catalog.stream()
                .filter(item -> item.get("ID").equals(id))
                .findFirst()
                .orElse(null);

        if (itemToEdit == null) {
            System.out.println("Error: Item not found.");
            return;
        }

        System.out.print("Enter new Name (current: " + itemToEdit.get("Name") + "): ");
        String newName = scanner.nextLine();
        System.out.print("Enter new Description (current: " + itemToEdit.get("Description") + "): ");
        String newDescription = scanner.nextLine();

        if (!newName.isEmpty()) itemToEdit.put("Name", newName);
        if (!newDescription.isEmpty()) itemToEdit.put("Description", newDescription);

        System.out.println("Item updated successfully.");
    }
}
