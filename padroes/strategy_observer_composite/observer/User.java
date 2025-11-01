
public class User implements UsuarioObserver {
    private String nome;
    private NotificacaoStrategy estrategia; // utiliza Strategy

    public Usuario(String nome, NotificacaoStrategy estrategia) {
        this.nome = nome;
        this.estrategia = estrategia;
    }

    public void setEstrategia(NotificacaoStrategy estrategia) {
        this.estrategia = estrategia; // permite trocar a estratégia de notificação
    }

    @Override
    public void atualizar(String mensagem) {
        estrategia.notificar(nome + " recebeu: " + mensagem);
    }
}
