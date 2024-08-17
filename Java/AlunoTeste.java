import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class AlunoTeste {

	
	@Test
	void test() {
		
		SalaAluno fatec = new SalaAluno();
		
		Aluno joao = new Aluno("joao","12345");
		
		fatec.cadastrarAluno(joao);
		
		assertEquals (fatec.getAlunos().size(),1);
		
	}
}
