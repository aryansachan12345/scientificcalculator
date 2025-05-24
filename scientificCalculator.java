import java.util.Scanner;

public class scientificcalculator {

    // Method overloading for basic arithmetic operations
    public double calculate(double a, double b, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return b != 0 ? a / b : Double.NaN;
            default: throw new IllegalArgumentException("Invalid operator.");
        }
    }

    // Method overloading for single-argument scientific operations
    public double calculate(String function, double value) {
        switch (function.toLowerCase()) {
            case "sin": return Math.sin(Math.toRadians(value));
            case "cos": return Math.cos(Math.toRadians(value));
            case "tan": return Math.tan(Math.toRadians(value));
            case "log": return value > 0 ? Math.log10(value) : Double.NaN;
            case "sqrt": return value >= 0 ? Math.sqrt(value) : Double.NaN;
            default: throw new IllegalArgumentException("Invalid scientific function.");
        }
    }

    // Method overloading for power function (two doubles)
    public double calculate(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // Main method for user interaction
    public static void main(String[] args) {
        scientificcalculator calc = new scientificcalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Scientific Calculator Using Method Overloading ===");
        System.out.println("Choose an operation:");
        System.out.println("1. Basic Arithmetic (+, -, *, /)");
        System.out.println("2. Scientific Function (sin, cos, tan, log, sqrt)");
        System.out.println("3. Power Function (x^y)");

        int choice = scanner.nextInt();

        try {
            switch (choice) {
                case 1:
                    System.out.print("Enter first number: ");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    double num2 = scanner.nextDouble();
                    System.out.print("Enter operator (+, -, *, /): ");
                    char op = scanner.next().charAt(0);
                    double result1 = calc.calculate(num1, num2, op);
                    System.out.println("Result: " + result1);
                    break;

                case 2:
                    System.out.print("Enter scientific function (sin, cos, tan, log, sqrt): ");
                    String func = scanner.next();
                    System.out.print("Enter value: ");
                    double val = scanner.nextDouble();
                    double result2 = calc.calculate(func, val);
                    System.out.println("Result: " + result2);
                    break;

                case 3:
                    System.out.print("Enter base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter exponent: ");
                    double exponent = scanner.nextDouble();
                    double result3 = calc.calculate(base, exponent);
                    System.out.println("Result: " + result3);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
