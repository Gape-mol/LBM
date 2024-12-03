import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.Objects;

class LibraryBookManagerTest {
    Object[][] libros = new Object[10][5];

    @BeforeEach
    void setUp() {
        libros[0][0] = "1234567890";
        libros[0][1] = "Model.Libro de prueba";
        libros[0][2] = "Autor de prueba";
        libros[0][3] = 3; //Stock de prueba
    }}
/*
    @Test
    void testEliminarLibro() {
        String isbn = "1234567890";
        GUI.LibraryBookManager.eliminarLibro(libros, isbn);
        assertNull(libros[0][0]);
        assertNull(libros[0][1]);
        assertNull(libros[0][2]);
        assertNull(libros[0][3]);
    }

    @Test
    void testEliminarLibroNoEncontrado() {
        GUI.LibraryBookManager.eliminarLibro(libros, "1234567891");
        assertEquals("1234567890", libros[0][0]);
        assertEquals("Model.Libro de prueba", libros[0][1]);
        assertEquals("Autor de prueba", libros[0][2]);
        assertEquals(3, libros[0][3]);
    }

    @Test
    void testBuscarLibro() {
        Object[] libro = GUI.LibraryBookManager.buscarLibro(libros, "1234567890");
        assertEquals("1234567890", Objects.requireNonNull(libro)[0]); //Esto verifica que el objeto no sea nulo y que ademas sea igual a el ISBN
        assertEquals("Model.Libro de prueba", libro[1]);
        assertEquals("Autor de prueba", libro[2]);
        assertEquals(3, libro[3]);
    }

    @Test
    void testAgregarLibro() {
        GUI.LibraryBookManager.agregarLibro(libros, "12345", "Papelucho", "Marcela Paz", 3);
        assertEquals(libros[1][0], "12345");
        assertEquals(libros[1][1], "Papelucho");
        assertEquals(libros[1][2], "Marcela Paz");
        assertEquals(libros[1][3], 3);
    }

    @Test
    void testAgregarLibroStock() {
        GUI.LibraryBookManager.agregarLibro(libros, "12345", "Papelucho", "Marcela Paz", 3);
        GUI.LibraryBookManager.agregarLibro(libros, "12345", "Papelucho", "Marcela Paz", 3);
        assertEquals(libros[1][0], "12345");
        assertEquals(libros[1][3], 6);
    }
    @Test
    void TestagregarLibros(){
        GUI.LibraryBookManager.agregarLibro(libros, "12345", "Papelucho", "Marcela Paz", 3);
        GUI.LibraryBookManager.agregarLibro(libros,"123","el pepe","pepito",4);
        GUI.LibraryBookManager.agregarLibro(libros,"124","LLego la hora","papi micky",3000);
        GUI.LibraryBookManager.agregarLibro(libros,"125","mess arround","Ray charles",3);
        GUI.LibraryBookManager.agregarLibro(libros,"126","Promises","Sam Smith",30);
        assertNotNull(libros[1][3]);
        String pepe = "pepito";
        int tito = 3000;
        assertEquals(libros[2][2],pepe);
        assertEquals(libros[3][3],tito);
        assertNotNull(libros[1][0]);
    }

    @Test
    void accionesMenuTest(){

        assertTrue(GUI.LibraryBookManager.accionesMenu(libros,1));
        assertTrue(GUI.LibraryBookManager.accionesMenu(libros, 2));
        assertFalse(GUI.LibraryBookManager.accionesMenu(libros,5));
        assertTrue(GUI.LibraryBookManager.accionesMenu(libros, 1000));
    }

}
///
 */