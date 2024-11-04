import org.junit.jupiter.api.*;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GestorDeArchivosTest {

    static GestorDeArchivos gestor;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        File file = new File("BibliotecaData.json");
        file.delete();
        file = new File("UsuariosData.json");
        file.delete();
        gestor = new GestorDeArchivos();
    }

    @BeforeEach
    void setUp() throws Exception {
        File file = new File("BibliotecaData.json");
        file.delete();
        file = new File("UsuariosData.json");
        file.delete();
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        File file = new File("BibliotecaData.json");
        file.delete();
        file = new File("UsuariosData.json");
        file.delete();
    }


    @Test
    void cargarBiblioteca() {
        Biblioteca biblioteca = gestor.cargarBiblioteca("Juan", "Temuco");
        assertEquals(biblioteca.getDireccion(), "Temuco");
        assertEquals(biblioteca.getNombre(), "Juan");
        gestor.guardarBiblioteca(biblioteca);
        Biblioteca biblioteca1 = gestor.cargarBiblioteca("NoEsJuan", "NoEsTemuco");
        assertEquals(biblioteca1.getDireccion(), "Temuco");
        assertEquals(biblioteca1.getNombre(), "Juan");
    }

    @Test
    void cargarUsuarios() { //recordar eliminar los archivos generados para evitar errores falsos
        ArrayList<Usuario> usuarios = gestor.cargarUsuarios();
        ArrayList<Usuario> usuarios1 = new ArrayList<Usuario>();
        assertEquals(usuarios.size(), usuarios1.size());
        usuarios.add(new Usuario("Juan", 1));
        usuarios.add(new Usuario("Temuco", 2));
        gestor.guardarUsuarios(usuarios);
        usuarios1 = gestor.cargarUsuarios();
        assertEquals(usuarios.size(), usuarios1.size());
    }

    @Test
    void guardarBiblioteca() {
        Biblioteca biblioteca = new Biblioteca("EsDeJuan", "CasiTemuco");
        gestor.guardarBiblioteca(biblioteca);
        assertEquals(gestor.cargarBiblioteca("NoEsDeJuan","CasiArica").getNombre(), "EsDeJuan");
        assertEquals(gestor.cargarBiblioteca("NoEsDeJuan","CasiArica").getDireccion(), "CasiTemuco");
    }

    @Test
    void guardarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("Juan", 1));
        usuarios.add(new Usuario("Temuco", 2));
        gestor.guardarUsuarios(usuarios);
        ArrayList<Usuario> usuarios1 = gestor.cargarUsuarios();
        assertEquals(usuarios.size(), usuarios1.size());
        for (int i = 0; i < usuarios1.size(); i++) {
            assertEquals(usuarios.get(i).getNombre(), usuarios1.get(i).getNombre());
        }
    }
/*
    @Test
    void verificarIntegridadArchivos() {
        assertTrue(gestor.verificarIntegridadArchivos());
    }
*/
}
