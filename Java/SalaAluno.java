import java.util.List;
import java.util.LinkedList;

public class SalaAluno {

	private List <Aluno> alunos = new LinkedList<Aluno>();
	
	public void cadastrarAluno (Aluno aluno) {
		
		alunos.add(aluno);
	}
	
	public List <Aluno> getAlunos(){
	
	return alunos;
	}
}


