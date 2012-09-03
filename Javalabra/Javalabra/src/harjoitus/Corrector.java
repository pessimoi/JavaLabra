package harjoitus;

/**
 * Vertaa käyttäjän arvausta arvattavan rivin kanssa ja palauttaa oikeiden, väärien 
 * ja melkein arvojen määrän.
 */
public class Corrector {

    private int correct;
    private int almost;
    private int miss;
    private Row attempt;
    private Row correctRow;

    /**
     * Alustaa Corrector luokan ja kutsuu tarkista metodia.
     * 
     * @param attempt Käyttäjän syöttämä arvaus
     * @param correctRow Koneen arpoma rivi johon arvausta verrataan
     */
    public Corrector(Row attempt, Row correctRow) {
        this.attempt = attempt;
        this.correctRow = correctRow;
        checkRow(this.attempt, this.correctRow);
    }

    /**
     * Metodi palauttaa oikeiden merkkien määrän
     * 
     * @return correct Palauttaa arvon, joka vastaa oikeiden merkkien määrää
     */
    public int getCorrect() {
        return correct;
    }

    /**
     * Metodi palauttaa melkein merkkien määrän
     * 
     * @return melkein  Palauttaa arvon, joka vastaa melkein merkkien määrää
     */
    public int getAlmost() {
        return almost;
    }

    /**
     * Metodi palauttaa väärien merkkien määrän
     * 
     * @return melkein  Palauttaa arvon, joka vastaa väärien merkkien määrää
     */
    public int getMiss() {
        return miss;
    }

    /**
     * Suorittaa arvauksen ja arvattavan vertailun, kasvattaa myöh huti, melkein ja oikein
     * muuttujien arvoja.
     * 
     * @param attempt Käyttäjän syöttämä arvaus
     * @param correctRow Koneen arpoma rivi johon arvausta verrataan
     */
    private void checkRow(Row attempt, Row correctRow) {

        int[] toUse = new int[]{correctRow.value(0), correctRow.value(1), correctRow.value(2), correctRow.value(3)};
        int[] attemptToUse = new int[]{attempt.value(0), attempt.value(1), attempt.value(2), attempt.value(3)};

        for (int h = 0; h < 4; h++) {
            int randomed = attempt.value(h);
            if (randomed == correctRow.value(h)) {
                toUse[h] = -1;
                attemptToUse[h] = -2;
                correct++;
            }
        }
        int z = 0;
        int g = 0;
        while (g < 4) {
            while (z < 4) {
                if (toUse[g] == attemptToUse[z]) {
                    almost++;
                    toUse[g] = -1;
                    attemptToUse[z] = -2;
                    z = 4;
                }
                z++;
            }
            z = 0;
            g++;
        }
        int r = 0;
        while (r < 4) {
            if (toUse[r] != -1) {
                miss++;
            }
            r++;
        }
    }
}
