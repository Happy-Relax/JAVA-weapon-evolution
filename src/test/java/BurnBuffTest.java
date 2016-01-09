import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by liujia on 1/9/16.
 */
public class BurnBuffTest {
    Buff burn=new BuffFactory().createBuff("burn");
    @Test
    public void should_getCritialRate_return_1_when_not_a_critial_buff(){

        assertThat(burn.getCritialRate(),is(1));
    }
    @Test
    public void should_getInstantDamageMessage_return_null_when_not_a_Instant_buff(){

        assertThat(burn.getInstantDamageMessage(),is(""));
    }
    @Test
    public void should_getBuffMessage_return_what_kind_of_buff(){
        assertThat(burn.getBuffMessage(),is("着火了"));
    }
    @Test
    public void should_getDelayDamagePoint_return_how_many_damage_when_a_delayDamage_buff(){
        assertThat(burn.getDelayDamagePoint(),is(2));
    }
    @Test
    public void should_getDelayDamageMessage_return_what_kind_of_damage(){
        assertThat(burn.getDelayDamageMessage(),is("点火焰伤害"));
    }

}
