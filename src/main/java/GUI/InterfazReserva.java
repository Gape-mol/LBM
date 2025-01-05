package GUI;

import Data.GestorDeArchivos;
import Model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * CLase de interfaz para realizar reservas
 */

public class InterfazReserva extends JFrame {

    private Biblioteca biblioteca;
    private Usuario usuario;
    private JTextField txtFecha;
    private JTextField txtLibro;

    /**
     * Metodo Constructor de la clase InterfazReserva
     * Configura la ventana para la realizacion de reservas
     * @param biblioteca Biblioteca guardada para donde se realizan las reservas
     */
    public InterfazReserva(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        this.usuario = UsuarioConectado.getUsuario();

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

        /**
         * Accion asociada al boton de Realizar Prestamo
         * Si esta todo correctamente agregado realiza el prestamo
         * En caso de que se realiza correctamente envia un mensaje al usuario indicando esto mismo.
         */
        btnRealizarPrestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date fecha = sdf.parse(txtFecha.getText());
                    String isbnLibro = txtLibro.getText();

                    Date fechaFormateada = formatearFecha(fecha);

                    Libro libro = biblioteca.buscarLibroPorIsbn(isbnLibro); // Método para buscar libro en la biblioteca
                    if (libro != null) {
                        Reserva reserva = new Reserva(obtenerIdentificador() , usuario, libro, fechaFormateada);
                        JOptionPane.showMessageDialog(null, "Reserva realizada con éxito!");

                        GestorDeArchivos gestor = new GestorDeArchivos();
                        ArrayList<Reserva> reservas = gestor.cargarReservas();

                        reservas.add(reserva);

                        gestor.guardarReservas(reservas);

                    } else {
                        JOptionPane.showMessageDialog(null, "Reserva no encontrada.");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al realizar la reserva.");
                }
            }
        });

        /**
         * Accion asociada al boton volver
         * Cierra la ventana y abre la ventana del menu principal
         */
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazPrincipal principalFrame = new InterfazPrincipal(biblioteca);
                principalFrame.setVisible(true);
                setVisible(false);
            }
        });
    }

    /**
     * Metodo para obtener un numero aleatorio mediante una operacion matematica
     * @return Retorna un valor en String que sera unico para cada reserva activa
     */

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

    /**
     * Metodo para establecer la fecha a un formato especifico
     * @param fecha Fecha establecida en el sistema
     * @return Retorna la fecha como Date, el cual posee el formato establecido para evitar problemas en el futuro
     */

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
