import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "Calle Principal 123");

        // Crear libros
        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", "1234567890", "Editorial Cervantes", 1605);
        Libro libro2 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", "0987654321", "Editorial Sudamericana", 1967);
        Libro libro3 = new Libro("Don Juan Tenorio", "José Zorrilla", "1111111111", "Editorial Zorrilla", 1844);

        // Añadir libros a la biblioteca
        List<Libro> libros = new ArrayList<>();
        libros.add(libro1);
        libros.add(libro2);
        biblioteca.setLibros(libros);

        // Probar agregar un libro nuevo
        biblioteca.crearLibro(libro3);

        // Mostrar biblioteca completa
        biblioteca.mostrarBibliotecaCompleta();

        // Buscar libro por ISBN
        biblioteca.buscarLibroPorIsbn("1234567890");

        // Modificar libro existente
        biblioteca.modificarLibro("El Quijote de la Mancha", "Miguel de Cervantes", "1234567890", "Editorial Cervantes", "Editorial pepito", 2022);

        // Eliminar libro por ISBN
        biblioteca.eliminarLibroPorIsbn("0987654321");
        biblioteca.mostrarBibliotecaCompleta();

        // Crear usuarios
        Usuario usuario1 = new Usuario("Juan Pérez", 101);
        Usuario usuario2 = new Usuario("Ana López", 102);

        // Crear y agregar una reserva
        Reserva reserva1 = new Reserva(1, usuario1, libro1, "2023-11-01");
        usuario1.agregarReserva(reserva1);
        usuario1.mostrarReservas();

        // Crear y agregar préstamos
        Prestamo prestamo1 = new Prestamo(new Date(), new Date(), libro1);
        usuario1.agregarPrestamo(prestamo1);
        usuario1.mostrarPrestamos();

        // Crear historial de préstamos y agregar préstamo
        Historial historial = new Historial();
        historial.agregarPrestamo(prestamo1);
        historial.mostrarHistorial();

        // Agregar review a un libro
        Review review1 = new Review("Gran obra literaria", 5, usuario1);
        libro1.agregarReview(review1);
        libro1.mostrarReviews();

        // Probar cargar y guardar datos usando el gestor de archivos
        GestorDeArchivos gestorArchivos = new GestorDeArchivos();
        gestorArchivos.guardarBiblioteca(biblioteca);
        gestorArchivos.guardarUsuarios(new ArrayList<>() {{
            add(usuario1);
            add(usuario2);
        }});
    }
}
