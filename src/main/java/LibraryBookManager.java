import java.util.Arrays;
import java.util.Scanner;

public class LibraryBookManager {
    public static void main(String[] args) {
    }

    public static void menuEliminarLibro(Object[][] libros){
        String ISBN = leerCadena("Ingrese el ISBN del libro a eliminar: ");
        eliminarLibro(libros, ISBN);
    }

    public static Object[][] eliminarLibro(Object[][] libros, String ISBN){
        Object[] libro = buscarLibro(libros, ISBN);
        if(libro != null){
            Arrays.fill(libro, null);
            System.out.println("Libro eliminado");
        }
        else{
            System.out.println("Libro no encontrado");
        }
        return libros;
    }
    public static Object[] buscarLibro(Object[][] libros, String ISBN){
        for (Object[] libro : libros){
            if (libro[0] == ISBN){
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
