public class SmartHomeSystem {
    private OldLamp oldLamp;

    public SmartHomeSystem() {
        this.oldLamp = new OldLamp();
    }

    public void connectOldLampDirectly() {
        System.out.println("Tentando conectar lâmpada antiga no sistema inteligente...");

        // Gambiarra: adicionando métodos direto no sistema legado
        System.out.println("Adicionando funções 'inteligentes' manualmente na lâmpada...");
        oldLamp.turnOn();

        System.out.println("Verificando estado manualmente...");
        if (oldLamp.isPowered()) {
            System.out.println("OK: Lâmpada ligada.");
        }

        System.out.println("Desligando manualmente...");
        oldLamp.turnOff();

        System.out.println("\nProblemas:");
        System.out.println("❌ Sistema precisa conhecer diretamente a OldLamp;");
        System.out.println("❌ Nenhuma interface comum entre dispositivos;");
        System.out.println("❌ Cada tipo de lâmpada exigirá código duplicado;");
        System.out.println("❌ Dificuldade para substituir por uma SmartLight real depois.");
    }
}
