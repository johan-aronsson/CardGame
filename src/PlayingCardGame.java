
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class PlayingCardGame {
    File file = new File("highScore.txt");

    public void loadScore () {
        try {
            Scanner sc = new Scanner(file);
            int wins = sc.nextInt();
            System.out.println("Vinster: "+wins);
            int losses = sc.nextInt();
            System.out.println("Förluster: "+losses);
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



    public void onePlayerGame () {
        PlayingCardDeck deck = new PlayingCardDeck();
        List<PlayingCard> filledDeck = deck.populateDeck();

        Dealer dealer = new Dealer();
        Player player1 = new Player();
        Scanner sc = new Scanner(System.in);
        boolean stillPlaying = true;

        while (stillPlaying) {
            dealer.setDealersCard(deck.takeCardStartOfDeck(filledDeck));
            dealer.getDealersCard().setFaceUp(true);
            player1.setPlayersCard(deck.takeCardStartOfDeck(filledDeck));

            renderCards(dealer.getDealersCard(), player1.getPlayersCard());
            int selection = sc.nextInt();
            player1.getPlayersCard().setFaceUp(true);
            renderCards(dealer.getDealersCard(), player1.getPlayersCard());
            checkWin(dealer.getDealersCard(), player1.getPlayersCard(), selection);

            deck.addCardEndOfDeck(filledDeck, dealer.getDealersCard());
            deck.addCardEndOfDeck(filledDeck, player1.getPlayersCard());

            System.out.println("Spela igen? JA (1) NEJ (2)");
            selection = sc.nextInt();
            if (selection == 1) {
                stillPlaying = true;
            } else {
                stillPlaying = false;
            }
        }

        renderMenu();








    }

    public void checkWin (PlayingCard dealerCard, PlayingCard playerCard, int selection) {
        int dealerCardValue = checkValue(dealerCard);
        int dealerCardSuitRank = checkSuitRank(dealerCard);
        int playerCardValue = checkValue(playerCard);
        int playerCardSuitRank = checkSuitRank(playerCard);

        int wins = 0;
        int losses = 0;

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

    //Menu functions

    public void renderMenu () {
        System.out.println("--HUVUDMENY--");
        System.out.println("1. Spela ett parti");
        System.out.println("2. Visa spelregler");
        System.out.println("3. Visa statistik");
        System.out.println("4. Avsluta spelet");
        System.out.println();
        System.out.println("Skriv 1-4 för att välja alternativ.");

        Scanner sc = new Scanner(System.in);
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

//    public void playGameMenu () {
//        System.out.println("--VÄLJ ANTAL SPELARE--");
//        System.out.println("1. Spelare");
//        System.out.println("2. Spelare");
//
//        Scanner sc = new Scanner(System.in);
//        int menuInput = sc.nextInt();
//
//        if (menuInput == 1) {
//            onePlayerGame();
//        } else if (menuInput == 2){
//            twoPlayerGame();
//        } else {
//            System.exit(1);
//        }
//    }

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
        int menuInput = sc.nextInt();
        if (menuInput == 1) {
            renderMenu();
        } else {
            System.exit(1);
        }
    }

    public void showStatistics () {
        System.out.println("--STATISTIK--");
        loadScore();
        System.out.println();
        System.out.println("Skriv 1 och ENTER för att återgå till huvudmenyn");

        Scanner sc = new Scanner(System.in);
        int menuInput = sc.nextInt();
        if (menuInput == 1) {
            renderMenu();
        } else {
            System.exit(1);
        }
    }

    
}




//    En spelklassPlayingCardGamesom använderminst en instans avPlayingCardDeckför att spela ett kortspel.
// PlayingCardGame ska innehålla/representera:
// oSkapa en blandad kortlek som spelet ska använda sig avo
// Kunna spela som en eller fleraspelare. Detta är heltberoende påvilketspel man väljer att implementera.
//
// oKunna vinna / förlora / få oavgjort i spelet.
// Med andra ord, man ska kunna spela ett kortspel.
//
// oSpara undan historik (tex highscore, antal spelade partier, etc.).
// Man kan spara undan denna informationgenom att skriva/läsa till en text-fil som ligger lokalt på datorn.
//
// oInnehålla en meny som ger användarenföljande alternativ:
// ▪Spela ett parti
// ▪Visa spelregler
// ▪Visa statistik (tex highscore, antal spelade partier, etc)
// ▪Avsluta spelet