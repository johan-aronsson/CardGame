import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PlayingCardGame {

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

    public void onePlayerGame () {
        PlayingCardDeck deck = new PlayingCardDeck();
        List<PlayingCard> filledDeck = deck.populateDeck();
        Collections.shuffle(filledDeck);

        for (PlayingCard card :filledDeck) {
            System.out.println(card.getCardSuit());
            System.out.println(card.getCardValue());
        }

    }

    public void twoPlayerGame () {
        System.out.println("2 player game");

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


    public void playGame() {
        System.out.println("Play a game");
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