import java.util.Scanner;

public class TrapezoidArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Height: ");
        int height = scanner.nextInt();
        
        System.out.print("Base A: ");
        int baseA = scanner.nextInt();
        
        System.out.print("Base B: ");
        int baseB = scanner.nextInt();
        
        int bases = baseA + baseB;
        int x = height * bases;
        double area = x / 2.0;
        
        System.out.println("Area of the Trapezoid is " + area);
        
        scanner.close();
    }
}

