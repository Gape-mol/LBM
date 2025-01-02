package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Clase que representa una biblioteca en el sistema.
 * Cada biblioteca tiene un nombre, una dirección y una lista de libros.
 * Gestiona libros, incluyendo su creación, modificación, búsqueda, y eliminación.
 */
public class Biblioteca {
    //Atributos

    /** Nombre de la biblioteca. */
    private String nombre;
    /** Dirección de la biblioteca. */
    private String direccion;
    /** Lista de libros de la biblioteca. */
    private List<Libro> libros;

    //Constructor

    /**
     * Constructor para inicializar una biblioteca con su nombre y dirección.
     * Por defecto, la lista de libros está vacía.
     *
     * @param nombre el nombre de la biblioteca.
     * @param direccion la dirección de la biblioteca.
     */
    public Biblioteca(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.libros = new ArrayList<>();
    }

    //Getters y Setters

    /**
     * Obtiene el nombre de la biblioteca.
     *
     * @return el nombre de la biblioteca.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre de la biblioteca.
     *
     * @param nombre el nombre de la biblioteca.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la dirección de la biblioteca.
     *
     * @return la dirección de la biblioteca.
     */
    public String getDireccion() {
        return this.direccion;
    }

    /**
     * Establece la dirección de la biblioteca.
     *
     * @param direccion la dirección de la biblioteca.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene la lista de libros de la biblioteca.
     *
     * @return una lista de objetos {@link Libro}.
     */
    public List<Libro> getLibros() {
        return this.libros;
    }

    /**
     * Establece la lista de libros de la biblioteca.
     *
     * @param libros la lista de libros de la biblioteca.
     */
    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    //Métodos

    /**
     * Agrega un nuevo libro a la biblioteca.
     * Verifica que no exista otro libro con el mismo ISBN antes de agregarlo.
     *
     * @param newLibro el nuevo libro a agregar.
     */
    public void crearLibro(Libro newLibro) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(newLibro.getIsbn())) {
                System.out.println("El ISBN de este libro ya está asignado a otro libro.");
                return;
            }
        }
        libros.add(newLibro);
        System.out.println("Model.Libro agregado correctamente.");
    }

    /**
     * Modifica los datos de un libro en la biblioteca.
     * Busca el libro por su ISBN y actualiza los datos proporcionados.
     *
     * @param newTitulo el nuevo título del libro.
     * @param newAutor el nuevo autor del libro.
     * @param isbn el ISBN del libro a modificar.
     * @param newEditorial la nueva editorial del libro.
     * @param newYear el nuevo año de publicación del libro.
     */
    public void modificarLibro(String newTitulo, String newAutor, String isbn, String newEditorial, int newYear) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {

                if (newTitulo != null && !newTitulo.isEmpty()) {
                    libro.setTitulo(newTitulo);
                }
                if (newAutor != null && !newAutor.isEmpty()) {
                    libro.setAutor(newAutor);
                }
                if (newEditorial != null && !newEditorial.isEmpty()) {
                    libro.setEditorial(newEditorial);
                }
                if (newYear > 0) {
                    libro.setYear(newYear);
                }

                System.out.println("Libro modificado correctamente");
                return;
            }
        }
        System.out.println("El libro con ISBN " + isbn + " no fue encontrado.");
    }

    /**
     * Elimina un libro de la biblioteca por su ISBN.
     *
     * @param isbn el ISBN del libro a eliminar.
     */
    public void eliminarLibroPorIsbn(String isbn){
        //Cambio del for each por un iterador para evitar la excepcion de concurrencia al eliminar un libro
        Iterator<Libro> iterator = libros.iterator();
        boolean encontrado = false;

        while(iterator.hasNext()){
            Libro libro = iterator.next();
            if(libro.getIsbn().equals(isbn)){
                iterator.remove();
                encontrado = true;
                System.out.println("Model.Libro eliminado correctamente.");
                break;
            }
        }
        if(!encontrado){
            System.out.println("El libro no fue encontrado, ningun ISBN registrado en la base de datos de la biblioteca coinside con el ISBN: "+isbn+" proporcionado");
        }
    }

    /**
     * Busca un libro en la biblioteca por su ISBN.
     *
     * @param isbn el ISBN del libro a buscar.
     * @return el libro encontrado, o {@code null} si no se encuentra.
     */
    public Libro buscarLibroPorIsbn(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                // Mostramos los datos del libro encontrado
                System.out.println("Datos del libro:\n | Titulo: " + libro.getTitulo() +
                        " | Autor: " + libro.getAutor() +
                        " | ISBN: " + libro.getIsbn() +
                        " | Año de publicación: " + libro.getYear());
                return libro; // Retorna el libro encontrado
            }
        }
        // Si no se encuentra ningún libro
        System.out.println("El libro con ISBN " + isbn + " no fue encontrado.");
        return null; // Retorna null si no se encuentra el libro
    }

    /**
     * Muestra todos los libros de la biblioteca en la consola.
     */
    public void mostrarBibliotecaCompleta() {
        if (libros != null && !libros.isEmpty()) {
            for (Libro libro : libros) {
                System.out.println("Datos del libro: " + libro);
            }
        } else {
            System.out.println("La biblioteca está vacía, no hay libros por mostrar .");
        }
    }

    /**
     * Busca un libro en la biblioteca por su título.
     *
     * @param titulo el título del libro a buscar.
     * @return el libro encontrado, o {@code null} si no se encuentra.
     */
    public Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }


}