public class OldLampAdapter implements SmartDevice {
    private OldLamp oldLamp;

    public OldLampAdapter(OldLamp oldLamp) {
        this.oldLamp = oldLamp;
    }

    @Override
    public void turnOn() {
        System.out.println("Adapter: ligando a lâmpada antiga via interface SmartDevice...");
        oldLamp.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println("Adapter: desligando a lâmpada antiga via interface SmartDevice...");
        oldLamp.turnOff();
    }

    @Override
    public boolean isOn() {
        return oldLamp.isPowered();
    }
}
