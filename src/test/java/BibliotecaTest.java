import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private Libro libro1;
    private Libro libro2;

    @BeforeEach
    public void setUp() {
        libro1 = new Libro("Cincuenta sombras de Grey", "Erika Leonard Mitchell", "12345", 2011);
        libro2 = new Libro("12 años de esclavitud", " David Wilson", "67890", 1853);
        List<Libro> libros = new ArrayList<>();
        libros.add(libro1);
        biblioteca = new Biblioteca("Biblioteca Central", libros, "123 Calle Falsa");
    }

    @Test
    public void testCrearLibroExitoso() {
        Libro libro3 = new Libro("Don Quijote", "Miguel de Cervantes", "11111", 1605);
        biblioteca.crearLibro(libro3);

        assertEquals(2, biblioteca.getLibros().size());
        assertTrue(biblioteca.getLibros().contains(libro3));
    }

    @Test
    public void testCrearLibroConIsbnExistente() {
        Libro libroDuplicado = new Libro("Libro duplicado", "Autor desconocido", "12345", 2000);
        biblioteca.crearLibro(libroDuplicado);

        assertEquals(1, biblioteca.getLibros().size());  // El libro no debería agregarse
    }

    @Test
    public void testModificarLibroExitoso() {
        biblioteca.modificarLibro("Nuevo Titulo", "Nuevo Autor", "54321", 2022);
        Libro libroModificado = biblioteca.getLibros().get(0);

        assertEquals("Nuevo Titulo", libroModificado.getTitulo());
        assertEquals("Nuevo Autor", libroModificado.getAutor());
        assertEquals("54321", libroModificado.getIsbn());
        assertEquals(2022, libroModificado.getYear());
    }


    @Test
    public void testEliminarLibroPorIsbnNoExistente() {
        biblioteca.eliminarLibroPorIsbn("00000");

        assertEquals(1, biblioteca.getLibros().size());
    }

    @Test
    public void testBuscarLibroPorIsbnExistente() {
        biblioteca.buscarLibroPorIsbn("12345");
        // La prueba confirma que el método se ejecuta sin excepciones.
    }

    @Test
    public void testBuscarLibroPorIsbnNoExistente() {
        biblioteca.buscarLibroPorIsbn("00000");
        // La prueba confirma que el método se ejecuta sin excepciones.
    }

    @Test
    public void testMostrarBibliotecaCompleta() {
        biblioteca.mostrarBibliotecaCompleta();
        // Se verifica que el método se ejecuta sin excepciones.
    }


}
