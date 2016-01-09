import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by liujia on 1/8/16.
 */
public class GameTest {
    private PrintStream fakedOut;
    @Before
    public void setUp() throws Exception {
        fakedOut = mock(PrintStream.class);
    }
    @Test
    public void should_main_print_name_hurt_loseblood_and_blood(){

    }
    @Test
    public void should_attackedby_print_lose_blood_and_game_print_loser(){
        Player reactor ;
        Player attacker;

        reactor=mock(Player.class);
        attacker=mock(Player.class);

        when(reactor.attackedBy(attacker)).thenReturn("Jerry攻击了Tom,Tom受到了10点伤害,Tom剩余生命：-2.");
        when(reactor.getBlood()).thenReturn(8).thenReturn(-2);
        when(attacker.getBlood()).thenReturn(100);
        when(reactor.getName()).thenReturn("Tom");
        when(attacker.getName()).thenReturn("Jerry");

        Game game=new Game(fakedOut);
        game.attackEachOther(attacker,reactor);

        InOrder inOrder = inOrder(fakedOut);
        inOrder.verify(fakedOut).println("Jerry攻击了Tom,Tom受到了10点伤害,Tom剩余生命：-2.");
        inOrder.verify(fakedOut).println("Tom被击败了.");

    }
    @Test
    public void should_attackedby_print_name_loseblood_and_print_loser_when_one_of_player_blood_become_zero(){

        Player playerTom=new Player("Tom", 20, 9);
        Player playerJerry=new Player("Jerry",10,8);

        playerJerry=mock(Player.class);
        playerTom=mock(Player.class);

        when(playerTom.attackedBy(playerJerry)).thenReturn("Jerry攻击了Tom,Tom受到了8点伤害,Tom剩余生命：12.").thenReturn("Jerry攻击了Tom,Tom受到了8点伤害,Tom剩余生命：4.");
        when(playerJerry.attackedBy(playerTom)).thenReturn("Tom攻击了Jerry,Jerry受到了9点伤害,Jerry剩余生命：1.").thenReturn("Tom攻击了Jerry,Jerry受到了9点伤害,Jerry剩余生命：-8.");
        when(playerJerry.getBlood()).thenReturn(10).thenReturn(1).thenReturn(-8);
        when(playerTom.getBlood()).thenReturn(20).thenReturn(12).thenReturn(4);
        when(playerJerry.getName()).thenReturn("Jerry");
        when(playerTom.getName()).thenReturn("Tom");

        Game game=new Game(fakedOut);
        game.attackEachOther(playerJerry,playerTom);


        InOrder inOrder = inOrder(fakedOut);
        inOrder.verify(fakedOut).println("Jerry攻击了Tom,Tom受到了8点伤害,Tom剩余生命：12.");
        inOrder.verify(fakedOut).println("Tom攻击了Jerry,Jerry受到了9点伤害,Jerry剩余生命：1.");
        inOrder.verify(fakedOut).println("Jerry攻击了Tom,Tom受到了8点伤害,Tom剩余生命：4.");
        inOrder.verify(fakedOut).println("Tom攻击了Jerry,Jerry受到了9点伤害,Jerry剩余生命：-8.");
        inOrder.verify(fakedOut).println("Jerry被击败了.");
    }

    @Test
    public void should_return_in_first_if_and_print_loser(){

        Player playerTom=new Player("Tom", 20, 9);
        Player playerJerry=new Player("Jerry",10,8);

        playerJerry=mock(Player.class);
        playerTom=mock(Player.class);

        when(playerJerry.getName()).thenReturn("Jerry");
        when(playerTom.getName()).thenReturn("Tom");
        when(playerJerry.getBlood()).thenReturn(0);
        Game game=new Game(fakedOut);
        game.attackEachOther(playerJerry,playerTom);


        InOrder inOrder = inOrder(fakedOut);
        inOrder.verify(fakedOut).println("Jerry被击败了.");
    }
    @Test
    public void should_return_in_second_if_and_print_loser(){

        Player playerTom=new Player("Tom", 20, 9);
        Player playerJerry=new Player("Jerry",10,8);

        playerJerry=mock(Player.class);
        playerTom=mock(Player.class);

        when(playerJerry.getName()).thenReturn("Jerry");
        when(playerTom.getName()).thenReturn("Tom");

        when(playerJerry.getBlood()).thenReturn(10);
        when(playerTom.getBlood()).thenReturn(0);

        when(playerTom.attackedBy(playerJerry)).thenReturn("first_attack_print");

        Game game=new Game(fakedOut);
        game.attackEachOther(playerJerry,playerTom);


        InOrder inOrder = inOrder(fakedOut);
        inOrder.verify(fakedOut).println("first_attack_print");
        inOrder.verify(fakedOut).println("Tom被击败了.");
    }
    @Test
    public void should_return_in_third_if_and_print_loser(){

        Player playerTom=new Player("Tom", 20, 9);
        Player playerJerry=new Player("Jerry",10,8);

        playerJerry=mock(Player.class);
        playerTom=mock(Player.class);

        when(playerJerry.getName()).thenReturn("Jerry");
        when(playerTom.getName()).thenReturn("Tom");

        when(playerJerry.getBlood()).thenReturn(10,0);
        when(playerTom.getBlood()).thenReturn(10);

        when(playerTom.attackedBy(playerJerry)).thenReturn("first_attack_print");
        when(playerJerry.attackedBy(playerTom)).thenReturn("second_attack_print");

        Game game=new Game(fakedOut);
        game.attackEachOther(playerJerry,playerTom);

        InOrder inOrder = inOrder(fakedOut);
        inOrder.verify(fakedOut).println("first_attack_print");
        inOrder.verify(fakedOut).println("second_attack_print");
        inOrder.verify(fakedOut).println("Jerry被击败了.");
    }

}
