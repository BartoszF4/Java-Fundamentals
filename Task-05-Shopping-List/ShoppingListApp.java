import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListApp {
    private static final Path CATALOG_PATH = Path.of("catalog.csv");
    private static final Path LIST_PATH = Path.of("shopping_list.csv");

    private final ProductCatalog catalog;
    private final ShoppingList shoppingList;
    private final ConsoleInput input;
    private final ShoppingListWriter writer;

    public ShoppingListApp(ProductCatalog catalog) {
        this.catalog = catalog;
        this.shoppingList = new ShoppingList();
        this.input = new ConsoleInput();
        this.writer = new ShoppingListWriter();
    }

    public static void main(String[] args) {
        try {
            ProductCatalog catalog = new CatalogLoader().load(CATALOG_PATH);
            new ShoppingListApp(catalog).runMenuLoop();
        } catch (NoSuchFileException e) {
            System.out.println("Catalog file not found: " + CATALOG_PATH.toAbsolutePath());
        } catch (CatalogFormatException e) {
            System.out.println("Invalid catalog file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Cannot read the catalog file: " + e.getMessage());
        }
    }

    public void runMenuLoop() {
        System.out.println("Welcome to the shopping list manager.");
        boolean running = true;
        while (running) {
            printMenu();
            int choice = input.readIntInRange("Choose option (1-5): ", 1, 5);
            switch (choice) {
                case 1 -> chooseAndAddProduct();
                case 2 -> printShoppingList();
                case 3 -> chooseAndRemoveProduct();
                case 4 -> saveShoppingList();
                case 5 -> running = false;
            }
        }
        System.out.println("Goodbye!");
    }

    private void printMenu() {
        System.out.println();
        System.out.println("=== MENU ===");
        System.out.println("1. Add a product");
        System.out.println("2. Show shopping list");
        System.out.println("3. Remove a product");
        System.out.println("4. Save shopping list to file");
        System.out.println("5. Exit");
    }

    private void chooseAndAddProduct() {
        List<String> categories = catalog.getCategories();
        int categoryIndex = input.chooseIndex("Select a category:", categories);
        if (categoryIndex == ConsoleInput.BACK) {
            return;
        }
        String category = categories.get(categoryIndex);

        List<Product> products = catalog.getProducts(category);
        int productIndex = input.chooseIndex("Select a product from " + category + ":", toNames(products));
        if (productIndex == ConsoleInput.BACK) {
            return;
        }
        Product product = products.get(productIndex);

        if (shoppingList.addProduct(product)) {
            System.out.println("Added: " + product.getName());
        } else {
            System.out.println(product.getName() + " is already on your list.");
        }
    }

    private void printShoppingList() {
        if (shoppingList.isEmpty()) {
            System.out.println("Your shopping list is empty.");
            return;
        }
        System.out.println();
        System.out.println("=== SHOPPING LIST ===");
        for (String category : shoppingList.getCategories()) {
            System.out.println(category + ":");
            for (Product product : shoppingList.getProducts(category)) {
                System.out.println("  - " + product.getName());
            }
        }
    }

    private void chooseAndRemoveProduct() {
        if (shoppingList.isEmpty()) {
            System.out.println("Your shopping list is empty, nothing to remove.");
            return;
        }
        List<String> categories = shoppingList.getCategories();
        int categoryIndex = input.chooseIndex("Select a category:", categories);
        if (categoryIndex == ConsoleInput.BACK) {
            return;
        }
        String category = categories.get(categoryIndex);

        List<Product> products = shoppingList.getProducts(category);
        int productIndex = input.chooseIndex("Select a product to remove:", toNames(products));
        if (productIndex == ConsoleInput.BACK) {
            return;
        }
        Product product = products.get(productIndex);

        if (shoppingList.removeProduct(product)) {
            System.out.println("Removed: " + product.getName());
        } else {
            System.out.println("Could not remove " + product.getName() + ".");
        }
    }

    private void saveShoppingList() {
        if (shoppingList.isEmpty()) {
            System.out.println("Your shopping list is empty, nothing to save.");
            return;
        }
        try {
            writer.write(shoppingList, LIST_PATH);
            System.out.println("Saved to " + LIST_PATH.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Could not save the file: " + e.getMessage());
        }
    }

    private List<String> toNames(List<Product> products) {
        List<String> names = new ArrayList<>();
        for (Product product : products) {
            names.add(product.getName());
        }
        return names;
    }
}