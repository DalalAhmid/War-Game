import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Deck {

    //declare deck fields
    private ArrayList<Card> cards = new ArrayList<Card>();
    private int arraySize;
    private int cardsLeft;
    private ArrayList<Card> discards = new ArrayList<Card>();

    //method to create new standard deck
    public void newDeck() {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                cards.add(new Card(i, j));
            }
        }
        cardsLeft = 52;
        discards.clear();
    }

    //method to shuffle deck
    public void shuffle() {
        Random r = new Random();
        for (int i = 0; i < Math.pow(cardsLeft, 2); i++) {
            Collections.swap(cards, r.nextInt(52), r.nextInt(52));
        }
    }

    //method to remove a card from the deck
    public Card removeCard() {
        if (cardsLeft > 0) {
            Random r = new Random();
            int index = r.nextInt(cardsLeft);
            discards.add(cards.get(index));
            cards.remove(index);
            cardsLeft--;
            return discards.get(discards.size() - 1);
        } else {
            return null;
        }
    }

    //method to add a card to the deck
    public String addCard() {
        Random r = new Random();
        if (cardsLeft < 52) {
            int index = r.nextInt(discards.size());
            cards.add(discards.get(index));
            cardsLeft++;
            return "Done";
        } else {
            return "False";
        }
    }

    //method that returns how many cards are left in deck
    public int getCardsLeft() {
        return cardsLeft;
    }


}
