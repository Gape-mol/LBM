package GUI;

import Model.Biblioteca;
import Model.Libro;
import Model.Review;

import javax.swing.*;
import java.awt.*;

public class InterfazMostrarReview extends JFrame {
    private Biblioteca biblioteca;

    public InterfazMostrarReview(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        setTitle("Mostrar Reseñas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel labelIsbn = new JLabel("ISBN del libro:");
        JTextField campoIsbn = new JTextField(20);
        JButton btnMostrar = new JButton("Mostrar Reseñas");
        JTextArea areaReseñas = new JTextArea(10, 30);
        areaReseñas.setEditable(false);  // Solo lectura para mostrar las reseñas

        // Agregar los componentes a la interfaz
        add(labelIsbn);
        add(campoIsbn);
        add(btnMostrar);
        add(new JScrollPane(areaReseñas));  // Usamos JScrollPane para agregar scroll al JTextArea

        btnMostrar.addActionListener(e -> {
            String isbn = campoIsbn.getText();
            Libro libro = biblioteca.buscarLibroPorIsbn(isbn);

            if (libro != null) {
                // Limpiar el área de reseñas antes de mostrar
                areaReseñas.setText("");

                // Mostrar todas las reseñas
                for (Review review : libro.getReviews()) {
                    areaReseñas.append(review.toString() + "\n\n");
                }

                // Si no hay reseñas
                if (libro.getReviews().isEmpty()) {
                    areaReseñas.setText("Este libro no tiene reseñas.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "El libro no se encontró.");
            }
        });
    }
}
