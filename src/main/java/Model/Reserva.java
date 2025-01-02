package Model;

import java.util.Date;

/**
 * Clase que representa una reserva en el sistema.
 * Cada reserva tiene un número de solicitud, un usuario, un libro y una fecha de reserva.
 */
public class Reserva {
	//Atributos

	/** Número de solicitud de la reserva. */
	private String numeroSolicitud;
	/** Usuario que realiza la reserva. */
	private Usuario usuario;
	/** Libro reservado. */
	private Libro libro;
	/** Fecha en que se realizó la reserva. */
	private Date fechaReserva;

	//Constructor

	/**
	 * Constructor para inicializar una reserva con su número de solicitud, usuario, libro y fecha de reserva.
	 *
	 * @param numeroSolicitud el número de solicitud de la reserva.
	 * @param usuario el usuario que realiza la reserva.
	 * @param libro el libro reservado.
	 * @param fechaReserva la fecha en que se realizó la reserva.
	 */
	public Reserva(String numeroSolicitud, Usuario usuario, Libro libro, Date fechaReserva) {
		this.numeroSolicitud = numeroSolicitud;
		this.libro=libro;
		this.usuario=usuario;
		this.fechaReserva=fechaReserva;
	}

	//Getters y Setters

	/**
	 * Obtiene el número de solicitud de la reserva.
	 *
	 * @return el número de solicitud de la reserva.
	 */
	public String getNumeroSolicitud() {
		return this.numeroSolicitud;
	}

	/**
	 * Establece el número de solicitud de la reserva.
	 *
	 * @param numeroSolicitud el número de solicitud de la reserva.
	 */
	public void setNumeroSolicitud(String numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}

	/**
	 * Obtiene el usuario que realiza la reserva.
	 *
	 * @return el usuario que realiza la reserva.
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Establece el usuario que realiza la reserva.
	 *
	 * @param usuario el usuario que realiza la reserva.
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Obtiene el libro reservado.
	 *
	 * @return el libro reservado.
	 */
	public Libro getLibro() {
		return this.libro;
	}

	/**
	 * Establece el libro reservado.
	 *
	 * @param libro el libro reservado.
	 */
	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	/**
	 * Obtiene la fecha en que se realizó la reserva.
	 *
	 * @return la fecha de la reserva.
	 */
	public Date getFechaReserva() { return this.fechaReserva; }

	/**
	 * Establece la fecha en que se realizó la reserva.
	 *
	 * @param fechaReserva la fecha de la reserva.
	 */
	public void setFechaReserva(Date fechaReserva) { this.fechaReserva = fechaReserva; }

	//Métodos

	/**
	 * Devuelve una representación en cadena de la reserva.
	 *
	 * @return una representación en cadena de la reserva.
	 */
	@Override
	public String toString() {
		return "Reserva{" +
				"numeroSolicitud=" + numeroSolicitud +
				", usuario='" + usuario.getNombre() + '\'' +
				", libro=" + libro.getTitulo() +
				", fechaReserva='" + fechaReserva + '\'' +
				'}';
	}

}