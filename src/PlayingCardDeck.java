import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayingCardDeck {

    public List<PlayingCard> populateDeck (){
        List<PlayingCard> deck = new ArrayList<>();

        int suit = 4;
        int cardPerSuit = 13;

        for(int i=0; i<suit; i++) {
            for (int j=0; j<cardPerSuit; j++) {
                deck.add(new PlayingCard(PlayingCard.Suit.values()[i], PlayingCard.RankDisplay.values()[j]));
            }
        }
        Collections.shuffle(deck);
        return deck;
    }

    public List<PlayingCard> addCardEndOfDeck (List<PlayingCard> deck, PlayingCard card) {
        deck.add(deck.size(), card);
        return deck;
    }

    public PlayingCard takeCardStartOfDeck (List<PlayingCard> deck) throws IndexOutOfBoundsException{
        PlayingCard topCard = deck.remove(0);
        return topCard;
    }
}