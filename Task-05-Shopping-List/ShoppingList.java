import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ShoppingList {
    private final Map<String, List<Product>> items;

    public ShoppingList() {
        this.items = new LinkedHashMap<>();
    }

    public boolean addProduct(Product product) {
        List<Product> products = getOrCreateProducts(product.getCategory());
        if (products.contains(product)) {
            return false;
        }
        products.add(product);
        return true;
    }

    public boolean removeProduct(Product product) {
        List<Product> products = items.get(product.getCategory());
        if (products == null) {
            return false;
        }
        boolean removed = products.remove(product);
        removeCategoryIfEmpty(product.getCategory());
        return removed;
    }

    public List<String> getCategories() {
        return List.copyOf(items.keySet());
    }

    public List<Product> getProducts(String category) {
        return List.copyOf(items.getOrDefault(category, List.of()));
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    private List<Product> getOrCreateProducts(String category) {
        if (!items.containsKey(category)) {
            items.put(category, new ArrayList<>());
        }
        return items.get(category);
    }

    private void removeCategoryIfEmpty(String category) {
        if (items.get(category).isEmpty()) {
            items.remove(category);
        }
    }
}