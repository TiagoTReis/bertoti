
public class NotificacaoEmail implements NotificacaoStrategy {
    @Override
    public void notificar(String mensagem) {
        System.out.println("Email enviado: " + mensagem);
    }
}
