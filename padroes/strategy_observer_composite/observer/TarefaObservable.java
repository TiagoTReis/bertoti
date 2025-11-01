import java.util.ArrayList;
import java.util.List;


public class TarefaObservable {
    private List<UsuarioObserver> observadores = new ArrayList<>();

    public void adicionarObservador(UsuarioObserver usuario) {
        observadores.add(usuario);
    }

    public void removerObservador(UsuarioObserver usuario) {
        observadores.remove(usuario);
    }

    protected void notificarObservadores(String mensagem) {
        for (UsuarioObserver obs : observadores) {
            obs.atualizar(mensagem);
        }
    }
}
