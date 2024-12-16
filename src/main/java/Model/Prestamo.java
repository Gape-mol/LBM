package Model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Prestamo {

	private Date fechaPrestamo;
	private Date fechaDevolucion;
	private Libro libro;

	public Prestamo(Date fechaPrestamo, Date fechaDevolucion, Libro libro) {
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
		this.libro = libro;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Date getFechaPrestamo() {
		return this.fechaPrestamo;
	}

	/**
	 * 
	 * @param fechaPrestamo
	 */
	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaDevolucion() {
		return this.fechaDevolucion;
	}

	/**
	 * 
	 * @param fechaDebolucion
	 */
	public void setFechaDevolucion(Date fechaDebolucion) {
		this.fechaDevolucion = fechaDebolucion;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Libro: " + libro.getTitulo() + " | " +
				"Autor: " + libro.getAutor() + " | " +
				"Fecha de Préstamo: " + sdf.format(fechaPrestamo) + " | " +
				"Fecha de Devolución: " + sdf.format(fechaDevolucion);
	}

}