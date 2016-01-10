import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by liujia on 1/10/16.
 */
public class BuffTest {
    //without buff
    @Test
    public void should_solider_without_Buff_attack_player_return_buff_message(){
        Weapon swort=new WeaponFactory().createWeapon("利剑",2,new BuffFactory().createBuff(""));
        Armor nullArmor=new AmorFactory().createArmor();
        Solider tom=new Solider("Tom",20,2,swort,nullArmor);
        Player jerry=new Player("Jerry",20,2);
        assertThat(jerry.attackedBy(tom),is("战士Tom用利剑攻击了普通人Jerry,Jerry受到了4点伤害,Jerry剩余生命：16."));
    }
    @Test
    public void should_solider_without_Buff_attack_solider_without_armor_return_buff_message(){
        Weapon swort=new WeaponFactory().createWeapon("利剑",2,new BuffFactory().createBuff(""));
        Weapon nullWeapon=new WeaponFactory().createWeapon();
        Armor nullArmor=new AmorFactory().createArmor();
        Solider tom=new Solider("Tom",20,2,swort,nullArmor);
        Solider jerry=new Solider("Jerry",20,2,nullWeapon,nullArmor);
        assertThat(jerry.attackedBy(tom),is("战士Tom用利剑攻击了战士Jerry,Jerry受到了4点伤害,Jerry剩余生命：16."));
    }
    @Test
    public void should_solider_without_Buff_attack_solider_with_armor_return_buff_message(){
        Weapon swort=new WeaponFactory().createWeapon("利剑",2,new BuffFactory().createBuff(""));
        Weapon nullWeapon=new WeaponFactory().createWeapon();
        Armor cloth=new AmorFactory().createArmor("cloth",2);
        Solider tom=new Solider("Tom",20,2,swort,cloth);
        Solider jerry=new Solider("Jerry",20,2,nullWeapon,cloth);
        assertThat(jerry.attackedBy(tom),is("战士Tom用利剑攻击了战士Jerry,Jerry受到了2点伤害,Jerry剩余生命：18."));
    }

    //critialBuff
    @Test
    public void should_solider_with_critialBuffWeapon_attack_player_return_buff_message(){
        Weapon swort=new WeaponFactory().createWeapon("利剑",2,new BuffFactory().createBuff("critial"));
        Armor nullArmor=new AmorFactory().createArmor();
        Solider tom=new Solider("Tom",20,2,swort,nullArmor);
        Player jerry=new Player("Jerry",20,2);
        assertThat(jerry.attackedBy(tom),is("战士Tom用利剑攻击了普通人Jerry,Tom发动了全力一击,Jerry受到了12点伤害,Jerry剩余生命：8."));
    }
    @Test
    public void should_solider_with_critialBuffWeapon_attack_solider_with_armor_return_buff_message(){
        Weapon swort=new WeaponFactory().createWeapon("利剑",2,new BuffFactory().createBuff("critial"));
        Weapon nullWeapon=new WeaponFactory().createWeapon();
        Armor nullArmor=new AmorFactory().createArmor();
        Armor cloth=new AmorFactory().createArmor("cloth",2);
        Solider tom=new Solider("Tom",20,2,swort,nullArmor);
        Solider jerry=new Solider("Jerry",20,2,nullWeapon,cloth);
        assertThat(jerry.attackedBy(tom),is("战士Tom用利剑攻击了战士Jerry,Tom发动了全力一击,Jerry受到了6点伤害,Jerry剩余生命：14."));
    }
    @Test
    public void should_solider_with_critialBuffWeapon_attack_solider_without_armor_return_buff_message(){
        Weapon swort=new WeaponFactory().createWeapon("利剑",2,new BuffFactory().createBuff("critial"));
        Weapon nullWeapon=new WeaponFactory().createWeapon();
        Armor nullArmor=new AmorFactory().createArmor();
        Armor cloth=new AmorFactory().createArmor("cloth",2);
        Solider tom=new Solider("Tom",20,2,swort,nullArmor);
        Solider jerry=new Solider("Jerry",20,2,nullWeapon,nullArmor);
        assertThat(jerry.attackedBy(tom),is("战士Tom用利剑攻击了战士Jerry,Tom发动了全力一击,Jerry受到了12点伤害,Jerry剩余生命：8."));
    }

    //poisonBuff
    @Test
    public void should_solider_with_poisonBuffWeapon_attack_player_return_buff_message(){
        Weapon swort=new WeaponFactory().createWeapon("毒剑",2,new BuffFactory().createBuff("poison"));
        Armor nullArmor=new AmorFactory().createArmor();
        Solider tom=new Solider("Tom",20,2,swort,nullArmor);
        Player jerry=new Player("Jerry",20,2);
        assertThat(jerry.attackedBy(tom),is("战士Tom用毒剑攻击了普通人Jerry,Jerry受到了4点伤害,Jerry中毒了,Jerry剩余生命：16."));
    }
    @Test
    public void should_solider_with_poisonBuffWeapon_attack_solider_with_armor_return_buff_message(){
        Weapon swort=new WeaponFactory().createWeapon("毒剑",2,new BuffFactory().createBuff("poison"));
        Weapon nullWeapon=new WeaponFactory().createWeapon();
        Armor nullArmor=new AmorFactory().createArmor();
        Armor cloth=new AmorFactory().createArmor("cloth",2);
        Solider tom=new Solider("Tom",20,2,swort,nullArmor);
        Solider jerry=new Solider("Jerry",20,2,nullWeapon,cloth);
        assertThat(jerry.attackedBy(tom),is("战士Tom用毒剑攻击了战士Jerry,Jerry受到了2点伤害,Jerry中毒了,Jerry剩余生命：18."));
    }
    @Test
    public void should_solider_with_poisonBuffWeapon_attack_solider_without_armor_return_buff_message(){
        Weapon swort=new WeaponFactory().createWeapon("冰剑",2,new BuffFactory().createBuff("poison"));
        Weapon nullWeapon=new WeaponFactory().createWeapon();
        Armor nullArmor=new AmorFactory().createArmor();
        Solider tom=new Solider("Tom",20,2,swort,nullArmor);
        Solider jerry=new Solider("Jerry",20,2,nullWeapon,nullArmor);
        assertThat(jerry.attackedBy(tom),is("战士Tom用冰剑攻击了战士Jerry,Jerry受到了4点伤害,Jerry中毒了,Jerry剩余生命：16."));
    }

    //frostBuff
    @Test
    public void should_solider_with_frostBuffWeapon_attack_player_return_buff_message(){
        Weapon swort=new WeaponFactory().createWeapon("冰剑",2,new BuffFactory().createBuff("frost"));
        Armor nullArmor=new AmorFactory().createArmor();
        Solider tom=new Solider("Tom",20,2,swort,nullArmor);
        Player jerry=new Player("Jerry",20,2);
        assertThat(jerry.attackedBy(tom),is("战士Tom用冰剑攻击了普通人Jerry,Jerry受到了4点伤害,Jerry冻僵了,Jerry剩余生命：16."));
    }
    @Test
    public void should_solider_with_frostBuffWeapon_attack_solider_with_armor_return_buff_message(){
        Weapon swort=new WeaponFactory().createWeapon("冰剑",2,new BuffFactory().createBuff("frost"));
        Weapon nullWeapon=new WeaponFactory().createWeapon();
        Armor nullArmor=new AmorFactory().createArmor();
        Armor cloth=new AmorFactory().createArmor("cloth",2);
        Solider tom=new Solider("Tom",20,2,swort,nullArmor);
        Solider jerry=new Solider("Jerry",20,2,nullWeapon,cloth);
        assertThat(jerry.attackedBy(tom),is("战士Tom用冰剑攻击了战士Jerry,Jerry受到了2点伤害,Jerry冻僵了,Jerry剩余生命：18."));
    }
    @Test
    public void should_solider_with_frostBuffWeapon_attack_solider_without_armor_return_buff_message(){
        Weapon swort=new WeaponFactory().createWeapon("冰剑",2,new BuffFactory().createBuff("frost"));
        Weapon nullWeapon=new WeaponFactory().createWeapon();
        Armor nullArmor=new AmorFactory().createArmor();
        Solider tom=new Solider("Tom",20,2,swort,nullArmor);
        Solider jerry=new Solider("Jerry",20,2,nullWeapon,nullArmor);
        assertThat(jerry.attackedBy(tom),is("战士Tom用冰剑攻击了战士Jerry,Jerry受到了4点伤害,Jerry冻僵了,Jerry剩余生命：16."));
    }

    //burnBuff
    @Test
    public void should_solider_with_burnBuffWeapon_attack_player_return_buff_message(){
        Weapon swort=new WeaponFactory().createWeapon("火焰剑",2,new BuffFactory().createBuff("burn"));
        Armor nullArmor=new AmorFactory().createArmor();
        Solider tom=new Solider("Tom",20,2,swort,nullArmor);
        Player jerry=new Player("Jerry",20,2);
        assertThat(jerry.attackedBy(tom),is("战士Tom用火焰剑攻击了普通人Jerry,Jerry受到了4点伤害,Jerry着火了,Jerry剩余生命：16."));
    }
    @Test
    public void should_solider_with_burnBuffWeapon_attack_solider_with_armor_return_buff_message(){
        Weapon swort=new WeaponFactory().createWeapon("火焰剑",2,new BuffFactory().createBuff("burn"));
        Weapon nullWeapon=new WeaponFactory().createWeapon();
        Armor nullArmor=new AmorFactory().createArmor();
        Armor cloth=new AmorFactory().createArmor("cloth",2);
        Solider tom=new Solider("Tom",20,2,swort,nullArmor);
        Solider jerry=new Solider("Jerry",20,2,nullWeapon,cloth);
        assertThat(jerry.attackedBy(tom),is("战士Tom用火焰剑攻击了战士Jerry,Jerry受到了2点伤害,Jerry着火了,Jerry剩余生命：18."));
    }
    @Test
    public void should_solider_with_burnBuffWeapon_attack_solider_without_armor_return_buff_message(){
        Weapon swort=new WeaponFactory().createWeapon("火焰剑",2,new BuffFactory().createBuff("burn"));
        Weapon nullWeapon=new WeaponFactory().createWeapon();
        Armor nullArmor=new AmorFactory().createArmor();
        Solider tom=new Solider("Tom",20,2,swort,nullArmor);
        Solider jerry=new Solider("Jerry",20,2,nullWeapon,nullArmor);
        assertThat(jerry.attackedBy(tom),is("战士Tom用火焰剑攻击了战士Jerry,Jerry受到了4点伤害,Jerry着火了,Jerry剩余生命：16."));
    }

    //DizzinessBuff
    @Test
    public void should_solider_with_dizzinessBuffWeapon_attack_player_return_buff_message(){
        Weapon swort=new WeaponFactory().createWeapon("眩晕剑",2,new BuffFactory().createBuff("dizziness"));
        Armor nullArmor=new AmorFactory().createArmor();
        Solider tom=new Solider("Tom",20,2,swort,nullArmor);
        Player jerry=new Player("Jerry",20,2);
        assertThat(jerry.attackedBy(tom),is("战士Tom用眩晕剑攻击了普通人Jerry,Jerry受到了4点伤害,Jerry晕倒了,Jerry剩余生命：16."));
    }
    @Test
    public void should_solider_with_dizzinessBuffWeapon_attack_solider_with_armor_return_buff_message(){
        Weapon swort=new WeaponFactory().createWeapon("眩晕剑",2,new BuffFactory().createBuff("dizziness"));
        Weapon nullWeapon=new WeaponFactory().createWeapon();
        Armor nullArmor=new AmorFactory().createArmor();
        Armor cloth=new AmorFactory().createArmor("cloth",2);
        Solider tom=new Solider("Tom",20,2,swort,nullArmor);
        Solider jerry=new Solider("Jerry",20,2,nullWeapon,cloth);
        assertThat(jerry.attackedBy(tom),is("战士Tom用眩晕剑攻击了战士Jerry,Jerry受到了2点伤害,Jerry晕倒了,Jerry剩余生命：18."));
    }
    @Test
    public void should_solider_with_dizzinessBuffWeapon_attack_solider_without_armor_return_buff_message(){
        Weapon swort=new WeaponFactory().createWeapon("眩晕剑",2,new BuffFactory().createBuff("dizziness"));
        Weapon nullWeapon=new WeaponFactory().createWeapon();
        Armor nullArmor=new AmorFactory().createArmor();
        Solider tom=new Solider("Tom",20,2,swort,nullArmor);
        Solider jerry=new Solider("Jerry",20,2,nullWeapon,nullArmor);
        assertThat(jerry.attackedBy(tom),is("战士Tom用眩晕剑攻击了战士Jerry,Jerry受到了4点伤害,Jerry晕倒了,Jerry剩余生命：16."));
    }

//    @Test
//    public void should_solider_with_poisonBuffWeapon_attack_player_return_buff_message(){
//        Weapon swort=new WeaponFactory().createWeapon("利剑",2,new BuffFactory().createBuff("critial"));
//        Armor nullArmor=new AmorFactory().createArmor();
//        Solider tom=new Solider("Tom",20,2,swort,nullArmor);
//        Player jerry=new Player("Jerry",20,2);
//        assertThat(jerry.attackedBy(tom),is("战士Tom用毒剑攻击了普通人Jerry,Jerry受到了３点伤害,Jerry剩余生命：17."));
//    }
}
