/**
 * Created by liujia on 1/9/16.
 */
public class PoisonBuff extends Buff {

    @Override
    public String getInstantDamageMessage() {
        return "";
    }

    @Override
    public String getBuffMessage() {
        return "中毒了";
    }

    @Override
    public Integer getDelayDamagePoint() {
        return 2;
    }

    @Override
    public String getDelayDamageMessage() {
        return "点毒性伤害";
    }

    @Override
    public Integer getCritialRate() {
        return 1;
    }
}
