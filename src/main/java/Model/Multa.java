package Model;

import java.util.Date;

/**
 * Clase que representa una multa en el sistema.
 * Cada multa tiene un monto, una fecha y un estado.
 */
public class Multa {
	//Atributos

	/** Monto de la multa. */
	private int monto;
	/** Fecha en que se generó la multa. */
	private Date fecha;
	/** Estado de la multa. */
	private String estado;

	//Constructor

	/**
	 * Constructor para inicializar una multa con su fecha, estado y monto.
	 *
	 * @param fecha la fecha en que se generó la multa.
	 * @param estado el estado de la multa.
	 * @param monto el monto de la multa.
	 */
	public Multa(Date fecha, String estado, int monto) {
		this.fecha = fecha;
		this.estado=estado;
		this.monto=monto;
	}

	//Getters y Setters

	/**
	 * Obtiene el monto de la multa.
	 *
	 * @return el monto de la multa.
	 */
	public int getMonto() {
		return this.monto;
	}

	/**
	 * Establece el monto de la multa.
	 *
	 * @param monto el monto de la multa.
	 */
	public void setMonto(int monto) {
		this.monto = monto;
	}

	/**
	 * Obtiene la fecha en que se generó la multa.
	 *
	 * @return la fecha de la multa.
	 */
	public Date getFecha() {
		return this.fecha;
	}

	/**
	 * Establece la fecha en que se generó la multa.
	 *
	 * @param fecha la fecha de la multa.
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Obtiene el estado de la multa.
	 *
	 * @return el estado de la multa.
	 */
	public String getEstado() {
		return this.estado;
	}

	/**
	 * Establece el estado de la multa.
	 *
	 * @param estado el estado de la multa.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

}