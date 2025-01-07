package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el historial de préstamos en el sistema.
 * Cada historial tiene una lista de préstamos asociados.
 */
public class Historial {
    //Atributos

    /** Lista de préstamos en el historial. */
    private List<Prestamo> historialPrestamos;

    /**
     * Constructor para inicializar un historial de préstamos vacío.
     */
    public Historial() {
        this.historialPrestamos = new ArrayList<>();
    }

    //Métodos

    /**
     * Agrega un préstamo al historial.
     *
     * @param prestamo el préstamo a agregar.
     */
    public void agregarPrestamo(Prestamo prestamo) {
        historialPrestamos.add(prestamo);
        System.out.println("Préstamo agregado al historial.");
    }

    /**
     * Muestra todos los préstamos en el historial.
     * Si no hay préstamos registrados, se muestra un mensaje indicando esto.
     */
    public void mostrarHistorial() {
        System.out.println("Model.Historial de Préstamos:");
        if (historialPrestamos.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
            return;
        }

        for (Prestamo prestamo : historialPrestamos) {
            System.out.println(prestamo);
        }
    }

    /**
     * Muestra el historial de préstamos de un usuario específico.
     * Si el usuario no tiene préstamos registrados, se muestra un mensaje indicando esto.
     *
     * @param usuario el usuario cuyo historial de préstamos se desea mostrar.
     */
    public void mostrarHistorialPorUsuario(Usuario usuario) {
        System.out.println("Model.Historial de Préstamos de " + usuario.getNombre() + ":");
        List<Prestamo> prestamosUsuario = usuario.getPrestamos();

        if (prestamosUsuario.isEmpty()) {
            System.out.println("No hay préstamos registrados para este usuario.");
            return;
        }

        for (Prestamo prestamo : prestamosUsuario) {
            System.out.println(prestamo);
        }
    }
}
