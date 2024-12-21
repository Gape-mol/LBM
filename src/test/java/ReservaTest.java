import Model.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaTest {

    @Test
    public void testConstructor() {
        Usuario usuario = new Usuario("Juan", 123456);
        Libro libro = new Libro("El señor de los completos", "Si", "1234567890", "Sopaipilla", 2004);
        Date fecha = new Date();

        Reserva reserva = new Reserva("1", usuario, libro, fecha);

        assertEquals("1", reserva.getNumeroSolicitud());
        assertEquals(usuario, reserva.getUsuario());
        assertEquals(libro, reserva.getLibro());
        assertEquals(fecha, reserva.getFechaReserva());
    }

    @Test
    public void testToString() {
        Usuario usuario = new Usuario("Juan", 123456);
        Libro libro = new Libro("El señor de los completos", "Si", "1234567890", "Sopaipilla", 2004);
        Date fecha = new Date();

        Reserva reserva = new Reserva("2", usuario, libro, fecha);

        String expected = "Reserva{" +
                "numeroSolicitud=2" +
                ", usuario='Juan'" +
                ", libro=El señor de los completos" +
                ", fechaReserva='" + fecha + '\'' +
                '}';

        assertEquals(expected, reserva.toString());
    }

    @Test
    public void testObjetos() {
        Usuario usuario = new Usuario("Juan", 123456);
        Libro libro = new Libro("El señor de los completos", "Si", "1234567890", "Sopaipilla", 2004);
        Date fecha = new Date();

        Reserva reserva = new Reserva("3", usuario, libro, fecha);

        assertEquals(usuario, reserva.getUsuario());
        assertEquals(libro, reserva.getLibro());
    }



}
