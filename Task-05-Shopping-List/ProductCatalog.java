import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProductCatalog {
    private final Map<String, List<Product>> productsByCategory;

    public ProductCatalog(List<Product> products) {
        this.productsByCategory = new LinkedHashMap<>();
        for (Product product : products) {
            addToCategory(product);
        }
    }

    public List<String> getCategories() {
        return List.copyOf(productsByCategory.keySet());
    }

    public List<Product> getProducts(String category) {
        return List.copyOf(productsByCategory.getOrDefault(category, List.of()));
    }

    private void addToCategory(Product product) {
        if (!productsByCategory.containsKey(product.getCategory())) {
            productsByCategory.put(product.getCategory(), new ArrayList<>());
        }
        List<Product> inCategory = productsByCategory.get(product.getCategory());
        if (!inCategory.contains(product)) {
            inCategory.add(product);
        }
    }
}