import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
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
        assertThat(playerTom.getHealthPoint(),is(90));
    }
    @Test
    public void should_attackedby_return_name_loseblood_blood(){
        Player playerTom=new Player("Tom", 8, 20);
        Player playerJerry=new Player("Jerry",100,10);

        assertThat(playerTom.attackedBy(playerJerry),is("普通人Jerry攻击了普通人Tom,Tom受到了10点伤害,Tom剩余生命：-2."));


    }


    @Test
    public void should_profession_is_people(){
        Player playerTom=new Player("Tom", 20, 9);
        assertThat(playerTom.getProfession(),is("普通人"));
    }


    @Test
    public void should_return_null_when_reactor_has_no_deBuff(){
        Weapon swort=new WeaponFactory().createWeapon("毒剑",2,new BuffFactory().createBuff("poison",2));
        Armor nullArmor=new AmorFactory().createArmor();
        Solider tom=new Solider("Tom",20,2,swort,nullArmor);
        Player jerry=new Player("Jerry",20,2);

        assertThat(jerry.sufferDeBuff(),is(""));
    }
    @Test
    public void should_delete_deBuff_when_reactor_has_a_deBuff(){
        Weapon swort=new WeaponFactory().createWeapon("毒剑",2,new BuffFactory().createBuff("poison",2));
        Armor nullArmor=new AmorFactory().createArmor();
        Solider tom=new Solider("Tom",20,2,swort,nullArmor);
        Player jerry=new Player("Jerry",20,2);
        jerry.attackedBy(tom);
        jerry.sufferDeBuff();

        assertThat(jerry.sufferDeBuff(),is(""));
    }
    @Test
    public void should_return_poison_delayDeBuff_message_this_deBuff_when_reactor_has_a_deBuff(){
        Weapon swort=new WeaponFactory().createWeapon("毒剑",2,new BuffFactory().createBuff("poison",2));
        Armor nullArmor=new AmorFactory().createArmor();
        Solider tom=new Solider("Tom",20,2,swort,nullArmor);
        Player jerry=new Player("Jerry",20,2);
        jerry.attackedBy(tom);
        assertThat(jerry.sufferDeBuff(),is("Jerry受到2点毒性伤害,Jerry剩余生命:14"));
    }
    @Test
    public void should_return_frost_delayDeBuff_message_this_deBuff_when_reactor_has_a_deBuff(){
        Weapon swort=new WeaponFactory().createWeapon("寒冰剑",2,new BuffFactory().createBuff("frost",2));
        Armor nullArmor=new AmorFactory().createArmor();
        Solider tom=new Solider("Tom",20,2,swort,nullArmor);
        Player jerry=new Player("Jerry",20,2);
        jerry.attackedBy(tom);
        assertThat(jerry.sufferDeBuff(),is("Jerry冻的直哆嗦,没有击中"));
    }


}
