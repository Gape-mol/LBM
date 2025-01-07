package Model;

/**
 * Clase que representa una reseña realizada por un usuario.
 * Cada reseña contiene un texto descriptivo, una calificación numérica,
 * y la información del usuario que la creó.
 */
public class Review {
    //Atributos

    /** Texto descriptivo de la reseña. */
    private String texto;
    /** Calificación numérica de la reseña. */
    private int calificacion;
    /** Usuario que creó la reseña. */
    private Usuario usuario;
    /** Nombre del usuario que creó la reseña. */
    private String nombreUsuario;
    /** Identificación del usuario que creó la reseña. */
    private int identificacionUsuario;

    /**
     * Constructor que inicializa una nueva reseña con el texto, calificación y usuario asociado.
     *
     * @param texto el texto descriptivo de la reseña.
     * @param calificacion la calificación asociada a la reseña.
     * @param usuario el usuario que creó la reseña.
     */
    public Review(String texto, int calificacion, Usuario usuario) {
        this.texto = texto;
        this.calificacion = calificacion;
        this.identificacionUsuario = usuario.getIdentificacion();
        this.nombreUsuario = usuario.getNombre();
    }

    //Getters

    /**
     * Obtiene el texto descriptivo de la reseña.
     *
     * @return el texto de la reseña.
     */
    public String getTexto() {
        return this.texto;
    }

    /**
     * Obtiene la calificación asociada a la reseña.
     *
     * @return la calificación como un número entero.
     */
    public int getCalificacion() {
        return this.calificacion;
    }

    /**
     * Obtiene la identificación única del usuario que creó la reseña.
     *
     * @return la identificación del usuario.
     */
    public int getIdentificacion() {
        return this.identificacionUsuario;
    }

    /**
     * Obtiene el nombre del usuario que creó la reseña.
     *
     * @return el nombre del usuario.
     */
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    //Setters

    /**
     * Establece el texto descriptivo de la reseña.
     *
     * @param texto el nuevo texto de la reseña.
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * Establece la calificación de la reseña.
     *
     * @param calificacion la nueva calificación de la reseña.
     */
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Actualiza la identificación del usuario que creó la reseña.
     *
     * @param usuario el usuario cuya identificación será actualizada.
     */
    public void setIdentificacionUsuario(Usuario usuario) {
        this.identificacionUsuario = usuario.getIdentificacion();
    }

    /**
     * Actualiza el nombre del usuario que creó la reseña.
     *
     * @param usuario el usuario cuyo nombre será actualizado.
     */
    public void setNombreUsuario(Usuario usuario) {
        this.nombreUsuario = usuario.getNombre();
    }

    //Métodos

    /**
     * Devuelve una representación en cadena de la reseña.
     *
     * @return una cadena con el texto, calificación y la identificación del usuario.
     */
    @Override
    public String toString() {
        return "Reseña: " + this.texto + "\nCalificación: " + this.calificacion + "\nUsuario: " + this.identificacionUsuario;
    }

    /**
     * Muestra una representación en cadena más amigable de la reseña.
     * Incluye el nombre del usuario en lugar de su identificación.
     *
     * @return una cadena con el texto, calificación y el nombre del usuario.
     */
    public String mostrarReseña() {
        return "Reseña: " + this.texto + "\nCalificación: " + this.calificacion + "\nUsuario: " + this.nombreUsuario;
    }

    /**
     * Edita el texto y la calificación de la reseña.
     *
     * @param texto el nuevo texto de la reseña.
     * @param calificacion la nueva calificación de la reseña.
     */
    public void editarReseña(String texto, int calificacion) {
        this.texto = texto;
        this.calificacion = calificacion;
    }
}