package lab01.challenge1;

import java.util.ArrayList;
import java.util.List;

// 1. abstractizare: folosim clasa abstracta Device care forteaza implementarea metodelor abstracte powerUsage() si status().
// 2. incapsulare: toate campurile sunt private, iar datele se modifica doar prin metode care valideaza intrarile (arunca IllegalArgumentException daca datele sunt gresite).
// 3. mostenire: clasele Light, Thermostat si SecurityCamera mostenesc din Device si apeleaza super(name).
// 4. polimorfism: in clasa SmartHome lucram doar cu o lista generica de tip List<Device>, iar la rulare se apeleaza automat metoda corespunzatoare fara verificari cu instanceof.
public class SmartHome {
    private List<Device> devices;

    public SmartHome() {
        this.devices = new ArrayList<>();
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public double totalPowerUsage() {
        double total = 0.0;
        for (Device device : devices) {
            total += device.powerUsage();
        }
        return total;
    }

    public void turnEverythingOff() {
        for (Device device : devices) {
            device.turnOff();
        }
    }

    public void printStatus() {
        for (Device device : devices) {
            System.out.println(device.status());
        }
    }

    public static void run() {
        SmartHome myHome = new SmartHome();

        Light livingLight = new Light("Living", 75);
        Thermostat bedroomThermostat = new Thermostat("Dormitor", 22);
        SecurityCamera outdoorCamera = new SecurityCamera("Exterior");

        livingLight.turnOn();
        bedroomThermostat.turnOn();
        outdoorCamera.turnOn();
        outdoorCamera.startRecording();

        myHome.addDevice(livingLight);
        myHome.addDevice(bedroomThermostat);
        myHome.addDevice(outdoorCamera);

        System.out.println("Status initial:");
        myHome.printStatus();
        System.out.println("Consum total curent: " + myHome.totalPowerUsage() + " W");

        System.out.println("Oprim dispozitivele");
        myHome.turnEverythingOff();
        myHome.printStatus();
        System.out.println("Consum total curent: " + myHome.totalPowerUsage() + " W");

        System.out.println("Testare exceptie");
        try {
            System.out.println("Incercam sa punem luminozitatea la 150...");
            livingLight.setBrightness(150);
        } catch (IllegalArgumentException e) {
            System.out.println("Exceptie prinsa: " + e.getMessage());
        }
    }
}