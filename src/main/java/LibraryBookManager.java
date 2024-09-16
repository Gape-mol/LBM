import java.util.Arrays;
import java.util.Scanner;

public class LibraryBookManager {
    public static void main(String[] args) {
    }
    // funcion que sera llamada por el menu principal para ejecutar la funcion eliminar libro
    public static void menuEliminarLibro(Object[][] libros){
        String ISBN = leerCadena("Ingrese el ISBN del libro a eliminar: ");
        eliminarLibro(libros, ISBN);
    }
    //Funcion para eliminar el libro
    public static Object[][] eliminarLibro(Object[][] libros, String ISBN){
        Object[] libro = buscarLibro(libros, ISBN);
        if(libro != null){
            Arrays.fill(libro, null); // si el libro es encontrado se llena de null ese espacio de la matriz
            System.out.println("Libro eliminado");
        }
        else{
            System.out.println("Libro no encontrado");
        }
        return libros;
    }
    public static Object[] buscarLibro(Object[][] libros, String ISBN){
        for (Object[] libro : libros){ // separo la matriz en arreglos de objetos
            if (libro[0] == ISBN){ // y compruebo si el ISBN coincide
                return libro;
            }
        }
        return null;
    }
    public static String leerCadena(String mensaje){
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}
