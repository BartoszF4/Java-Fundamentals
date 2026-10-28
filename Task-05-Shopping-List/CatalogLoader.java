import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CatalogLoader {
    private static final String SEPARATOR = ";";

    public ProductCatalog load(Path path) throws IOException, CatalogFormatException {
        List<String> lines = Files.readAllLines(path);
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.isBlank()) {
                continue;
            }
            products.addAll(parseLine(line, i + 1));
        }
        if (products.isEmpty()) {
            throw new CatalogFormatException("The catalog file contains no products");
        }
        return new ProductCatalog(products);
    }

    private List<Product> parseLine(String line, int lineNumber) throws CatalogFormatException {
        String[] parts = line.split(SEPARATOR);
        if (parts.length < 2) {
            throw new CatalogFormatException("Line " + lineNumber + ": expected a category and at least one product");
        }
        String category = parts[0].trim();
        if (category.isEmpty()) {
            throw new CatalogFormatException("Line " + lineNumber + ": empty category name");
        }
        List<Product> products = new ArrayList<>();
        for (int i = 1; i < parts.length; i++) {
            String name = parts[i].trim();
            if (name.isEmpty()) {
                throw new CatalogFormatException("Line " + lineNumber + ": empty product name");
            }
            products.add(new Product(name, category));
        }
        return products;
    }
}