import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegularExpressions {
    static boolean isBalanced(String expression) {
        int depth = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '('){
                depth++;
            }
            else if (expression.charAt(i) == ')') {
                depth--;
            }
            if (depth < 0) {
                return false;
            }
        }
        return depth == 0;
    }
    static boolean hasOnlyAllowedCharacters(String expression) {
        Pattern p = Pattern.compile("[0-9+*/(). -]+");
        Matcher m = p.matcher(expression);
        return m.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (!hasOnlyAllowedCharacters(line)) {
            System.out.println("Expression contains invalid characters");
        } else if (isBalanced(line)) {
            System.out.println("Parentheses are correctly balanced");
        } else {
            System.out.println("Parentheses are not correctly balanced");
        }
    }
}