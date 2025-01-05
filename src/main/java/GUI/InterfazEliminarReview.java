package GUI;

import Model.Biblioteca;
import Model.Libro;
import Model.Review;
import Model.Usuario;
import Data.GestorDeArchivos;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa la interfaz gráfica para eliminar una reseña de un libro.
 * Permite al usuario eliminar su reseña previamente agregada para un libro específico,
 * buscando el libro por su ISBN.
 */
public class InterfazEliminarReview extends JFrame {

    private Biblioteca biblioteca;
    private Usuario usuario;

    /**
     * Constructor de la clase InterfazEliminarReview.
     * Inicializa los componentes de la ventana para eliminar una reseña.
     *
     * @param biblioteca Objeto de la clase Biblioteca que contiene la colección de libros.
     * @param usuario Objeto de la clase Usuario que representa al usuario que desea eliminar la reseña.
     */
    public InterfazEliminarReview(Biblioteca biblioteca, Usuario usuario) {
        this.biblioteca = biblioteca;
        this.usuario = usuario;

        // Configuración de la ventana
        setTitle("Eliminar Reseña");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Componentes de la interfaz
        JLabel labelIsbn = new JLabel("ISBN del libro:");
        JTextField campoIsbn = new JTextField(20);
        JButton btnEliminar = new JButton("Eliminar Reseña");
        JButton btnVolver = new JButton("Volver");

        add(labelIsbn);
        add(campoIsbn);
        add(btnEliminar);
        add(btnVolver);

        /**
         * Acción asociada al botón "Eliminar Reseña".
         * Busca el libro por su ISBN, verifica si el usuario tiene una reseña para ese libro
         * y la elimina si es el caso. Muestra un mensaje de éxito o error según el resultado.
         */
        btnEliminar.addActionListener(e -> {
            String isbn = campoIsbn.getText();
            Libro libro = biblioteca.buscarLibroPorIsbn(isbn);

            if (libro != null) {
                Review review = libro.buscarReview(usuario);
                if (review != null) {
                    libro.eliminarReview(review);
                    JOptionPane.showMessageDialog(this, "Reseña eliminada exitosamente.");
                    setVisible(false);
                    new InterfazPrincipal(biblioteca).setVisible(true); // Volver a la ventana principal
                } else {
                    JOptionPane.showMessageDialog(this, "No tienes reseña para eliminar.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "El libro no se encontró.");
            }

            // Guardar los cambios en la biblioteca
            GestorDeArchivos gestor = new GestorDeArchivos();
            gestor.guardarBiblioteca(biblioteca); // Guardar los cambios en el archivo
        });

        /**
         * Acción asociada al botón "Volver".
         * Cierra la ventana actual y regresa a la interfaz principal de la aplicación.
         */
        btnVolver.addActionListener(e -> {
            dispose();
            new InterfazPrincipal(biblioteca).setVisible(true); // Volver a la ventana principal
        });
    }
}
