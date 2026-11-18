public final class SampleDataFactory {

    private SampleDataFactory() {
    }

    public static TelephoneDirectory createSampleDirectory() {
        TelephoneDirectory directory = new TelephoneDirectory();
        directory.add(new Person("Jan", "Kowalski",
                new Address("Piotrkowska", "12", "95-011", "Lodz"),
                new TelephoneNumber(48, "600100200")));
        directory.add(new Company("Google",
                new Address("Politechniki", "5", "93-590", "Lodz"),
                new TelephoneNumber(48, "422000111")));
        directory.add(new Person("Anna", "Nowak",
                new Address("Warszawska", "17", "76-001", "Warszawa"),
                new TelephoneNumber(48, "501300400")));
        directory.add(new Person("John", "Smith",
                new Address("Abbey Road", "221", "NW-683", "London"),
                new TelephoneNumber(44, "2079460018")));
        directory.add(new Company("Rockstar",
                new Address("Beverly Boulevard", "43", "10117", "Los Angeles"),
                new TelephoneNumber(49, "3012345678")));
        return directory;
    }
}