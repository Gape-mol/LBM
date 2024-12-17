package GUI;

import Data.GestorDeArchivos;
import Model.Biblioteca;
import Model.Libro;

import javax.swing.*;
import java.awt.*;

public class InterfazCrearLibro extends JFrame {

    private Biblioteca biblioteca;

    public InterfazCrearLibro(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        setTitle("Crear Libro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

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

        JButton btnGuardar = new JButton("Guardar");
        JButton btnVolver = new JButton("Volver");

        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

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

        // Acción para guardar el libro
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
                    JOptionPane.showMessageDialog(null, "El ISBN ya está registrado en la biblioteca.");
                } else {
                    biblioteca.crearLibro(new Libro(titulo, autor, isbn, editorial, anio));

                    GestorDeArchivos gestor = new GestorDeArchivos();
                    gestor.guardarBiblioteca(biblioteca);

                    JOptionPane.showMessageDialog(null, "Libro guardado correctamente.");
                    setVisible(false);
                    new InterfazPrincipal(biblioteca).setVisible(true); // Volver a la ventana principal
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "El año debe ser un número entero.");
            }
        });

        // Acción para volver al frame principal
        btnVolver.addActionListener(e -> {
            setVisible(false);
            new InterfazPrincipal(biblioteca).setVisible(true); // Volver a la ventana principal
        });
    }
}
