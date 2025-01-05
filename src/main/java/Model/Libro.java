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

    public ArrayList<Review> getReviews() {
        return this.reviews;
    }

    //Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(String Isbn) {
        this.Isbn = Isbn;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    //To String
    public String toString() {
        return "Titulo: " + this.titulo + "\nAutor: " + this.autor + "\nIsbn: " + this.Isbn + "\nEditorial: " + this.editorial + "\nAño: " + this.year;
    }

    //Métodos
    public void agregarReview(Review review) {
        this.reviews.add(review);
    }

    //Busco la review por Model.Usuario, ya que en teoria solo deberia haber una review por usuario
    public Review buscarReview(Usuario usuario) {
        for (Review review : this.reviews) {
            if (review.getNombreUsuario().equals(usuario.getNombre())) {
                return review;
            }
        }
        return null;
    }

    public void editarReview(Usuario usuario, String texto, int calificacion) {
        Review review = buscarReview(usuario);
        review.setTexto(texto);
        review.setCalificacion(calificacion);
    }

    public void mostrarReviews() {
        for (Review review : this.reviews) {
            System.out.println(review.toString());
        }
    }

    public void eliminarReview(Review review) {
        this.reviews.remove(review);
    }
}
