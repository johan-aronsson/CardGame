public class PlayingCard {

    private Suit cardSuit;
    private RankDisplay cardValue;
    private boolean faceUp = false;

    public enum Suit {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES;
    }

    public enum RankDisplay {
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