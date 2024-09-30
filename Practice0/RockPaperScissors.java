import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] choices = {"Rock", "Paper", "Scissors"};

        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("Enter your choice (Rock, Paper, Scissors):");

        while (true) {
            String userChoice = scanner.nextLine();
            String computerChoice = choices[random.nextInt(choices.length)];

            if (!userChoice.equalsIgnoreCase("Rock") && 
                !userChoice.equalsIgnoreCase("Paper") && 
                !userChoice.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid choice! Please enter Rock, Paper, or Scissors.");
                continue;
            }

            System.out.println("You chose: " + userChoice);
            System.out.println("Computer chose: " + computerChoice);

            // Determine the result
            if (userChoice.equalsIgnoreCase(computerChoice)) {
                System.out.println("It's a tie!");
            } else if (userChoice.equalsIgnoreCase("Rock") && computerChoice.equals("Scissors") ||
                       userChoice.equalsIgnoreCase("Paper") && computerChoice.equals("Rock") ||
                       userChoice.equalsIgnoreCase("Scissors") && computerChoice.equals("Paper")) {
                System.out.println("You win!");
            } else {
                System.out.println("Computer wins!");
            }

            // Play again or exit
            System.out.println("Do you want to play again? (yes/no)");
            String playAgain = scanner.nextLine();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}

