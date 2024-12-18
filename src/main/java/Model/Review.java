package Model;

public class Review {
    private String texto;
    private int calificacion;
    private Usuario usuario;
    private String nombreUsuario;
    private int identificacionUsuario;

    //Constructor
    public Review(String texto, int calificacion, Usuario usuario) {
        this.texto = texto;
        this.calificacion = calificacion;
        this.identificacionUsuario = usuario.getIdentificacion();
        this.nombreUsuario = usuario.getNombre();
    }

    //Getters
    public String getTexto() {
        return this.texto;
    }

    public int getCalificacion() {
        return this.calificacion;
    }

    public int getIdentificacion() {
        return this.identificacionUsuario;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    //Setters
    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public void setIdentificacionUsuario(Usuario usuario) {
        this.identificacionUsuario = usuario.getIdentificacion();
    }

    public void setNombreUsuario(Usuario usuario) {
        this.nombreUsuario = usuario.getNombre();
    }

    //Métodos
    public String toString() {
        return "Reseña: " + this.texto + "\nCalificación: " + this.calificacion + "\nUsuario: " + this.identificacionUsuario;
    }

    public String mostrarReseña() {
        return "Reseña: " + this.texto + "\nCalificación: " + this.calificacion + "\nUsuario: " + this.nombreUsuario;
    }

    public void editarReseña(String texto, int calificacion) {
        this.texto = texto;
        this.calificacion = calificacion;
    }
}