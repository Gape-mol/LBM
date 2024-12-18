package GUI;

import Data.GestorDeArchivos;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class InterfazEstadoReserva extends JFrame {

    private Usuario usuario;
    private Biblioteca biblioteca;

    public InterfazEstadoReserva(Biblioteca biblioteca) {
        this.usuario = UsuarioConectado.getUsuario();
        this.biblioteca = biblioteca;

        setTitle("Buscar Libro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel labelISBN = new JLabel("Ingrese el numero de solicitud del prestamo");
        JTextField campoNumeroSolicitud = new JTextField(20);
        JTextArea areaResultado = new JTextArea(5, 30);
        areaResultado.setEditable(false);

        JButton btnBuscar = new JButton("Buscar");
        JButton btnVolver = new JButton("Volver");

        add(labelISBN);
        add(campoNumeroSolicitud);
        add(new JScrollPane(areaResultado));
        add(btnBuscar);
        add(btnVolver);

        // Acción para buscar libro
        btnBuscar.addActionListener((ActionEvent e) -> {
            String numeroSolicitud = campoNumeroSolicitud.getText();
            boolean encontrado = false;

            GestorDeArchivos gestor = new GestorDeArchivos();
            ArrayList<Reserva> reservas = gestor.cargarReservas();

            for (Reserva reserva : reservas) {

                if (Objects.equals(reserva.getNumeroSolicitud(), numeroSolicitud)) {
                    Date fechaReserva = reserva.getFechaReserva();
                    Date fechaActualSinFormatear = new Date();

                    Date fechaActual = formatearFecha(fechaActualSinFormatear);

                    String respuesta = "";
                    if (fechaActual.before(fechaReserva)) {
                        respuesta = "El libro aun no se encuentra listo para realizar el prestamo";
                    } else if (fechaActual.equals(fechaReserva)) {
                        respuesta = "El libro esta listo para retiro";
                    } else if (fechaActual.after(fechaReserva)) {
                        respuesta = "El libro ya no se encuentra reservado";
                        reservas.remove(reserva);
                        gestor.guardarReservas(reservas);
                    }
                    areaResultado.setText(respuesta);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                areaResultado.setText("La solicitud de reserva con el numero de solicitud " + numeroSolicitud + " no existe");
            }
        });

        // Acción para volver al menú principal
        btnVolver.addActionListener((ActionEvent e) -> {
            setVisible(false);
            new InterfazPrincipal(biblioteca).setVisible(true);
        });
    }

    public Date formatearFecha(Date fecha){
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}