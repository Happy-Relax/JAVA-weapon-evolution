/**
 * Created by liujia on 1/9/16.
 */
public class AmorFactory {
    public Armor createArmor() {
        return new NullArmor();
    }


    public Armor createArmor(String name, int defensivePower) {
        return new RealArmor(name,defensivePower);
    }
}
