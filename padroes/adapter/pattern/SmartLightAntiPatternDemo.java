public class SmartLightPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== DEMONSTRAÇÃO DO ADAPTER PATTERN ===\n");

        OldLamp oldLamp = new OldLamp();
        SmartDevice lampAdapter = new OldLampAdapter(oldLamp);

        SmartHomeSystem homeSystem = new SmartHomeSystem();
        homeSystem.controlDevice(lampAdapter);
    }
}
