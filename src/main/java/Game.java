import java.io.PrintStream;

/**
 * Created by liujia on 1/8/16.
 */
public class Game {
    private PrintStream printer=null;

    public Game(PrintStream printer){
        this.printer=printer;
    }
    public String attackEachOtherWithoutBuff(Player attacker, Player reactor) {
        while(true) {

            this.printer.println(attacker.sufferDeBuff());
            if (attacker.getHealthPoint() <= 0) {
                this.printer.println(attacker.getName() + "被击败了.");
                return "GameOver";
            }
            this.printer.println(reactor.attackedBy(attacker));

            if (reactor.getHealthPoint() <= 0) {
                this.printer.println(reactor.getName() + "被击败了.");
                return "GameOver";
            }
            this.printer.println(attacker.attackedBy(reactor));
        }
    }

    public String attackEachOtherWithBuff(Player attacker, Player reactor) {
        while(true) {

            if(this.gameCotrolWithBuff(attacker,reactor)){
                return "GameOver";
            }
            if(this.gameCotrolWithBuff(reactor,attacker)){
                return "GameOver";
            }

        }
    }

    public boolean gameCotrolWithBuff(Player attacker,Player reactor){
        String printString="";

        if (attacker.getHealthPoint() <= 0) {
            this.printer.println(attacker.getName() + "被击败了.");
            return true;
        }
        //攻击前状态判定
        printString=attacker.sufferDeBuff();
        if (attacker.getDeBuff().getBeforAttack()){
            printString+=reactor.getName();
        }
        this.printer.println(printString);
        //攻击
        if (attacker.getHealthPoint() <= 0) {
            this.printer.println(attacker.getName() + "被击败了.");
            return true;
        }
        if(attacker.getDeBuff() instanceof ControlBuff){
            return false;
        }
        this.printer.println(reactor.attackedBy(attacker));
        return false;
    }

}
