
public class TarefaSimples extends Tarefa {

    public TarefaSimples(String nome) {
        super(nome);
    }

    @Override
    public void concluir() {
        System.out.println("Tarefa concluída: " + nome);
        notificarObservadores("Tarefa concluída: " + nome);
    }
}
