package GUI;

import Model.Biblioteca;
import Model.Libro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Clase que representa la interfaz gráfica para buscar un libro en la biblioteca.
 * Permite al usuario buscar un libro ingresando su ISBN y visualizar la información correspondiente.
 */
public class InterfazBuscarLibro extends JFrame {

    private Biblioteca biblioteca;

    /**
     * Constructor de la clase InterfazBuscarLibro.
     * Inicializa los componentes de la ventana para buscar un libro.
     *
     * @param biblioteca Objeto de la clase Biblioteca que contiene la colección de libros.
     */
    public InterfazBuscarLibro(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        // Configuración de la ventana
        setTitle("Buscar Libro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Componentes de la interfaz
        JLabel labelISBN = new JLabel("ISBN del libro a buscar:");
        JTextField campoISBN = new JTextField(20);
        JTextArea areaResultado = new JTextArea(5, 30);
        areaResultado.setEditable(false);

        JButton btnBuscar = new JButton("Buscar");
        JButton btnVolver = new JButton("Volver");

        // Agregar componentes a la ventana
        add(labelISBN);
        add(campoISBN);
        add(new JScrollPane(areaResultado));
        add(btnBuscar);
        add(btnVolver);

        /**
         * Acción asociada al botón "Buscar".
         * Busca un libro en la colección de la biblioteca utilizando el ISBN proporcionado
         * y muestra su información en el área de texto.
         *
         * Si el libro no se encuentra, muestra un mensaje indicando que no fue hallado.
         */
        btnBuscar.addActionListener((ActionEvent e) -> {
            String isbn = campoISBN.getText();
            boolean encontrado = false;

            // Iterar sobre la colección de libros para buscar por ISBN
            for (Libro libro : biblioteca.getLibros()) {
                if (libro.getIsbn().equals(isbn)) {
                    areaResultado.setText("Libro encontrado:\n" +
                            "Título: " + libro.getTitulo() + "\n" +
                            "Autor: " + libro.getAutor() + "\n" +
                            "ISBN: " + libro.getIsbn() + "\n" +
                            "Editorial: " + libro.getEditorial() + "\n" +
                            "Año: " + libro.getYear());
                    encontrado = true;
                    break;
                }
            }

            // Mensaje si el libro no fue encontrado
            if (!encontrado) {
                areaResultado.setText("El libro con ISBN " + isbn + " no fue encontrado.");
            }
        });

        /**
         * Acción asociada al botón "Volver".
         * Cierra la ventana actual y abre la interfaz principal de la aplicación.
         */
        btnVolver.addActionListener((ActionEvent e) -> {
            setVisible(false);
            new InterfazPrincipal(biblioteca).setVisible(true);
        });
    }
}
