public class PlayingCard {


    private Suit cardSuit;
    private RankDisplay cardValue;
    private boolean faceUp = false;

    public static enum Suit {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES;
    }

    public static enum RankDisplay {
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
        ACE
    }




//    String[] suit = {"CLUBS", "DIAMONDS", "HEARTS", "SPADES"};
//    int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    PlayingCard(Suit cardSuit, RankDisplay cardValue) {
        setCardSuit(cardSuit);
        setCardValue(cardValue);
    }

    public void setCardSuit(Suit cardSuit) {
        this.cardSuit = cardSuit;
    }

    public void setCardValue(RankDisplay cardValue) {
        this.cardValue = cardValue;
    }

    public RankDisplay getCardValue() {
        return cardValue;
    }

    public Suit getCardSuit() {
        return cardSuit;
    }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

    public boolean isFaceUp() {
        return faceUp;
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