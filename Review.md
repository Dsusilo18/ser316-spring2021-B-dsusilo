
1. [ID#:CS 5][Location:Attack.java]
<Description:>
The class does nothing but store variables for type and damage form its single constructor.  
[Problem]
<Category:> Code Smells
<Severity:> LOW

2. [ID#:FD][Location:BattleScenerio.java Line 30]
<Description:>
Prints out health of the attacker for no apparent reason without any information that its doing so as well. 
[Problem]
<Category:> Functional Defects
<Severity:> MJ

3. [ID#:CG 3][Location: Environment.java Line 9]
<Description:>
The constructor doesn't have a method banner comment present and filled in. 
[Problem]
<Category:> Coding Standards
<Severity:> LOW

4. [ID#:CG 5][Location:Description.java Line 3]
<Description:>
The class variable in the class is able to be accessed without any getter method because it has an access type public. 
[Problem]
<Category:> Coding Standards
<Severity:> BR

5. [ID#:CG 7][Location:Description.java Line 9-21]
<Description:>
The if, else if and else statements doesn't use explicit {} because the body is a single line. 
[Problem]
<Category:> Code Standards
<Severity:> LOW

6. [ID#:FD][Location:BattleScenerio.java Line 145]
<Description:>
The method doesnt calculate damage correctly, it doesn't calculate type, attack and weather bonuses. It also doesn't use the correct formula to calculate damage. 
[Problem]
<Category:> Functional Defects
<Severity:> BR

7. [ID#:CS 3][Location:Mascotmon.java Line 12-22]
<Description:>
Instead of using an if, else if and else statments, it should be a switch stament instead. 
[Problem]
<Category:> Code Smells
<Severity:> LOW
