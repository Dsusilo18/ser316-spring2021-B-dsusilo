
public class BattleScenario {

    Mascotmon mon1;
    Mascotmon mon2;
//    Stats mon1Stats;
//    Stats mon2Stats; SER316 TASK 2 SPOT-BUGS FIX
    Environment battleWeather;
    Mascotmon winner;

    public BattleScenario(Mascotmon pmon1, Mascotmon pmon2) {
        setMon1(pmon1);
        setMon2(pmon2);
    }

    /**
     * Sets environment of the battlefield, and sets buff/debuff modifiers for
     * all Mascotmons on the field. If the Mascotmon's type is buffed by the
     * environment,they receive a 25% multiplier to their attack and defense
     * stat. If the Mascotmon's type is debuffed by the environment, they
     * receive a reduction of 25% to their attack and defense stat.
     *
     * @param pWeather is the weather enum to use from Environment class
     */
    public void setEnvironment(Environment.Weather pweather) {
        battleWeather = new Environment(pweather);
    }

    /**
     * winner is moved to a public class variable so that the method can be
     * tested.
     */
    public void initiateBattle() {

//        // initiate stats for mon1 and mon2
//        mon1Stats = new Stats(mon1.name);
//        mon2Stats = new Stats(mon2.name); SER316 TASK 2 SPOT-BUGS FIX

        System.out.println("\nWelcome everyone to the Mascotmon training arena!");
        System.out.println("It is a " + battleWeather.WEATHER.toString().toLowerCase()
                + " day here at Frank Kush Field");
        System.out.println("Today, on the attacking team we have " + mon1.name + " "
                + mon1.description);
        System.out.println("Their opponent, on the defending team is " + mon2.name + " "
                + mon2.description);
        System.out.println(mon2.name + " prepares for the incoming attack");

        winner = fight();
        System.out.println(winner.name + " has won with " + winner.stats.health + " health left");
    }

    /**
     * Sample fight scenario of two rounds. Each Mascotmon uses one random
     * attack per round; this attack multiplier is used to calculate damage
     * output against opposing mascotmon.
     */
    public Mascotmon fight() {
        int round = 1;
        double damage1;
        double damage2;

        Attack attack1;
        Attack attack2;
        mon1.stats.health = 0.0;
        mon2.stats.health = 0.0;

        while (round < 4) {
            //Mon 1's turn:
            System.out.println("\n" + mon1.name + " launches an attack against "
                    + mon2.name + "!");
            attack1 = mon1.attack();

            //Calculate damage:
            damage1 = calculateDamage(attack1, mon1, mon2);
            System.out.println(damage1 + " damage dealt");

            //Adjust mon2's health:
            mon2.stats.health = mon2.stats.health - damage1;
            System.out.println(mon2.name + " has " + mon2.stats.health
                    + " health left");
            //Battle terminating condition:
            if (mon2.stats.health <= 0.0) {
                System.out.println(mon2.name + " has fainted in round " + round);
                if (round == 2 && mon1.type.equals("Water")) {
                    return mon1;
                }
            }

            //Mon 2's turn:
            System.out.println("\n" + mon2.name + " launches an attack against "
                    + "" + mon1.name + "!");
            attack2 = mon2.attack();

            //Calculate damage:
            damage2 = calculateDamage(attack2, mon2, mon1);
            System.out.println(damage2 + " damage dealt");

            //Adjust mon1's health:
            mon1.stats.health = mon1.stats.health - damage2;
            System.out.println(mon1.name + " has " + mon1.stats.health + " health left");
            //Battle terminating condition:
            if (mon1.stats.health <= 0.0) {
                System.out.println(mon1.name + " has fainted in round " + round);
                // SER316 TASK 2 SPOT-BUGS FIX
                if (round == 2 && mon1.type.equals("Neutral")) {
                    return mon2;
                }
            }
            round++;
            if (round == 3) {
                mon1.stats.health = 70;
                mon2.stats.health = 70;
            }
        } //end while
        if (mon1.stats.health <= 0.0) {
            return mon2;
        } else {
            return mon1;
        }
    }

    public void setMon1(Mascotmon pmon) {
        mon1 = pmon;
    }

    public void setMon2(Mascotmon pmon) {
        mon2 = pmon;
    }

    /**
     * TO DO: Implement for Assignment 3 This method implements the calculation
     * of damage for one specific attack. One monster attacks with the given
     * damage, the dealt damage is then calculated through totalDamage =
     * (pAttack.damage * pAttacker.attack * pAttacker.weatherBonus *
     * pAttacker.typeBonus) - (pDefender.stats.defense * pDefender.weatherBonus
     * pDefender.typeBonus).
     *
     * <p>Note: totalDamage is rounded to the nearest integer before it is returned
     * If the initial pAttack.damage is 0, then the damage dealt is 0. If the
     * totalDamage calculated is negative, the totalDamage dealt should be 1.
     * Any positive value is the total damage dealt.
     *
     * <p>Weather bonus: see the Environment which you can assume is correct. You
     * do need to check if the weather bonus is applied correctly, since maybe
     * the method does not use the environment correctly.On attack or defense,
     * the monster have a buff, debuff or nothing based on the weather. EG. fire
     * monsters have a stat advantage of +25% in sunny weather while they have a
     * stat disadvantage of -25% in the rain.
     *
     * <p>If the attack chosen, matches the monsters type, the attacker will get an
     * extra 20% on its attack. Type bonus: Certain monsters have an type bonus
     * against others (bonuses: Fire against Water: Water gains 25% while Fire
     * looses 25% Fire against Ground: Fire gains 25% while Ground looses 25%
     * Ground against Water: Ground gains 25% while Water looses 25% Normal mon:
     * never gain any type bonus and are weaker during droughts. These bonuses
     * do not stack up, they are just applied for every attack.
     *
     *
     *
     * @param pattack is the attack value given to the method where that attack
     * value is based on the monsters damage value
     * @param pattacker the attacking monster
     * @param pdefender the defending monster (the defending monster will never
     * get damage) to calculate damage output.
     * @return total damage output
     */
    public double calculateDamage(Attack pattack, Mascotmon pattacker, Mascotmon pdefender) {
//        return Math.round(pAttack.damage * 0.2);
        double attackBonus = 1;
        double totalDamage = 0;
        if (pattacker.type.equals(battleWeather.buffedType)) {
            pattacker.weatherBonus = battleWeather.buffModifier;
        } else if (pattacker.type.equals(battleWeather.DebuffedType)) {
            pattacker.weatherBonus = battleWeather.debuffModifier;
        }
        if (pdefender.type.equals(battleWeather.buffedType)) {
            pdefender.weatherBonus = battleWeather.buffModifier;
        } else if (pdefender.type.equals(battleWeather.DebuffedType)) {
            pdefender.weatherBonus = battleWeather.debuffModifier;
        }
        if (pattack.type.equals(pattacker.type)) {
            attackBonus = 1.20;
        }

        switch (pattacker.type) {
            case "Fire":
                if (pdefender.type.equals("Ground")) {
                    pattacker.typeBonus = 1.25;
                    pdefender.typeBonus = 0.75;
                } else if (pdefender.type.equals("Water")) {
                    pattacker.typeBonus = 0.75;
                    pdefender.typeBonus = 1.25;
                }
                break;
            case "Water":
                if (pdefender.type.equals("Fire")) {
                    pattacker.typeBonus = 1.25;
                    pdefender.typeBonus = 0.75;
                } else if (pdefender.type.equals("Ground")) {
                    pattacker.typeBonus = 0.75;
                    pdefender.typeBonus = 1.25;
                }
                break;
            case "Ground":
                if (pdefender.type.equals("Water")) {
                    pattacker.typeBonus = 1.25;
                    pdefender.typeBonus = 0.75;
                } else if (pdefender.type.equals("Fire")) {
                    pattacker.typeBonus = 0.75;
                    pdefender.typeBonus = 1.25;
                }
                break;
            default:
                break;
        }
        totalDamage = (pattack.damage * attackBonus * pattacker.weatherBonus
                * pattacker.typeBonus) - (pdefender.stats.defense
                * pdefender.weatherBonus * pdefender.typeBonus);

        if (totalDamage < 0) {
            return 1;
        } else if (totalDamage == 0) {
            return 0;
        } else {
            return Math.round(totalDamage);
        }
    }

}
