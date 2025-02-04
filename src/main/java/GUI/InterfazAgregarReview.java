package GUI;

import Model.Biblioteca;
import Model.Libro;
import Model.Review;
import Model.Usuario;
import Data.GestorDeArchivos;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa la interfaz gráfica para agregar una reseña a un libro en la biblioteca.
 * Permite al usuario ingresar el ISBN de un libro, escribir una reseña y asignar una calificación.
 * La reseña será guardada en el libro correspondiente si no se ha agregado previamente.
 */
public class InterfazAgregarReview extends JFrame {

    private Biblioteca biblioteca;
    private Usuario usuario;

    /**
     * Constructor de la clase InterfazAgregarReview.
     * Inicializa los componentes de la ventana para agregar una reseña.
     *
     * @param biblioteca Objeto de la clase Biblioteca que contiene la colección de libros.
     * @param usuario Objeto de la clase Usuario que está agregando la reseña.
     */
    public InterfazAgregarReview(Biblioteca biblioteca, Usuario usuario) {
        this.biblioteca = biblioteca;
        this.usuario = usuario;

        // Configuración de la ventana
        setTitle("Agregar Reseña");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Componentes de la interfaz
        JLabel labelISBN = new JLabel("ISBN del libro:");
        JTextField campoISBN = new JTextField(20);
        JLabel labelTextoReseña = new JLabel("Texto de la reseña:");
        JTextArea areaReseña = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(areaReseña);
        JLabel labelCalificacion = new JLabel("Calificación:");

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

        JButton btnAgregarReseña = new JButton("Agregar Reseña");
        JButton btnVolver = new JButton("Volver");

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
                                        .addComponent(btnAgregarReseña)
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
                                .addComponent(btnAgregarReseña)
                        )
        );

        add(panel);

        /**
         * Acción asociada al botón "Agregar Reseña".
         * Valida los campos ingresados y agrega una reseña al libro con el ISBN proporcionado.
         * Si ya existe una reseña del mismo usuario, muestra un mensaje de error.
         * Si el libro no se encuentra, también muestra un mensaje de error.
         */
        btnAgregarReseña.addActionListener(e -> {
            String isbn = campoISBN.getText().trim();
            String textoReseña = areaReseña.getText().trim();
            int calificacion = -1;

            if (isbn.isEmpty() || textoReseña.isEmpty() || grupoCalificacion.getSelection() == null) {
                JOptionPane.showMessageDialog(this, "Por favor, rellena todos los campos y selecciona una calificación.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (calificacion1.isSelected()) calificacion = 1;
            else if (calificacion2.isSelected()) calificacion = 2;
            else if (calificacion3.isSelected()) calificacion = 3;
            else if (calificacion4.isSelected()) calificacion = 4;
            else if (calificacion5.isSelected()) calificacion = 5;

            // Buscar el libro por ISBN
            Libro libro = biblioteca.buscarLibroPorIsbn(isbn);

            if (libro != null) {
                // Crear y agregar la reseña
                Review nuevaReseña = new Review(textoReseña, calificacion, usuario);
                Review reseñaExistente = libro.buscarReview(usuario);
                if (reseñaExistente != null) {
                    JOptionPane.showMessageDialog(this, "Ya has agregado una reseña para este libro.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    libro.agregarReview(nuevaReseña);
                }

                // Guardar los datos de la biblioteca con las nuevas reseñas
                GestorDeArchivos gestor = new GestorDeArchivos();
                gestor.guardarBiblioteca(biblioteca); // Guardar los cambios en el archivo

                JOptionPane.showMessageDialog(this, "Reseña agregada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                campoISBN.setText("");
                areaReseña.setText("");
                grupoCalificacion.clearSelection();
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró un libro con ese ISBN.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        /**
         * Acción asociada al botón "Volver".
         * Cierra la ventana actual y abre la interfaz principal de la aplicación.
         */
        btnVolver.addActionListener(e -> {
            setVisible(false);
            new InterfazPrincipal(biblioteca).setVisible(true);
        });
    }
}
