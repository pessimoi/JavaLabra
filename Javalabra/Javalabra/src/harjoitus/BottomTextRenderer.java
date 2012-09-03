package harjoitus;

import java.awt.Color;
import java.awt.Graphics;

/**
 * BottomTextRenderer luokka tekee grafiikka kokonaisuuteen alalaidan tulosteet
 */
public class BottomTextRenderer {

    /**
     * Tulostaa halutut tekstit oikeille kohdille ja vaihtelee pelejä/voittoja
     * 
     * @param g grafiikka kokonaisuus johon kyseiset tekstit tulevat
     * @param games pelien määrä
     * @param wins voittojen määrä
     */
    public void paint(Graphics g, int games, int wins) {
        g.setColor(Color.WHITE);
        g.drawString("Poistu: 'Q'", 560, 585);
        g.drawString("Uusi peli: 'R'", 560, 605);
        g.drawString("Pelattujen pelienmäärä: " + games, 560, 625);
        g.drawString("Voitetut pelit: " + wins, 560, 645);
    }
}
