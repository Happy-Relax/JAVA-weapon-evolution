import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by liujia on 1/10/16.
 */
public class ControlBuffTest {
    Buff dizziness=new BuffFactory().createBuff("dizziness",0);
    @Test
    public void should_getCritialRate_return_1_when_not_a_critial_buff(){

        assertThat(dizziness.getCritialRate(),is(1));
    }
    @Test
    public void should_getInstantDamageMessage_return_null_when_not_a_Instant_buff(){

        assertThat(dizziness.getInstantDamageMessage(),is(""));
    }
    @Test
    public void should_getBuffMessage_return_what_kind_of_buff(){
        assertThat(dizziness.getBuffMessage(),is("晕倒了"));
    }
    @Test
    public void should_getDelayDamagePoint_return_how_many_damage_when_a_delayDamage_buff(){
        assertThat(dizziness.getDelayDamagePoint(),is(0));
    }
    @Test
    public void should_getDelayDamageMessage_return_what_kind_of_damage(){
        assertThat(dizziness.getDelayDamageMessage(),is("晕倒了,无法攻击"));
    }


}
