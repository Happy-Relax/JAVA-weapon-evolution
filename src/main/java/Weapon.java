/**
 * Created by liujia on 1/8/16.
 */
public class Weapon {
    private final String weaponName;
    private final int attackForce;
    private int attackerForce;

    public Weapon(String weaponName, int attackForce) {
        this.weaponName=weaponName;
        this.attackForce=attackForce;
    }

    public int getAttackerForce() {
        return attackerForce;
    }
}
