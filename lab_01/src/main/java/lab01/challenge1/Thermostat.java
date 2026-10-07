package lab01.challenge1;

public class Thermostat extends Device {
    private int targetTemperature;

    public Thermostat(String name, int targetTemperature) {
        super(name);
        setTargetTemperature(targetTemperature);
    }

    public void setTargetTemperature(int targetTemperature) {
        if (targetTemperature < 16 || targetTemperature > 28) {
            throw new IllegalArgumentException("Temperatura trebuie sa fie intre 16 si 28 grade");
        }
        this.targetTemperature = targetTemperature;
    }

    @Override
    public double powerUsage() {
        if (!isOn()){
            return 0.0;
        }
        return 50.0;
    }

    @Override
    public String status() {
        return "Termostatul " + getName() + " are starea " + (isOn() ? "pornit cu " + targetTemperature + " grade tinta" : "oprit");
    }
}