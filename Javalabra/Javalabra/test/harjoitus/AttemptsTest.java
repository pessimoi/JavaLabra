/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitus;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 *
 * @author admin
 */
public class AttemptsTest {

    Random random = new Random();

    public AttemptsTest() {
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
    public void attemptAndReturnFirst() {
        Attempts attempts = new Attempts();
        Row attempt = new Row(0, 0, 0, 0);
        attempts.addAttempt(attempt);
        assertEquals(attempts.getAttempt(0), attempt);
    }

    @Test
    public void attemptAndReturnSecond() {
        Attempts attempts = new Attempts();
        Row attempt = new Row(1, 1, 0, 0);
        attempts.addAttempt(attempt);
        assertEquals(attempts.getAttempt(0), attempt);
    }

    @Test
    public void attemptAndReturnManyFirst() {
        Attempts attempts = new Attempts();
        Row attemtFirst = new Row(1, 1, 0, 0);
        Row attemptSecond = new Row(0, 0, 0, 0);
        attempts.addAttempt(attemtFirst);
        attempts.addAttempt(attemptSecond);
        assertEquals(attempts.getAttempt(1), attemptSecond);
    }

    @Test
    public void attemptAndReturnManySecond() {
        Attempts attempts = new Attempts();
        Row attemptFirst = new Row(1, 1, 0, 0);
        Row attemptSecond = new Row(0, 0, 0, 0);
        Row attemptThird = new Row(1, 2, 3, 4);
        attempts.addAttempt(attemptFirst);
        attempts.addAttempt(attemptSecond);
        attempts.addAttempt(attemptThird);
        assertEquals(attempts.getAttempt(0), attemptFirst);
        assertEquals(attempts.getAttempt(1), attemptSecond);
        assertEquals(attempts.getAttempt(2), attemptThird);
    }
}
