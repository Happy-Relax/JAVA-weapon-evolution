/**
 * Created by liujia on 1/7/16.
 */
public class Player {
    private  String name;
    private int healthPoint;
    private  int attackForce;
    private String profession="普通人";

    public Player(String name, int healthPoint, int attackForce) {
        this.name=name;
        this.healthPoint = healthPoint;
        this.attackForce=attackForce;
    }

    public String attackedBy(Player attacker) {

            int loseBlood=attacker.attackOut();
            this.healthPoint = this.healthPoint - loseBlood;
            return (attacker.getProfession()+attacker.getName()+attacker.attackWith()+this.getProfession()+this.getName()+","+this.getName()+"受到了"+loseBlood+"点伤害,"+this.getName()+"剩余生命："+this.getHealthPoint()+".");


    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }

    public int getAttackForce() {
        return attackForce;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }


    public String attackWith() {
        return "攻击了";
    }

    public int attackOut() {
        return attackForce;
    }
}
