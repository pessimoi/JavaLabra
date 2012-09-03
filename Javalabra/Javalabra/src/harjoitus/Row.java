package harjoitus;

/**
 * Luodaan Row luokka jonka avulla voidaan tehdä Row olioita, jotka sisältävät
 * neljä erillistä arvoa välillä 0-6 ja tallentaa ne listaan. Kyseistä luokkaa 
 * käytetään koneen arpoman rivin ylläpitoon ja käyttäjän arvaamien rivien 
 * ylläpitämiseen
 */
public class Row {

    private int first;
    private int second;
    private int third;
    private int fourth;
    private int[] row;

    /**
     * Alustaa Row olion. Tallentaa tauluun neljä saatua arvoa.
     * 
     * @param first Row olion eka int tyyppinen arvo
     * @param second Row olion toinen int tyyppinen arvo
     * @param third Row olion kolmas int tyyppinen arvo
     * @param fourth Row olion neljäs int tyyppinen arvo
     */
    public Row(int first, int second, int third, int fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;

        row = new int[]{first, second, third, fourth};
    }

    /**
     * Palauttaa Row olion neljästä luvusta halutun luvun
     * 
     * @param which Sisältää luvun indeksin
     * @return palauttaa taulukosta kyseisen Row olion luvun
     */
    public int value(int which) {
        return row[which];
    }

    /**
     * Antaa syötettä
     * 
     * @return palauttaa syötteenä Row olion sisältämät numerot
     */
    public String toString() {
        return "" + first + second + third + fourth;
    }
}
