import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {
    // main switchboard
    public void run() {
        System.out.println("Welcome to Blind Man's Bluff");
        boolean play, invalid, guessedHigher = false;
        String response;
        int nWin = 0, nLoss = 0, nTie = 0;
        Card compCard, userCard;
        Scanner sc = new Scanner(System.in);
        Deck theDeck = new Deck();
        theDeck.newDeck();
        CardSortingComparator c = new CardSortingComparator();
        play = true;
        Random rand = new Random();

        while (play) {
            // assign values to computer and user
            compCard = theDeck.removeCard();
            userCard = theDeck.removeCard();
            // get user's bet, only if there are cards left in the deck
            if (theDeck.getCardsLeft() > 0) {
                System.out.println("Computer's card is " + compCard.toString());
                invalid = true;
                while (invalid) {
                    System.out.println("Keep in mind that there are " + theDeck.getCardsLeft() + " cards left in the deck");
                    System.out.println("Do you think your card is higher or lower? (H/L)");
                    response = sc.next();
                    if (response.toUpperCase().charAt(0) == 'H') {
                        // continue playing
                        guessedHigher = true;
                        invalid = false;
                    } else if (response.toUpperCase().charAt(0) == 'L') {
                        // break out of while(play) loop
                        guessedHigher = false;
                        invalid = false;
                    } else {
                        // invalid response, ask again
                        System.out.println("Invalid response...");
                        invalid = true;
                    }
                }
                // determine outcome
                if (((c.compare(userCard, compCard) > 0) && guessedHigher) || ((c.compare(compCard, userCard) > 0) && !guessedHigher)) {
                    System.out.println("Great! You're right:");
                    nWin++;
                } else if (((c.compare(compCard, userCard) > 0) && guessedHigher) || ((c.compare(userCard, compCard) > 0) && !guessedHigher)) {
                    System.out.println("Sorry, you're wrong:");
                    nLoss++;
                } else {
                    System.out.println("It's a tie:");
                    nTie++;
                }
                System.out.println("Your card was " + userCard.toString());

                // ask user to play again
                invalid = true;
                while (invalid) {
                    System.out.println("Play again? (Y/N)");
                    response = sc.next();
                    if (response.toUpperCase().charAt(0) == 'Y') {
                        // continue playing
                        play = true;
                        invalid = false;
                    } else if (response.toUpperCase().charAt(0) == 'N') {
                        // break out of while(play) loop
                        play = false;
                        invalid = false;
                    } else {
                        // invalid response, ask again
                        System.out.println("Invalid response...");
                        invalid = true;
                    }
                }
                //end game when deck is empty
            } else {
                System.out.println("There are no cards left in the deck");
                play = false;
            }
        }

        // output stats
        System.out.println("Thanks for playing!");
        System.out.println("Your record was " + nWin + "-" + nLoss + "-" + nTie + " (W-L-T)");
    }

    public static void main(String[] args) {
        new Main().run();
    }

}
