package GUI;

import Model.Biblioteca;
import Model.Libro;
import Model.Review;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa la interfaz gráfica para mostrar las reseñas asociadas a un libro específico en la biblioteca.
 */
public class InterfazMostrarReview extends JFrame {

    private Biblioteca biblioteca;

    /**
     * Constructor de la clase InterfazMostrarReview.
     * Inicializa la ventana y los componentes necesarios para mostrar las reseñas de un libro.
     *
     * @param biblioteca Objeto de tipo {@link Biblioteca} que contiene los datos de la biblioteca.
     */
    public InterfazMostrarReview(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        setTitle("Mostrar Reseñas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Componentes de la interfaz gráfica
        JLabel labelIsbn = new JLabel("ISBN del libro:");
        JTextField campoIsbn = new JTextField(20);
        JButton btnMostrar = new JButton("Mostrar Reseñas");
        JTextArea areaReseñas = new JTextArea(10, 30);
        areaReseñas.setEditable(false); // Configura el área de texto como solo lectura
        JButton btnVolver = new JButton("Volver");

        // Agregar los componentes a la ventana
        add(labelIsbn);
        add(campoIsbn);
        add(btnMostrar);
        add(new JScrollPane(areaReseñas)); // JScrollPane agrega funcionalidad de scroll al área de texto
        add(btnVolver);

        /**
         * Acción asociada al botón "Mostrar Reseñas".
         * Busca el libro por su ISBN, y si existe, muestra las reseñas asociadas a dicho libro.
         * Si no se encuentra el libro o no hay reseñas disponibles, se muestra un mensaje informativo.
         */
        btnMostrar.addActionListener(e -> {
            String isbn = campoIsbn.getText(); // Obtiene el ISBN ingresado por el usuario
            Libro libro = biblioteca.buscarLibroPorIsbn(isbn); // Busca el libro en la biblioteca

            if (libro != null) {
                // Limpiar el área de reseñas antes de mostrar nuevas reseñas
                areaReseñas.setText("");

                // Mostrar todas las reseñas asociadas al libro
                for (Review review : libro.getReviews()) {
                    areaReseñas.append(review.mostrarReseña() + "\n\n");
                }

                // Mensaje en caso de que el libro no tenga reseñas
                if (libro.getReviews().isEmpty()) {
                    areaReseñas.setText("Este libro no tiene reseñas.");
                }
            } else {
                // Mensaje en caso de que no se encuentre el libro
                JOptionPane.showMessageDialog(this, "El libro no se encontró.");
            }
        });

        /**
         * Acción asociada al botón "Volver".
         * Cierra la ventana actual y regresa a la ventana principal de la aplicación.
         */
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazPrincipal principalFrame = new InterfazPrincipal(biblioteca); // Crea la ventana principal
                principalFrame.setVisible(true); // Hace visible la ventana principal
                setVisible(false); // Oculta la ventana actual
            }
        });
    }
}
