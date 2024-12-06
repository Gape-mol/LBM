package Model;

import java.util.ArrayList;
import java.util.Iterator;

public class Biblioteca {

    private String nombre;
    private String direccion;
    private ArrayList<Libro> libros;

    public Biblioteca(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.libros = new ArrayList<Libro>();
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

    public ArrayList<Libro> getLibros() {
        return this.libros;
    }
    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public void crearLibro(Libro newLibro) {
        if (!libros.isEmpty()) { //Esto de aqui asumo que existe para ahorrar recursos si la Array esta vacia -G
            for (Libro libro : libros) {
                if (libro.getIsbn().equals(newLibro.getIsbn())) {
                    System.out.println("El ISBN de este libro ya está asignado a otro libro.");
                    return;
                }
            }
        }
        libros.add(newLibro);
        System.out.println("Model.Libro agregado correctamente.");
    }

    public void modificarLibro( String newTitulo,String newAutor, String newIsbn,String neweditorial, int newYear  ){
        for(Libro libro : libros){
            if(libro.getIsbn().equals(newIsbn)){
                libro.setTitulo(newTitulo);
                libro.setAutor(newAutor);
                libro.setIsbn(newIsbn);
                libro.setYear(newYear);
                System.out.println("Model.Libro editado con exito");
            }
        }
    }

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