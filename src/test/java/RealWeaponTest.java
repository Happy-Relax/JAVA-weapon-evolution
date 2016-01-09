import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by liujia on 1/9/16.
 */
public class RealWeaponTest{

    @Test
    public void should_getName_is_name(){
        assertThat(new RealWeapon("sword",0).getWeaponName(),is("sword"));
    }
    @Test
    public void should_getAtteckForce_is_atteckForce(){
        assertThat(new RealWeapon("sword",1).getAttackerForce(),is(1));
    }

}
