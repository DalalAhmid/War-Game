import java.util.Comparator;

abstract class CardSortingComparator implements Comparator<Card> {

    public int Compare(Card a, Card b) {
        int RankCompare = Integer.compare(a.getRankIndex(), b.getRankIndex());
        int SuitCompare = Integer.compare(a.getSuitIndex(), b.getSuitIndex());

        if (RankCompare == 0) {
            return SuitCompare;
        }
        else {
            return RankCompare;
        }


    }



}
