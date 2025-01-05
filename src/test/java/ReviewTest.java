import Model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewTest {

    @Test
    public void testCrearReview() {
        Usuario usuario = new Usuario("Juan", 123456);
        Libro libro = new Libro("El señor de los completos", "Si", "1234567890", "Sopaipilla", 2004);
        Review review = new Review("Muy bueno, la verdad quede con hambre", 5, usuario);
        libro.agregarReview(review, usuario);
        assertEquals(1, libro.getReviews().size());

    }

    @Test
    public void verificarInformacionReview() {
        Usuario usuario = new Usuario("Juan", 123456);
        Libro libro = new Libro("El señor de los completos", "Si", "1234567890", "Sopaipilla", 2004);
        Review review = new Review("Muy bueno, la verdad quede con hambre", 5, usuario);
        libro.agregarReview(review, usuario);
        assertEquals("Muy bueno, la verdad quede con hambre", review.getTexto());
        assertEquals(5, review.getCalificacion());
        assertEquals(usuario.getNombre(), review.getNombreUsuario());
        assertEquals(usuario.getIdentificacion(), review.getIdentificacion());
    }

    @Test
    public void testToString() {
        Usuario usuario = new Usuario("Manuel", 99999);
        Review review = new Review("Si", 5, usuario);

        String expected = "Reseña: Si\nCalificación: 5\nUsuario: 99999";
        assertEquals(expected, review.toString());
    }

    @Test
    public void testMostrarReseña() {
        Usuario usuario = new Usuario("aaaa", 11111);
        Review review = new Review("bbbb", 5, usuario);

        String expected = "Reseña: bbbb\nCalificación: 5\nUsuario: aaaa";
        assertEquals(expected, review.mostrarReseña());
    }

    @Test
    public void testEditarReseña() {
        Usuario usuario = new Usuario("aaa", 22222);
        Review review = new Review("bbb", 3, usuario);

        review.editarReseña("cccc", 5);

        assertEquals("cccc", review.getTexto());
        assertEquals(5, review.getCalificacion());
    }


}

