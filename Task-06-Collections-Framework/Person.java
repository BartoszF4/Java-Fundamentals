public class Person extends TelephoneEntry {

    private final String firstName;
    private final String lastName;

    public Person(String firstName, String lastName, Address address, TelephoneNumber telephoneNumber) {
        super(address, telephoneNumber);
        this.firstName = Validation.requireNonBlank(firstName, "firstName");
        this.lastName = Validation.requireNonBlank(lastName, "lastName");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String description() {
        return "Person: " + firstName + " " + lastName + ", " + getAddress();
    }
}