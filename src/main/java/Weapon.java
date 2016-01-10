/**
 * Created by liujia on 1/8/16.
 */
public abstract class Weapon {
    protected String weaponName;
    protected   int attackForce;
    protected Buff buff;

    public abstract int getAttackerForce();
    public abstract String getWeaponName();

    public abstract Buff getBuff();
}
