
public class Stats {

    private double attack;
    private double defense;
    private double health;

    public Stats() {
        attack = 50;
        defense = 50;
        health = 100;
    }

    public Stats(Mascotmon.Name name) {
        switch (name) {
            case ALBERT:
                attack = 60;
                defense = 40;
                health = 100;
                break;
            case RALPHIE:
                attack = 30;
                defense = 65;
                health = 105;
                break;
            case SPARKY:
                attack = 70;
                defense = 40;
                health = 90;
                break;
            case BULLY:
                attack = 40;
                defense = 40;
                health = 110;
                break;
        }

    }

    public double getAttack() {
        return attack;
    }

    public double getDefense() {
        return defense;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double newHealth) {
        this.health = newHealth;
    }

    public void setDefense(double newDef) {
        this.defense = newDef;
    }

    public void setAttack(double newAtt) {
        this.attack = newAtt;
    }
}
