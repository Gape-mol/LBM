package GUI;

import Model.Biblioteca;
import Model.Reserva;
import Model.Usuario;
import Model.UsuarioConectado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class InterfazVerReservas extends JFrame {

    private Usuario usuario;
    private Biblioteca biblioteca;

    public InterfazVerReservas(Biblioteca biblioteca) {
        this.usuario = UsuarioConectado.getUsuario();
        this.biblioteca = biblioteca;

        setTitle("Ver Reservas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextArea areaReservas = new JTextArea();
        areaReservas.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaReservas);

        JButton btnVolver = new JButton("Volver");

        ArrayList<Reserva> reservas = usuario.getReservas(); // Obtener la lista de reservas

        // Mostrar los libros
        if (reservas.isEmpty() || reservas == null) { // Esta funcion no puede funcionar si no hay una lista de reservas
            areaReservas.setText("No hay reservas para mostrar");
        } else {
            StringBuilder reservasInfo = new StringBuilder();
            for (Reserva reserva : reservas) {
                reservasInfo.append("Numero de solicitud: ").append(reserva.getNumeroSolicitud())
                        .append("\nFecha de la reserva: ").append(reserva.getFechaReserva())
                        .append("\nLibro de la reserva ").append(reserva.getLibro().getTitulo())
                        .append("\n\n");
            }
            areaReservas.setText(reservasInfo.toString());
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