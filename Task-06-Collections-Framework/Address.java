public final class Address {

    private final String street;
    private final String houseNumber;
    private final String postalCode;
    private final String city;

    public Address(String street, String houseNumber, String postalCode, String city) {
        this.street = Validation.requireNonBlank(street, "street");
        this.houseNumber = Validation.requireNonBlank(houseNumber, "houseNumber");
        this.postalCode = Validation.requireNonBlank(postalCode, "postalCode");
        this.city = Validation.requireNonBlank(city, "city");
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return street + " " + houseNumber + ", " + postalCode + " " + city;
    }
}