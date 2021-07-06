
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Mascotmon {

    String description;
    String type;
    String name;
    private Name title;
    Stats stats;
    double weatherBonus = 1.0;
    double typeBonus = 1.0;
    int bufCounter = 0;
    private LinkedList<Attack> attacks = new LinkedList<>();
    private int attMax;

    public Mascotmon() {
        int rand = ThreadLocalRandom.current().nextInt(0, 4);
        switch (rand) {
            case 0:
                title = Name.ALBERT;
                break;
            case 1:
                title = Name.RALPHIE;
                break;
            case 2:
                title = Name.SPARKY;
                break;
            default:
                title = Name.BULLY;
                break;
        }
        name = title.toString();
        getType();
        getStats();
        getDescription();
        attMax = 4;
    }

    public Mascotmon(Name name) {
        title = name;
        this.name = name.toString();
        getType();
        getStats();
        getDescription();
        attMax = 4;
    }

    public Mascotmon(CreateMascotmon newMon) {
        name = newMon.getName();
        type = newMon.getType();
        stats = newMon.getStats();
        description = newMon.getDescription();
        attacks = newMon.getAtt();
        attMax = 0;
    }

    public void addAttack(Attack attack) {
        attacks.add(attack);
    }

    private void getType() {
        Type t = new Type(title);
        this.type = t.getType();
    }

    private void getStats() {
        stats = new Stats(title);

    }

    private void getDescription() {
        Description desc = new Description(title);
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
        if (!attacks.isEmpty()) {
            attMax += attacks.size();
        }

        while (true) {
            attackNumber = ThreadLocalRandom.current().nextInt(0, attMax);
            if (attackNumber == 0 && bufCounter <= 2) {
                bufCounter++;
                break;
            } else if (attackNumber != 0) {
                break;
            }
        }

        String desc = "";
        Attack attack = null;

        switch (title) {
            case ALBERT:
        switch (attackNumber) {
            case 0:
                desc = " uses Iron Scales, increasing defense stat by 10%";
                stats.setDefense(stats.getDefense() * 1.10);
                attack = new Attack(0, "None");
                break;
            case 1:
                desc = " uses Death Roll";
                attack = new Attack(stats.getAttack(), "Ground");
                break;
            case 2:
                desc = " uses Chomp";
                attack = new Attack(stats.getAttack(), "Normal");
                break;
            case 3:
                desc = " uses Aqua Cannon";
                attack = new Attack(stats.getAttack(), "Water");
                break;
            default:
                desc = attacks.get(attackNumber - 4).getDesc();
                attack = new Attack(stats.getAttack(), attacks.get(attackNumber - 4).getType());
                break;
        }
                break;
            case RALPHIE:
        switch (attackNumber) {
            case 0:
                desc = " uses Iron Hide, increasing defense stat by 10%";
                stats.setDefense(stats.getDefense() * 1.10);
                attack = new Attack(0, "None");
                break;
            case 1:
                desc = " uses Ground Stomp";
                attack = new Attack(stats.getAttack(), "Ground");
                break;
            case 2:
                desc = " uses Headbutt";
                attack = new Attack(stats.getAttack(), "Normal");
                break;
            case 3:
                desc = " uses Flaming Horn";
                attack = new Attack(stats.getAttack(), "Fire");
                break;
            default:
                desc = attacks.get(attackNumber - 4).getDesc();
                attack = new Attack(stats.getAttack(), attacks.get(attackNumber - 4).getType());
                break;
        }
                break;
            case SPARKY:
        switch (attackNumber) {
            case 0:
                desc = " uses Heat Up, increasing attack stat by 10%";
                stats.setAttack(stats.getDefense() * 1.10);
                attack = new Attack(0, "None");
                break;
            case 1:
                desc = " uses Inferno";
                attack = new Attack(stats.getAttack(), "Fire");
                break;
            case 2:
                desc = " uses Quick Attack";
                attack = new Attack(stats.getAttack(), "Normal");
                System.out.println("Attack value: " + stats.getAttack());
                break;
            case 3:
                desc = " uses Earthquake";
                attack = new Attack(stats.getAttack(), "Ground");
                break;
            default:
                desc = attacks.get(attackNumber - 4).getDesc();
                attack = new Attack(stats.getAttack(), attacks.get(attackNumber - 4).getType());
                break;
        }
                break;
            case BULLY:
        switch (attackNumber) {
            case 0:
                desc = " uses Sleep, increasing health stat by 10%";
                double health = stats.getHealth() * 1.10;
                stats.setHealth(Math.round(health));
                attack = new Attack(0, "None");
                break;
            case 1:
                desc = " uses Body Slam";
                attack = new Attack(stats.getAttack(), "Normal");
                break;
            case 2:
                desc = " uses Splash";
                attack = new Attack(stats.getAttack(), "Water");
                break;
            case 3:
                desc = " uses Ground Pound";
                attack = new Attack(stats.getAttack(), "Ground");
                break;
            default:
                desc = attacks.get(attackNumber - 4).getDesc();
                attack = new Attack(stats.getAttack(), attacks.get(attackNumber - 4).getType());
                break;
        }
                break;
            default:
                desc = attacks.get(attackNumber).getDesc();
                attack = new Attack(stats.getAttack(), attacks.get(attackNumber).getType());
                break;

        }

        System.out.println(name.toString().toLowerCase() + desc);
        return attack;

    }

    public enum Name {
        ALBERT, RALPHIE, SPARKY, BULLY
    }
}
