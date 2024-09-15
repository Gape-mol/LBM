import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class LibraryBookManagerTest {


    private Object[][] biblioteca;

    @BeforeEach
    void setUp() {
        biblioteca = new Object[100][4];
    }

    @Test
    void testAgregarLibro() {
        LibraryBookManager.agregarLibro(biblioteca, "12345", "Papelucho", "Marcela Paz", 3);
        assertEquals(biblioteca[0][0], "12345");
        assertEquals(biblioteca[0][1], "Papelucho");
        assertEquals(biblioteca[0][2], "Marcela Paz");
        assertEquals(biblioteca[0][3], 3);
    }

    @Test
    void testAgregarLibroStock() {
        LibraryBookManager.agregarLibro(biblioteca, "12345", "Papelucho", "Marcela Paz", 3);
        LibraryBookManager.agregarLibro(biblioteca, "12345", "Papelucho", "Marcela Paz", 3);
        assertEquals(biblioteca[0][0], "12345");
        assertEquals(biblioteca[0][3], 6);
    }

}
