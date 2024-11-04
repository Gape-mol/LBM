import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private int identificacion;
    private ArrayList<Prestamo> prestamos;
    private ArrayList<Reserva> reservas;
    private ArrayList<Multa> multas;

    //Constructor
    public Usuario(String nombre, int identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.prestamos = new ArrayList<Prestamo>();
        this.reservas = new ArrayList<Reserva>();
        this.multas = new ArrayList<Multa>();
    }

    //Getters
    public String getNombre() {
        return this.nombre;
    }

    public int getIdentificacion() {
        return this.identificacion;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return this.prestamos;
    }

    public ArrayList<Reserva> getReservas() {
        return this.reservas;
    }

    public ArrayList<Multa> getMultas() {
        return this.multas;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void setMultas(ArrayList<Multa> multas) {
        this.multas = multas;
    }

    //Métodos

    public void agregarPrestamo(Prestamo prestamo) {
        this.prestamos.add(prestamo);
    }

    public void agregarReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public void agregarMulta(Multa multa) {
        this.multas.add(multa);
    }

    public void eliminarPrestamo(Prestamo prestamo) {
        this.prestamos.remove(prestamo);
    }

    public void eliminarReserva(Reserva reserva) {
        this.reservas.remove(reserva);
    }

    public void eliminarMulta(Multa multa) {
        this.multas.remove(multa);
    }

    public void mostrarPrestamos() {
        for (Prestamo prestamo : this.prestamos) {
            System.out.println(prestamo.toString());
        }
    }

    public void mostrarReservas() {
        for (Reserva reserva : this.reservas) {
            System.out.println(reserva.toString());
        }
    }

    public void mostrarMultas() {
        for (Multa multa : this.multas) {
            System.out.println(multa.toString());
        }
    }

    //To String
    public String toString() {
        return "Nombre: " + this.nombre + "\nIdentificacion: " + this.identificacion;
    }
}