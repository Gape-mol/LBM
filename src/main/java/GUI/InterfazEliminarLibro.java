package GUI;

import Data.GestorDeArchivos;
import Model.Biblioteca;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa la interfaz gráfica para eliminar un libro de la colección de la biblioteca.
 */
public class InterfazEliminarLibro extends JFrame {

    private Biblioteca biblioteca;

    /**
     * Constructor de la clase InterfazEliminarLibro.
     * Configura la ventana para la eliminación de un libro de la biblioteca.
     *
     * @param biblioteca Objeto de la clase Biblioteca que gestiona la colección de libros.
     */
    public InterfazEliminarLibro(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        // Configuración inicial de la ventana
        setTitle("Eliminar Libro");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Componentes de la interfaz
        JLabel labelISBN = new JLabel("ISBN del libro a eliminar:");
        JTextField campoISBN = new JTextField(20);
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnVolver = new JButton("Volver");

        // Agregar componentes al frame
        add(labelISBN);
        add(campoISBN);
        add(btnEliminar);
        add(btnVolver);

        /**
         * Acción asociada al botón "Eliminar".
         * Elimina el libro con el ISBN proporcionado por el usuario y guarda la biblioteca actualizada.
         * Si el libro es eliminado con éxito, se notifica al usuario, de lo contrario, se informa que no se encontró.
         */
        btnEliminar.addActionListener(e -> {
            String isbn = campoISBN.getText(); // Obtener el ISBN ingresado
            boolean libroEliminado = eliminarLibroYGuardar(isbn); // Intentar eliminar el libro

            if (libroEliminado) {
                // Mostrar mensaje si el libro fue eliminado correctamente
                JOptionPane.showMessageDialog(null, "Libro eliminado correctamente.");
            } else {
                // Mostrar mensaje si no se encontró un libro con el ISBN ingresado
                JOptionPane.showMessageDialog(null, "No se encontró un libro con ese ISBN.");
            }

            // Volver a la ventana principal
            setVisible(false);
            new InterfazPrincipal(biblioteca).setVisible(true);
        });

        /**
         * Acción asociada al botón "Volver".
         * Cierra la ventana actual y redirige al usuario a la interfaz principal.
         */
        btnVolver.addActionListener(e -> {
            setVisible(false);
            new InterfazPrincipal(biblioteca).setVisible(true); // Volver a la ventana principal
        });
    }

    /**
     * Método para eliminar un libro de la biblioteca por su ISBN y guardar la biblioteca actualizada.
     *
     * @param isbn El ISBN del libro a eliminar.
     * @return {@code true} si el libro fue eliminado correctamente, {@code false} si no se encontró el libro.
     */
    private boolean eliminarLibroYGuardar(String isbn) {
        // Recorrer la lista de libros para encontrar el libro con el ISBN proporcionado
        for (int i = 0; i < biblioteca.getLibros().size(); i++) {
            if (biblioteca.getLibros().get(i).getIsbn().equals(isbn)) {
                // Eliminar el libro de la lista
                biblioteca.getLibros().remove(i);

                // Guardar la biblioteca actualizada en el archivo
                GestorDeArchivos gestor = new GestorDeArchivos();
                gestor.guardarBiblioteca(biblioteca);

                return true; // Indicar que el libro fue eliminado con éxito
            }
        }
        return false; // Indicar que no se encontró un libro con el ISBN proporcionado
    }
}
