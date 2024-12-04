package Model;

import java.util.ArrayList;

public class Libro {
    private String titulo;
    private String autor;
    private String Isbn;
    private String editorial;
    private int year;

    private ArrayList<Review> reviews;

    //Constructor
    public Libro(String titulo, String autor, String Isbn, String editorial, int year) {
        this.titulo = titulo;
        this.autor = autor;
        this.Isbn = Isbn;
        this.editorial = editorial;
        this.year = year;
        this.reviews = new ArrayList<Review>();
    }

    //Getters
    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public String getIsbn() {
        return this.Isbn;
    }

    public String getEditorial() {
        return this.editorial;
    }

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
            if (review.getUsuario().equals(usuario)) {
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
