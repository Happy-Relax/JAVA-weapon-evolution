/**
 * Created by liujia on 1/9/16.
 */
public abstract class Buff {
    protected int damagePoint;
    protected int critialRate=1;

    public abstract String getInstantDamageMessage();//发动了全力一击

    public abstract String getBuffMessage();//着火了/中毒了/晕倒了/冻僵了

    public abstract Integer getDelayDamagePoint();//延时技能伤害点数

    public abstract String getDelayDamageMessage();//冻的直哆嗦，没有击中／点毒性伤害／点火焰伤害／晕倒了，无法攻击

    public abstract Integer getCritialRate() ;//暴击率
}
