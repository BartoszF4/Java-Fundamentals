public class Company extends TelephoneEntry {

    private final String companyName;

    public Company(String companyName, Address address, TelephoneNumber telephoneNumber) {
        super(address, telephoneNumber);
        this.companyName = Validation.requireNonBlank(companyName, "companyName");
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String description() {
        return "Company: " + companyName + ", " + getAddress();
    }
}