import java.util.List;

public class Biblioteca {

    private String nombre;
    private String direccion;
    private List<Libro> libros;

    public Biblioteca(String nombre, String direccion) {
        this.nombre = nombre;

        this.direccion = direccion;
    }
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Libro> getLibros() {
        return this.libros;
    }
    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public void crearLibro(String titulo, String autor, String isbn,String Editorial, int Year) {
        // Verificar si ya existe un libro con el mismo ISBN
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                System.out.println("El ISBN de este libro ya está asignado a otro libro.");
                return; // Salimos del método si se encuentra un duplicado
            }
        }

        // Crear un nuevo objeto Libro y agregarlo a la lista
        Libro newLibro = new Libro(titulo, autor, isbn,Editorial, Year);
        libros.add(newLibro);
        System.out.println("Libro creado y agregado exitosamente: " + newLibro);
    }


    public void modificarLibro( String Isbn,String newTitulo,String newAutor, String newIsbn,String neweditorial, int newYear  ){
        for(Libro libro : libros){
            if(libro.getIsbn().equals(Isbn)){
                libro.setTitulo(newTitulo);
                libro.setAutor(newAutor);
                libro.setIsbn(newIsbn);
                libro.setYear(newYear);
                libro.setEditorial(neweditorial);
                System.out.println("Libro editado con exito");
                break;
            }else{
                System.out.println("El isbn que ingresaste no coincide con ningun libro");
            }
        }
    }

    public void eliminarLibroPorIsbn(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                libros.remove(libro);
                System.out.println("El libro con ISBN " + isbn + " ha sido eliminado.");
                break;
            } else {
                System.out.println("Este ISBN " + libro.getIsbn() + " no está asignado a ningún libro existente");
            }
        }
    }


    public void buscarLibroPorIsbn(String isbn){
        for(Libro libro : libros){
            if(libro.getIsbn().equals(isbn)){
                System.out.println("Datos del Libro:...\n | Titulo: "+libro.getTitulo()+"| Autor: "+libro.getAutor()+"| ISBN: "+libro.getIsbn()+" | Año de publicacion: "+libro.getYear());
                break;
            }else{
                System.out.println("El libro no fue encontrado, ningun ISBN registrado en la base de datos de la biblioteca coinside con el ISBN: "+libro.getIsbn()+" proporcionado");
            }

        }

    }
    public void mostrarBibliotecaCompleta() {
        if (libros != null && !libros.isEmpty()) {
            for (Libro libro : libros) {
                System.out.println("Datos del libro: " + libro);
            }
        } else {
            System.out.println("La biblioteca está vacía, no hay libros por mostrar .");
        }
    }

}