import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by liujia on 1/7/16.
 */
public class PlayerTest {

    private PrintStream fakedOut;

    @Before
    public void setUp() throws Exception {
        fakedOut = mock(PrintStream.class);
    }

    @Test
    public void should_attackedby_lose_blood(){
        int defensivePower=1;
        String name="Tom";
        int blood=100;
        int attackForce=20;
        Player playerTom=new Player(name,blood,attackForce,defensivePower,fakedOut);
        Player playerJerry=new Player("Jerry",100,10,1,fakedOut);
        playerTom.attackedBy(playerJerry);
        assertThat(playerTom.getBlood(),is(91));
    }
    @Test
    public void should_attackedby_not_lose_blood_when_attacker_attackForce_less_than_attackeder(){
        Player playerTom=new Player("Tom", 100, 20, 11,fakedOut);
        Player playerJerry=new Player("Jerry",100,10,1,fakedOut);
        playerTom.attackedBy(playerJerry);
        assertThat(playerTom.getBlood(),is(100));
    }
    @Test
    public void should_attackedby_print_name_loseblood_blood(){
        Player playerTom=new Player("Tom", 100, 20, 1, fakedOut);
        Player playerJerry=new Player("Jerry",100,10,1, fakedOut);

        playerTom.attackedBy(playerJerry);
        verify(fakedOut).println("Jerry攻击了Tom,Tom受到了9点伤害,Tom剩余生命：91.");

    }

    @Test
    public void should_attackedby_print_loser_when_one_of_player_blood_become_zero(){
        Player playerTom=new Player("Tom", 8, 20, 1, fakedOut);
        Player playerJerry=new Player("Jerry",100,10,1, fakedOut);

        playerTom.attackedBy(playerJerry);
        verify(fakedOut).println("Tom被打败了.");
        InOrder inOrder = inOrder(fakedOut);
        inOrder.verify(fakedOut).println("Jerry攻击了Tom,Tom受到了9点伤害,Tom剩余生命：-1.");
        inOrder.verify(fakedOut).println("Tom被击败了.");

    }
    @Test
    public void should_attackedby_print_name_loseblood_and_print_loser_when_one_of_player_blood_become_zero(){

        Player playerTom=new Player("Tom", 20, 9, 0, fakedOut);
        Player playerJerry=new Player("Jerry",1,8,0, fakedOut);

//        playerTom.attackedBy(playerJerry);
//        playerJerry.attackedBy(playerTom);
//        playerTom.attackedBy(playerJerry);
        playerJerry.attackedBy(playerTom);
//        playerTom.attackedBy(playerJerry);


        InOrder inOrder = inOrder(fakedOut);
//        inOrder.verify(fakedOut).println("Jerry攻击了Tom,Tom受到了8点伤害,Tom剩余生命：12.");
//        inOrder.verify(fakedOut).println("Tom攻击了Jerry,Jerry受到了9点伤害,Jerry剩余生命：1.");
//        inOrder.verify(fakedOut).println("Jerry攻击了Tom,Tom受到了8点伤害,Tom剩余生命：4.");
        inOrder.verify(fakedOut).println("Tom攻击了Jerry,Jerry受到了9点伤害,Jerry剩余生命：-8.");
//        inOrder.verify(fakedOut).println("Jerry被击败了.");
    }

}
