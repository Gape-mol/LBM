package GUI;

import Model.Biblioteca;
import Model.Libro;
import Model.Review;
import Model.Usuario;
import Data.GestorDeArchivos;

import javax.swing.*;
import java.awt.*;

public class InterfazEliminarReview extends JFrame {
    private Biblioteca biblioteca;
    private Usuario usuario;

    public InterfazEliminarReview(Biblioteca biblioteca, Usuario usuario) {
        this.biblioteca = biblioteca;
        this.usuario = usuario;

        setTitle("Eliminar Reseña");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel labelIsbn = new JLabel("ISBN del libro:");
        JTextField campoIsbn = new JTextField(20);
        JButton btnEliminar = new JButton("Eliminar Reseña");
        JButton btnVolver = new JButton("Volver");

        add(labelIsbn);
        add(campoIsbn);
        add(btnEliminar);
        add(btnVolver);

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

            GestorDeArchivos gestor = new GestorDeArchivos();
            gestor.guardarBiblioteca(biblioteca); // Guardar los cambios en el archivo
        });

        btnVolver.addActionListener(e -> {
            dispose();
            new InterfazPrincipal(biblioteca).setVisible(true); // Volver a la ventana principal
        });
    }
}
