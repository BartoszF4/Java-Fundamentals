import java.util.Objects;

public class Product {
    private final String name;
    private final String category;

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Product)) {
            return false;
        }
        Product product = (Product) other;
        return name.equals(product.name) && category.equals(product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }
}