package harjoitus;

/**
 * Pitää huolta pelitilanteesta, ja antaa tärkeätä tietoa siitä, jotta graafiset 
 * ominaisuudet toimivat kunnolla
 */
public class GameState {

    private boolean win = false;
    private boolean newGame = false;
    private boolean isNewGame = true;
    private int games = 0;
    private int wins = 0;

    /**
     * Palauttaa arvon jonka perusteella uusi peli alkaa
     * 
     * @return Arvo uudesta pelistä
     */
    public boolean isNewGame() {
        return newGame;
    }

    /**
     * Palauttaa arvon jonka perusteella peli on voitettu
     * 
     * @return Arvo voitosta
     */
    public boolean isWin() {
        return win;
    }

    /**
     * Kasvattaa pelien lukumäärää totuusarvon perusteella
     * 
     * @return Arvo pelien määrän kasvattamisesta
     */
    public boolean isAddGames() {
        return isNewGame;
    }

    /**
     * Katsoo arvon perusteella aloitetaanko uusi peli
     * 
     * @param state Arvo kertoo onko uusi peli aloitettava
     */
    public void setGames(boolean state) {
        isNewGame = state;
    }

    /**
     * Uuden pelin alkaessa asettaa arvot perus asemiin
     */
    void reset() {
        newGame = false;
        win = false;
        isNewGame = true;
    }

    /**
     * Arvo kertoo onko voittojen määrää kasvatettava
     * 
     * @param state Kerto onko voittoja kasvatetava
     */
    void setWin(boolean state) {
        win = state;
    }

    /**
     * Antaa komennon nollata tilanteet uuden pelin alkaessa
     * @param state Arvosta näkee onko uusi peli aloitettava
     */
    void setNewGame(boolean state) {
        newGame = state;
    }

    /**
     * Antaa pelien lukumäärän
     * @return Paluuarvosta näke pelattujen pelien lukumäärän
     */
    int getGames() {
        return games;
    }

    /**
     * Kasvatta pelien määrää
     */
    void addGames() {
        ++games;
    }

    /**
     * Antaa voittojen lukumäärän
     * 
     * @return Paluuarvosta saadaan voittojen lukumäärä 
     */
    int getWins() {
        return wins;
    }

    /**
     * Jos peli on voitettu, kasvattaa pelien ja voittojen lukumäärää
     */
    void wonGame() {
        System.out.println("Voitit!");
        wins++;
        games++;
    }

    /**
     * Jos peli on hävitty, kasvattaa pelien lukumäärää
     */
    void lostGame() {
        System.out.println("Hävisit!");
        games++;
    }
}
