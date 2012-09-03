package harjoitus;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class CorrectorTest {

    Random random = new Random();

    public CorrectorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void matchRowMarkFirst() {
        int first = 0;
        int second = 1;
        int third = 2;
        int fourth = 3;
        Row row = new Row(first, second, third, fourth);
        assertEquals(row.value(0), first);
        assertEquals(row.value(1), second);
        assertEquals(row.value(2), third);
        assertEquals(row.value(3), fourth);
    }

    @Test
    public void matchRowMarkSecond() {
        int first = 4;
        int second = 3;
        int third = 2;
        int fourth = 1;
        Row row = new Row(first, second, third, fourth);
        assertEquals(row.value(0), first);
        assertEquals(row.value(1), second);
        assertEquals(row.value(2), third);
        assertEquals(row.value(3), fourth);
    }

    @Test
    public void matchRowMarkThird() {
        int first = 0;
        int second = 0;
        int third = 0;
        int fourth = 0;
        Row row = new Row(first, second, third, fourth);
        assertEquals(row.value(0), first);
        assertEquals(row.value(1), first);
        assertEquals(row.value(2), first);
        assertEquals(row.value(3), first);
    }

    @Test
    public void almostRightMiss() {
        boolean onnistuu = true;
        for (int i = 0; i < 1000000; i++) {
            int eka = random.nextInt(6);
            int toka = random.nextInt(6);
            int kolmas = random.nextInt(6);
            int neljas = random.nextInt(6);
            Row oikeaRivi = new Row(eka, toka, kolmas, neljas);
            eka = random.nextInt(6);
            toka = random.nextInt(6);
            kolmas = random.nextInt(6);
            neljas = random.nextInt(6);
            Row arvaus = new Row(eka, toka, kolmas, neljas);
            Corrector tarkastaja = new Corrector(oikeaRivi, arvaus);

            if (tarkastaja.getMiss() + tarkastaja.getAlmost() + tarkastaja.getCorrect() != 4) {
                onnistuu = false;
            }
        }
        assertTrue(onnistuu);
    }

    @Test
    public void correctionFirst() {
        Row attempt = new Row(0, 0, 1, 0);
        Row correctRow = new Row(0, 0, 3, 1);
        Corrector tarkastaja = new Corrector(attempt, correctRow);
        assertEquals(2, tarkastaja.getCorrect());
        assertEquals(1, tarkastaja.getAlmost());
        assertEquals(1, tarkastaja.getMiss());
    }

    @Test
    public void correctionSecond() {
        Row attempt = new Row(2, 3, 4, 5);
        Row correctRow = new Row(5, 4, 3, 2);
        Corrector corrector = new Corrector(attempt, correctRow);
        assertEquals(0, corrector.getCorrect());
        assertEquals(4, corrector.getAlmost());
        assertEquals(0, corrector.getMiss());
    }

    @Test
    public void correctionThird() {
        Row attempt = new Row(2, 3, 4, 2);
        Row correctRow = new Row(2, 3, 4, 2);
        Corrector corrector = new Corrector(attempt, correctRow);
        assertEquals(4, corrector.getCorrect());
        assertEquals(0, corrector.getAlmost());
        assertEquals(0, corrector.getMiss());
    }

    @Test
    public void correctionFourth() {
        Row attempt = new Row(2, 3, 4, 2);
        Row correctRow = new Row(2, 4, 3, 2);
        Corrector corrector = new Corrector(attempt, correctRow);
        assertEquals(2, corrector.getCorrect());
        assertEquals(2, corrector.getAlmost());
        assertEquals(0, corrector.getMiss());
    }

    @Test
    public void correctionFifth() {
        Row attempt = new Row(1, 1, 1, 1);
        Row correctrow = new Row(0, 0, 0, 1);
        Corrector corrector = new Corrector(attempt, correctrow);
        assertEquals(1, corrector.getCorrect());
        assertEquals(0, corrector.getAlmost());
        assertEquals(3, corrector.getMiss());
    }
}
