
import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;

public class GivenWhiteBox {

    @Before
    public void setUp() throws Exception {
    }

    /**
     * This is not deterministic if total damage is calculated correctly. Try to
     * find out why and what the problem is. Then make changes so that the
     * battle outcome IS deterministic! The battle mechanic will need to change
     * for this but you should try to make the least amount of changes possible
     */
    @Test
    public void BvsRsunny() {
        // One Student
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);

        //Create First battle scenario with two mons
        BattleScenario fight1 = new BattleScenario(attacker1, defender1);
        //Set the weather
        fight1.setEnvironment(Environment.Weather.sunny);

        Mascotmon mon = fight1.fight();
        assertEquals(mon, attacker1);
    }

    /**
     * Testing the fight() method so it would satisfy node coverage.
     */
    @Test
    public void NodeCoverageTest() {
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        BattleScenario scenario1 = new BattleScenario(attacker1, defender1);
        scenario1.setEnvironment(Environment.Weather.neutral);
        Mascotmon winner = scenario1.fight();
        assertNotNull(winner);
    }

    /**
     * Testing the fight() method so it would satisfy branch coverage and still
     * works like intended.
     */
    @Test
    public void BranchCoverageTest() {
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        BattleScenario scenario1 = new BattleScenario(defender1, attacker1);
        scenario1.setEnvironment(Environment.Weather.neutral);
        Mascotmon winner = scenario1.fight();
        assertEquals(defender1.name, winner.name);
    }

    /**
     * Testing the constructor to see if it works.
     */
    @Test
    public void BattleScenerioTest() {
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        BattleScenario scenario1 = new BattleScenario(attacker1, defender1);
        assertEquals(attacker1, scenario1.mon1);
        assertEquals(defender1, scenario1.mon2);
    }

    /**
     * Testing the setEnvironment method to see if the environment would be set.
     */
    @Test
    public void SetEnvironmentTest() {
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        BattleScenario scenario1 = new BattleScenario(attacker1, defender1);
        scenario1.setEnvironment(Environment.Weather.neutral);
        assertEquals(Environment.Weather.neutral, scenario1.getEnv().getWeather());
    }

    /**
     * Testing the setMon1 method to see if the mon1 variable would be set.
     */
    @Test
    public void SetMon1Test() {
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon attacker2 = new Mascotmon(Mascotmon.Name.ALBERT);
        BattleScenario scenario1 = new BattleScenario(attacker1, defender1);
        scenario1.setMon1(attacker2);
        assertEquals(attacker2, scenario1.mon1);
    }

    /**
     * Testing the setMon2 method to see if the mon1 variable would be set.
     */
    @Test
    public void SetMon2Test() {
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon attacker2 = new Mascotmon(Mascotmon.Name.ALBERT);
        BattleScenario scenario1 = new BattleScenario(attacker1, defender1);
        scenario1.setMon2(attacker2);
        assertEquals(attacker2, scenario1.mon2);
    }

    /**
     * Testing the initiateBattle method to see if it will call the fight()
     * method and determine a winner.
     */
    @Test
    public void InitiateBattleTest() {
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        BattleScenario scenario1 = new BattleScenario(attacker1, defender1);
        scenario1.setEnvironment(Environment.Weather.neutral);
        scenario1.initiateBattle();
        assertNotNull(scenario1.getWin());
    }
}
