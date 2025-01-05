package GUI;

import Model.Biblioteca;
import Model.Libro;
import Model.Review;
import Model.Usuario;
import Data.GestorDeArchivos;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa la interfaz gráfica para modificar una reseña de un libro.
 * Permite al usuario editar el texto y la calificación de una reseña previamente escrita.
 */
public class InterfazModificarReview extends JFrame {

    private Biblioteca biblioteca;
    private Usuario usuario;

    /**
     * Constructor de la clase InterfazModificarReview.
     * Inicializa la interfaz gráfica para modificar una reseña, cargando los componentes necesarios como campos de texto,
     * botones y opciones de calificación.
     *
     * @param biblioteca La biblioteca que contiene los libros y reseñas.
     * @param usuario El usuario que quiere modificar su reseña.
     */
    public InterfazModificarReview(Biblioteca biblioteca, Usuario usuario) {
        this.biblioteca = biblioteca;
        this.usuario = usuario;

        setTitle("Modificar Reseña");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Componentes de la interfaz
        JLabel labelISBN = new JLabel("ISBN del libro:");
        JTextField campoISBN = new JTextField(20);
        JLabel labelTextoReseña = new JLabel("Nuevo texto de reseña:");
        JTextArea areaReseña = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(areaReseña);
        JLabel labelCalificacion = new JLabel("Nueva Calificación:");

        // Botones de calificación
        ButtonGroup grupoCalificacion = new ButtonGroup();
        JRadioButton calificacion1 = new JRadioButton("1");
        JRadioButton calificacion2 = new JRadioButton("2");
        JRadioButton calificacion3 = new JRadioButton("3");
        JRadioButton calificacion4 = new JRadioButton("4");
        JRadioButton calificacion5 = new JRadioButton("5");

        grupoCalificacion.add(calificacion1);
        grupoCalificacion.add(calificacion2);
        grupoCalificacion.add(calificacion3);
        grupoCalificacion.add(calificacion4);
        grupoCalificacion.add(calificacion5);

        JPanel panelCalificacion = new JPanel();
        panelCalificacion.add(calificacion1);
        panelCalificacion.add(calificacion2);
        panelCalificacion.add(calificacion3);
        panelCalificacion.add(calificacion4);
        panelCalificacion.add(calificacion5);

        JButton btnModificarReseña = new JButton("Modificar Reseña");
        JButton btnVolver = new JButton("Volver");

        // Layout para organizar los componentes
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(labelISBN)
                                .addComponent(labelTextoReseña)
                                .addComponent(labelCalificacion)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(campoISBN)
                                .addComponent(scrollPane)
                                .addComponent(panelCalificacion)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnVolver)
                                        .addComponent(btnModificarReseña)
                                )
                        )
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelISBN)
                                .addComponent(campoISBN)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(labelTextoReseña)
                                .addComponent(scrollPane)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelCalificacion)
                                .addComponent(panelCalificacion)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnVolver)
                                .addComponent(btnModificarReseña)
                        )
        );

        add(panel);

        /**
         * Acción asociada al botón "Modificar Reseña".
         * Permite modificar la reseña de un libro si el usuario ya ha escrito una. La reseña y calificación se actualizan
         * en el libro correspondiente y se guardan los cambios.
         */
        btnModificarReseña.addActionListener(e -> {
            String isbn = campoISBN.getText().trim();
            String textoReseña = areaReseña.getText().trim();
            int calificacion = -1;

            if (isbn.isEmpty() || textoReseña.isEmpty() || grupoCalificacion.getSelection() == null) {
                JOptionPane.showMessageDialog(this, "Por favor, rellena todos los campos y selecciona una calificación.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener la calificación seleccionada
            if (calificacion1.isSelected()) calificacion = 1;
            else if (calificacion2.isSelected()) calificacion = 2;
            else if (calificacion3.isSelected()) calificacion = 3;
            else if (calificacion4.isSelected()) calificacion = 4;
            else if (calificacion5.isSelected()) calificacion = 5;

            // Buscar el libro por ISBN
            Libro libro = biblioteca.buscarLibroPorIsbn(isbn);

            if (libro != null) {
                // Buscar y modificar la reseña
                Review review = libro.buscarReview(usuario);
                if (review != null) {
                    review.editarReseña(textoReseña, calificacion);

                    JOptionPane.showMessageDialog(this, "Reseña modificada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    campoISBN.setText("");
                    areaReseña.setText("");
                    grupoCalificacion.clearSelection();
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró una reseña tuya para este libro.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró un libro con ese ISBN.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Guardar los cambios en la biblioteca
            GestorDeArchivos gestor = new GestorDeArchivos();
            gestor.guardarBiblioteca(biblioteca); // Guardar los cambios en el archivo
        });

        /**
         * Acción asociada al botón "Volver".
         * Permite regresar a la interfaz principal de la biblioteca.
         */
        btnVolver.addActionListener(e -> {
            setVisible(false);
            new InterfazPrincipal(biblioteca).setVisible(true);
        });
    }
}
