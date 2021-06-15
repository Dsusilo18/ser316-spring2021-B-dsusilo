
public class Attack {

    private String type;
    private double damage;

    public Attack(double damage, String type) {
        this.type = type;
        this.damage = damage;
    }

    public String getType() {
        return type;
    }

    public double getDamage() {
        return damage;
    }

}
