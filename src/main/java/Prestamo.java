public class Prestamo {

	private Date fechaPrestamo;
	private Date fechaDevolucion;

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

}