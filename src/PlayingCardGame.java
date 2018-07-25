
import java.util.List;
import java.util.Scanner;

public class PlayingCardGame {



    public void onePlayerGame () {
        PlayingCardDeck deck = new PlayingCardDeck();
        List<PlayingCard> filledDeck = deck.populateDeck();
//        int playerSum = 0;
//        int dealerSum = 0;
        Dealer dealer = new Dealer();
        Player player1 = new Player();
        Scanner sc = new Scanner(System.in);

        dealer.setDealersCard(deck.takeCardStartOfDeck(filledDeck));
        dealer.getDealersCard().setFaceUp(true);
        player1.setPlayersCard(deck.takeCardStartOfDeck(filledDeck));

        renderCards(dealer.getDealersCard(), player1.getPlayersCard());
        int selection = sc.nextInt();
        player1.getPlayersCard().setFaceUp(true);
        renderCards(dealer.getDealersCard(), player1.getPlayersCard());
        checkWin(dealer.getDealersCard(), player1.getPlayersCard(), selection);





    }

    public void checkWin (PlayingCard dealerCard, PlayingCard playerCard, int selection) {
        int dealerCardValue = checkValue(dealerCard);
        int dealerCardSuitRank = checkSuitRank(dealerCard);
        int playerCardValue = checkValue(playerCard);
        int playerCardSuitRank = checkSuitRank(playerCard);

        if (dealerCardValue < playerCardValue) {
            if (selection == 1) {
                System.out.println("Spelare vinner");
            } else {
                System.out.println("Spelare förlorar");
            }
        } else if (dealerCardValue > playerCardValue) {
            if (selection == 1) {
                System.out.println("Spelare förlorar");
            } else {
                System.out.println("Spelare vinner");
            }
        } else {
            if (dealerCardSuitRank < playerCardSuitRank) {
                if (selection == 1) {
                    System.out.println("Spelare vinner");
                } else {
                    System.out.println("Spelare förlorar");
                }
            } else {
                if (selection == 1) {
                    System.out.println("Spelare förlorar");
                } else {
                    System.out.println("Spelare vinner");
                }
            }
        }
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


    public void twoPlayerGame () {
//        PlayingCardDeck deck = new PlayingCardDeck();
//        List<PlayingCard> filledDeck = deck.populateDeck();
//        Boolean playing = true;
//        int playerSum = 0;
//        int dealerSum = 0;
//
//        Dealer dealer = new Dealer();
//        Player player1 = new Player();
//        Scanner sc = new Scanner(System.in);
//
//        dealer.addCardToDealersHand(deck.takeCardStartOfDeck(filledDeck));
//        player1.addCardToPlayersHand(deck.takeCardStartOfDeck(filledDeck));
//
//        //Player draws cards
//
//        while (playing) {
//            System.out.println("Dealer has:");
//            for (PlayingCard card : dealer.dealerHand) {
//                System.out.println(card.getCardSuit()+" "+card.getCardValue());
//            }
//            player1.addCardToPlayersHand(deck.takeCardStartOfDeck(filledDeck));
//            System.out.println();
//            System.out.println("Player has:");
//            for (PlayingCard card : player1.playerHand) {
//                System.out.println(card.getCardSuit()+" "+card.getCardValue());
//            }
//
//            playerSum = checkHand(player1.playerHand);
//
//
//            if (playerSum > 21) {
//                System.out.println();
//                System.out.println("Player BUST!");
//                break;
//            }
//            System.out.println();
//            System.out.println("Choose 1 to draw card.");
//            System.out.println("Choose 2 to stop.");
//            int selected = sc.nextInt();
//            if (selected == 1) {
//                playing = true;
//            } else {
//                playing = false;
//            }
//        }
//
//// dealer draws cards until 17 and valuates against player hand
//
//        while (dealerSum<17 && playerSum <= 21) {
//            dealerSum = checkHand(dealer.dealerHand);
//
//            if (dealerSum <= 17) {
//                dealer.addCardToDealersHand(deck.takeCardStartOfDeck(filledDeck));
//                System.out.println("Dealer taking card");
//                System.out.println();
//                System.out.println("Dealer has:");
//                for (PlayingCard card : dealer.dealerHand) {
//                    System.out.println(card.getCardSuit()+" "+card.getCardValue());
//                }
//                System.out.println();
//            } else if (dealerSum <= 17 && dealerSum <= 21){
//                playerSum = checkHand(player1.playerHand);
//                if (playerSum == dealerSum) {
//                    System.out.println("Draw!");
//                    break;
//                } else if (playerSum < dealerSum) {
//                    System.out.println("Dealer win!");
//                    break;
//                } else {
//                    System.out.println("Player win!");
//                    break;
//                }
//            } else {
//                System.out.println("Dealer bust!");
//                System.out.println("Player win!");
//            }
//        }
//
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
                playGameMenu();
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

    public void playGameMenu () {
        System.out.println("Välj antal spelare:");
        System.out.println("1. Spelare");
        System.out.println("2. Spelare");

        Scanner sc = new Scanner(System.in);
        int menuInput = sc.nextInt();

        if (menuInput == 1) {
            onePlayerGame();
        } else if (menuInput == 2){
            twoPlayerGame();
        } else {
            System.exit(1);
        }
    }

    public void showRules() {
        System.out.println("Rules bla bla bla");
        System.out.println("bla bla bla bal");
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
        System.out.println("Statistics.......");
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