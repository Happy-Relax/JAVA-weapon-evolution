/**
 * Created by liujia on 1/9/16.
 */
public class BuffFactory {
    public Buff createBuff(String poison,int damagePoint) {

        switch (poison){
            case "poison":return new DelayBuff("中毒了","点毒性伤害",damagePoint);
            case "burn":  return new DelayBuff("着火了","点火焰伤害",damagePoint);
            case "frost":  return new DelayBuff("冻僵了","冻的直哆嗦,没有击中",0);
            case "dizziness":  return new DelayBuff("冻僵了","冻的直哆嗦,没有击中",0);
            case "critial":  return new InstantBuff(3);

            default:return new NullBuff();
        }
    }
    public Buff createBuff(){
        return new NullBuff();
    }
}
