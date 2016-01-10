/**
 * Created by liujia on 1/7/16.
 */
public class Player {
    private  String name;
    private int healthPoint;
    private  int attackForce;
    private String profession="普通人";
    protected Buff deBuff=new BuffFactory().createBuff();

    public Player(String name, int healthPoint, int attackForce) {
        this.name=name;
        this.healthPoint = healthPoint;
        this.attackForce=attackForce;
    }

    public String attackedBy(Player attacker) {

        int loseBlood = attacker.attackOut() * attacker.getWeapon().getBuff().getCritialRate();
        this.healthPoint = this.healthPoint - loseBlood;
        this.deBuff = attacker.getWeapon().getBuff();
        return (attacker.getProfession() + attacker.getName() + attacker.attackWith() + this.getProfession() + this.getName() + "," + attacker.getInstantBuff() + this.getName() + "受到了" + loseBlood + "点伤害," +this.getDeBuff() +this.getName() + "剩余生命：" + this.getHealthPoint() + ".");


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


    public Weapon getWeapon() {
        return new WeaponFactory().createWeapon();
    }

    public String getInstantBuff() {
        return "";
    }

    public String getDeBuff() {
        if (this.deBuff.getClass().getName()!="NullBuff"&&this.deBuff.getDelayDamageMessage()!=""){
            return this.getName()+deBuff.getBuffMessage()+",";
        }
        else {
            return "";
        }

    }


    public String sufferDeBuff() {
        String deBuffMessage="";
        if(("DelayBuff").equals(this.deBuff.getClass().getName())){
            deBuffMessage+=this.name+this.deBuff.getDelayDamageMessage();
            if(this.deBuff.getDelayDamagePoint()!=0){
                this.healthPoint=this.healthPoint-this.deBuff.getDelayDamagePoint();
                deBuffMessage+=","+this.name+"剩余生命:"+this.healthPoint;
            }
        }

        this.deBuff=new BuffFactory().createBuff();
        return deBuffMessage ;
    }

}
