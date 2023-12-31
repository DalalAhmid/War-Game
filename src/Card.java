import java.util.Comparator;
import java.util.Random;

public class Card {

    // Declare card fields
    // ranks are ordered Ace-low and Queen-high
    private final String ranks[] = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "King", "Queen"};
    // suits are ordered alphabetically
    private final String suits[] = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private String rank;
    private String suit;

    //Default constructor for card
    public Card() {
        Random r = new Random();
        int index = r.nextInt(4);
        this.suit = suits[index];
        index = r.nextInt(13);
        this.rank = ranks[index];
    }

    //Constructor that takes indexes for rank and suit and creates card
    public Card(int rankIndex, int suitIndex) {
        this.rank = ranks[rankIndex];
        this.suit = suits[suitIndex];
    }

    //Method that gets value of a card's suit
    public int getSuitIndex() {
        int index = 0;
        for (int i = 0; i < suits.length; i++) {
            if (suit.equals(suits[i])) {
                index = i;
            }
        }
        return index;
    }

    //method that gets value of a card's ranl
    public int getRankIndex() {
        int index = 0;
        for (int i = 0; i < ranks.length; i++) {
            if (rank.equals(ranks[i])) {
                index = i;
            }
        }
        return index;
    }

    //method that converts a card's value to string format
    public String toString() {
        return rank + " of " + suit;
    }

    //Comparator method
    public int Comparator(Card userCard, Card compCard) {
        CardSortingComparator c = new CardSortingComparator();
        return c.compare(userCard, compCard);
    }
}

//Comparator interface
class CardSortingComparator implements Comparator<Card> {
    @Override
    public int compare(Card a, Card b) {
        int RankCompare = Integer.compare(a.getRankIndex(), b.getRankIndex());
        int SuitCompare = Integer.compare(a.getSuitIndex(), b.getSuitIndex());

        if (RankCompare == 0) {
            return SuitCompare;
        } else {
            return RankCompare;
        }
    }
}
