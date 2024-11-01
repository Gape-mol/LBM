public class Reserva {
	private int numeroSolicitud;
	private String nombreUsuario;
	private Libro libro;
	public Reserva(int numeroSolicitud, String nombreUsuario, Libro libro) {
		this.numeroSolicitud = numeroSolicitud;
		this.libro=libro;
		this.nombreUsuario=nombreUsuario;
	}

	public int getNumeroSolicitud() {
		return this.numeroSolicitud;
	}

	/**
	 * 
	 * @param numeroSolicitud
	 */
	public void setNumeroSolicitud(int numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	/**
	 * 
	 * @param nombreUsuario
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Libro getLibro() {
		return this.libro;
	}

	/**
	 * 
	 * @param libro
	 */
	public void setLibro(Libro libro) {
		this.libro = libro;
	}

}