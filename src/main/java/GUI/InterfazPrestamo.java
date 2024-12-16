package GUI;

import Model.Biblioteca;
import Model.Prestamo;
import Model.Libro;
import Model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InterfazPrestamo extends JFrame {

    private Biblioteca biblioteca;
    private Usuario usuario;
    private JTextField txtFechaPrestamo;
    private JTextField txtFechaDevolucion;
    private JTextField txtLibro;

    public InterfazPrestamo(Biblioteca biblioteca, Usuario usuario) {
        this.biblioteca = biblioteca;
        this.usuario = usuario;

        setTitle("Gestionar Préstamos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        JLabel lblFechaPrestamo = new JLabel("Fecha de Préstamo (dd/MM/yyyy):");
        JLabel lblFechaDevolucion = new JLabel("Fecha de Devolución (dd/MM/yyyy):");
        JLabel lblLibro = new JLabel("ISBN del Libro:");

        txtFechaPrestamo = new JTextField();
        txtFechaDevolucion = new JTextField();
        txtLibro = new JTextField();

        JButton btnRealizarPrestamo = new JButton("Realizar Préstamo");
        JButton btnVolver = new JButton("Volver");

        add(lblFechaPrestamo);
        add(txtFechaPrestamo);
        add(lblFechaDevolucion);
        add(txtFechaDevolucion);
        add(lblLibro);
        add(txtLibro);
        add(btnRealizarPrestamo);
        add(btnVolver);

        // Acción para realizar préstamo
        btnRealizarPrestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date fechaPrestamo = sdf.parse(txtFechaPrestamo.getText());
                    Date fechaDevolucion = sdf.parse(txtFechaDevolucion.getText());
                    String isbnLibro = txtLibro.getText();

                    Libro libro = biblioteca.buscarLibroPorIsbn(isbnLibro); // Método para buscar libro en la biblioteca
                    if (libro != null) {
                        Prestamo prestamo = new Prestamo(fechaPrestamo, fechaDevolucion, libro);
                        usuario.agregarPrestamo(prestamo); // Método para agregar préstamo al usuario
                        JOptionPane.showMessageDialog(null, "Préstamo realizado con éxito!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Libro no encontrado.");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al realizar el préstamo.");
                }
            }
        });

        // Acción para volver a la ventana principal
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazPrincipal principalFrame = new InterfazPrincipal(biblioteca);
                principalFrame.setVisible(true);
                setVisible(false);
            }
        });
    }
}
