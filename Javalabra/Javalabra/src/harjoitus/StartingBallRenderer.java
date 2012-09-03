package harjoitus;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Luo ylärivillä olevat aloituspallot, kahdeksan erilaista
 */
public class StartingBallRenderer {

    /**
     * Ball luokan avulla lisätään kyseiset pallot piirtymään kokonaisuuteen
     * 
     * @param g Grafiikka kokonaisuus, johon kaikki piirtyy
     */
    public void paint(Graphics g) {
        Ball ballMaker = new Ball(g);
        ballMaker.makeBall(Color.BLUE, 430, 30);
        ballMaker.makeBall(Color.YELLOW, 500, 30);
        ballMaker.makeBall(Color.RED, 570, 30);
        ballMaker.makeBall(Color.MAGENTA, 640, 30);
        ballMaker.makeBall(Color.GREEN, 710, 30);
        ballMaker.makeBall(Color.CYAN, 780, 30);
        ballMaker.makeBall(Color.WHITE, 80, 30);
        ballMaker.makeBall(Color.GRAY, 200, 30);
    }
}
