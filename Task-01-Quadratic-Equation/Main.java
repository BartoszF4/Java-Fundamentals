public class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: java Main <a> <b> <c>");
            return;
        }
        int a;
        int b;
        int c;
        try {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
            c = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.err.println("Arguments must be integers.");
            return;
        }
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Infinitely many solutions.");
                }
                else {
                    System.out.println("No solution.");
                }
            }
            else {
                System.out.println((double)-c/b + 0.0);
            }
        }
        else {
            long delta = (long) b * b - 4L * a * c;
            if (delta < 0) {
                System.out.println("No answer.");
            }
            else if (delta == 0) {
                System.out.println((double)-b/(2.0 * a) + 0.0);
            }
            else {
                System.out.println((-b+Math.sqrt(delta))/(2.0 * a)+ 0.0);
                System.out.println((-b-Math.sqrt(delta))/(2.0 * a)+ 0.0);
            }
        }
    }
}