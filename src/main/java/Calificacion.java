public class Calificacion {
    private Usuario usuario;
    private int calificacion;
    private String comentario;
    private Libro libro;

    public Calificacion(Usuario usuario, int calificacion, String comentario, Libro libro) {
        this.usuario = usuario;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
}
