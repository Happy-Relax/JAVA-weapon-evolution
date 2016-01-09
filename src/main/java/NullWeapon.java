/**
 * Created by liujia on 1/9/16.
 */
public class NullWeapon extends Weapon{

    @Override
    public int getAttackerForce() {
        return 0;
    }

    @Override
    public String getWeaponName() {
        return "";
    }
}
