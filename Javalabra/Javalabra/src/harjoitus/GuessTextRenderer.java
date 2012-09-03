package harjoitus;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Arvaus tekstirivien tuloste
 */
public class GuessTextRenderer {

    /**
     * Liittää kokonaisuuteen yhdeksän erillistä arvaus tekstiriviä
     * @param g Grafiikka kokonaisuus johon arvaus tekstit lisätään 
     */
    public void paint(Graphics g) {

        g.setColor(Color.WHITE);
        g.drawString("Oikea", 125, 55);
        g.drawString("Melkein", 245, 55);
        for (int i = 0; i < 9; i++) {
            g.drawString("Arvaus " + (i + 1) + " :", 360, 140 + (i * 50));
        }
    }
}
