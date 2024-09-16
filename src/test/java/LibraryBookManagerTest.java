import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.Objects;

class LibraryBookManagerTest {
    Object[][] libros = new Object[10][5];

    @BeforeEach
    void setUp() {
        libros[0][0] = "1234567890";
        libros[0][1] = "Libro de prueba";
        libros[0][2] = "Autor de prueba";
        libros[0][3] = 3; //Stock de prueba
    }
    @Test
    void testEliminarLibro() {
        String isbn = "1234567890";
        LibraryBookManager.eliminarLibro(libros, isbn);
        assertNull(libros[0][0]);
        assertNull(libros[0][1]);
        assertNull(libros[0][2]);
        assertNull(libros[0][3]);
    }

    @Test
    void testEliminarLibroNoEncontrado() {
        LibraryBookManager.eliminarLibro(libros, "1234567891");
        assertEquals("1234567890", libros[0][0]);
        assertEquals("Libro de prueba", libros[0][1]);
        assertEquals("Autor de prueba", libros[0][2]);
        assertEquals(3, libros[0][3]);
    }

    @Test
    void testBuscarLibro() {
        Object[] libro = LibraryBookManager.buscarLibro(libros, "1234567890");
        assertEquals("1234567890", Objects.requireNonNull(libro)[0]); //Esto verifica que el objeto no sea nulo y que ademas sea igual a el ISBN
        assertEquals("Libro de prueba", libro[1]);
        assertEquals("Autor de prueba", libro[2]);
        assertEquals(3, libro[3]);
    }
    ;
    @Test
    void testAgregarLibro() {
        LibraryBookManager.agregarLibro(biblioteca, "12345", "Papelucho", "Marcela Paz", 3);
        assertEquals(biblioteca[1][0], "12345");
        assertEquals(biblioteca[1][1], "Papelucho");
        assertEquals(biblioteca[1][2], "Marcela Paz");
        assertEquals(biblioteca[1][3], 3);
    }

    @Test
    void testAgregarLibroStock() {
        LibraryBookManager.agregarLibro(biblioteca, "12345", "Papelucho", "Marcela Paz", 3);
        LibraryBookManager.agregarLibro(biblioteca, "12345", "Papelucho", "Marcela Paz", 3);
        assertEquals(biblioteca[1][0], "12345");
        assertEquals(biblioteca[1][3], 6);
    }

}