package NumberGuessingGame;

import java.util.Scanner;

/**
 * @author Hasan Acar
 */
public class Runner {

    public static void main(String[] args) {

        System.err.println("===== Welcome to Number Guessing Game =====");
        System.out.println("=========== Choose game level =============");
        System.out.println("--- 1. Easy 2. Middle 3. Hard 4. Expert ---");
        System.out.println("-------------------------------------------");
        Scanner inputFromUser = new Scanner(System.in);
        boolean correctLevel = false;
        int gameLevel = 0;
        int tryCounter = 0;
        boolean findExactNumber = false;
        do {
            try {
                System.out.print("Choose Level: ");
                int level = inputFromUser.nextInt();
                if (level > 0 && level < 5) {
                    correctLevel = true;
                    gameLevel = level;
                }
            } catch (Exception e) {
                String wrongInput = inputFromUser.next();
                System.out.println("Please input correct number! Try again!");
            }
        } while (!correctLevel);

        NGG myGame = new NGG(gameLevel);

        System.out.println("Game starting..");

        System.out.println("You have " + myGame.getNumberOfAttempts() + " tries to find the correct number.");
        System.out.print("Please input a number between " + myGame.getRangeStart() + " and " + myGame.getRangeFinish() + " : ");

        do {
            try {
                int number = inputFromUser.nextInt();
                if (myGame.checkExactNumber(number)) {
                    findExactNumber = true;
                    break;
                }
                System.out.println("Correct number is " + myGame.checkBigOrSmall(number) + " than your number, please try again");

            } catch (Exception e) {
                String wrongInput = inputFromUser.next();
                System.out.println("Please input a number! Try again!");
            }
            tryCounter++;
            System.out.println("Remaining tries: " + (myGame.getNumberOfAttempts() - tryCounter));
        } while (tryCounter < myGame.getNumberOfAttempts() && findExactNumber == false);

        if (findExactNumber) {
            System.err.println("Congratulations you found the right answer");
        } else {
            System.err.println("You didn't find right number, please run the game again!");
        }
    }

}
