package Model;

import java.util.ArrayList;
import java.util.List;

public class Historial {
    private List<Prestamo> historialPrestamos;

    public Historial() {
        this.historialPrestamos = new ArrayList<>();
    }

    public void agregarPrestamo(Prestamo prestamo) {
        historialPrestamos.add(prestamo);
        System.out.println("Préstamo agregado al historial.");
    }

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
