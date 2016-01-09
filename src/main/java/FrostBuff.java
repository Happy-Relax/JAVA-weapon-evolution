/**
 * Created by liujia on 1/9/16.
 */
public class FrostBuff extends PoisonBuff {
    @Override
    public String getBuffMessage() {
        return "冻僵了";
    }
    @Override
    public String getDelayDamageMessage() {
        return "冻的直哆嗦，没有击中";
    }
    @Override
    public Integer getDelayDamagePoint() {
        return 0;
    }



}
