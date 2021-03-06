import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards = new ArrayList <Card>();
    private int arraySize;
    private int cardsLeft;
    private ArrayList<Card> discards = new ArrayList<Card>();

    public void newDeck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
               cards.add(new Card(i, j));
            }
        }
        cardsLeft = 0;
    }

   // public int getCardsLeft() {
   //     return cardsLeft;
   // }

    public void shuffle() {
        Random r = new Random();
        for (int i = 0; i < Math.pow(cardsLeft, 2); i++) {
            Collections.swap(cards, r.nextInt(52), r.nextInt(52));
        }
    }

    public String removeCard() {
        if (cardsLeft > 0) {
            Random r = new Random();
            int index = r.nextInt(cardsLeft);
            discards.add(cards.get(index));
            cards.remove(index);
            cardsLeft++;
            return cards.get(index).toString();
        }
        else {
            return "No more cards remaining";
        }
    }

    public String addCard() {
        Random r = new Random();
        if (cardsLeft < 52) {
            int index = r.nextInt(discards.size());
            cards.add(discards.get(index));
            cardsLeft--;
            return "Done";
        }
        else {
            return "False";
        }
    }




}
