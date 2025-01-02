package Model;

import java.util.ArrayList;

/**
 * Clase que representa un libro en el sistema.
 * Cada libro tiene un título, autor, ISBN, editorial, año de publicación y una lista de reseñas asociadas.
 */
public class Libro {
    //Atributos

    /** Título del libro. */
    private String titulo;
    /** Autor del libro. */
    private String autor;
    /** ISBN del libro. */
    private String Isbn;
    /** Editorial del libro. */
    private String editorial;
    /** Año de publicación del libro. */
    private int year;
    /** Lista de reseñas asociadas al libro. */
    private ArrayList<Review> reviews;

    //Constructor

    /**
     * Constructor para inicializar un libro con su título, autor, ISBN, editorial y año de publicación.
     * Por defecto, la lista de reseñas está vacía.
     *
     * @param titulo el título del libro.
     * @param autor el autor del libro.
     * @param Isbn el ISBN del libro.
     * @param editorial la editorial del libro.
     * @param year el año de publicación del libro.
     */
    public Libro(String titulo, String autor, String Isbn, String editorial, int year) {
        this.titulo = titulo;
        this.autor = autor;
        this.Isbn = Isbn;
        this.editorial = editorial;
        this.year = year;
        this.reviews = new ArrayList<Review>();
    }

    //Getters

    /**
     * Obtiene el título del libro.
     *
     * @return el título del libro.
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Obtiene el autor del libro.
     *
     * @return el autor del libro.
     */
    public String getAutor() {
        return this.autor;
    }

    /**
     * Obtiene el ISBN del libro.
     *
     * @return el ISBN del libro.
     */
    public String getIsbn() {
        return this.Isbn;
    }

    /**
     * Obtiene la editorial del libro.
     *
     * @return la editorial del libro.
     */
    public String getEditorial() {
        return this.editorial;
    }

    /**
     * Obtiene el año de publicación del libro.
     *
     * @return el año de publicación del libro.
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Obtiene la lista de reseñas asociadas al libro.
     *
     * @return una lista de objetos {@link Review}.
     */
    public ArrayList<Review> getReviews() {
        return this.reviews;
    }

    //Setters

    /**
     * Establece el título del libro.
     *
     * @param titulo el nuevo título del libro.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Establece el autor del libro.
     *
     * @param autor el nuevo autor del libro.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Establece el ISBN del libro.
     *
     * @param Isbn el nuevo ISBN del libro.
     */
    public void setIsbn(String Isbn) {
        this.Isbn = Isbn;
    }

    /**
     * Establece la editorial del libro.
     *
     * @param editorial la nueva editorial del libro.
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * Establece el año de publicación del libro.
     *
     * @param year el nuevo año de publicación del libro.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Establece la lista de reseñas asociadas al libro.
     *
     * @param reviews la nueva lista de reseñas.
     */
    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    //To String

    /**
     * Devuelve una representación en cadena del libro.
     *
     * @return una cadena con los detalles del libro.
     */
    @Override
    public String toString() {
        return "Titulo: " + this.titulo + "\nAutor: " + this.autor + "\nIsbn: " + this.Isbn + "\nEditorial: " + this.editorial + "\nAño: " + this.year;
    }

    //Métodos

    /**
     * Agrega una nueva reseña al libro.
     * Si el usuario ya tiene una reseña asociada al libro, no se agregará una nueva.
     *
     * @param review la reseña a agregar.
     * @param usuario el usuario que realiza la reseña.
     */
    public void agregarReview(Review review, Usuario usuario) {
        Review reviewExistente = buscarReview(usuario);
        if (reviewExistente == null) {
            this.reviews.add(review);
        } else {
            System.out.println("Ya existe una review para este usuario.");
        }
    }

    /**
     * Busca una reseña asociada a un usuario específico.
     *
     * @param usuario el usuario cuya reseña se busca.
     * @return el objeto {@link Review} encontrado o {@code null} si no existe.
     */
    public Review buscarReview(Usuario usuario) { //Busco la review por Model.Usuario, ya que en teoria solo deberia haber una review por usuario
        for (Review review : this.reviews) {
            if (review.getIdentificacion() == usuario.getIdentificacion()) {
                return review;
            }
        }
        return null;
    }

    /**
     * Edita una reseña asociada a un usuario específico.
     *
     * @param usuario el usuario cuya reseña se editará.
     * @param texto el nuevo texto de la reseña.
     * @param calificacion la nueva calificación de la reseña.
     */
    public void editarReview(Usuario usuario, String texto, int calificacion) {
        Review review = buscarReview(usuario);
        review.setTexto(texto);
        review.setCalificacion(calificacion);
    }

    /**
     * Muestra todas las reseñas asociadas al libro en la consola.
     * Cada reseña se representa como una cadena mediante su metodo {@code toString()}.
     */
    public void mostrarReviews() {
        for (Review review : this.reviews) {
            System.out.println(review.toString());
        }
    }

    /**
     * Elimina una reseña específica del libro.
     *
     * @param review la reseña a eliminar.
     */
    public void eliminarReview(Review review) {
        this.reviews.remove(review);
    }
}
