1 - We see three critical differences between programming and software engineering: time, scale, and the trade-offs at play. On a software engineering project, engineers need to be more concerned with the passage of time and the eventual need for change. In a software engineering organization, we need to be more concerned about scale and efficiency, both for the software we produce as well as for the organization that is producing it. Finally, as software engineers, we are asked to make more complex decisions with higher-stakes outcomes, often based on imprecise estimates of time and growth.

Basicamente existem 3 diferenças criticas entre programação e engenharia de software

- tempo
- escala
- compensações

Na engenharia de software o engenheiro precisa ter uma visão do projeto total afim de otimizar o tempo para eventuais mudanças, a escala e os trade -offs pelo caminho. Os engenheiros de software são os profissionais preparados a tomar as decisões mais complexas com risco alto nem sempre dentro do tempo ou obtendo exito.

2 - Trade - Offs

É um processo de escolha buscando o equilíbrio entre muitas características onde melhoramos um aspecto e acabamos sacrificando outro. Por exemplo: 
- um código muito otimizado acaba deixando-o menos intuitivo ou então um código mais complexo pode ser mais difícil de manter ou depurar.
  
- Quando optamos por soluções mais simples e diretas facilitamos a manutenção, mas pode limitar a funcionalidade ou a eficiência.

- Implementar verificações extensivas e tratamentos de erros pode aumentar a confiabilidade do software, mas também pode diminuir a performance devido ao tempo extra necessário para essas verificações.

3 - Comentarios do codigo Aluno feitos no Eclipse

CLASSE SalaAula

// import das classes utilitárias
import java.util.List;
import java.util.LinkedList;

// definição da classe da sala
public class SalaAula {
    // atributo da classe
    private List<Aluno> alunos = new LinkedList<Aluno>();

    // métodos para acessar o atributo da classe por fora da classe
    public void cadastrarAluno(Aluno aluno) {
	this.alunos.add(aluno);
    }

    public List<Aluno> getAlunos() {
	return this.alunos;
    }
}

CLASSE Aluno

// definição da classe do aluno
public class Aluno {
    // atributos da classe
    private String nome;
    private String ra;

    // construtor da classe
    public Aluno(String nome, String ra) {
	this.nome = nome;
	this.ra = ra;
    }

    // métodos para acessar o atributo da classe por fora da classe
    public String getNome() {
	return this.nome;
    }

    public String getRa() {
	return this.ra;
    }
}

CLASSE Teste

// import das classes utilitárias
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// definição da classe teste
class AlunoTeste {
    // decorator do teste
    @Test
    void testCadastrarDoisAlunos() {
        // instancia uma sala
	SalaAula sala2BD = new SalaAula();

        // instancia alunos
	Aluno joao = new Aluno("Joao", "12345");
	Aluno jose = new Aluno("Jose", "54321");

 	// cadastra os alunos na sala
	sala2BD.cadastrarAluno(joao);
	sala2BD.cadastrarAluno(jose);

 	// verificase a sala tem os dois alunos cadastrados
	assertEquals(sala2BD.getAlunos().size(), 2);
    }

    @Test
    void testTrazPrimeiroAlunoDaLista() {
	SalaAula sala2BD = new SalaAula();
	Aluno augustoJose = new Aluno("Augusto Jose", "123");
	Aluno joseAugusto = new Aluno("Jose Augusto", "321");
	sala2BD.cadastrarAluno(augustoJose);
	sala2BD.cadastrarAluno(joseAugusto);

 	// associa todos alunos da sala em uma variável
	List<Aluno> todosAlunos = sala2BD.getAlunos();

 	// verifica se o primeiro aluno é o primeiro aluno cadastrado
	assertEquals(todosAlunos.get(0).getRa(), augustoJose.getRa());
    }

    @Test
    void testAlunosSaoDiferentes() {
	SalaAula sala2BD = new SalaAula();
	Aluno augustoJose = new Aluno("Augusto Jose", "123");
	Aluno joseAugusto = new Aluno("Jose Augusto", "321");
	sala2BD.cadastrarAluno(augustoJose);
	sala2BD.cadastrarAluno(joseAugusto);
	List<Aluno> todosAlunos = sala2BD.getAlunos();
 	// verifica se os dois alunos são diferentes
	assertNotEquals(todosAlunos.get(0).getNome(), todosAlunos.get(1).getNome());
    }
}




