import java.util.*;

public class PlayingCard {


    private Suit cardSuit;
    private Rank cardValue;
    private boolean faceUp = false;

    public static enum Suit {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES;
    }

    public static enum Rank {
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE;
    }


//    String[] suit = {"CLUBS", "DIAMONDS", "HEARTS", "SPADES"};
//    int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    PlayingCard(Suit cardSuit, Rank cardValue) {
        setCardSuit(cardSuit);
        setCardValue(cardValue);
    }

    public void setCardSuit(Suit cardSuit) {
        this.cardSuit = cardSuit;
    }

    public void setCardValue(Rank cardValue) {
        this.cardValue = cardValue;
    }

    public Rank getCardValue() {
        return cardValue;
    }

    public Suit getCardSuit() {
        return cardSuit;
    }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

}



/*
    En klass PlayingCard som representerar ett vanligt spelkort.
        PlayingCardskainnehålla/representera:
        oFärg/svit.
        Dvs spader (♠), hjärter (♥), ruter (♦) och klöver (♣)
        oValör.
        Dvs ess, 2, 3, 4, 5, 6, 7, 8, 9, 10, knekt, dam, kungoIndikerar om ett kort är vänt/dolt eller inte.
        Dvs, är färg/svit och valör synlig*/