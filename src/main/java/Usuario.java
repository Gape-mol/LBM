import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private int identificacion;
    private List<Prestamo> prestamos;

    public Usuario(String nombre, int identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        prestamos = new ArrayList<Prestamo>();
    }

    public String getNombre() { return nombre; }

    public int getIdentificacion() { return identificacion; }

    public List<Prestamo> getPrestamos() { return prestamos; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setIdentificacion(int identificacion) { this.identificacion = identificacion; }

    public void setPrestamos(List<Prestamo> prestamos) { this.prestamos = prestamos; }

    public void realizarPrestamo(Prestamo prestamo) { this.prestamos.add(prestamo); }
}
