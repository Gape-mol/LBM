package GUI;

import Model.Biblioteca;
import Model.Libro;
import Model.Review;
import Model.Usuario;

import javax.swing.*;
import java.awt.*;

public class InterfazModificarReview extends JFrame {
    private Biblioteca biblioteca;
    private Usuario usuario;

    public InterfazModificarReview(Biblioteca biblioteca, Usuario usuario) {
        this.biblioteca = biblioteca;
        this.usuario = usuario;

        setTitle("Modificar Reseña");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel labelIsbn = new JLabel("ISBN del libro:");
        JTextField campoIsbn = new JTextField(20);
        JLabel labelTexto = new JLabel("Nuevo texto de reseña:");
        JTextArea campoTexto = new JTextArea(5, 20);
        JLabel labelCalificacion = new JLabel("Nueva calificación:");
        JComboBox<Integer> comboCalificacion = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        JButton btnModificar = new JButton("Modificar Reseña");

        add(labelIsbn);
        add(campoIsbn);
        add(labelTexto);
        add(campoTexto);
        add(labelCalificacion);
        add(comboCalificacion);
        add(btnModificar);

        btnModificar.addActionListener(e -> {
            String isbn = campoIsbn.getText();
            String texto = campoTexto.getText();
            int calificacion = (Integer) comboCalificacion.getSelectedItem();
            Libro libro = biblioteca.buscarLibroPorIsbn(isbn);

            if (libro != null) {
                Review review = libro.buscarReview(usuario);
                if (review != null) {
                    review.editarReseña(texto, calificacion);
                    JOptionPane.showMessageDialog(this, "Reseña modificada exitosamente.");
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "No has escrito una reseña para este libro.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "El libro no se encontró.");
            }
        });
    }
}
