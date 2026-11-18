import java.util.Iterator;
import java.util.Map;

public final class DirectoryPrinter {

    private DirectoryPrinter() {
    }

    public static void print(TelephoneDirectory directory) {
        Iterator<Map.Entry<TelephoneNumber, TelephoneEntry>> iterator = directory.iterator();
        while (iterator.hasNext()) {
            Map.Entry<TelephoneNumber, TelephoneEntry> mapEntry = iterator.next();
            System.out.println(mapEntry.getKey() + " -> " + mapEntry.getValue().description());
        }
    }
}