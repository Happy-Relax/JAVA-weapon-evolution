/**
 * Created by liujia on 1/10/16.
 */
public class ControlBuff extends DelayBuff {

    public ControlBuff(String buffMessage, String damageMessage,boolean beforArrack) {
        super(buffMessage, damageMessage, 0);
        this.beforAttack =beforArrack;
    }

}
