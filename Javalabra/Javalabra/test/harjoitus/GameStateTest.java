package harjoitus;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameStateTest {

    public GameStateTest() {
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
    public void gamesNone() {
        GameState gameState = new GameState();
        assertEquals(gameState.getGames(), 0);
    }

    @Test
    public void gamesAdded() {
        GameState gameState = new GameState();
        gameState.addGames();
        assertEquals(gameState.getGames(), 1);
    }

    @Test
    public void gamesAddedTwice() {
        GameState gameState = new GameState();
        gameState.addGames();
        gameState.addGames();
        assertEquals(gameState.getGames(), 2);
    }

    @Test
    public void winsGamesNone() {
        GameState gameState = new GameState();
        assertEquals(gameState.getGames(), 0);
        assertEquals(gameState.getWins(), 0);
    }

    @Test
    public void winsAdded() {
        GameState gameState = new GameState();
        gameState.wonGame();
        assertEquals(gameState.getGames(), 1);
        assertEquals(gameState.getWins(), 1);
    }

    @Test
    public void winsAddedTwice() {
        GameState gameState = new GameState();
        gameState.wonGame();
        gameState.wonGame();
        assertEquals(gameState.getGames(), 2);
        assertEquals(gameState.getWins(), 2);
    }

    @Test
    public void lostAdded() {
        GameState gameState = new GameState();
        gameState.lostGame();
        assertEquals(gameState.getGames(), 1);
        assertEquals(gameState.getWins(), 0);
    }

    @Test
    public void losingAddedTwice() {
        GameState gameState = new GameState();
        gameState.lostGame();
        gameState.lostGame();
        assertEquals(gameState.getGames(), 2);
        assertEquals(gameState.getWins(), 0);
    }

    @Test
    public void wonAndLost() {
        GameState gameState = new GameState();
        gameState.wonGame();
        gameState.lostGame();
        assertEquals(gameState.getGames(), 2);
        assertEquals(gameState.getWins(), 1);
    }
}
