package harjoitus;

import java.awt.*;
import javax.swing.*;

/**
 * Toteuttaa pelin graafiset ominaisuudet ja toteuttaa ne lähinnä erilaisten
 * rendereiden kautta, tähän liittyy myös tekstien ja renderien käytön vaihtelevuus
 * sen mukaan miä gameState oikein on kyseisellä hetkellä.
 */
public class GameGraphics extends JPanel {

    private GameIO game;
    private Graphics paint;
    private GuessTextRenderer guessTextRenderer = new GuessTextRenderer();
    private NumberRenderer numbersRenderer = new NumberRenderer();
    private StartingBallRenderer startingBallRenderer = new StartingBallRenderer();
    private FeedbackRenderer feedbackRenderer = new FeedbackRenderer();
    private GuessRenderer guessRenderer = new GuessRenderer();
    private BottomTextRenderer bottomTextRenderer = new BottomTextRenderer();
    private WinOrLoseRenderer winOrLoseRenderer = new WinOrLoseRenderer();

    /**
     * Yhdistää grafiikat kyseiseen peliin
     */
    public void setGame(GameIO game) {
        this.game = game;
    }

    /**
     * Kutsuu erillisillä metodeilla piirtymään peliä
     * @param g Grafiikka kokonaisuus johon asiat piirtyvät
     */
    public void paint(Graphics g) {

        if (game == null) {
            return;
        }

        this.paint = g;
        super.paint(paint);

        //Tulostaa kaikki omat arvatut pallot
        guessRenderer.paint(g, game.getRounds(), game.getMarks());

        //Tulostaa kaikki oikeat ja melkein rivit
        feedbackRenderer.paint(g, game.getRounds(), game.getNumCorrect(), game.getNumAlmost());

        //Tekee ylärivin kaikki pallot
        startingBallRenderer.paint(g);

        //Numerot pallojen päälle
        numbersRenderer.paint(g);

        //Arvaus tekstit
        guessTextRenderer.paint(g);

        //Voitto ilmoitus
        if (game.gameState.isWin()) {
            game.gameState.wonGame();
            winOrLoseRenderer.paint(g, true);
            if (!game.gameState.isNewGame()) {
                game.gameState.setGames(false);
            }
        }

        //Häviö ilmoitus
        if (game.getRounds() == 9 && !game.gameState.isWin()) {
            game.gameState.lostGame();
            winOrLoseRenderer.paint(g, false);
            if (!game.gameState.isNewGame()) {
                game.gameState.setGames(false);
            }
        }

        //Alaosan ilmoitukset
        //bottomTextRenderer.paint(g, pelit, voitot);
        bottomTextRenderer.paint(g, game.gameState.getGames(), game.gameState.getWins());
    }
}
