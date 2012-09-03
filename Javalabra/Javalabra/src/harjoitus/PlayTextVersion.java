package harjoitus;

import java.util.*;

/**
 * Pitää pelin kulkua yllä, vertailee vastauksia arvattavan rivin kanssa ja
 * kysyy käyttäjän syötettä
 */
class PlayTextVersion {

    private Row rightRow;
    private Scanner scanner = new Scanner(System.in, "ISO-8859-1");

    /**
     * Alustaa PlayTextVersion luokan
     * 
     * @param rightRow Row tyyppinen muuttuja joka on koneen arpoma
     */
    public PlayTextVersion(Row rightRow) {
        this.rightRow = rightRow;
    }

    /**
     * Jatkaa arvausten kyselyä, kunnes osuu oikea vastaus pitää peliä yllä.
     */
    public void inPut() {
        Attempts attempts = new Attempts();
        while (true) {
            Row attempt = askAttempt();
            attempts.addAttempt(attempt);
            Corrector corrector = new Corrector(attempt, rightRow);
            if (systemOutPut(attempt, corrector)) {
                break;
            }
            attempts.printAttempts();
        }
    }

    /**
     * @param attempt Käyttäjän antama arvaus
     * @param corrector Corrector olio, joka ilmoittaa arvauksen oikeellisuuden
     * @return boolean Palauttaa True jos kaikki 4 oikein, muuten false
     */
    private boolean systemOutPut(Row attempt, Corrector corrector) {
        System.out.println("arvaus: " + attempt);
        System.out.println("Oikea: " + corrector.getCorrect());
        System.out.println("Melkein: " + corrector.getAlmost());
        System.out.println("Huti: " + corrector.getMiss());
        if (corrector.getCorrect() == 4) {
            System.out.println("Oikein meni! :D");
            return true;
        }
        return false;
    }

    /**
     * Ottaa käyttäjän arvauksen syötteenä ja palauttaa sen kokonaisena
     * @return arvaus Palauttaa käyttäjän arvauksista muodostetun Row olion
     */
    private Row askAttempt() {
        System.out.println("Syötä numerot yksitellen!");
        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());
        int fourth = Integer.parseInt(scanner.nextLine());
        Row attempt = new Row(first, second, third, fourth);
        return attempt;
    }
}
