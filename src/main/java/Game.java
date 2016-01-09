import java.io.PrintStream;

/**
 * Created by liujia on 1/8/16.
 */
public class Game {
    private PrintStream printer=null;

    public Game(PrintStream printer){
        this.printer=printer;
    }
    public String attackEachOther(Player attacker, Player reactor) {
        while(true) {

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


}
