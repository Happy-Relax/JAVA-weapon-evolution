import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by liujia on 1/9/16.
 */
public class FrostBuffTest {
    Buff frost=new BuffFactory().createBuff("frost");
    @Test
    public void should_getCritialRate_return_1_when_not_a_critial_buff(){

        assertThat(frost.getCritialRate(),is(1));
    }
    @Test
    public void should_getInstantDamageMessage_return_null_when_not_a_Instant_buff(){

        assertThat(frost.getInstantDamageMessage(),is(""));
    }
    @Test
    public void should_getBuffMessage_return_what_kind_of_buff(){
        assertThat(frost.getBuffMessage(),is("冻僵了"));
    }
    @Test
    public void should_getDelayDamagePoint_return_how_many_damage_when_a_delayDamage_buff(){
        assertThat(frost.getDelayDamagePoint(),is(0));
    }
    @Test
    public void should_getDelayDamageMessage_return_what_kind_of_damage(){
        assertThat(frost.getDelayDamageMessage(),is("冻的直哆嗦，没有击中"));
    }

}
