
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author daryl
 */
public class calculateDamageTest {

    @Before
    public void setUp() throws Exception {
    }


    @After
    public void cleanUp() throws Exception {
    }
    // sample test
    /**
     * Battle between Bully and Ralphie on a sunny day with ground attack
     *
     * @throws Exception
     */
    @Test
    public void BvsRSunnyGround() throws Exception{

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);

        BattleScenario fight1 = new BattleScenario(attacker1, defender1);

        System.out.println("    BvsRSunnyGround");

        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(80, "Ground");

        //Calculation: 80 * 1 * 1 - 65 * 1 *1
        // 80 put into attack manually, no weather bonuses on either side, Ralphi has 65 defense
        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 15, 0.2);
    }

    /**
     * Battle between Bully and Ralphie on a sunny day with ground attack
     *
     * @throws Exception
     */
    @Test
    public void RvsBSunnyGround() throws Exception{

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);

        BattleScenario fight1 = new BattleScenario(attacker1, defender1);
        System.out.println("    RvsBSunnyGround");

        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(80, "Ground");

        //Calculation: 80 * 1.2 * 1 * 1 - 40 * 1 *1
        // 80 put into attack manually, Ralhpie gets bonus for ground attack no weather bonuses or type bonus
        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 56, 0.2);
    }

    @Test
    public void EnvironmentTypeTestCase1() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon attacker2;
        Mascotmon defender2;
        System.out.println("Environment Test Case 1");

        double damage = CreateTest(attacker1, defender1, 30, Environment.Weather.sunny);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 1, 0.2);

        attacker2 = new Mascotmon(Mascotmon.Name.ALBERT);
        defender2 = new Mascotmon(Mascotmon.Name.SPARKY);

        damage = CreateTest(attacker2, defender2, 60, Environment.Weather.sunny);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 19, 0.2);

        attacker2 = new Mascotmon(Mascotmon.Name.ALBERT);
        defender2 = new Mascotmon(Mascotmon.Name.SPARKY);

        damage = CreateTest(defender2, attacker2, 70, Environment.Weather.sunny);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 28, 0.2);

        attacker1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        defender1 = new Mascotmon(Mascotmon.Name.BULLY);

        damage = CreateTest(defender1, attacker1, 40, Environment.Weather.sunny);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 1, 0.2);
    }

    @Test
    public void EnvironmentTypeTestCase2() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon attacker2;
        Mascotmon defender2;
        System.out.println("Environment Test Case 2");

        double damage = CreateTest(attacker1, defender1, 30, Environment.Weather.rainy);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 1, 0.2);

        attacker2 = new Mascotmon(Mascotmon.Name.SPARKY);
        defender2 = new Mascotmon(Mascotmon.Name.ALBERT);

        damage = CreateTest(attacker2, defender2, 70, Environment.Weather.rainy);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 1, 0.2);

        attacker2 = new Mascotmon(Mascotmon.Name.SPARKY);
        defender2 = new Mascotmon(Mascotmon.Name.ALBERT);

        damage = CreateTest(defender2, attacker2, 60, Environment.Weather.rainy);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 71, 0.2);

        attacker1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        defender1 = new Mascotmon(Mascotmon.Name.BULLY);

        damage = CreateTest(defender1, attacker1, 40, Environment.Weather.sunny);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 1, 0.2);
    }

    @Test
    public void EnvironmentTypeTestCase3() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.SPARKY);

        System.out.println("Environment Test Case 3");

        double damage = CreateTest(attacker1, defender1, 40, Environment.Weather.drought);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 1, 0.2);

        Mascotmon attacker2 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon defender2 = new Mascotmon(Mascotmon.Name.RALPHIE);

        damage = CreateTest(attacker2, defender2, 60, Environment.Weather.drought);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 1, 0.2);

        attacker2 = new Mascotmon(Mascotmon.Name.ALBERT);
        defender2 = new Mascotmon(Mascotmon.Name.RALPHIE);

        damage = CreateTest(defender2, attacker2, 30, Environment.Weather.drought);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 17, 0.2);

        attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        defender1 = new Mascotmon(Mascotmon.Name.SPARKY);

        damage = CreateTest(defender1, attacker1, 70, Environment.Weather.drought);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 40, 0.2);
    }

    @Test
    public void EnvironmentTypeTestCase4() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender2;
        System.out.println("Environment Test Case 3");

        double damage = CreateTest(attacker1, defender1, 40, Environment.Weather.drought);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 1, 0.2);

        attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        defender2 = new Mascotmon(Mascotmon.Name.RALPHIE);

        damage = CreateTest(attacker1, defender2, 40, Environment.Weather.drought);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 1, 0.2);

        attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        defender2 = new Mascotmon(Mascotmon.Name.RALPHIE);

        damage = CreateTest(defender2, attacker1, 30, Environment.Weather.drought);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 8, 0.2);

        attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        defender1 = new Mascotmon(Mascotmon.Name.SPARKY);

        damage = CreateTest(defender1, attacker1, 70, Environment.Weather.drought);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 40, 0.2);
    }

    @Test
    public void TypeTestCase1() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon attacker2;
        System.out.println("Type Test Case 1");

        double damage = CreateTest(attacker1, defender1, 40, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 0, 0.2);

        defender1 = new Mascotmon(Mascotmon.Name.SPARKY);
        attacker2 = new Mascotmon(Mascotmon.Name.RALPHIE);

        damage = CreateTest(attacker2, defender1, 30, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 1, 0.2);

        defender1 = new Mascotmon(Mascotmon.Name.SPARKY);
        attacker2 = new Mascotmon(Mascotmon.Name.RALPHIE);

        damage = CreateTest(defender1, attacker2, 70, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 39, 0.2);

        attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        defender1 = new Mascotmon(Mascotmon.Name.SPARKY);

        damage = CreateTest(defender1, attacker1, 70, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
       Assert.assertEquals(damage, 30, 0.2);
    }

    @Test
    public void TypeTestCase2() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon attacker2;
        System.out.println("Type Test Case 2");

        double damage = CreateTest(attacker1, defender1, 40, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 1, 0.2);

        defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        attacker2 = new Mascotmon(Mascotmon.Name.ALBERT);

        damage = CreateTest(attacker2, defender1, 60, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 1, 0.2);

        defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        attacker2 = new Mascotmon(Mascotmon.Name.ALBERT);

        damage = CreateTest(defender1, attacker2, 30, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 8, 0.2);

        attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);

        damage = CreateTest(defender1, attacker1, 30, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 1, 0.2);
    }

    @Test
    public void TypeTestCase3() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon attacker2;
        System.out.println("Type Test Case 3");

        double damage = CreateTest(attacker1, defender1, 40, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 0, 0.2);

        defender1 = new Mascotmon(Mascotmon.Name.ALBERT);
        attacker2 = new Mascotmon(Mascotmon.Name.SPARKY);

        damage = CreateTest(attacker2, defender1, 70, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 3, 0.2);

        defender1 = new Mascotmon(Mascotmon.Name.ALBERT);
        attacker2 = new Mascotmon(Mascotmon.Name.SPARKY);

        damage = CreateTest(defender1, attacker2, 60, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 45, 0.2);

        attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        defender1 = new Mascotmon(Mascotmon.Name.ALBERT);

        damage = CreateTest(defender1, attacker1, 60, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
        Assert.assertEquals(damage, 20, 0.2);
    }

    private double CreateTest(Mascotmon attacker, Mascotmon defender, int att,
            Environment.Weather pWeather) throws Exception {

        BattleScenario fight1 = new BattleScenario(attacker, defender);

        fight1.setEnvironment(pWeather);
        Attack attack = new Attack(att, "");

        return fight1.calculateDamage(attack, attacker, defender);
    }
}
