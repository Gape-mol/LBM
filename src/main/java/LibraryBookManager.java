import java.util.Scanner;

public class LibraryBookManager {


    public static void main(String[] args) {
        Object[][] biblioteca =new Object[100][4];
        mostrarMenu();
    }


    public static void mostrarMenu() {
        System.out.println("\n---Library Book Manager---");
        System.out.println("1. Agregar Libro");
        System.out.println("2. Eliminar Libro");
        System.out.println("3. Buscar Libro");
        System.out.println("4. Listar Libros");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }


    public static void agregarLibroMenu(Object[][] biblioteca){
        String ISBN = leerCadena("Ingrese el ISBN del libro: ");
        String titulo = leerCadena("Ingrese el título del libro:");
        String autor = leerCadena("Ingrese el autor del libro:");
        int stock = leerStock("Ingrese el stock del libro:");

        agregarLibro(biblioteca, ISBN, titulo, autor, stock);
        System.out.println("Libro ingresado con exito.");
    }



    public static Object[][] agregarLibro(Object[][] biblioteca, String ISBN, String titulo, String autor, int stock) {
        boolean libroEncontrado = false;
        for (int i = 0; i < biblioteca.length; i++) {
            if (biblioteca[i][0] != null &&  biblioteca[i][0] == ISBN) {
                biblioteca[i][3] = (int) biblioteca[i][3] + stock;
                libroEncontrado = true;
                break;
            }
        }
        if (!libroEncontrado) {
            for (int i = 0; i < biblioteca.length; i++) {
                if (biblioteca[i][0] == null) {
                    biblioteca[i][0] = ISBN;
                    biblioteca[i][1] = titulo;
                    biblioteca[i][2] = autor;
                    biblioteca[i][3] = stock;
                    break;
                }
            }
        }

        return biblioteca;
    }

    public static String leerCadena(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public static int leerStock(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        int valor = -1;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensaje);
                valor = Integer.parseInt(scanner.nextLine());
                if (valor < 0) {
                    System.out.println("Error: Debe ingresar un valor válido. Inténtelo de nuevo.");
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un valor válido. Inténtelo de nuevo.");
            }
        }
        return valor;
    }
}
