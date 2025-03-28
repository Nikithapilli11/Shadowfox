import java.util.Scanner;

public class Console Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Square Root");
            System.out.println("6. Exponentiation");
            System.out.println("7. Temperature Conversion");
            System.out.println("8. Exit");
            int choice = scanner.nextInt();

            if (choice == 8) {
                System.out.println("Exiting...");
                break;
            }

            switch (choice) {
                case 1:
                case 2:
                case 3:
                case 4:
                    System.out.print("Enter first number: ");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    double num2 = scanner.nextDouble();
                    performBasicOperation(choice, num1, num2);
                    break;
                case 5:
                    System.out.print("Enter number: ");
                    double num = scanner.nextDouble();
                    System.out.println("Square Root: " + Math.sqrt(num));
                    break;
                case 6:
                    System.out.print("Enter base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter exponent: ");
                    double exponent = scanner.nextDouble();
                    System.out.println("Result: " + Math.pow(base, exponent));
                    break;
                case 7:
                    temperatureConversion(scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    private static void performBasicOperation(int choice, double num1, double num2) {
        switch (choice) {
            case 1:
                System.out.println("Result: " + (num1 + num2));
                break;
            case 2:
                System.out.println("Result: " + (num1 - num2));
                break;
            case 3:
                System.out.println("Result: " + (num1 * num2));
                break;
            case 4:
                if (num2 != 0)
                    System.out.println("Result: " + (num1 / num2));
                else
                    System.out.println("Error: Division by zero is not allowed.");
                break;
        }
    }

    private static void temperatureConversion(Scanner scanner) {
        System.out.println("Choose conversion type:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        int tempChoice = scanner.nextInt();
        System.out.print("Enter temperature: ");
        double temp = scanner.nextDouble();
        if (tempChoice == 1) {
            System.out.println("Converted: " + ((temp * 9/5) + 32) + " °F");
        } else if (tempChoice == 2) {
            System.out.println("Converted: " + ((temp - 32) * 5/9) + " °C");
        } else {
            System.out.println("Invalid choice.");
        }
    }
}