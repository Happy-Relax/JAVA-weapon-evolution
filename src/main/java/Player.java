import java.io.PrintStream;

/**
 * Created by liujia on 1/7/16.
 */
public class Player {
    private  PrintStream printer=null;
    private  String name;
    private int blood;
    private  int attackForce;
    private  int defensivePower;

    public Player(String name, int blood, int attackForce, int defensivePower, PrintStream printer) {
        this.name=name;
        this.blood=blood;
        this.attackForce=attackForce;
        this.defensivePower=defensivePower;
        this.printer=printer;
    }

    public void attackedBy(Player attacker) {
        if (attacker.attackForce > this.defensivePower) {
            int loseBlood=attacker.attackForce - this.defensivePower;
            this.blood = this.blood - loseBlood;
            this.printer.println(attacker.getname() + "攻击了"+this.getname()+","+this.getname()+"受到了"+loseBlood+"点伤害,"+this.getname()+"剩余生命："+this.getBlood()+".");
            if (this.blood <= 0) {
                this.printer.println(this.name + "被打败了.");
            }
        }

    }

    public int getBlood() {
        return blood;
    }

    public String getname() {
        return name;
    }
}
