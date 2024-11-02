public class Reserva {
	private int numeroSolicitud;
	private Usuario usuario;
	private Libro libro;
	public Reserva(int numeroSolicitud, Usuario nombreUsuario, Libro libro) {
		this.numeroSolicitud = numeroSolicitud;
		this.libro=libro;
		this.usuario=nombreUsuario;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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