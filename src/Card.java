import java.util.Random;

public class Card {

    // ranks are ordered Ace-low and Queen-high
    private final String ranks[] ={"Ace","2","3","4","5","6","7","8","9","10","Jack","King","Queen"};

    // suits are ordered alphabetically
    private final String suits[] = {"Clubs","Diamonds","Hearts","Spades"};

    private String rank;
    private String suit;

    public Card() {
        Random r = new Random();
        int index = r.nextInt(4);
        this.suit = suits[index];
        index = r.nextInt(13);
        this.rank = ranks[index];
    }

    public Card (int rankIndex, int suitIndex) {
        this.rank = ranks[rankIndex];
        this.suit = suits[suitIndex];
    }

    public int getSuitIndex() {
        int index = 0;
        for (int i = 0; i < suits.length; i++) {
            if (suit.equals(suits[i])) {
                index = i;
            }
        }
        return index;
    }

    public int getRankIndex() {
        int index = 0;
        for (int i = 0; i < ranks.length; i++) {
            if (rank.equals(ranks[i])) {
                index = i;
            }
        }
        return index;
    }

    public String toString() {
        return rank + " of " + suit;
    }
    }
