import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by liujia on 1/10/16.
 */
public class CritialBuffTest {
    Buff critial=new BuffFactory().createBuff("critial");
    @Test
    public void should_getCritialRate_return_3_when_is_a_critial_buff(){

        assertThat(critial.getCritialRate(),is(3));
    }
    @Test
    public void should_getInstantDamageMessage_return_message_when_is_a_Instant_buff(){

        assertThat(critial.getInstantDamageMessage(),is("发动了全力一击,"));
    }
    @Test
    public void should_getBuffMessage_return_what_kind_of_buff(){
        assertThat(critial.getBuffMessage(),is(""));
    }
    @Test
    public void should_getDelayDamagePoint_return_how_many_damage_when_a_delayDamage_buff(){
        assertThat(critial.getDelayDamagePoint(),is(0));
    }
    @Test
    public void should_getDelayDamageMessage_return_what_kind_of_damage(){
        assertThat(critial.getDelayDamageMessage(),is(""));
    }


}
