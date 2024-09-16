import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryBookManagerTest {
    Object[][] libros = new Object[10][4];
    @Test
    void accionesMenuTest(){
        LibraryBookManager manager = new LibraryBookManager();
        assertEquals(true, manager.accionesMenu(libros,1));
        assertEquals(true, manager.accionesMenu(libros, 2));
        assertEquals(false, manager.accionesMenu(libros,5));
        assertEquals(true, manager.accionesMenu(libros, 1000));
    }

}