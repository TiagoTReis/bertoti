1 - We see three critical differences between programming and software engineering: time, scale, and the trade-offs at play. On a software engineering project, engineers need to be more concerned with the passage of time and the eventual need for change. In a software engineering organization, we need to be more concerned about scale and efficiency, both for the software we produce as well as for the organization that is producing it. Finally, as software engineers, we are asked to make more complex decisions with higher-stakes outcomes, often based on imprecise estimates of time and growth.

**RESUMO:**

Basicamente existem 3 diferenças criticas entre programação e engenharia de software

- tempo
- escala
- compensações

Na engenharia de software o engenheiro precisa ter uma visão do projeto total afim de otimizar o tempo para eventuais mudanças, a escala e os trade -offs pelo caminho. Os engenheiros de software são os profissionais preparados a tomar as decisões mais complexas com risco alto nem sempre dentro do tempo ou obtendo exito.

**2 - Trade - Offs**

É um processo de escolha buscando o equilíbrio entre muitas características onde melhoramos um aspecto e acabamos sacrificando outro. Por exemplo: 
- um código muito otimizado acaba deixando-o menos intuitivo ou então um código mais complexo pode ser mais difícil de manter ou depurar.
  
- Quando optamos por soluções mais simples e diretas facilitamos a manutenção, mas pode limitar a funcionalidade ou a eficiência.

- Implementar verificações extensivas e tratamentos de erros pode aumentar a confiabilidade do software, mas também pode diminuir a performance devido ao tempo extra necessário para essas verificações.

**3 - Projeto java com junit testes**

CLASSE Livro

public class Livro {
    
    private String titulo;
    private String autor;

    
    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    
    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }
}

CLASSE Biblioteca

import java.util.List;
import java.util.ArrayList;

public class Biblioteca {

    private List<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        this.livros.add(livro);
    }

    public List<Livro> getLivros() {
        return this.livros;
    }

       public Livro buscarLivroPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null; 
    }
}
CLASSE BibliotecaTeste

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

class BibliotecaTeste {

    @Test
    void testAdicionarLivros() {
        Biblioteca biblioteca = new Biblioteca();

        Livro livro1 = new Livro("O Hobbit", "J.R.R. Tolkien");
        Livro livro2 = new Livro("1984", "George Orwell");

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);

       assertEquals(2, biblioteca.getLivros().size());
    }

    @Test
    void testBuscarLivroPorTitulo() {
        Biblioteca biblioteca = new Biblioteca();

        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien");
        Livro livro2 = new Livro("A Revolução dos Bichos", "George Orwell");

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);

        Livro encontrado = biblioteca.buscarLivroPorTitulo("O Senhor dos Anéis");

        assertNotNull(encontrado);
        assertEquals("J.R.R. Tolkien", encontrado.getAutor());
    }

    @Test
    void testBuscarLivroInexistente() {
        Biblioteca biblioteca = new Biblioteca();

        Livro livro = new Livro("Dom Quixote", "Miguel de Cervantes");
        biblioteca.adicionarLivro(livro);

        Livro encontrado = biblioteca.buscarLivroPorTitulo("Cem Anos de Solidão");

        assertNull(encontrado);
    }
}

**4- DIAGRAMA UML**

[diagrama UML](https://github.com/TiagoTReis/bertoti/blob/main/Eng%20SW/BERTOTI.png)
