import java.util.Random;
import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String again;
        do {
            int target = random.nextInt(101);
            int attempts = 0;
            while (true) {
                System.out.print("Do your guess: ");
                if (!scanner.hasNextInt()) {
                    scanner.next();
                    System.out.println("That is not a number.");
                    continue;
                }
                int guess = scanner.nextInt();
                attempts++;
                if (guess < target) {
                    System.out.println("The target number is higher");
                } else if (guess > target) {
                    System.out.println("The target number is lower");
                } else {
                    System.out.println("You guessed correctly. It took you " + attempts + " attempts.");
                    break;
                }
            }
            System.out.print("Again? (y/n): ");
            again = scanner.next();
        } while (again.equalsIgnoreCase("y"));
    }
}