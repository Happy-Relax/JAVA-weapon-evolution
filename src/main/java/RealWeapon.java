/**
 * Created by liujia on 1/9/16.
 */
public class RealWeapon extends Weapon{
    public RealWeapon(String name, int attackForce,Buff buff) {
        this.weaponName=name;
        this.attackForce=attackForce;
        this.buff=buff;
    }

    @Override
    public int getAttackerForce() {
        return this.attackForce;
    }

    @Override
    public String getWeaponName() {
        return this.weaponName;
    }

    @Override
    public Buff getBuff() {
        return this.buff;
    }


}
