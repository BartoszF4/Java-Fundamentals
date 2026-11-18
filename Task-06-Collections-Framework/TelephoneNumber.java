import java.util.Objects;

public final class TelephoneNumber implements Comparable<TelephoneNumber> {

    private static final int MIN_LOCAL_NUMBER_LENGTH = 4;
    private static final int MAX_LOCAL_NUMBER_LENGTH = 12;

    private final int countryCode;
    private final String localNumber;

    public TelephoneNumber(int countryCode, String localNumber) {
        if (countryCode <= 0) {
            throw new IllegalArgumentException("countryCode must be positive");
        }
        String validatedNumber = Validation.requireNonBlank(localNumber, "localNumber");
        if (!hasValidLength(validatedNumber) || !containsOnlyDigits(validatedNumber)) {
            throw new IllegalArgumentException("localNumber must contain 4 to 12 digits");
        }
        this.countryCode = countryCode;
        this.localNumber = validatedNumber;
    }

    private static boolean hasValidLength(String value) {
        return value.length() >= MIN_LOCAL_NUMBER_LENGTH && value.length() <= MAX_LOCAL_NUMBER_LENGTH;
    }

    private static boolean containsOnlyDigits(String value) {
        for (char character : value.toCharArray()) {
            if (!Character.isDigit(character)) {
                return false;
            }
        }
        return true;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public String getLocalNumber() {
        return localNumber;
    }

    @Override
    public int compareTo(TelephoneNumber other) {
        int countryCodeComparison = Integer.compare(countryCode, other.countryCode);
        if (countryCodeComparison != 0) {
            return countryCodeComparison;
        }
        return localNumber.compareTo(other.localNumber);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof TelephoneNumber)) {
            return false;
        }
        TelephoneNumber other = (TelephoneNumber) object;
        return countryCode == other.countryCode && localNumber.equals(other.localNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, localNumber);
    }

    @Override
    public String toString() {
        return "+" + countryCode + " " + localNumber;
    }
}