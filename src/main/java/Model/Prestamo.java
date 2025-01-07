package Model;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Clase que representa un préstamo en el sistema.
 * Cada préstamo tiene una fecha de préstamo, una fecha de devolución y un libro asociado.
 */
public class Prestamo {
	//Atributos

	/** Fecha en que se realizó el préstamo. */
	private Date fechaPrestamo;
	/** Fecha en que se debe devolver el libro. */
	private Date fechaDevolucion;
	/** Libro prestado. */
	private Libro libro;

	//Constructor

	/**
	 * Constructor para inicializar un préstamo con su fecha de préstamo, fecha de devolución y libro asociado.
	 *
	 * @param fechaPrestamo la fecha en que se realizó el préstamo.
	 * @param fechaDevolucion la fecha en que se debe devolver el libro.
	 * @param libro el libro prestado.
	 */
	public Prestamo(Date fechaPrestamo, Date fechaDevolucion, Libro libro) {
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
		this.libro = libro;
	}

	//Getters y Setters

	/**
	 * Obtiene el libro prestado.
	 *
	 * @return el libro prestado.
	 */
	public Libro getLibro() {
		return libro;
	}

	/**
	 * Establece el libro prestado.
	 *
	 * @param libro el libro prestado.
	 */
	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	/**
	 * Obtiene la fecha de préstamo.
	 *
	 * @return la fecha de préstamo.
	 */
	public Date getFechaPrestamo() {
		return this.fechaPrestamo;
	}

	/**
	 * Establece la fecha de préstamo.
	 *
	 * @param fechaPrestamo la fecha de préstamo.
	 */
	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	/**
	 * Obtiene la fecha de devolución.
	 *
	 * @return la fecha de devolución.
	 */
	public Date getFechaDevolucion() {
		return this.fechaDevolucion;
	}

	/**
	 * Establece la fecha de devolución.
	 *
	 * @param fechaDevolucion la fecha de devolución.
	 */
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	//Métodos

	/**
	 * Devuelve una representación en cadena del préstamo.
	 *
	 * @return una cadena con el título del libro, el autor, la fecha de préstamo y la fecha de devolución.
	 */
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Libro: " + libro.getTitulo() + " | " +
				"Autor: " + libro.getAutor() + " | " +
				"Fecha de Préstamo: " + sdf.format(fechaPrestamo) + " | " +
				"Fecha de Devolución: " + sdf.format(fechaDevolucion);
	}

}