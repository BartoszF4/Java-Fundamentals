public class DirectoryApplication {

    public static void main(String[] args) {
        new DirectoryApplication().run();
    }

    public void run() {
        TelephoneDirectory directory = SampleDataFactory.createSampleDirectory();
        DirectoryPrinter.print(directory);
        tryAddingDuplicate(directory);
    }

    private void tryAddingDuplicate(TelephoneDirectory directory) {
        try {
            directory.add(new Person("Piotr", "Zielinski",
                    new Address("Zielona", "1", "90-002", "Lodz"),
                    new TelephoneNumber(48, "600100200")));
        } catch (DuplicateTelephoneNumberException exception) {
            System.err.println(exception.getMessage());
        }
    }
}