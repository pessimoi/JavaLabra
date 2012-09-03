// Pessi Moilanen
// Testaaaaaaan
package harjoitus;

import java.awt.*;
import javax.swing.*;

/**
 * Suorituksen alkupiste, alustaa pelin kulun
 */
public class MastermindMain {

    /**
     *Saa aikaan pelin kulun
     * 
     * @param args Komento rivi parametrit 
     */
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setSize(860, 700);
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        window.setVisible(true);

        GameGraphics graphics = new GameGraphics();
        GameIO keyListener = new GameIO(graphics);
        graphics.setGame(keyListener);

        graphics.setBackground(Color.BLACK);
        Container container = window.getContentPane();
        container.add(graphics);
        window.addKeyListener(keyListener);


    }
}
