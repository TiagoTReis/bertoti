
public abstract class Tarefa extends TarefaObservable {
    protected String nome;

    public Tarefa(String nome) {
        this.nome = nome;
    }

    public abstract void concluir();
}
