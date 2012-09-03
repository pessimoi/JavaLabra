package harjoitus;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Pitää yllä pallojen tuloja, kun uusi merkki syötetään
 */
public class GuessRenderer {

    /**
     * Lisää palloja kokonaisuuteen 
     * 
     * @param g Grafiikka kokonaisuus johon piirretään lisää tavaraa
     * @param rounds Kuinka monta riviä ravauksia on jo laitettu
     * @param marks Lista kaikista laitetuista merkeistä
     */
    public void paint(Graphics g, int rounds, ArrayList<Character> marks) {
        Ball ballType = new Ball(g);

        for (int k = 0; k < rounds + 1; k++) {
            int x = 430;
            int y = 120;
            int rivi = 1;
            for (int ball = 0; ball < marks.size(); ball++) {

                if (marks.get(ball) == '0') {
                    ballType.makeBall(Color.BLUE, x, y);
                } else if (marks.get(ball) == '1') {
                    ballType.makeBall(Color.YELLOW, x, y);
                } else if (marks.get(ball) == '2') {
                    ballType.makeBall(Color.RED, x, y);
                } else if (marks.get(ball) == '3') {
                    ballType.makeBall(Color.MAGENTA, x, y);
                } else if (marks.get(ball) == '4') {
                    ballType.makeBall(Color.GREEN, x, y);
                } else if (marks.get(ball) == '5') {
                    ballType.makeBall(Color.CYAN, x, y);
                }
                if (rivi % 4 == 0) {
                    y = y + 50;
                    x = 380;
                }
                x = x + 50;
                rivi++;
            }
        }
    }
}
