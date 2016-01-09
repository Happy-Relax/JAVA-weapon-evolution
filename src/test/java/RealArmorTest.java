import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by liujia on 1/9/16.
 */
public class RealArmorTest {
    @Test
    public void should_getname_is_name(){
        assertThat(new RealArmor("cloth",0).getName(),is("cloth"));
    }
    @Test
    public void should_getDfensivePower_is_defensivePower(){
        assertThat(new RealArmor("cloth",0).getDefensivePower(),is(0));
    }
}
