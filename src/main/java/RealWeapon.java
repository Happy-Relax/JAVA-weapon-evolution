/**
 * Created by liujia on 1/9/16.
 */
public class RealWeapon extends Weapon{
    public RealWeapon(String name, int attackForce) {
        this.weaponName=name;
        this.attackForce=attackForce;
    }

    @Override
    public int getAttackerForce() {
        return this.attackForce;
    }

    @Override
    public String getWeaponName() {
        return this.weaponName;
    }
}
