import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListWriter {
    public void write(ShoppingList shoppingList, Path path) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String category : shoppingList.getCategories()) {
            List<String> names = new ArrayList<>();
            for (Product product : shoppingList.getProducts(category)) {
                names.add(product.getName());
            }
            lines.add(category + ";" + String.join(";", names));
        }
        Files.write(path, lines, StandardCharsets.UTF_8);
    }
}