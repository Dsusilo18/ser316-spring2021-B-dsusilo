
import java.util.concurrent.ThreadLocalRandom;

public class Mascotmon {

    String description;
    String type;
    Name name;
    Stats stats;
    double weatherBonus = 1.0;
    double typeBonus = 1.0;
    int bufCounter = 0;

    public Mascotmon() {
        int rand = ThreadLocalRandom.current().nextInt(0, 4);
        switch (rand) {
            case 0:
                name = Name.ALBERT;
                break;
            case 1:
                name = Name.RALPHIE;
                break;
            case 2:
                name = Name.SPARKY;
                break;
            default:
                name = Name.BULLY;
                break;
        }
        getType();
        getStats();
        getDescription();
    }

    public Mascotmon(Name name) {
        this.name = name;
        getType();
        getStats();
        getDescription();
    }

    private void getType() {
        Type t = new Type(name);
        this.type = t.getType();
    }

    private void getStats() {
        stats = new Stats(name);

    }

    private void getDescription() {
        Description desc = new Description(name);
        this.description = desc.getDesc();
    }

    /**
     * Method randomly determines an attack to use based on the defending
     * Mascotmon and returns the base damage of the attack selected. The
     * self-buff (attackNumber 0) can only be used 3 times during a battle.
     *
     * @return attack damage You can assume that this method uses the values it
     * is supposed to use and is correct.
     */
    public Attack attack() {
        double attackDamage;
        attackDamage = 0;
        int attackNumber = 0;

        while (true) {
            attackNumber = ThreadLocalRandom.current().nextInt(0, 4);
            if (attackNumber == 0 && bufCounter <= 2) {
                bufCounter++;
                break;
            } else if (attackNumber != 0) {
                break;
            }
        }

        String desc = "";
        Attack attack = null;

        switch (name) {
            case ALBERT:
                if (attackNumber == 0) {
                    desc = " uses Iron Scales, increasing defense stat by 10%";
                    stats.setDefense(stats.getDefense()* 1.10);
                    attack = new Attack(0, "None");
                } else if (attackNumber == 1) {
                    desc = " uses Death Roll";
                    attack = new Attack(stats.getAttack(), "Ground");
                } else if (attackNumber == 2) {
                    desc = " uses Chomp";
                    attack = new Attack(stats.getAttack(), "Normal");
                } else {
                    desc = " uses Aqua Cannon";
                    attack = new Attack(stats.getAttack(), "Water");
                }
                break;
            case RALPHIE:
                if (attackNumber == 0) {
                    desc = " uses Iron Hide, increasing defense stat by 10%";
                    stats.setDefense(stats.getDefense()* 1.10);
                    attack = new Attack(0, "None");
                } else if (attackNumber == 1) {
                    desc = " uses Ground Stomp";
                    attack = new Attack(stats.getAttack(), "Ground");
                } else if (attackNumber == 2) {
                    desc = " uses Headbutt";
                    attack = new Attack(stats.getAttack(), "Normal");
                } else {
                    desc = " uses Flaming Horn";
                    attack = new Attack(stats.getAttack(), "Fire");
                }
                break;
            case SPARKY:
                if (attackNumber == 0) {
                    desc = " uses Heat Up, increasing attack stat by 10%";
                    stats.setAttack(stats.getDefense()* 1.10);
                    attack = new Attack(0, "None");
                } else if (attackNumber == 1) {
                    desc = " uses Inferno";
                    attack = new Attack(stats.getAttack(), "Fire");
                } else if (attackNumber == 2) {
                    desc = " uses Quick Attack";
                    attack = new Attack(stats.getAttack(), "Normal");
                    System.out.println("Attack value: " + stats.getAttack());
                } else {
                    desc = " uses Earthquake";
                    attack = new Attack(stats.getAttack(), "Ground");
                }
                break;
            case BULLY:
                if (attackNumber == 0) {
                    desc = " uses Sleep, increasing health stat by 10%";
                    double health = stats.getHealth() * 1.10;
                    stats.setHealth(Math.round(health));
                    attack = new Attack(0, "None");
                } else if (attackNumber == 1) {
                    desc = " uses Body Slam";
                    attack = new Attack(stats.getAttack(), "Normal");
                } else if (attackNumber == 2) {
                    desc = " uses Splash";
                    attack = new Attack(stats.getAttack(), "Water");
                } else {
                    desc = " uses Ground Pound";
                    attack = new Attack(stats.getAttack(), "Ground");
                }
        }

        System.out.println(name.toString().toLowerCase() + desc);
        return attack;
    }

    public enum Name {
        ALBERT, RALPHIE, SPARKY, BULLY
    }
}
