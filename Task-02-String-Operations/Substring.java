public class Substring {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Error: expected exactly 3 arguments");
            return;
        }
        int a;
        int b;
        try {
            a = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Error: '" + args[1] + "' is not an integer");
            return;
        }
        try {
            b = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Error: '" + args[2] + "' is not an integer");
            return;
        }
        if (a < 0) {
            System.out.println("Error: a must not be negative");
            return;
        }
        if (b < 0) {
            System.out.println("Error: b must not be negative");
            return;
        }
        if (b > args[0].length()) {
            System.out.println("Error: b is larger than the string length");
            return;
        }
        if (b <= a) {
            System.out.println("Error: a must be smaller than b");
            return;
        }
        System.out.println(args[0].substring(a, b));
        System.out.println(args[0].substring(0, a) + args[0].substring(b));
    }
}