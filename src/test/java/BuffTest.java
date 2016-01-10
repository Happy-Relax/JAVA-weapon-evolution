import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by liujia on 1/10/16.
 */
public class BuffTest {
    @Test
    public void should_solider_with_critialBuffWeapon_attack_player_return_buff_message(){
        Weapon swort=new WeaponFactory().createWeapon("利剑",2,new BuffFactory().createBuff("critial"));
        Armor nullArmor=new AmorFactory().createArmor();
        Solider tom=new Solider("Tom",20,2,swort,nullArmor);
        Player jerry=new Player("Jerry",20,2);
        assertThat(jerry.attackedBy(tom),is("战士Tom用利剑攻击了普通人Jerry,Tom发动了全力一击,Jerry受到了12点伤害,Jerry剩余生命：8."));
    }
}
