package GUI;

import Data.GestorDeArchivos;
import Model.Biblioteca;
import Model.Libro;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa la interfaz gráfica para crear un nuevo libro y agregarlo
 * a la colección de libros gestionada por la biblioteca.
 */
public class InterfazCrearLibro extends JFrame {

    private Biblioteca biblioteca;

    /**
     * Constructor de la clase InterfazCrearLibro.
     * Configura la ventana para la creación de un nuevo libro en la biblioteca.
     *
     * @param biblioteca Objeto de la clase Biblioteca que gestiona la colección de libros.
     */
    public InterfazCrearLibro(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        // Configuración inicial de la ventana
        setTitle("Crear Libro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Componentes de entrada para los datos del libro
        JLabel labelTitulo = new JLabel("Título:");
        JTextField campoTitulo = new JTextField(20);
        JLabel labelAutor = new JLabel("Autor:");
        JTextField campoAutor = new JTextField(20);
        JLabel labelISBN = new JLabel("ISBN:");
        JTextField campoISBN = new JTextField(20);
        JLabel labelAnio = new JLabel("Año:");
        JTextField campoAnio = new JTextField(20);
        JLabel labelEditorial = new JLabel("Editorial:");
        JTextField campoEditorial = new JTextField(20);

        // Botones para guardar el libro o volver al menú principal
        JButton btnGuardar = new JButton("Guardar");
        JButton btnVolver = new JButton("Volver");

        // Configuración del layout para organizar los componentes
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Definición de la disposición horizontal del layout
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(labelTitulo)
                                .addComponent(labelAutor)
                                .addComponent(labelISBN)
                                .addComponent(labelAnio)
                                .addComponent(labelEditorial)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(campoTitulo)
                                .addComponent(campoAutor)
                                .addComponent(campoISBN)
                                .addComponent(campoAnio)
                                .addComponent(campoEditorial)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnVolver)
                                        .addComponent(btnGuardar)
                                )
                        )
        );

        // Definición de la disposición vertical del layout
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelTitulo)
                                .addComponent(campoTitulo)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelAutor)
                                .addComponent(campoAutor)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelISBN)
                                .addComponent(campoISBN)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelAnio)
                                .addComponent(campoAnio)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelEditorial)
                                .addComponent(campoEditorial)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnVolver)
                                .addComponent(btnGuardar)
                        )
        );

        // Agregar el panel al frame
        add(panel);

        /**
         * Acción asociada al botón "Guardar".
         * Crea un nuevo objeto de la clase Libro con los datos ingresados por el usuario,
         * verifica que el ISBN no esté repetido, y guarda el libro en la biblioteca.
         * También almacena la información de la biblioteca utilizando GestorDeArchivos.
         */
        btnGuardar.addActionListener(e -> {
            try {
                String titulo = campoTitulo.getText();
                String autor = campoAutor.getText();
                String isbn = campoISBN.getText();
                int anio = Integer.parseInt(campoAnio.getText());
                String editorial = campoEditorial.getText();

                // Verificar si el ISBN ya está registrado en la biblioteca
                boolean isbnRepetido = false;
                for (Libro libro : biblioteca.getLibros()) {
                    if (libro.getIsbn().equals(isbn)) {
                        isbnRepetido = true;
                        break;
                    }
                }

                if (isbnRepetido) {
                    // Mostrar mensaje si el ISBN ya existe
                    JOptionPane.showMessageDialog(null, "El ISBN ya está registrado en la biblioteca.");
                } else {
                    // Crear y guardar el libro en la biblioteca
                    biblioteca.crearLibro(new Libro(titulo, autor, isbn, editorial, anio));

                    // Guardar los cambios en el archivo
                    GestorDeArchivos gestor = new GestorDeArchivos();
                    gestor.guardarBiblioteca(biblioteca);

                    JOptionPane.showMessageDialog(null, "Libro guardado correctamente.");
                    setVisible(false);
                    new InterfazPrincipal(biblioteca).setVisible(true); // Volver a la ventana principal
                }
            } catch (NumberFormatException ex) {
                // Manejar el caso en que el año no sea un número válido
                JOptionPane.showMessageDialog(null, "El año debe ser un número entero.");
            }
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
}
