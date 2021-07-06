
import java.util.LinkedList;

public class CreateMascotmon {

    private String type;
    private String name;
    private LinkedList<Attack> attacks = new LinkedList<>();
    private Stats stats;
    private String description;

    public CreateMascotmon(String name) {
        this.name = name;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(double att, double damage, double health) {
        stats = new Stats();
        stats.setAttack(att);
        stats.setDefense(damage);
        stats.setHealth(health);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public LinkedList<Attack> getAtt() {
        LinkedList<Attack> attTemp = attacks;
        return attTemp;
    }

    public void setAtt(Attack att) {
        attacks.add(att);
    }

}
