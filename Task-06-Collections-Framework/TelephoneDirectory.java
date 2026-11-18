import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TelephoneDirectory {

    private final TreeMap<TelephoneNumber, TelephoneEntry> entries = new TreeMap<>();

    public void add(TelephoneEntry entry) {
        TelephoneNumber number = entry.getTelephoneNumber();
        if (entries.containsKey(number)) {
            throw new DuplicateTelephoneNumberException(number);
        }
        entries.put(number, entry);
    }

    public Iterator<Map.Entry<TelephoneNumber, TelephoneEntry>> iterator() {
        return Collections.unmodifiableMap(entries).entrySet().iterator();
    }
}