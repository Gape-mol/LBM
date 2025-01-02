package GUI;

import GUI.InterfazPrincipal;
import Model.Biblioteca;
import Model.Libro;
import Data.GestorDeArchivos;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa la interfaz gráfica para modificar los datos de un libro existente en la biblioteca.
 */
public class InterfazModificarLibro extends JFrame {

    private Biblioteca biblioteca;

    /**
     * Constructor de la clase InterfazModificarLibro.
     * Configura la ventana para modificar los datos de un libro.
     *
     * @param biblioteca Objeto de la clase Biblioteca que contiene la colección de libros.
     */
    public InterfazModificarLibro(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        // Configuración de la ventana
        setTitle("Modificar Libro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creación de componentes de la interfaz
        JLabel labelISBN = new JLabel("ISBN del libro a modificar:");
        JTextField campoISBN = new JTextField(20);
        JLabel labelTitulo = new JLabel("Nuevo Título:");
        JTextField campoTitulo = new JTextField(20);
        JLabel labelAutor = new JLabel("Nuevo Autor:");
        JTextField campoAutor = new JTextField(20);
        JLabel labelYear = new JLabel("Nuevo Año:");
        JTextField campoYear = new JTextField(20);
        JLabel labelEditorial = new JLabel("Nueva Editorial:");
        JTextField campoEditorial = new JTextField(20);

        JButton btnModificar = new JButton("Modificar");
        JButton btnVolver = new JButton("Volver");

        // Configuración del diseño usando GroupLayout
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(labelISBN)
                                .addComponent(labelTitulo)
                                .addComponent(labelAutor)
                                .addComponent(labelYear)
                                .addComponent(labelEditorial)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(campoISBN)
                                .addComponent(campoTitulo)
                                .addComponent(campoAutor)
                                .addComponent(campoYear)
                                .addComponent(campoEditorial)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnVolver)
                                        .addComponent(btnModificar)
                                )
                        )
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelISBN)
                                .addComponent(campoISBN)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelTitulo)
                                .addComponent(campoTitulo)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelAutor)
                                .addComponent(campoAutor)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelYear)
                                .addComponent(campoYear)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelEditorial)
                                .addComponent(campoEditorial)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnVolver)
                                .addComponent(btnModificar)
                        )
        );

        // Agregar el panel al frame
        add(panel);

        /**
         * Acción asociada al botón "Modificar".
         * Permite buscar un libro existente por su ISBN y actualizar sus datos.
         */
        btnModificar.addActionListener(e -> {
            String isbn = campoISBN.getText(); // Obtener el ISBN ingresado
            // Buscar el libro en la biblioteca por su ISBN
            Libro libro = biblioteca.buscarLibroPorIsbn(isbn);

            if (libro != null) {
                // Si el libro existe, actualizar sus datos con los nuevos valores ingresados
                String titulo = campoTitulo.getText();
                String autor = campoAutor.getText();
                int year = 0;

                try {
                    // Intentar convertir el año ingresado a un entero
                    year = Integer.parseInt(campoYear.getText());
                } catch (NumberFormatException ex) {
                    // Mostrar un mensaje de error si el año no es un número válido
                    JOptionPane.showMessageDialog(null, "Error: El año debe ser un número entero.");
                    return;
                }

                String editorial = campoEditorial.getText();

                // Actualizar los datos del libro
                libro.setTitulo(titulo);
                libro.setAutor(autor);
                libro.setYear(year);
                libro.setEditorial(editorial);

                // Guardar los cambios en la biblioteca
                GestorDeArchivos gestor = new GestorDeArchivos();
                gestor.guardarBiblioteca(biblioteca); // Guardar la biblioteca actualizada

                // Mostrar mensaje de confirmación
                JOptionPane.showMessageDialog(null, "Libro modificado correctamente.");
                setVisible(false);
                new InterfazPrincipal(biblioteca).setVisible(true); // Volver a la ventana principal
            } else {
                // Mostrar un mensaje de error si no se encuentra el libro
                JOptionPane.showMessageDialog(null, "No se encontró un libro con ese ISBN.");
            }
        });

        /**
         * Acción asociada al botón "Volver".
         * Cierra la ventana actual y regresa a la interfaz principal.
         */
        btnVolver.addActionListener(e -> {
            setVisible(false);
            new InterfazPrincipal(biblioteca).setVisible(true); // Volver a la ventana principal
        });
    }
}
