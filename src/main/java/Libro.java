public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private int year;

    public Libro(String titulo, String autor, String isbn, int year) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.year = year;
    }

    public String getTitulo() { return titulo; }

    public String getAutor() { return autor; }

    public String getIsbn() { return isbn; }

    public int getYear() { return year; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public void setAutor(String autor) { this.autor = autor; }

    public void setIsbn(String isbn) { this.isbn = isbn; }

    public void setYear(int year) { this.year = year; }

    public String toString() {
        return "Titulo: "+ this.titulo +" | Autor: "+this.autor+" | ISBN: "+this.isbn+" | Año: "+this.year;
    }

}
