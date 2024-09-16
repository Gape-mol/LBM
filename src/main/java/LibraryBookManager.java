import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

public class LibraryBookManager {
    public static void main(String[] args) {
        Object[][] libros =new Object[100][4];
        mostrarMenu();
        inicializarMenu(libros);
    }
    public static void inicializarMenu(Object[][] libros){
        boolean continuar = true;
        while (continuar){
            mostrarMenu();
            continuar = accionesMenu(libros, seleccionUsuario());
        }
    }

    public static boolean accionesMenu(Object[][] libros, int seleccionUsuario){
        switch (seleccionUsuario){
            case 1:
                agregarLibroMenu(libros);
                return true;
            case 2:
                menuEliminarLibro(libros);
                return true;
            case 3:
                //Funcion en la opcion 3
                return true;
            case 4:
                listarLibros(libros);
                return true;
            case 5:
                return false;
            default:
                return true;
        }
    }

    //La funcion verifica que la seleccion del usuario es correcta y no ingresa error
    public static int seleccionUsuario(){
        try{
            return obtenerEntero();
        } catch (InputMismatchException e){
            System.out.println("¡Opcion invalida!");
            return 0;
        }
    }


    //La funcion obtiene un numero entero
    public static int obtenerEntero(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }


    //Funcion para listar los libros, lista las fila no nulas de la matriz de libros
    public static void listarLibros(Object[][] libros){
        System.out.println("   ISBN   |   Titulo   |   Autor   |   Stock   ");
        for (Object[] libro : libros) {
            if (libro[0] != null) {
                System.out.print((String) libro[0]);
                System.out.print(" | ");
                System.out.print((String) libro[1]);
                System.out.print(" | ");
                System.out.print((String) libro[2]);
                System.out.print(" | ");
                System.out.println((int) libro[3]);
            }
        }
    }
    //Metodo que imprime el menú en la consola
    public static void mostrarMenu() {
        System.out.println("\n---Library Book Manager---");
        System.out.println("1. Agregar Libro");
        System.out.println("2. Eliminar Libro");
        System.out.println("3. Buscar Libro");
        System.out.println("4. Listar Libros");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    //Le pedirá al usuario que ingrese los datos y llamará a la funcion agregarLibro() para guardarlo en la matriz
    public static void agregarLibroMenu(Object[][] biblioteca){
        String ISBN = leerCadena("Ingrese el ISBN del libro: ");
        String titulo = leerCadena("Ingrese el título del libro:");
        String autor = leerCadena("Ingrese el autor del libro:");
        int stock = leerStock("Ingrese el stock del libro:");
        agregarLibro(biblioteca, ISBN, titulo, autor, stock);
        System.out.println("Libro ingresado con exito.");
    }

    //Funcion para agregar el libro a la matriz, si el ISBN ya existe dentro de la matriz, se agregará el stock ingresado al que estaba guardado.
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
    //Se asegura de que el valor ingresado cuando se pide el stock sea un numero entero, y no uno negativo, una letra o caracter no numerico.
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

    //Lucas Hay problemas con este codigo, pero lo dejare para revision
    /*
    public Libro buscarLibroPorTítuloYCódigo(String título, String código) {
        for (Object[] libroArray : libros) {
            if (libroArray[0] instanceof Libro) {
                Libro libro = (Libro) libroArray[0];
                if (libro.getTítulo().equals(título) && libro.getCódigo().equals(código)) {
                    return libro;
                }
            }
        }
        return null; // Libro no encontrado
    }

    public void buscarLibroPorConsola() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el título del libro:");
        String título = scanner.nextLine();
        System.out.println("Ingrese el ISBN del libro:");
        String código = scanner.nextLine();
        Libro libroEncontrado = buscarLibroPorTítuloYCódigo(título, código);
        if (libroEncontrado != null) {
            System.out.println("Libro encontrado: " + libroEncontrado.getTítulo() + " de " + libroEncontrado.getAutor() + ", copias disponibles: " + libroEncontrado.getStock());
        } else {
            System.out.println("Libro no encontrado");
        }
    }*/
}
