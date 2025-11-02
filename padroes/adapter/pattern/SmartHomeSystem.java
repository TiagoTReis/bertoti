public class SmartHomeSystem {
    public void controlDevice(SmartDevice device) {
        System.out.println("SmartHomeSystem: Controlando dispositivo...");
        device.turnOn();
        System.out.println("Dispositivo ligado? " + device.isOn());
        device.turnOff();
        System.out.println("Dispositivo ligado? " + device.isOn());
    }
}
