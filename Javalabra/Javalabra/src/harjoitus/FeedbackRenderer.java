package harjoitus;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Antaa palautetta rivin oikeellisuudesta luomallillaan valkoisilla ja harmailla
 * palloilla, joista saa apua oikean rivin ratkaisuun
 */
public class FeedbackRenderer {

    /**
     * Saa aikaan valkoiset ja harmaat pallot parametrien arvoja tarkastelemalla
     * 
     * @param g Grafiikka kokonaisuus johon piirtyy uudet pallot
     * @param rounds Pitää kirjaa merkkirivien määrästä
     * @param correct Lista kohdallaan olevista merkeistä
     * @param almost Lista melkein kohdallaan olevista merkeistä
     */
    public void paint(Graphics g, int rounds, ArrayList<Integer> correct, ArrayList<Integer> almost) {
        Ball ballMaker = new Ball(g);

        if (rounds > 0) {
            for (int z = 0; z < rounds; z++) {
                int x = 100;
                int y = 120 + (z * 50);

                for (int i = 0; i < correct.get(z); i++) {
                    ballMaker.makeBall(Color.WHITE, x, y);
                    x = x + 50;
                }
                for (int j = 0; j < almost.get(z); j++) {
                    ballMaker.makeBall(Color.GRAY, x, y);
                    x = x + 50;
                }
            }
        }
    }
}
