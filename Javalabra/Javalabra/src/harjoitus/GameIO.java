package harjoitus;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * Pitää huolen pelin kulun ylläpidosta ja tunnistaa näppäimistön painallukset
 */
class GameIO implements KeyListener {

    protected GameState gameState = new GameState();
    static Random random = new Random();
    private int rounds = 0;
    private int amount = 0;
    private int first;
    private int second;
    private int third;
    private int fourth;
    private Row attempt;
    private Row correctRow;
    private Attempts attempts = new Attempts();
    private ArrayList<Integer> correct = new ArrayList<Integer>();
    private ArrayList<Integer> almost = new ArrayList<Integer>();
    private ArrayList<Character> marks = new ArrayList<Character>();
    private final GameGraphics graphics;

    /**
     * Alustaa kyseisen luokan
     * 
     * @param graphics pelin grafiikat joihin kaikki yhdistyy 
     */
    GameIO(GameGraphics graphics) {
        this.graphics = graphics;
    }

    /**
     * Antaa tiedon rivien lukumäärästä
     * 
     * @return rounds antaa rivien lukumäärän 
     */
    public int getRounds() {
        return rounds;
    }

    /**
     * Antaa tiedon listana, montako lukua on melkein kohdallaan rivillään
     * 
     * @return Kyseinen melkein tulosten lista annetaan paluuarvona
     */
    public ArrayList<Integer> getNumAlmost() {
        return almost;
    }

    /**
     * Antaa tiedon listana, montako lukua on oikein kohdallaan rivillään
     * 
     * @return Kyseinen oikein tulosten lista annetaan paluuarvona
     */
    public ArrayList<Integer> getNumCorrect() {
        return correct;
    }

    /**
     * Antaa tiedon listana, millaisia merkkejä on syötetty
     * 
     * @return Kyseinen lista sisältää syötetyt merkit
     */
    public ArrayList<Character> getMarks() {
        return marks;
    }

    /**
     * Luo erilliset rivit ja arpoo niistä yhden, jota käyttäjän on arvailtava
     * 
     * @return Palauttaa arvattavan rivin 
     */
    public Row randomRow() {
        DifferentRows rowMaker = new DifferentRows();
        ArrayList<Row> combinations = rowMaker.differentRows();
        int combination = random.nextInt(combinations.size());
        correctRow = combinations.get(combination);
        return correctRow;
    }

    /**
     * Tyhjentää peli statuksen, mikä tarvitaan uuden pelin aloittamiseen
     */
    private void startNewGame() {
        this.correctRow = randomRow();
        if (gameState.isAddGames()) {
            gameState.addGames();
        }
        gameState.reset();
        rounds = 0;
        marks.clear();
        amount = 0;
        correct.clear();
        almost.clear();

        attempts.clearAttempts();
        graphics.repaint();
    }

    /**
     * Tarkastaa pelitilanteen jokaisen syötetyn rivin jälkeen
     * 
     * @param corrector Tarkastaa merkkirivien oikeellisuuden
     */
    private void checkState(Corrector corrector) {
        correct.add(corrector.getCorrect());
        almost.add(corrector.getAlmost());
        if (corrector.getCorrect() == 4) {
            gameState.setWin(true);
        }
        rounds++;
        amount = 0;
        graphics.repaint();
    }

    /**
     * Ei käytössä
     * 
     * @param e Ei käytössä
     */
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Reagoi näppäimistön painalluksiin ja pitää näin pelin kulkua yllä, ottaa
     * käyttäjältä syötettä, jota vertaillaan oikeaan riviin.
     * 
     * @param e Painettu nappula
     */
    public void keyPressed(KeyEvent e) {

        char p = e.getKeyChar();

        //Jos painetaan Q:ta ohjelma sammuu
        if (p == 'q') {
            System.exit(0);
        }

        //Arpoo ensimmäisen rivin, kun pelejä pelattu 0
        if (rounds == 0 && gameState.getGames() == 0) {
            this.correctRow = randomRow();
        }

        //Käynnistää uuden pelin, jos painetaan r-kirjainta
        if ((p == 'r' && gameState.getGames() >= 0 && marks.size() > 0)) {
            this.startNewGame();
        }

        if (rounds == 9 || gameState.isWin()) {
            gameState.setNewGame(true);
        }

        //Tallentaa painetut merkit
        if (p == '0' || p == '1' || p == '2' || p == '3' || p == '4' || p == '5') {
            if (!gameState.isNewGame()) {
                marks.add(p);
                String row = "" + p;
                if (amount == 0) {
                    first = Integer.parseInt(row);
                }
                if (amount == 1) {
                    second = Integer.parseInt(row);
                }
                if (amount == 2) {
                    third = Integer.parseInt(row);
                }
                if (amount == 3) {
                    fourth = Integer.parseInt(row);
                }
                amount++;
                graphics.repaint();
            }

        }
        if (amount == 4) {
            this.attempt = new Row(first, second, third, fourth);
            attempts.addAttempt(attempt);
            Corrector corrector = new Corrector(attempt, correctRow);
            checkState(corrector);
            attempts.printAttempts();
            amount = 0;
        }
    }

    /**
     * Ei käytössä
     * 
     * @param e Ei käytössä 
     */
    public void keyReleased(KeyEvent e) {
    }
}
