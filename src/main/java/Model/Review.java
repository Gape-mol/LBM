package Model;

public class Review {
    private String texto;
    private int calificacion;
    private Usuario usuario;

    //Constructor
    public Review(String texto, int calificacion, Usuario usuario) {
        this.texto = texto;
        this.calificacion = calificacion;
        this.usuario = usuario;
    }

    //Getters
    public String getTexto() {
        return this.texto;
    }

    public int getCalificacion() {
        return this.calificacion;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    //Setters
    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    //Métodos
    public String toString() {
        return "Reseña: " + this.texto + "\nCalificación: " + this.calificacion + "\nUsuario: " + this.usuario.getNombre();
    }

    public void editarReseña(String texto, int calificacion) {
        this.texto = texto;
        this.calificacion = calificacion;
    }
}