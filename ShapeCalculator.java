import java.text.DecimalFormat;
import java.util.Scanner;

public class ShapeCalculator {
public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    DecimalFormat decimalFormat = new DecimalFormat("#.##");

    System.out.println("Choose a shape: ");
    System.out.println("1. Rectangle");
    System.out.println("2. Triangle");
    System.out.println("3. Square");
    System.out.println("4. Circle");
    int choice = scanner.nextInt();

    boolean validShape = choice >= 1 && choice <= 4;

    if (!validShape) {
        System.out.println("Invalid shape!");
    } else {
        System.out.println("Choose the type: ");
        System.out.println("1. Perimeter");
        System.out.println("2. Area");
        int type = scanner.nextInt();

        double dimension1 = 0;
        double dimension2 = 0;

        if (type == 1 || type == 2) {
            dimension1 = validateInput(scanner, getDimensionMessage(choice, type, 1));
            if (choice != 3 && choice != 4) {
                dimension2 = validateInput(scanner, getDimensionMessage(choice, type, 2));
            }
        }

        String shapeName = "";
        double result = 0;

        switch (choice) {
            case 1:
                shapeName = "rectangle";
                if (type == 1) {
                    result = 2 * (dimension1 + dimension2);
                } else if (type == 2) {
                    result = dimension1 * dimension2;
                }
                break;
            
            case 2:
                shapeName = "triangle";
                if (type == 1) {
                    result = dimension1 + dimension2 + dimension1;
                } else if (type == 2)  {
                    result = (dimension1 * dimension2) / 2;
                }
                break;

            case 3:
                shapeName = "square";
                if (type == 1) {
                    result = dimension1 * 4;
                } else if (type == 2) {
                    result = dimension1 * dimension1;
                }
                break;

            case 4:
                shapeName = "circle";
                if (type == 1) {
                    result = 2 * Math.PI * dimension1;
                } else if (type == 2) {
                    result = Math.PI * dimension1 * dimension1;
                }
                break;
        }
        System.out.println("The " + shapeName + " " + (type == 1 ? "perimeter" : "area") + " is: " + decimalFormat.format(result));
        scanner.close();
    }
}

public static String getDimensionMessage(int choice, int type, int dimensionNumber) {
    switch (choice) {
        case 1:
            return (dimensionNumber == 1) ? "Enter the length of the rectangle: " 
                                          : "Enter the width of the rectangle: ";
        case 2:
            if (type == 1) {
                return (dimensionNumber == 1) ? "Enter the length of the triangle: " 
                                              : "Enter the width of the triangle: ";
            } else if (type == 2) {
                return (dimensionNumber == 1) ? "Enter the base of the triangle: " 
                                              : "Enter the height of the triangle: ";
            }
        case 3:
            return "Enter the length of the square: ";
        case 4:
            return "Enter the radius of the circle: ";
        default:
            return null;
    }
}

    public static double validateInput(Scanner scanner, String message) {
        System.out.println(message);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
