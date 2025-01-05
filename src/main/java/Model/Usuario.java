package Model;

import java.util.ArrayList;

/**
 * Clase para gestionar la información de los usuarios.
 * Esta clase permite almacenar la información de los usuarios, como su nombre, identificación, prestamos y multas.
 */
public class Usuario {
    //Atributos

    /** Nombre del usuario. */
    private String nombre;
    /** Identificación del usuario. */
    private int identificacion;
    /** Lista de prestamos del usuario. */
    private ArrayList<Prestamo> prestamos;
    /** Lista de multas del usuario. */
    private ArrayList<Multa> multas;
    /** Indica si el usuario es administrador. */
    private boolean administrador; //Esto lo añadire para permitir que solo los administradores puedas crear libros, usuarios, etc.

    /**
     * Constructor para inicializar un usuario con su nombre e identificación.
     * Por defecto, el usuario no es administrador.
     *
     * @param nombre el nombre del usuario.
     * @param identificacion la identificación única del usuario.
     */
    public Usuario(String nombre, int identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.prestamos = new ArrayList<Prestamo>();
        this.multas = new ArrayList<Multa>();
        this.administrador = false;
    }

    //Getters

    /**
     * Obtiene el nombre del usuario.
     *
     * @return el nombre del usuario.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtiene la identificación del usuario.
     *
     * @return la identificación del usuario.
     */
    public int getIdentificacion() {
        return this.identificacion;
    }

    /**
     * Obtiene la lista de préstamos del usuario.
     *
     * @return una lista de objetos {@link Prestamo}.
     */
    public ArrayList<Prestamo> getPrestamos() {
        return this.prestamos;
    }

    /**
     * Obtiene la lista de multas del usuario.
     *
     * @return una lista de objetos {@link Multa}.
     */
    public ArrayList<Multa> getMultas() {
        return this.multas;
    }

    /**
     * Verifica si el usuario tiene permisos de administrador.
     *
     * @return {@code true} si el usuario es administrador, de lo contrario {@code false}.
     */
    public boolean getAdministrador() {
        return this.administrador;
    }

    //Setters

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre el nuevo nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece la identificación del usuario.
     *
     * @param identificacion la nueva identificación del usuario.
     */
    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * Establece la lista de préstamos del usuario.
     *
     * @param prestamos una lista de objetos {@link Prestamo}.
     */
    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    /**
     * Establece la lista de multas del usuario.
     *
     * @param multas una lista de objetos {@link Multa}.
     */
    public void setMultas(ArrayList<Multa> multas) {
        this.multas = multas;
    }

    /**
     * Establece si el usuario tiene permisos de administrador.
     *
     * @param administrador {@code true} si el usuario es administrador, de lo contrario {@code false}.
     */
    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    //Métodos

    /**
     * Agrega un nuevo préstamo a la lista de préstamos del usuario.
     *
     * @param prestamo el objeto {@link Prestamo} a agregar.
     */
    public void agregarPrestamo(Prestamo prestamo) {
        this.prestamos.add(prestamo);
    }

    /**
     * Agrega una nueva multa a la lista de multas del usuario.
     *
     * @param multa el objeto {@link Multa} a agregar.
     */
    public void agregarMulta(Multa multa) {
        this.multas.add(multa);
    }

    /**
     * Elimina un préstamo de la lista de préstamos del usuario.
     *
     * @param prestamo el objeto {@link Prestamo} a eliminar.
     */
    public void eliminarPrestamo(Prestamo prestamo) {
        this.prestamos.remove(prestamo);
    }

    /**
     * Elimina una multa de la lista de multas del usuario.
     *
     * @param multa el objeto {@link Multa} a eliminar.
     */
    public void eliminarMulta(Multa multa) {
        this.multas.remove(multa);
    }

    /**
     * Muestra todos los préstamos del usuario en la consola.
     * Utiliza el método {@code toString()} de la clase {@link Prestamo}.
     */
    public void mostrarPrestamos() {
        for (Prestamo prestamo : this.prestamos) {
            System.out.println(prestamo.toString());
        }
    }

    /**
     * Muestra todas las multas del usuario en la consola.
     * Utiliza el metodo {@code toString()} de la clase {@link Multa}.
     */
    public void mostrarMultas() {
        for (Multa multa : this.multas) {
            System.out.println(multa.toString());
        }
    }

    //ToString

    /**
     * Devuelve una representación en cadena del usuario.
     *
     * @return una cadena con el nombre y la identificación del usuario.
     */
    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\nIdentificacion: " + this.identificacion;
    }
}
