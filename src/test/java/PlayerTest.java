import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by liujia on 1/7/16.
 */
public class PlayerTest {
    @Test
    public void should_attackedby_lose_blood(){
        int defensivePower=1;
        String name="Tom";
        int blood=100;
        int attackForce=20;
        Player playerTom=new Player(name,blood,attackForce,defensivePower);
        Player playerJerry=new Player("Jerry",100,10,1);
        playerTom.attackedBy(playerJerry);
        assertThat(playerTom.getblood(),is(91));
    }
    @Test
    public void should_attackedby_not_lose_blood_when_attacker_attackForce_less_than_attackeder(){
        Player playerTom=new Player("Tom", 100, 20, 11);
        Player playerJerry=new Player("Jerry",100,10,1);
        playerTom.attackedBy(playerJerry);
        assertThat(playerTom.getblood(),is(100));
    }
    @Test
    public void should_attackedby_print_when_blood_become_zero(){
        PrintStream fakedOut = mock(PrintStream.class);
        Player playerTom=new Player("Tom", 9, 20, 1,fakedOut);
        Player playerJerry=new Player("Jerry",100,10,1);

        playerTom.attackedBy(playerJerry);
        verify(fakedOut).println("Tom被打败了.");

    }

}
