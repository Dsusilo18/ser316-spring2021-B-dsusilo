
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;

//import main.java.BearWorkshop;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GivenBlackBox {

    private Class<BattleScenario> classUnderTest;

    @SuppressWarnings("unchecked")
    public GivenBlackBox(Object classUnderTest) {
        this.classUnderTest = (Class<BattleScenario>) classUnderTest;
    }

    @Parameters
    public static Collection<Object[]> courseGradesUnderTest() {
        Object[][] classes = {
            {BattleScenario1.class},
            {BattleScenario2.class},
            {BattleScenario3.class},
            {BattleScenario4.class},
            {BattleScenario5.class}

        };
        return Arrays.asList(classes);
    }

    private BattleScenario createBattleScenario(Mascotmon a, Mascotmon d) throws Exception {
        Constructor<BattleScenario> constructor = classUnderTest.getConstructor(Mascotmon.class, Mascotmon.class);
        System.out.println(constructor);
        return constructor.newInstance(a, d);
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    // sample test
    /**
     * Battle between Bully and Ralphie on a sunny day with ground attack
     *
     * @throws Exception
     */
    @Test
    public void BvsRSunnyGround() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    BvsRSunnyGround");

        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(80, "Ground");

        //Calculation: 80 * 1 * 1 - 65 * 1 *1
        // 80 put into attack manually, no weather bonuses on either side, Ralphi has 65 defense
        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 15, 0.2);
    }

    /**
     * Battle between Bully and Ralphie on a sunny day with ground attack
     *
     * @throws Exception
     */
    @Test
    public void RvsBSunnyGround() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    RvsBSunnyGround");

        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(80, "Ground");

        //Calculation: 80 * 1.2 * 1 * 1 - 40 * 1 *1
        // 80 put into attack manually, Ralhpie gets bonus for ground attack no weather bonuses or type bonus
        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 56, 0.2);
    }

    @Test
    public void EnvironmentTypeTestCase1() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon attacker2 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon defender2 = new Mascotmon(Mascotmon.Name.SPARKY);
        System.out.println("Environment Test Case 1");

        double damage = CreateTest(attacker1, defender1, 30, Environment.Weather.sunny);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 1, 0.2);

        damage = CreateTest(attacker2, defender2, 60, Environment.Weather.sunny);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 19, 0.2);

        damage = CreateTest(defender2, attacker2, 70, Environment.Weather.sunny);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 28, 0.2);

        damage = CreateTest(defender1, attacker1, 40, Environment.Weather.sunny);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 1, 0.2);
    }

    @Test
    public void EnvironmentTypeTestCase2() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon attacker2 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender2 = new Mascotmon(Mascotmon.Name.ALBERT);
        System.out.println("Environment Test Case 2");

        double damage = CreateTest(attacker1, defender1, 30, Environment.Weather.rainy);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 1, 0.2);

        damage = CreateTest(attacker2, defender2, 70, Environment.Weather.rainy);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 1, 0.2);

        damage = CreateTest(defender2, attacker2, 60, Environment.Weather.rainy);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 71, 0.2);

        damage = CreateTest(defender1, attacker1, 40, Environment.Weather.sunny);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 1, 0.2);
    }

    @Test
    public void EnvironmentTypeTestCase3() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon attacker2 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon defender2 = new Mascotmon(Mascotmon.Name.RALPHIE);
        System.out.println("Environment Test Case 3");

        double damage = CreateTest(attacker1, defender1, 40, Environment.Weather.drought);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 1, 0.2);

        damage = CreateTest(attacker2, defender2, 60, Environment.Weather.drought);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 1, 0.2);

        damage = CreateTest(defender2, attacker2, 30, Environment.Weather.drought);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 17, 0.2);

        damage = CreateTest(defender1, attacker1, 70, Environment.Weather.sunny);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 30, 0.2);
    }

    @Test
    public void EnvironmentTypeTestCase4() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender2 = new Mascotmon(Mascotmon.Name.RALPHIE);
        System.out.println("Environment Test Case 3");

        double damage = CreateTest(attacker1, defender1, 40, Environment.Weather.drought);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 1, 0.2);

        damage = CreateTest(attacker1, defender2, 40, Environment.Weather.drought);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 1, 0.2);

        damage = CreateTest(defender2, attacker1, 30, Environment.Weather.drought);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 8, 0.2);

        damage = CreateTest(defender1, attacker1, 70, Environment.Weather.sunny);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 40, 0.2);
    }

    @Test
    public void TypeTestCase1() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon attacker2 = new Mascotmon(Mascotmon.Name.RALPHIE);
        System.out.println("Type Test Case 1");

        double damage = CreateTest(attacker1, defender1, 40, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 0, 0.2);

        damage = CreateTest(attacker2, defender1, 30, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 1, 0.2);

        damage = CreateTest(defender1, attacker2, 70, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 39, 0.2);

        damage = CreateTest(defender1, attacker1, 70, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 30, 0.2);
    }

    @Test
    public void TypeTestCase2() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon attacker2 = new Mascotmon(Mascotmon.Name.ALBERT);
        System.out.println("Type Test Case 2");

        double damage = CreateTest(attacker1, defender1, 40, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 1, 0.2);

        damage = CreateTest(attacker2, defender1, 60, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 1, 0.2);

        damage = CreateTest(defender1, attacker2, 30, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 8, 0.2);

        damage = CreateTest(defender1, attacker1, 30, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 1, 0.2);
    }

    @Test
    public void TypeTestCase3() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon attacker2 = new Mascotmon(Mascotmon.Name.SPARKY);
        System.out.println("Type Test Case 3");

        double damage = CreateTest(attacker1, defender1, 40, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 0, 0.2);

        damage = CreateTest(attacker2, defender1, 70, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 3, 0.2);

        damage = CreateTest(defender1, attacker2, 60, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 45, 0.2);

        damage = CreateTest(defender1, attacker1, 60, Environment.Weather.neutral);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 20, 0.2);
    }

    private double CreateTest(Mascotmon attacker, Mascotmon defender, int att,
            Environment.Weather pWeather) throws Exception {

        BattleScenario fight1 = createBattleScenario(attacker, defender);

        fight1.setEnvironment(pWeather);
        Attack attack = new Attack(att, "");

        return fight1.calculateDamage(attack, attacker, defender);
    }
}
