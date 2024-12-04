package GUI;

import Model.Biblioteca;
import Model.Libro;
import Model.Review;
import Model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InterfazAgregarReview extends JFrame {

    private Biblioteca biblioteca;
    private Usuario usuario;

    // Constructor que recibe la biblioteca y el usuario (que hace la reseña)
    public InterfazAgregarReview(Biblioteca biblioteca, Usuario usuario) {
        this.biblioteca = biblioteca;
        this.usuario = usuario;

        setTitle("Agregar Reseña");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Componentes de la interfaz
        JLabel labelISBN = new JLabel("ISBN del libro:");
        JTextField campoISBN = new JTextField(20);
        JLabel labelTextoReseña = new JLabel("Texto de la reseña:");
        JTextArea areaReseña = new JTextArea(4, 20);
        JScrollPane scrollPane = new JScrollPane(areaReseña);
        JLabel labelCalificacion = new JLabel("Calificación (1-5):");
        JTextField campoCalificacion = new JTextField(5);

        JButton btnAgregarReseña = new JButton("Agregar Reseña");
        JButton btnVolver = new JButton("Volver");

        add(labelISBN);
        add(campoISBN);
        add(labelTextoReseña);
        add(scrollPane);
        add(labelCalificacion);
        add(campoCalificacion);
        add(btnAgregarReseña);
        add(btnVolver);

        // Acción para agregar la reseña
        btnAgregarReseña.addActionListener((ActionEvent e) -> {
            String isbn = campoISBN.getText().trim();
            String textoReseña = areaReseña.getText().trim();
            int calificacion;

            try {
                calificacion = Integer.parseInt(campoCalificacion.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "La calificación debe ser un número entre 1 y 5.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (calificacion < 1 || calificacion > 5) {
                JOptionPane.showMessageDialog(this, "La calificación debe estar entre 1 y 5.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Buscar el libro por ISBN
            Libro libro = biblioteca.buscarLibroPorIsbn(isbn);

            if (libro != null) {
                // Crear y agregar la reseña
                Review nuevaReseña = new Review(textoReseña, calificacion, usuario);
                libro.agregarReview(nuevaReseña);

                JOptionPane.showMessageDialog(this, "Reseña agregada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false); // Cerrar la ventana de agregar reseña
                new InterfazPrincipal(biblioteca).setVisible(true); // Volver a la ventana principal
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró un libro con ese ISBN.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Acción para volver al menú principal
        btnVolver.addActionListener((ActionEvent e) -> {
            setVisible(false);
            new InterfazPrincipal(biblioteca).setVisible(true); // Volver a la ventana principal
        });
    }
}
