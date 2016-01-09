/**
 * Created by liujia on 1/9/16.
 */
public class BuffFactory {
    public Buff createBuff(String poison) {
        switch (poison){
            case "poison":return new PoisonBuff();
            case "burn":  return new BurnBuff();
            case "frost":  return new FrostBuff();
            case "dizziness":  return new DizzinessBuff();
            case "critial":  return new CritialBuff();

            default:return new NullBuff();
        }
    }
}
