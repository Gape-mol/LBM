public class Libro {

	private String titulo;
	private String autor;
	private String isbn;
	private int year;

    public Libro(String titulo, String autor, String isbn, int year ) {
        this.titulo = titulo;
        this.autor=autor;
        this.isbn=isbn;
        this.year=year;
    }

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return this.autor;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String toString(){
		return "Titulo:"+ this.titulo+"Autor: "+this.autor+"ISBN:"+ this.isbn+"año de publicacion"+this.year;
	}

}