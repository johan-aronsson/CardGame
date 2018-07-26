import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class PlayingCardGame {
    File file = new File("highScore.txt");
    private int wins;
    private int losses;

//Game Loop

    public void onePlayerGame () {
        PlayingCardDeck deck = new PlayingCardDeck();
        List<PlayingCard> filledDeck = deck.populateDeck();
        loadScore();
        Player dealer = new Player();
        Player player1 = new Player();
        Scanner sc = new Scanner(System.in);
        boolean stillPlaying = true;

        while (stillPlaying) {
            dealer.setPlayersCard(deck.takeCardStartOfDeck(filledDeck));
            dealer.getPlayersCard().setFaceUp(true);
            player1.setPlayersCard(deck.takeCardStartOfDeck(filledDeck));

            renderCards(dealer.getPlayersCard(), player1.getPlayersCard());
            int selection = sc.nextInt();
            player1.getPlayersCard().setFaceUp(true);
            renderCards(dealer.getPlayersCard(), player1.getPlayersCard());
            checkWin(dealer.getPlayersCard(), player1.getPlayersCard(), selection);

            deck.addCardEndOfDeck(filledDeck, dealer.getPlayersCard());
            deck.addCardEndOfDeck(filledDeck, player1.getPlayersCard());

            System.out.println("Spela igen? JA (1) NEJ (2)");
            while (true) {
                selection = sc.nextInt();
                if (selection == 1) {
                    stillPlaying = true;
                    break;
                } else if (selection ==2){
                    stillPlaying = false;
                    break;
                }
            }

        }
        renderMenu();
    }

    public void renderCards(PlayingCard dealerCard, PlayingCard playerCard) {
        if (!playerCard.isFaceUp()) {
            System.out.println("Dealers kort:");
            System.out.println(dealerCard.getCardSuit()+" "+dealerCard.getCardValue());
            System.out.println();
            System.out.println("Spelares kort:");
            System.out.println("KORT DOLT");
            System.out.println();
            System.out.println("Är ditt kort högre (1) eller lägre (2)?");
        } else {
            System.out.println("Spelares kort:");
            System.out.println(playerCard.getCardSuit()+" "+playerCard.getCardValue());
        }
    }

//Functions to check for card rank and if player or dealer is the winner.

    public void checkWin (PlayingCard dealerCard, PlayingCard playerCard, int selection) {
        int dealerCardValue = checkValue(dealerCard);
        int dealerCardSuitRank = checkSuitRank(dealerCard);
        int playerCardValue = checkValue(playerCard);
        int playerCardSuitRank = checkSuitRank(playerCard);


        if (dealerCardValue < playerCardValue) {
            if (selection == 1) {
                System.out.println("Spelare vinner");
                wins += 1;
            } else {
                System.out.println("Spelare förlorar");
                losses += 1;
            }
        } else if (dealerCardValue > playerCardValue) {
            if (selection == 1) {
                System.out.println("Spelare förlorar");
                losses += 1;
            } else {
                System.out.println("Spelare vinner");
                wins += 1;
            }
        } else {
            if (dealerCardSuitRank < playerCardSuitRank) {
                if (selection == 1) {
                    System.out.println("Spelare vinner");
                    wins += 1;
                } else {
                    System.out.println("Spelare förlorar");
                    losses += 1;
                }
            } else {
                if (selection == 1) {
                    System.out.println("Spelare förlorar");
                    losses += 1;
                } else {
                    System.out.println("Spelare vinner");
                    wins += 1;
                }
            }
        }
        saveScore(wins, losses);
    }

    public int checkValue(PlayingCard card) {
        int value = 0;
            switch (card.getCardValue()) {
                case ACE:
                    value = 1;
                    break;
                case TWO:
                    value = 2;
                    break;
                case THREE:
                    value = 3;
                    break;
                case FOUR:
                    value = 4;
                    break;
                case FIVE:
                    value = 5;
                    break;
                case SIX:
                    value = 6;
                    break;
                case SEVEN:
                    value = 7;
                    break;
                case EIGHT:
                    value = 8;
                    break;
                case NINE:
                    value = 9;
                    break;
                case TEN:
                    value = 10;
                    break;
                case JACK:
                    value = 11;
                    break;
                case QUEEN:
                    value = 12;
                    break;
                case KING:
                    value = 13;
                    break;
            }
        return value;
    }

    public int checkSuitRank (PlayingCard card) {
        int suitRank = 0;
        switch (card.getCardSuit()) {
            case CLUBS:
                suitRank = 1;
                break;
            case DIAMONDS:
                suitRank = 2;
                break;
            case HEARTS:
                suitRank = 3;
                break;
            case SPADES:
                suitRank = 4;
                break;
        }
        return suitRank;
    }

// Functions to handle win statistics. Modifies the declared class specific variables wins and losses.

    public void loadScore () {
        try {
            Scanner sc = new Scanner(file);
            wins = sc.nextInt();
            losses = sc.nextInt();
        } catch (FileNotFoundException e) {
            System.out.println("Du har ingen statistik.");
        }
    }

    public void saveScore (int playerWins, int playerLosses) {

        try {
            PrintWriter output = new PrintWriter(file);
            output.println(playerWins);
            output.println(playerLosses);
            output.close();
        } catch (FileNotFoundException e){
            System.out.println(e);
        }
    }

    //Menu rendering functions

    public void renderMenu () {
        System.out.println("--HUVUDMENY--");
        System.out.println("1. Spela ett parti");
        System.out.println("2. Visa spelregler");
        System.out.println("3. Visa statistik");
        System.out.println("4. Avsluta spelet");
        System.out.println();
        System.out.println("Skriv 1-4 för att välja alternativ.");

        Scanner sc = new Scanner(System.in);

        while (true) {
            int menuSelected = sc.nextInt();
            switch(menuSelected) {
                case 1:
                    onePlayerGame();
                    break;
                case 2:
                    showRules();
                    break;
                case 3:
                    showStatistics();
                    break;
                case 4:
                    System.exit(1);
            }
        }

    }

    public void showRules() {
        System.out.println("--REGLER--");
        System.out.println("Spelet går ut på att gissa om det kort som du fått tilldelat");
        System.out.println("är högre eller lägre än dealerns kort.");
        System.out.println();
        System.out.println("Följande suit ranking tillämpas:");
        System.out.println("Spader (♠) > Hjärter (♥) > Ruter (♦) > Klöver (♣)");
        System.out.println();
        System.out.println("Skriv 1 och ENTER för att återgå till huvudmenyn");
        Scanner sc = new Scanner(System.in);
        while (true) {
            int menuInput = sc.nextInt();
            if (menuInput == 1) {
                renderMenu();
                break;
            }
        }

    }

    public void showStatistics () {
        System.out.println("--STATISTIK--");
        loadScore();
        System.out.println("Vinster: " + wins);
        System.out.println("Förluster: " + losses);
        System.out.println();
        System.out.println("Skriv 1 och ENTER för att återgå till huvudmenyn");

        Scanner sc = new Scanner(System.in);
        while (true) {
            int menuInput = sc.nextInt();
            if (menuInput == 1) {
                renderMenu();
                break;
            }
        }

    }
}