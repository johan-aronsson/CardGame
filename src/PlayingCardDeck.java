import java.util.ArrayList;
import java.util.List;

public class PlayingCardDeck {

    public List<PlayingCard> populateDeck (){
        List<PlayingCard> deck = new ArrayList<>();

        int suit = 4;
        int cardPerSuit = 13;

        for(int i=0; i<suit; i++) {
            for (int j=0; j<cardPerSuit; j++) {
                deck.add(new PlayingCard(PlayingCard.Suit.values()[i], PlayingCard.Rank.values()[j]));
            }
        }
        return deck;
    }

    public List<PlayingCard> addCardEndOfDeck (List<PlayingCard> deck, PlayingCard card) {
        deck.add(deck.size(), card);
        return deck;
    }

    public PlayingCard takeCardStartOfDeck (List<PlayingCard> deck) throws IndexOutOfBoundsException{
        PlayingCard topCard = deck.get(0);
        return topCard;
    }




}




//
//    En klass PlayingCardDeck som representerar en kortlek på 52 kort av typen PlayingCard.
//        PlayingCardDeckska innehålla/representera:
//        oMinst en datastruktur för att lagra alla PlayingCardobjekt.
//        Tex Array, ArrayList, LinkedList, HashMap,etc.
//        oEn metod som tar ut det översta/första kortet från PlayingCardDeck.
//        Implementera på valfritt sätt vadsom skahändaom kortleken är tomoch man anropar metoden
//        (ska den returnera null/ false? Ska den kasta ett exception?etc).
//        oEn metod för att lägga till ett kort underst/längst bakpå PlayingCardDeck.
