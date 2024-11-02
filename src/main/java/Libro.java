import java.util.ArrayList;

public class Libro {
    private String titulo;
    private String autor;
    private String ISBN;
    private String editorial;
    private int year;
    private ArrayList<Review> reviews;

    //Constructor
    public Libro(String titulo, String autor, String ISBN, String editorial, int year) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
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

    public String getISBN() {
        return this.ISBN;
    }

    public String getEditorial() {
        return this.editorial;
    }

    public int getYear() {
        return this.year;
    }

    //Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //To String
    public String toString() {
        return "Titulo: " + this.titulo + "\nAutor: " + this.autor + "\nISBN: " + this.ISBN + "\nEditorial: " + this.editorial + "\nAño: " + this.year;
    }
}
