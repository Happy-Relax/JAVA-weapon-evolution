import java.io.PrintStream;

/**
 * Created by liujia on 1/8/16.
 */
public class Solider extends Player{
    private final Weapon weapon;
    private final Amor amor;
    private String profession;

    public Solider(String name, int blood, int attackForce, PrintStream fakedOut, Weapon weapon, Amor amor) {
        super(name,blood,attackForce);
        this.weapon=weapon;
        this.amor=amor;
        this.profession="战士";
    }

    public String attackedBy(Player attacker) {
        int loseBlood = 0;
        if(attacker.getProfession()=="普通人"){
            loseBlood = attacker.getAttackForce() - this.getAmor().getdefensivePower();
        }
        else{
            if (attacker.getWeapon()!=null) {
                loseBlood = attacker.getAttackForce() - attacker.getWeapon().getAttackerForce() - this.getAmor().getdefensivePower();
            }
        }
        this.setBlood(this.getBlood() - loseBlood);
        return (attacker.getName() + "攻击了战士" + this.getName() + "," + this.getName() + "受到了" + loseBlood + "点伤害," + this.getName() + "剩余生命：" + this.getBlood() + ".");


    }
    public Weapon getWeapon(){
        return weapon;
    }
    public String getProfession() {
        return profession;
    }

    public Amor getAmor() {
        return amor;
    }
}
