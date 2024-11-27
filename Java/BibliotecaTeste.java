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
