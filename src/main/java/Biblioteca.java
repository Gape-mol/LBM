import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
   private String nombre;
   private String direccion;
   private List<Libro> libros;

   public Biblioteca(String nombre, String direccion) {
       this.nombre = nombre;
       this.direccion = direccion;
       this.libros = new ArrayList<Libro>();
   }


   public String getNombre() {
       return this.nombre;
   }

   /**
    *
    * @param nombre
    */

   public void setNombre(String nombre) {
       this.nombre = nombre;
   }

   public String getDireccion() {
       return this.direccion;
   }

   /**
    *
    * @param direccion
    */

   public void setDireccion(String direccion) {
       this.direccion = direccion;
   }

   public List<Libro> getLibros() {
       return this.libros;
   }

   /**
    *
    * @param libros
    */
   public void setLibros(List<Libro> libros) {
       this.libros = libros;
   }
}
