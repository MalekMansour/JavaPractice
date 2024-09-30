import java.util.Scanner;

public class IntegerComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the first integer: ");
        int userChoice1 = scanner.nextInt();
        
        System.out.print("Enter the second integer: ");
        int userChoice2 = scanner.nextInt();
        
        if (userChoice1 == userChoice2) {
            System.out.println("These numbers are equal.");
        } 
        if (userChoice1 > userChoice2) {
            System.out.println(userChoice1 + " is larger.");
        } 
        if (userChoice2 > userChoice1) {
            System.out.println(userChoice2 + " is larger.");
        }
        
        scanner.close();
    }
}

