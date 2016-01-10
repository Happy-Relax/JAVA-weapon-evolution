import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by liujia on 1/9/16.
 */
public class DelayBuffTest {
    @Test
    public void should_getCritialRate_return_1_when_not_a_critial_buff(){
        Buff poison=new BuffFactory().createBuff("poison",2);

        assertThat(poison.getCritialRate(),is(1));
    }
    @Test
    public void should_getInstantDamageMessage_return_null_when_not_a_Instant_buff(){
        Buff poison=new BuffFactory().createBuff("poison",2);
        assertThat(poison.getInstantDamageMessage(),is(""));
    }
    @Test
    public void should_getBuffMessage_return_what_kind_of_buff(){
        Buff poison=new BuffFactory().createBuff("poison",2);
        assertThat(poison.getBuffMessage(),is("中毒了"));
    }
    @Test
    public void should_getDelayDamagePoint_return_how_many_damage_when_a_delayDamage_buff(){
        Buff poison=new BuffFactory().createBuff("poison",2);
        assertThat(poison.getDelayDamagePoint(),is(2));
    }
    @Test
    public void should_getDelayDamageMessage_return_what_kind_of_damage(){
        Buff poison=new BuffFactory().createBuff("poison",2);
        assertThat(poison.getDelayDamageMessage(),is("点毒性伤害"));
    }
}

