package GUI;

import Data.GestorDeArchivos;
import Model.Biblioteca;

import javax.swing.*;
import java.awt.*;

public class InterfazEliminarLibro extends JFrame {

    private Biblioteca biblioteca;

    public InterfazEliminarLibro(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        setTitle("Eliminar Libro");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel labelISBN = new JLabel("ISBN del libro a eliminar:");
        JTextField campoISBN = new JTextField(20);
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnVolver = new JButton("Volver");

        add(labelISBN);
        add(campoISBN);
        add(btnEliminar);
        add(btnVolver);

        // Acción para eliminar el libro
        btnEliminar.addActionListener(e -> {
            String isbn = campoISBN.getText();
            boolean libroEliminado = eliminarLibroYGuardar(isbn);

            if (libroEliminado) {
                JOptionPane.showMessageDialog(null, "Libro eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un libro con ese ISBN.");
            }

            setVisible(false);
            new InterfazPrincipal(biblioteca).setVisible(true); // Volver a la ventana principal
        });

        // Acción para volver al frame principal
        btnVolver.addActionListener(e -> {
            setVisible(false);
            new InterfazPrincipal(biblioteca).setVisible(true); // Volver a la ventana principal
        });
    }

    // Método para eliminar un libro por ISBN y guardar la biblioteca actualizada
    private boolean eliminarLibroYGuardar(String isbn) {
        // Iterar sobre los libros y eliminar el libro con el ISBN proporcionado
        for (int i = 0; i < biblioteca.getLibros().size(); i++) {
            if (biblioteca.getLibros().get(i).getIsbn().equals(isbn)) {
                biblioteca.getLibros().remove(i);  // Elimina el libro de la lista
                // Guardar la biblioteca después de la eliminación
                GestorDeArchivos gestor = new GestorDeArchivos();
                gestor.guardarBiblioteca(biblioteca);  // Guardar la biblioteca actualizada
                return true;  // Libro eliminado
            }
        }
        return false;  // No se encontró el libro con el ISBN
    }
}

