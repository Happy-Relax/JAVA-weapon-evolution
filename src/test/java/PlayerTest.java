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
        String name="Tom";
        int blood=100;
        int attackForce=20;
        Player playerTom=new Player(name,blood,attackForce);
        Player playerJerry=new Player("Jerry",100,10);
        playerTom.attackedBy(playerJerry);
        assertThat(playerTom.getBlood(),is(90));
    }
//    @Test
//    public void should_attackedby_not_lose_blood_when_attacker_attackForce_less_than_attackeder(){
//        Player playerTom=new Player("Tom", 100, 20, fakedOut);
//        Player playerJerry=new Player("Jerry",100,10, fakedOut);
//        playerTom.attackedBy(playerJerry);
//        assertThat(playerTom.getBlood(),is(100));
//    }
    @Test
    public void should_attackedby_return_name_loseblood_blood(){
        Player playerTom=new Player("Tom", 8, 20);
        Player playerJerry=new Player("Jerry",100,10);

        assertThat(playerTom.attackedBy(playerJerry),is("Jerry攻击了Tom,Tom受到了10点伤害,Tom剩余生命：-2."));


    }



    @Test
    public void should_profession_is_people(){

        Player playerTom=new Player("Tom", 20, 9);

        assertThat(playerTom.getProfession(),is("普通人"));

    }



}
