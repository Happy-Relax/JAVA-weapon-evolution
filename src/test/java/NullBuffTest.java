import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by liujia on 1/10/16.
 */
public class NullBuffTest {
    Buff lull=new BuffFactory().createBuff();
    @Test
    public void should_getCritialRate_return_3_when_is_a_critial_buff(){

        assertThat(lull.getCritialRate(),is(1));
    }
    @Test
    public void should_getInstantDamageMessage_return_message_when_is_a_Instant_buff(){

        assertThat(lull.getInstantDamageMessage(),is(""));
    }
    @Test
    public void should_getBuffMessage_return_what_kind_of_buff(){
        assertThat(lull.getBuffMessage(),is(""));
    }
    @Test
    public void should_getDelayDamagePoint_return_how_many_damage_when_a_delayDamage_buff(){
        assertThat(lull.getDelayDamagePoint(),is(0));
    }
    @Test
    public void should_getDelayDamageMessage_return_what_kind_of_damage(){
        assertThat(lull.getDelayDamageMessage(),is(""));
    }

}
