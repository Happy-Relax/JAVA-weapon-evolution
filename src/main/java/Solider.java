import java.io.PrintStream;

/**
 * Created by liujia on 1/8/16.
 */
public class Solider extends Player{
    private final Weapon weapon;
    private final Armor armor;
    private String profession;

    public Solider(String name, int blood, int attackForce, PrintStream fakedOut, Weapon weapon, Armor armor) {
        super(name,blood,attackForce);
        this.weapon=weapon;
        this.armor = armor;
        this.profession="战士";
    }

    public String attackedBy(Player attacker) {

        int loseBlood = attacker.getAttackForce()-this.getArmor().getDefensivePower();
        this.setBlood(this.getBlood() - loseBlood);
        return (attacker.getProfession()+attacker.getName() + "攻击了" +getProfession()+ this.getName() + "," + this.getName() + "受到了" + loseBlood + "点伤害," + this.getName() + "剩余生命：" + this.getBlood() + ".");


    }
    public Weapon getWeapon(){
        return weapon;
    }
    public String getProfession() {
        return profession;
    }

    public Armor getArmor() {
        return armor;
    }
}
