/**
 * Created by liujia on 1/9/16.
 */
public class NullBuff extends Buff {
    @Override
    public String getInstantDamageMessage() {
        return "";
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
        return 1;
    }
}
