public class OldLamp {
    private boolean power;

    public void turnOn() {
        power = true;
        System.out.println("Lâmpada antiga ligada (interruptor físico).");
    }

    public void turnOff() {
        power = false;
        System.out.println("Lâmpada antiga desligada (interruptor físico).");
    }

    public boolean isPowered() {
        return power;
    }
}
