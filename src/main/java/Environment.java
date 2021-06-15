
public class Environment {

    private Weather WeatherType;
    private String buffedType;
    private String DebuffedType;
    private double buffModifier;
    private double debuffModifier;

    public Environment() {
        this(Weather.neutral);
    }

    public Environment(Weather weather) {
        this.WeatherType = weather;
        this.buffModifier = 1.25;
        this.debuffModifier = 0.75;
        switch (weather) {
            case sunny:
                this.buffedType = "Fire";
                this.DebuffedType = "Water";
                break;
            case rainy:
                this.buffedType = "Water";
                this.DebuffedType = "Fire";
                break;
            case drought:
                this.buffedType = "Ground";
                this.DebuffedType = "Normal";
                break;
            default:
                this.buffedType = "";
                this.DebuffedType = "";
                break;
        }
    }

    //SER316 TASK 2 SPOT-BUGS FIX
    public String getBuffedType() {
        return buffedType;
    }

    public String getDebuffedType() {
        return DebuffedType;
    }

    public enum Weather {
        sunny, rainy, drought, neutral
    }

    public double getDebuffMod() {
        return debuffModifier;
    }

    public double getBuffMod() {
        return buffModifier;
    }

    public Weather getWeather() {
        return WeatherType;
    }
}
