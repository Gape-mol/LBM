import Model.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    Usuario usuario = new Usuario("Juan", 123456);
    Libro libro = new Libro("El señor de los anillos", "J.R.R. Tolkien", "9780007525546", "Minotauro", 1954);
    Date fecha = new Date();
    Date fecha2 = new Date();

    @Test
    void agregarPrestamo() {
        Prestamo prestamo = new Prestamo(fecha, fecha2, libro);
        usuario.agregarPrestamo(prestamo);
        assertEquals(1, usuario.getPrestamos().size());
    }

    /*
    @Test
    void agregarReserva() {
        Reserva reserva = new Reserva(1, usuario, libro, fecha);
        usuario.agregarReserva(reserva);
        assertEquals(1, usuario.getReservas().size());
    }

     */

    @Test
    void agregarMulta() {
        Multa multa = new Multa(fecha, "No pagado", 1000);
        usuario.agregarMulta(multa);
        assertEquals(1, usuario.getMultas().size());
    }

    @Test
    void eliminarPrestamo() {
        Prestamo prestamo = new Prestamo(fecha, fecha2, libro);
        usuario.agregarPrestamo(prestamo);
        usuario.eliminarPrestamo(prestamo);
        assertEquals(0, usuario.getPrestamos().size());
    }

    /*
    @Test
    void eliminarReserva() {
        Reserva reserva = new Reserva(1, usuario, libro, fecha);
        usuario.agregarReserva(reserva);
        usuario.eliminarReserva(reserva);
        assertEquals(0, usuario.getReservas().size());
    }

     */

    @Test
    void eliminarMulta() {
        Multa multa = new Multa(fecha, "No pagado", 1000);
        usuario.agregarMulta(multa);
        usuario.eliminarMulta(multa);
        assertEquals(0, usuario.getMultas().size());
    }

    @Test
    void mostrarPrestamos() {
        Prestamo prestamo = new Prestamo(fecha, fecha2, libro);
        usuario.agregarPrestamo(prestamo);
        usuario.mostrarPrestamos();
    }

    /*
    @Test
    void mostrarReservas() {
        Reserva reserva = new Reserva(1, usuario, libro, fecha);
        usuario.agregarReserva(reserva);
        usuario.mostrarReservas();
    }

     */

    @Test
    void mostrarMultas() {
        Multa multa = new Multa(fecha, "No pagado", 1000);
        usuario.agregarMulta(multa);
        usuario.mostrarMultas();
    }
}