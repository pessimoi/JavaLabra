package harjoitus;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Luo ylärivin numerot
 */
public class NumberRenderer {

    /**
     * Luo numerot 1-6
     * @param g Grafiikka kokonaisuus johon numerot piirtyvät
     */
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        for (int i = 0; i < 6; i++) {
            g.drawString("" + i, 445 + (70 * i), 25);
        }
    }
}
