
public class Attack {

    private String type;
    private double damage;
    private String description;

    public Attack(double damage, String type) {
        this.type = type;
        this.damage = damage;
    }

    public Attack(String desc, String type) {
        this.type = type;
        description = desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return description;
    }

    public double getDamage() {
        return damage;
    }

}
