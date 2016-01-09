/**
 * Created by liujia on 1/10/16.
 */
public class CritialBuff extends Buff {
    @Override
    public String getInstantDamageMessage() {
        return "发动了全力一击，";
    }

    @Override
    public String getBuffMessage() {
        return "";
    }

    @Override
    public Integer getDelayDamagePoint() {
        return 0;
    }

    @Override
    public String getDelayDamageMessage() {
        return "";
    }

    @Override
    public Integer getCritialRate() {
        return 3;
    }
}
