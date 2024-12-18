package GUI;

import GUI.InterfazPrincipal;
import Model.Biblioteca;
import Model.Libro;
import Data.GestorDeArchivos;

import javax.swing.*;
import java.awt.*;

public class InterfazModificarLibro extends JFrame {

    private Biblioteca biblioteca;

    public InterfazModificarLibro(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        setTitle("Modificar Libro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

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

        add(panel);

        // Acción para modificar el libro
        btnModificar.addActionListener(e -> {
            String isbn = campoISBN.getText();
            // Buscar el libro por el ISBN
            Libro libro = biblioteca.buscarLibroPorIsbn(isbn);

            if (libro != null) {
                // Si el libro existe, se pueden modificar los datos
                String titulo = campoTitulo.getText();
                String autor = campoAutor.getText();
                int year = 0;
                try {
                    year = Integer.parseInt(campoYear.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: El año debe ser un número entero.");
                    return;
                }
                String editorial = campoEditorial.getText();

                // Modificar los datos del libro
                libro.setTitulo(titulo);
                libro.setAutor(autor);
                libro.setYear(year);
                libro.setEditorial(editorial);

                // Guardar la biblioteca actualizada en el archivo
                GestorDeArchivos gestor = new GestorDeArchivos();
                gestor.guardarBiblioteca(biblioteca);  // Sobrescribir el archivo con la biblioteca actualizada

                // Mensaje de confirmación
                JOptionPane.showMessageDialog(null, "Libro modificado correctamente.");
                setVisible(false);
                new InterfazPrincipal(biblioteca).setVisible(true); // Volver a la ventana principal
            } else {
                // Si no se encuentra el libro, mostrar mensaje de error
                JOptionPane.showMessageDialog(null, "No se encontró un libro con ese ISBN.");
            }
        });

        // Acción para volver al frame principal
        btnVolver.addActionListener(e -> {
            setVisible(false);
            new InterfazPrincipal(biblioteca).setVisible(true); // Volver a la ventana principal
        });
    }
}
