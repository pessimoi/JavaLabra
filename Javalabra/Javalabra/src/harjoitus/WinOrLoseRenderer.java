package harjoitus;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Antaa voitto tai häviö tulosteen riippuen kumpaa tarvitaan
 */
public class WinOrLoseRenderer {

    /**
     * Luo tulosteen
     * @param g Yhdistää piirrettävät asiat grafiikka kokonaisuuteen
     * @param win totuusargo jonka avulla tiedetään tuleeko voitto vai häviö
     */
    public void paint(Graphics g, boolean win) {
        if (win == true) {
            g.setColor(Color.MAGENTA);
            g.drawString("VOITIT! :D", 260, 575);
            g.drawString("VOITIT! :D", 360, 575);
            g.drawString("VOITIT! :D", 460, 575);
        } else if (win == false) {
            g.setColor(Color.RED);
            g.drawString("HÄVISIT! :<", 260, 575);
            g.drawString("HÄVISIT! :<", 360, 575);
            g.drawString("HÄVISIT! :<", 460, 575);
        }
    }
}
