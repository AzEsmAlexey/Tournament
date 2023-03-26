import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TournamentTests {

    @Test
    public void testFirstPlayerWins() {
        GameManager game = new GameManager();
        Player player1 = new Player(01, "Senya", 33);
        Player player2 = new Player(02, "Sanya", 22);
        game.register(player1);
        game.register(player2);

        int expected =  1;
        int actual = game.round("Senya", "Sanya");

        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void testSecondPlayerWins() {
        GameManager game = new GameManager();
        Player player1 = new Player(01, "Senya", 11);
        Player player2 = new Player(02, "Sanya", 22);
        game.register(player1);
        game.register(player2);

        int expected =  2;
        int actual = game.round("Senya", "Sanya");

        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void testDrawnGame() {
        GameManager game = new GameManager();
        Player player1 = new Player(01, "Senya", 22);
        Player player2 = new Player(02, "Sanya", 22);
        game.register(player1);
        game.register(player2);

        int expected =  0;
        int actual = game.round("Senya", "Sanya");

        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void testFirstPlayerIsNotRegistered() {
        GameManager game = new GameManager();
        Player player1 = new Player(01, "Senya", 22);
        Player player2 = new Player(02, "Sanya", 19);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Senya","Sanya");
        } );

    }
    @Test
    public void testSecondPlayerIsNotRegistered() {
        GameManager game = new GameManager();
        Player player1 = new Player(01, "Senya", 22);
        Player player2 = new Player(02, "Sanya", 33);
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Senya","Sanya");
        } );

    }
    @Test
    public void testBothPlayersIsNotRegistered() {
        GameManager game = new GameManager();
        Player player1 = new Player(01, "Senya", 22);
        Player player2 = new Player(02, "Sanya", 44);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Senya","Sanya");
        } );

    }


}
