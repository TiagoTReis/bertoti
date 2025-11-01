import java.util.ArrayList;
import java.util.List;


public class Projeto extends Tarefa {
    private List<Tarefa> tarefas = new ArrayList<>();

    public Projeto(String nome) {
        super(nome);
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public void removerTarefa(Tarefa tarefa) {
        tarefas.remove(tarefa);
    }

    @Override
    public void concluir() {
        System.out.println("Projeto concluído: " + nome);
        for (Tarefa t : tarefas) {
            t.concluir();
        }
        notificarObservadores("Projeto concluído: " + nome);
    }
}
