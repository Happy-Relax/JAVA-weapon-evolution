import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by liujia on 1/9/16.
 */
public class WeaponFactoryTest {
    @Test
    public void should_create_a_NullWeapon_object_when_get_nothing(){
        assertThat(new WeaponFactory().createWeapon().getClass().getName(),is("NullWeapon"));
    }
    @Test
    public void should_create_a_NullWeapon_object_when_get_name_and_defensivePower(){
        assertThat(new WeaponFactory().createWeapon("swort",1).getClass().getName(),is("RealWeapon"));
    }
}
