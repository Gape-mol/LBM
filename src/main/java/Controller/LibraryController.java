package Controller;

import Data.GestorDeArchivos;
import Model.Biblioteca;
import Model.Libro;
import Model.Usuario;
import Model.Prestamo;
import Model.Reserva;
import Model.Multa;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LibraryController {

    private Biblioteca biblioteca;
    private GestorDeArchivos gestorArchivos;

    public LibraryController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        this.gestorArchivos = new GestorDeArchivos();
    }

    public void cargarBiblioteca() {
        this.biblioteca = gestorArchivos.cargarBiblioteca("Biblioteca", "Dirección de la Biblioteca");
    }

    public boolean guardarBiblioteca() {
        return gestorArchivos.guardarBiblioteca(this.biblioteca);
    }

    public void agregarLibro(Libro libro) {
        biblioteca.crearLibro(libro);
    }

    public void eliminarLibro(String isbn) {
        biblioteca.eliminarLibroPorIsbn(isbn);
    }

    public Libro buscarLibro(String isbn) {
        for (Libro libro : biblioteca.getLibros()) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public List<Libro> obtenerTodosLosLibros() {
        return biblioteca.getLibros();
    }

    public void agregarUsuario(Usuario usuario) {
        // Hay que hacerlo luego
    }

    public void eliminarUsuario(int identificacion) {
        // Hay que hacerlo luego
    }

    public void realizarPrestamo(Usuario usuario, Libro libro, Date fechaPrestamo, Date fechaDevolucion) {
        Prestamo prestamo = new Prestamo(fechaPrestamo, fechaDevolucion, libro);
        usuario.agregarPrestamo(prestamo);
    }

    public void devolverPrestamo(Usuario usuario, Libro libro) {
        Prestamo prestamo = buscarPrestamo(usuario, libro);
        if (prestamo != null) {
            usuario.eliminarPrestamo(prestamo);
        }
    }

    private Prestamo buscarPrestamo(Usuario usuario, Libro libro) {
        for (Prestamo prestamo : usuario.getPrestamos()) {
            if (prestamo.getLibro().equals(libro)) {
                return prestamo;
            }
        }
        return null;
    }

    public void realizarReserva(String numeroReserva, Usuario usuario, Libro libro, Date fechaReserva) {
        Reserva reserva = new Reserva(numeroReserva, usuario, libro, fechaReserva);
        //usuario.agregarReserva(reserva);
    }

    public void cancelarReserva(Usuario usuario, Reserva reserva) {
        //usuario.eliminarReserva(reserva);
    }

    public void aplicarMulta(Usuario usuario, int monto, Date fecha, String estado) {
        Multa multa = new Multa(fecha, estado, monto);
        usuario.agregarMulta(multa);
    }

    public void mostrarBibliotecaCompleta() {
        biblioteca.mostrarBibliotecaCompleta();
    }

    public boolean verificarBiblioteca() {
        return biblioteca != null && !biblioteca.getLibros().isEmpty();
    }
}
