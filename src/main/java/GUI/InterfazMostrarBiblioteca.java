package GUI;

import Model.Biblioteca;
import Model.Libro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InterfazMostrarBiblioteca extends JFrame {

    private Biblioteca biblioteca;

    public InterfazMostrarBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        setTitle("Mostrar Biblioteca");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextArea areaLibros = new JTextArea();
        areaLibros.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaLibros);

        JButton btnVolver = new JButton("Volver");

        // Mostrar los libros
        try {
            if (biblioteca.getLibros().isEmpty() || biblioteca.getLibros() == null) { // Esta funcion no puede funcionar si no hay una lista de libros
                areaLibros.setText("La biblioteca está vacía, no hay libros por mostrar.");
                throw new NullPointerException();
            } else {
                StringBuilder librosInfo = new StringBuilder();
                for (Libro libro : biblioteca.getLibros()) {
                    librosInfo.append("Título: ").append(libro.getTitulo())
                            .append("\nAutor: ").append(libro.getAutor())
                            .append("\nISBN: ").append(libro.getIsbn())
                            .append("\nEditorial: ").append(libro.getEditorial())
                            .append("\nAño: ").append(libro.getYear())
                            .append("\n\n");
                }
                areaLibros.setText(librosInfo.toString());
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null,"No hay libros en la biblioteca." , "Error", JOptionPane.WARNING_MESSAGE);
            dispose(); // Cierra esta ventana
            return;
        }

        add(scrollPane, BorderLayout.CENTER);
        add(btnVolver, BorderLayout.SOUTH);

        // Acción para volver al menú principal
        btnVolver.addActionListener((ActionEvent e) -> {
            setVisible(false);
            new InterfazPrincipal(biblioteca).setVisible(true);
        });
    }
}
