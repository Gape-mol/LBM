import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryBookManager {
    public static void main(String[] args) {
        Object[][] libros = new Object[100][4];
        iniciarlizarMenu(libros);
    }

    public static void iniciarlizarMenu(Object[][] libros){
        boolean continuar = true;
        while (continuar){
            //mostrarMenu();
            continuar = accionesMenu(libros, seleccionUsuario());
        }
    }

    public static boolean accionesMenu(Object[][] libros, int seleccionUsuario){
        switch (seleccionUsuario){
            case 1:
                //agregarLibroMenu();
                return true;

            case 2:
                //menuEliminarLibro();
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
            int seleccion = obtenerEntero();
            return seleccion;
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
        for (int i = 0; i < libros.length; i++){
            if (libros[i][0] != null){
                System.out.print((String) libros[i][0]);
                System.out.print(" | ");
                System.out.print((String) libros[i][1]);
                System.out.print(" | ");
                System.out.print((String) libros[i][2]);
                System.out.print(" | ");
                System.out.println((int) libros[i][3]);
            }
        }
    }
}
