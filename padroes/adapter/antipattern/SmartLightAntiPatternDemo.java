public class SmartLightAntiPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== DEMONSTRAÇÃO DO ANTI-PATTERN ADAPTER ===\n");

        SmartHomeSystem system = new SmartHomeSystem();
        system.connectOldLampDirectly();
    }
}

