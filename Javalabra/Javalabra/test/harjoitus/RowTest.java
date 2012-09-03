package harjoitus;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class RowTest {

    Random random = new Random();

    public RowTest() {
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
    public void gameStatusEquals() {
        boolean done = true;
        for (int i = 0; i < 1000000; i++) {
            int first = random.nextInt(6);
            int second = random.nextInt(6);
            int third = random.nextInt(6);
            int fourth = random.nextInt(6);
            Row correctRow = new Row(first, second, third, fourth);
            first = random.nextInt(6);
            second = random.nextInt(6);
            third = random.nextInt(6);
            fourth = random.nextInt(6);
            Row attempt = new Row(first, second, third, fourth);
            Corrector corrector = new Corrector(correctRow, attempt);

            if (corrector.getMiss() + corrector.getAlmost() + corrector.getCorrect() != 4) {
                done = false;
            }
        }
        assertTrue(done);
    }
}
