/**
 * Created by liujia on 1/10/16.
 */
public class DizzinessBuff extends PoisonBuff {
    @Override
    public String getBuffMessage() {
        return "晕倒了";
    }
    @Override
    public String getDelayDamageMessage() {
        return "晕倒了,无法攻击";
    }
    @Override
    public Integer getDelayDamagePoint() {
        return 0;
    }




}
