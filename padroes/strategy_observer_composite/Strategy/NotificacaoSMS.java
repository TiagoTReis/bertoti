
public class NotificacaoSMS implements NotificacaoStrategy {
    @Override
    public void notificar(String mensagem) {
        System.out.println("SMS enviado: " + mensagem);
    }
}
