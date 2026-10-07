package lab01.challenge1;

public abstract class Device {
    private String name;

    private boolean isOn;

    public Device(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Numele dispozitivului nu poate lipsi");
        }
        this.name = name;
        this.isOn = false;
    }

    public void turnOn() {
        this.isOn = true;
    }

    public void turnOff(){
        this.isOn = false;
    }

    public boolean isOn() {
        return this.isOn;
    }

    public String getName() {
        return this.name;
    }

    public abstract double powerUsage();

    public abstract String status();

}
