import Model.Libro;
import Model.Review;
import Model.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibroTest {

    @Test
    void agregarReview() {
        Usuario usuario = new Usuario("Juan", 1);
        Review review = new Review("Excelente libro", 5, usuario);
        Libro libro = new Libro("El señor de los anillos", "J.R.R. Tolkien", "9780007525546", "Minotauro", 1954);
        libro.agregarReview(review, usuario);
        assertEquals(1, libro.getReviews().size());
    }

    @Test
    void buscarReview() {
        Usuario usuario = new Usuario("Juan", 1);
        Review review = new Review("Excelente libro", 5, usuario);
        Libro libro = new Libro("El señor de los anillos", "J.R.R. Tolkien", "9780007525546", "Minotauro", 1954);
        libro.agregarReview(review, usuario);
        assertEquals("Reseña: Excelente libro\nCalificación: 5\nUsuario: 1", libro.buscarReview(usuario).toString());
    }

    @Test
    void editarReview() {
        Usuario usuario = new Usuario("Juan", 1);
        Review review = new Review("Excelente libro", 5, usuario);
        Libro libro = new Libro("El señor de los anillos", "J.R.R. Tolkien", "9780007525546", "Minotauro", 1954);
        libro.agregarReview(review, usuario);
        libro.editarReview(usuario, "Muy buen libro", 4);
        assertEquals("Reseña: Muy buen libro\nCalificación: 4\nUsuario: 1", libro.buscarReview(usuario).toString());
    }

    @Test
    void mostrarReviews() {
        Review review1 = new Review("Excelente libro", 5, new Usuario("Juan", 123456));
        Review review2 = new Review("Muy buen libro", 4, new Usuario("Pedro", 654321));
        Libro libro = new Libro("El señor de los anillos", "J.R.R. Tolkien", "9780007525546", "Minotauro", 1954);
        libro.agregarReview(review1, new Usuario("Juan", 123456));
        libro.agregarReview(review2, new Usuario("Pedro", 654321));
        libro.mostrarReviews();
    }
}