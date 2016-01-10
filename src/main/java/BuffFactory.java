/**
 * Created by liujia on 1/9/16.
 */
public class BuffFactory {
    public Buff createBuff(String poison,int damagePoint) {

        switch (poison){
            case "poison":return new DelayBuff("中毒了","受到"+damagePoint+"点毒性伤害",damagePoint);
            case "burn":  return new DelayBuff("着火了","受到"+damagePoint+"点火焰伤害",damagePoint);
            case "frost":  return new ControlBuff("冻僵了","冻的直哆嗦,没有击中",true);
            case "dizziness":  return new ControlBuff("晕倒了","晕倒了,无法攻击",false);
            case "critial":  return new InstantBuff(3);

            default:return new NullBuff();
        }
    }
    public Buff createBuff(){
        return new NullBuff();
    }
}
