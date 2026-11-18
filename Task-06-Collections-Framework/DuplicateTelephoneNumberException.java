public class DuplicateTelephoneNumberException extends RuntimeException {

    public DuplicateTelephoneNumberException(TelephoneNumber telephoneNumber) {
        super("Telephone number already registered: " + telephoneNumber);
    }
}