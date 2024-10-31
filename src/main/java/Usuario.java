import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private int identificacion;
    private List<Prestamo> prestamos;
    private List<Reserva> reservas;

    public Usuario(String nombre, int identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        prestamos = new ArrayList<Prestamo>();
        reservas = new ArrayList<>();
    }

    public String getNombre() { return nombre; }

    public int getIdentificacion() { return identificacion; }

    public List<Prestamo> getPrestamos() { return prestamos; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setIdentificacion(int identificacion) { this.identificacion = identificacion; }

    public void setPrestamos(List<Prestamo> prestamos) { this.prestamos = prestamos; }

    public void realizarPrestamo(Prestamo prestamo) { this.prestamos.add(prestamo); }

    public List<Reserva> getReservas() { return reservas; }

    public void setReservas(List<Reserva> reservas) { this.reservas = reservas; }

    public void reservarLibro(Reserva reserva) {
        this.reservas.add(reserva);
        System.out.println("Reserva realizada con exito.");
    }

    public void mostrarReservas() {
        System.out.println("Reservas de " + nombre + ":");
        if (reservas.isEmpty()) {
            System.out.println("No se ha reservado ningun libro.");
        } else {
            for (Reserva reserva : reservas) {
                System.out.println(reserva);
            }
        }
    }
}
