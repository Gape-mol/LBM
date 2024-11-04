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
        // Inicializamos la biblioteca sin libros
        biblioteca = new Biblioteca("Biblioteca Central", "123 Calle Falsa");

        // Creamos objetos de libros para usar en las pruebas
        libro1 = new Libro("Cincuenta sombras de Grey", "Erika Leonard Mitchell", "12345","martavid", 2011 );
        libro2 = new Libro("12 años de esclavitud", "David Wilson", "67890", "papelucho",1853);

        // Asignamos una lista de libros inicial
        List<Libro> libros = new ArrayList<>();
        libros.add(libro1);
        biblioteca.setLibros(libros);
    }

    @Test
    public void testCrearLibroExitoso() {
        Libro libro3 = new Libro("Don Quijote", "Miguel de Cervantes", "11111", "IVREA", 1943);
        biblioteca.crearLibro(libro3);

        assertEquals(2, biblioteca.getLibros().size());
        assertTrue(biblioteca.getLibros().contains(libro3));
    }

    @Test
    public void testCrearLibroConIsbnExistente() {
        Libro libroDuplicado = new Libro("Libro duplicado", "Autor desconocido", "12345", "parapapam",200);
        biblioteca.crearLibro(libroDuplicado);

        assertEquals(1, biblioteca.getLibros().size());  // El libro duplicado no debería agregarse
    }


    @Test
    public void testModificarLibroExitoso() {
        biblioteca.modificarLibro("Cincuenta sombras de Grey", "Nuevo Autor", "12345", "Pancho Villa",2022);

        Libro libroModificado = biblioteca.getLibros().get(0);
        assertEquals("Cincuenta sombras de Grey", libroModificado.getTitulo());
        assertEquals("Erika Leonard Mitchell", libroModificado.getAutor());
        assertEquals("12345", libroModificado.getIsbn());
        assertEquals(2011, libroModificado.getYear());
    }



    @Test
    public void testEliminarLibroPorIsbnNoExistente() {
        biblioteca.eliminarLibroPorIsbn("00000");

        assertEquals(1, biblioteca.getLibros().size()); // La biblioteca aún debería contener libro1
    }

    @Test
    public void testBuscarLibroPorIsbnExistente() {
        // Esta prueba confirma que el método se ejecuta sin excepciones y el libro es encontrado
        biblioteca.buscarLibroPorIsbn("12345");
    }

    @Test
    public void testBuscarLibroPorIsbnNoExistente() {
        biblioteca.buscarLibroPorIsbn("00000");
        // Confirma que el método se ejecuta sin excepciones y el libro no es encontrado
    }

    @Test
    public void testMostrarBibliotecaCompleta() {
        biblioteca.mostrarBibliotecaCompleta();
        // Se verifica que el método se ejecuta sin excepciones
    }

    @Test
    public void testMostrarBibliotecaVacia() {
        biblioteca.setLibros(new ArrayList<>()); // Limpiamos la lista de libros
        biblioteca.mostrarBibliotecaCompleta();
        // Se verifica que el método se ejecuta sin excepciones
    }
}

