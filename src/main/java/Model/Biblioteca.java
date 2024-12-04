package Model;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private String nombre;
    private String direccion;
    private List<Libro> libros;

    public Biblioteca(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.libros = new ArrayList<>();
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

    public void modificarLibro( String newTitulo,String newAutor, String newIsbn,String neweditorial, int newYear  ){
        for(Libro libro : libros){
            if(libro.getIsbn().equals(newIsbn)){
                System.out.println("El ISBN que quieres asignar ya pertenece a otro libro");
            } else if (libro.getTitulo().equals(newTitulo)) {
                System.out.println("El titulo que quieres asignar ya existe prueba con otro titulo");

            }else{
                libro.setTitulo(newTitulo);
                libro.setAutor(newAutor);
                libro.setIsbn(newIsbn);
                libro.setYear(newYear);
                System.out.println("Model.Libro editado con exito");
            }
        }
    }

    public void eliminarLibroPorIsbn(String isbn){
        for(Libro libro : libros){
            if(libro.getIsbn().equals(isbn)){
                libros.remove(libro);
            }else{
                System.out.println("Este ISBN"+libro.getIsbn()+" no esta asignado a ningun libro existente");
            }
        }
    }

    public void buscarLibroPorIsbn(String isbn){
        for(Libro libro : libros){
            if(libro.getIsbn().equals(isbn)){
                System.out.println("Datos del Model.Libro:...\n | Titulo: "+libro.getTitulo()+"| Autor: "+libro.getAutor()+"| ISBN: "+libro.getIsbn()+" | Año de publicacion: "+libro.getYear());
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