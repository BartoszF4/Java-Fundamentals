import java.util.List;
import java.util.Scanner;

public class ConsoleInput {
    public static final int BACK = -1;

    private final Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    public int readIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Enter a number from " + min + " to " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("That is not a number.");
            }
        }
    }

    public int chooseIndex(String title, List<String> labels) {
        printNumberedOptions(title, labels);
        int choice = readIntInRange("Your choice: ", 0, labels.size());
        if (choice == 0) {
            return BACK;
        }
        return choice - 1;
    }

    private void printNumberedOptions(String title, List<String> labels) {
        System.out.println();
        System.out.println(title);
        for (int i = 0; i < labels.size(); i++) {
            System.out.println((i + 1) + ". " + labels.get(i));
        }
        System.out.println("0. Back");
    }
}