package harjoitus;

import java.awt.*;
import javax.swing.*;

/**
 * Ball luokka piirtää pallon, pallon voin määritellä
 */
public class Ball extends JPanel {

    private Graphics painter;

    /**
     * Alustaa Ball luokan
     * 
     * @param g grafiikka kokonaisuus
     */
    public Ball(Graphics g) {
        this.painter = g;
    }

    /**
     * makeBall metodi piirtää halutunlaisen pallon
     * 
     * @param vari määrää pallon värityksen
     * @param x määrää x-koordinaatin
     * @param y määrää y-koordinaatin
     */
    public void makeBall(Color vari, int x, int y) {
        super.paint(painter);
        painter.setColor(vari);
        painter.fillOval(x, y, 35, 35);

    }
}