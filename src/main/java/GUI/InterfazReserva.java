package GUI;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class InterfazReserva extends JFrame {

    private Biblioteca biblioteca;
    private Usuario usuario;
    private JTextField txtFecha;
    private JTextField txtLibro;

    public InterfazReserva(Biblioteca biblioteca, Usuario usuario) {
        this.biblioteca = biblioteca;
        this.usuario = usuario;

        setTitle("Gestionar Reservas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        JLabel lblFechaPrestamo = new JLabel("Fecha de Reserva (dd/MM/yyyy):");
        JLabel lblLibro = new JLabel("ISBN del Libro:");

        txtFecha = new JTextField();
        txtLibro = new JTextField();

        JButton btnRealizarPrestamo = new JButton("Realizar Reserva");
        JButton btnVolver = new JButton("Volver");

        add(lblFechaPrestamo);
        add(txtFecha);
        add(lblLibro);
        add(txtLibro);
        add(btnRealizarPrestamo);
        add(btnVolver);

        // Acción para realizar la reserva
        btnRealizarPrestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date fecha = sdf.parse(txtFecha.getText());
                    String isbnLibro = txtLibro.getText();

                    Libro libro = biblioteca.buscarLibroPorIsbn(isbnLibro); // Método para buscar libro en la biblioteca
                    if (libro != null) {
                        Reserva reserva = new Reserva(obtenerIdentificador() , usuario, libro, fecha);
                        usuario.agregarReserva(reserva);
                        JOptionPane.showMessageDialog(null, "Reserva realizada con éxito!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Libro no encontrado.");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al realizar la reserva.");
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

    public String obtenerIdentificador(){
        Instant instant = Instant.now();
        long milis = instant.toEpochMilli();

        LocalDate fecha  = LocalDate.now();

        int dia = fecha.getDayOfMonth();
        int anio = fecha.getYear();
        int mes = fecha.getMonthValue();

        long identificacion = milis * dia * anio - mes * dia;

        System.out.println(identificacion);

        return String.valueOf(identificacion);

    }
}
