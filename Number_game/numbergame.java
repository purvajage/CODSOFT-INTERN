import java.util.Scanner;
import java.util.Random;

public class numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;
        int attempts;
        int score = 0;

        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1;
            attempts = 0;

            System.out.println("Welcome to Guess the Number Game!");
            System.out.println("I have selected a random number between 1 and 100.");

            int guess;
            boolean guessedCorrectly = false;

            while (!guessedCorrectly) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number " + randomNumber + " correctly!");
                    guessedCorrectly = true;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (!guessedCorrectly && attempts >= 3) {
                    System.out.println("You've run out of attempts. The correct number was " + randomNumber);
                    break;
                }
            }

            score += guessedCorrectly ? attempts : 0;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();

            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Game Over. Your total score is: " + score);
        scanner.close();
    }
}
