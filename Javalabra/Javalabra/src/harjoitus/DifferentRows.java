package harjoitus;

import java.util.ArrayList;

/**
 * Luo eri Row yhdistelmät ja tallentaa ne listaan
 */
public class DifferentRows {

    /**
     * Metodi luo eri Row yhdistelmät ja tallentaa ne listaan
     * 
     * @return combinations Palauttaa listan jossa on kaikki yhdistelmät
     */
    public ArrayList<Row> differentRows() {

        ArrayList<Row> combinations = new ArrayList<Row>();

        int k = 0;
        int j = 0;
        int z = 0;
        int y = 0;


        while (k < 6) {
            j = 0;
            while (j < 6) {
                z = 0;
                while (z < 6) {
                    y = 0;
                    while (y < 6) {
                        Row newRow = new Row(k, j, z, y);
                        combinations.add(newRow);
                        y++;
                        if (y > 5) {
                            z++;
                        }
                        if (z > 5) {
                            j++;
                        }
                        if (j > 5) {
                            k++;
                        }
                    }
                }
            }
        }
        return combinations;
    }
}
