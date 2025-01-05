package GUI;

import Data.GestorDeArchivos;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Calendar;

/**
 * Clase que representa la interfaz gráfica para consultar el estado de una reserva de libro.
 * Permite al usuario ingresar el número de solicitud de la reserva para conocer si el libro
 * está disponible para su préstamo o si ya no está reservado.
 */
public class InterfazEstadoReserva extends JFrame {

    private Usuario usuario;
    private Biblioteca biblioteca;

    /**
     * Constructor de la clase InterfazEstadoReserva.
     * Inicializa los componentes de la ventana para consultar el estado de una reserva.
     *
     * @param biblioteca Objeto de la clase Biblioteca que contiene la colección de libros.
     */
    public InterfazEstadoReserva(Biblioteca biblioteca) {
        this.usuario = UsuarioConectado.getUsuario();
        this.biblioteca = biblioteca;

        // Configuración de la ventana
        setTitle("Buscar Libro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Componentes de la interfaz
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

        /**
         * Acción asociada al botón "Buscar".
         * Permite consultar el estado de la reserva ingresando el número de solicitud.
         * Si la reserva existe, muestra el estado del libro (listo para retiro, no disponible, o no reservado).
         * Si la reserva no se encuentra, muestra un mensaje indicando que no existe.
         */
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

        /**
         * Acción asociada al botón "Volver".
         * Cierra la ventana actual y regresa a la interfaz principal de la aplicación.
         */
        btnVolver.addActionListener((ActionEvent e) -> {
            setVisible(false);
            new InterfazPrincipal(biblioteca).setVisible(true);
        });
    }

    /**
     * Formatea la fecha eliminando la hora, los minutos, los segundos y los milisegundos.
     *
     * @param fecha La fecha a formatear.
     * @return La fecha formateada, con hora establecida a 00:00:00.
     */
    public Date formatearFecha(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
