package GUI;

import Model.Biblioteca;

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
        JLabel labelAnio = new JLabel("Nuevo Año:");
        JTextField campoAnio = new JTextField(20);
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
                                .addComponent(labelAnio)
                                .addComponent(labelEditorial)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(campoISBN)
                                .addComponent(campoTitulo)
                                .addComponent(campoAutor)
                                .addComponent(campoAnio)
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
                                .addComponent(labelAnio)
                                .addComponent(campoAnio)
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
            try {
                String isbn = campoISBN.getText();
                String titulo = campoTitulo.getText();
                String autor = campoAutor.getText();
                int anio = Integer.parseInt(campoAnio.getText());
                String editorial = campoEditorial.getText();

                biblioteca.modificarLibro(titulo, autor, isbn, editorial, anio);

                JOptionPane.showMessageDialog(null, "Libro modificado correctamente.");
                setVisible(false);
                new InterfazPrincipal(biblioteca).setVisible(true);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error: El año debe ser un número entero.");
            }
        });

        // Acción para volver al frame principal
        btnVolver.addActionListener(e -> {
            setVisible(false);
            new InterfazPrincipal(biblioteca).setVisible(true);
        });
    }
}

