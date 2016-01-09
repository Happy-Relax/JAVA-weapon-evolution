/**
 * Created by liujia on 1/9/16.
 */
public class BurnBuff extends PoisonBuff {
    @Override
    public String getBuffMessage() {
        return "着火了";
    }
    @Override
    public String getDelayDamageMessage() {
        return "点火焰伤害";
    }


}
