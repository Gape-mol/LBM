package GUI;

import Model.Biblioteca;
import Model.Libro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * Clase que representa la interfaz gráfica para mostrar los libros disponibles en la biblioteca.
 */
public class InterfazMostrarBiblioteca extends JFrame {

    private Biblioteca biblioteca;

    /**
     * Constructor de la clase InterfazMostrarBiblioteca.
     * Configura la ventana para mostrar todos los libros almacenados en la biblioteca.
     *
     * @param biblioteca Objeto de la clase Biblioteca que contiene la lista de libros.
     */
    public InterfazMostrarBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        // Configuración de la ventana
        setTitle("Mostrar Biblioteca");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Creación del área de texto donde se mostrarán los libros
        JTextArea areaLibros = new JTextArea();
        areaLibros.setEditable(false); // El texto no puede ser editado
        JScrollPane scrollPane = new JScrollPane(areaLibros); // Agregar scroll en caso de que los libros excedan el tamaño

        // Botón para volver al menú principal
        JButton btnVolver = new JButton("Volver");

        // Obtener la lista de libros de la biblioteca
        List<Libro> libros = biblioteca.getLibros();

        // Verificar si hay libros en la biblioteca y mostrar la información correspondiente
        if (libros == null || libros.isEmpty()) {
            // Mostrar un mensaje indicando que no hay libros en la biblioteca
            areaLibros.setText("La biblioteca está vacía, no hay libros por mostrar.");
        } else {
            // Crear un StringBuilder para construir la información de los libros
            StringBuilder librosInfo = new StringBuilder();
            for (Libro libro : libros) {
                librosInfo.append("Título: ").append(libro.getTitulo())
                        .append("\nAutor: ").append(libro.getAutor())
                        .append("\nISBN: ").append(libro.getIsbn())
                        .append("\nEditorial: ").append(libro.getEditorial())
                        .append("\nAño: ").append(libro.getYear())
                        .append("\n\n");
            }
            // Establecer la información de los libros en el área de texto
            areaLibros.setText(librosInfo.toString());
        }

        // Agregar componentes al frame
        add(scrollPane, BorderLayout.CENTER); // Área de texto con scroll al centro
        add(btnVolver, BorderLayout.SOUTH);   // Botón "Volver" en la parte inferior

        /**
         * Acción asociada al botón "Volver".
         * Cierra la ventana actual y regresa a la interfaz principal.
         */
        btnVolver.addActionListener((ActionEvent e) -> {
            setVisible(false); // Ocultar la ventana actual
            new InterfazPrincipal(biblioteca).setVisible(true); // Mostrar la ventana principal
        });
    }
}
