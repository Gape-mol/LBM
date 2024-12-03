package GUI;

import Model.Biblioteca;
import Model.Libro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InterfazBuscarLibro extends JFrame {

    private Biblioteca biblioteca;

    public InterfazBuscarLibro(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        setTitle("Buscar Libro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel labelISBN = new JLabel("ISBN del libro a buscar:");
        JTextField campoISBN = new JTextField(20);
        JTextArea areaResultado = new JTextArea(5, 30);
        areaResultado.setEditable(false);

        JButton btnBuscar = new JButton("Buscar");
        JButton btnVolver = new JButton("Volver");

        add(labelISBN);
        add(campoISBN);
        add(new JScrollPane(areaResultado));
        add(btnBuscar);
        add(btnVolver);

        // Acción para buscar libro
        btnBuscar.addActionListener((ActionEvent e) -> {
            String isbn = campoISBN.getText();
            boolean encontrado = false;

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

            if (!encontrado) {
                areaResultado.setText("El libro con ISBN " + isbn + " no fue encontrado.");
            }
        });

        // Acción para volver al menú principal
        btnVolver.addActionListener((ActionEvent e) -> {
            setVisible(false);
            new InterfazPrincipal(biblioteca).setVisible(true);
        });
    }
}
