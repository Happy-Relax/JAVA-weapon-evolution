import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by liujia on 1/9/16.
 */
public class ArmorFactoryTest {
    @Test
    public void should_create_a_NullAmor_object_when_get_nothing(){
        assertThat(new AmorFactory().createArmor().getClass().getName(),is("NullArmor"));
    }
    @Test
    public void should_create_a_NullAmor_object_when_get_name_and_defensivePower(){
        assertThat(new AmorFactory().createArmor("cloth",1).getClass().getName(),is("RealArmor"));
    }
}
