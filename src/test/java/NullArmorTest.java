import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by liujia on 1/9/16.
 */
public class NullArmorTest {
    @Test
    public void should_get_name_is_null(){
        assertThat(new NullArmor().getName(),is(""));
    }
    @Test
    public void should_get_defensivePower_is_zero(){
        assertThat(new NullArmor().getDefensivePower(),is(0));
    }
}
