/**
 * Created by liujia on 1/9/16.
 */
public class RealArmor extends Armor {

    public RealArmor(String name, int defensivePower) {
        this.armorName =name;
        this.defensivePower=defensivePower;

    }

    @Override
    public int getDefensivePower() {
        return this.defensivePower;
    }

    @Override
    public String getName() {
        return armorName;
    }
}
