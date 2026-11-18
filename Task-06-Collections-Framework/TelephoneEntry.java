import java.util.Objects;

public abstract class TelephoneEntry {

    private final Address address;
    private final TelephoneNumber telephoneNumber;

    protected TelephoneEntry(Address address, TelephoneNumber telephoneNumber) {
        this.address = Objects.requireNonNull(address, "address must not be null");
        this.telephoneNumber = Objects.requireNonNull(telephoneNumber, "telephoneNumber must not be null");
    }

    public Address getAddress() {
        return address;
    }

    public TelephoneNumber getTelephoneNumber() {
        return telephoneNumber;
    }

    public abstract String description();
}