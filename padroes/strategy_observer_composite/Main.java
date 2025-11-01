public class Main {
    public static void main(String[] args) {

        // ====== Estratégias (Strategy) ======
        NotificacaoStrategy console = new NotificacaoConsole();
        NotificacaoStrategy email = new NotificacaoEmail();
        NotificacaoStrategy sms = new NotificacaoSMS();

        // ====== Usuários (Observer) ======
        Usuario u1 = new Usuario("Alice", console);
        Usuario u2 = new Usuario("Bob", email);
        Usuario u3 = new Usuario("Carol", sms);

        // ====== Tarefas simples (Composite - Leaf) ======
        Tarefa t1 = new TarefaSimples("Analisar requisitos");
        Tarefa t2 = new TarefaSimples("Desenvolver módulo X");
        Tarefa t3 = new TarefaSimples("Testar integração");

        // ====== Projeto (Composite - nó composto) ======
        Projeto projeto = new Projeto("Sistema de Gestão");
        projeto.adicionarTarefa(t1);
        projeto.adicionarTarefa(t2);
        projeto.adicionarTarefa(t3);

        // ====== Observadores inscritos ======
        t1.adicionarObservador(u1); // Alice será notificada da tarefa 1
        t2.adicionarObservador(u2); // Bob será notificado da tarefa 2
        projeto.adicionarObservador(u3); // Carol será notificada do projeto

        // ====== Execução ======
        projeto.concluir(); // Conclui o projeto e todas as tarefas

        // ====== Demonstra troca dinâmica de Strategy ======
        System.out.println("\n--- Trocando a estratégia de notificação da Alice ---");
        u1.setEstrategia(new NotificacaoEmail());
        t1.concluir(); // Alice agora recebe notificação por email
    }
}
