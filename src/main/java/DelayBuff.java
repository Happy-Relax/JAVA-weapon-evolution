/**
 * Created by liujia on 1/9/16.
 */
public class DelayBuff extends Buff {
    protected String buffMessage;
    protected String damageMessage;

    public DelayBuff(String buffMessage,String damageMessage,int damagePoint){
        this.buffMessage=buffMessage;
        this.damageMessage=damageMessage;
        this.damagePoint=damagePoint;
    }

    @Override
    public String getInstantDamageMessage() {
        return "";
    }

    @Override
    public String getBuffMessage() {
        return this.buffMessage;//"中毒了";
    }

    @Override
    public Integer getDelayDamagePoint() {
        return this.damagePoint;
    }

    @Override
    public String getDelayDamageMessage() {
        return this.damageMessage;//"点毒性伤害";
    }

    @Override
    public Integer getCritialRate() {
        return this.critialRate;
    }
}
