# SER316 Mascotmon Simulator

Ever wanted to show more support for your favorite team and mascot? Then have no fear because Mascotmon is here! 
This simulator allows mascots to battle each other to see which is the strongest one of all. 
The mascots have a specific type (fire, water, ground, or normal) and three stats that consist of: attack, defense, and health.
The battlefield's weather as well as type advantages may have positive or negative effects on the attack or defense stats of certain types.

The damage formula should be the attacker's attack value * weather and types bonuses - defender's defense * weather and types bonuses. 


-----------------------------------------------------------------------------------------------------------------------------
Partial example scenario calculation:

This is a bit of additional explanation for how the method calculateDamage() in BattleScenario.java should work. There is a full description of the calculation in the header comments of calculateDamage(). Below are just a few partial examples to help clarify any points of confusion. 

totalDamage = (pAttack.damage * pAttacker.attack * pAttacker.weatherBonus * pAttacker.typeBonus) -
                (pDefender.stats.defense * pDefender.weatherBonus * pDefender.typeBonus)

Choose your multipliers depending on the attack type and monster types and day type.

--- Examples for attacking (left) side of the equation:   
- Ground monster attacks another ground monster on a sunny day with a ground attack with 70 damage (number given to the method)
70 * 1.2 * 1 * 1 would be the left side of the equation, since 70 is the damage
1.2 - 20% on top since ground monster uses ground attack
1 - no bonus since ground monster does not have weather advantage on sunny day
1 - since ground against ground has no advantage
** don't forget to then subtract the right side of the equation with the multiple of the defender's stats)

- fire monster, with ground attack, on sunny day against a water monster, with 60 damage
left side of the equation = 60 * 1 * 1.25 * 0.75
60 - damage 
1 - since not fire attack
1.25 - since sunny day
0.75 - since less effective against water
** don't forget to then subtract the right side of the equation with the multiple of the defender's stats)

--- For defending, the type bonus means that if a fire monster attacks a water monster, the fire monster's attack will be less effective (0.75) while the water defender will get the 25% boost, so 1.25 as factor.

In general, if the day matches the mon the weather bonus is +25%, while in bad weather for them -25% no matter if they are the attacker or defender. Same for the type bonus, if the attack is good for the attacker (fire mon, fire attack) the attacker gets a buf, if the defender has an advantage or disadvantage with the attack, e.g. defender is water it will be able to better deflect fire attacks, so it will get a buf on the type. 


