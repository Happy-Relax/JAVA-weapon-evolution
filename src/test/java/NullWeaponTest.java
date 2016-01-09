import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by liujia on 1/9/16.
 */
public class NullWeaponTest {
    @Test
    public void should_get_name_is_null(){
        assertThat(new NullWeapon().getWeaponName(),is(""));
    }
    @Test
    public void should_get_attackForce_is_zero(){
        assertThat(new NullWeapon().getAttackerForce(),is(0));
    }
}
