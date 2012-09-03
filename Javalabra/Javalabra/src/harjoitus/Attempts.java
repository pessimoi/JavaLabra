package harjoitus;

import java.util.*;

/**
 * Attempts luokka pitää kirjaa käyttäjän syöttämistä arvauksista
 */
public class Attempts {

    private ArrayList<Row> list = new ArrayList<Row>();

    /**
     * Metodi lisää käyttäjän antaman arvauksen listaan
     * @param attempt  Käyttäjän antama arvaus
     */
    public void addAttempt(Row attempt) {
        list.add(attempt);
    }

    /**
     * Metodi tulostaa listan sisällön, jotta aiemmat arvaukset näkyisi.
     */
    public void printAttempts() {
        System.out.print("Arvaukset: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println("");
    }

    /*
     * Metodi tyhjentää listan sisällön.
     */
    public void clearAttempts() {
        list.clear();
    }

    /**
     * 
     * @param i indeksi, josta halutaan arvaus
     * @return palauttaa tietyn arvauksen listasta
     */
    public Row getAttempt(int i) {
        return list.get(i);
    }
}
