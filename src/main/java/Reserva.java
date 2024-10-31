public class Reserva {
	private int numeroSolicitud;
	private String nombreUsuario;
	private Libro libro;
	private String fechaReserva;

	public Reserva(int numeroSolicitud, String nombreUsuario, Libro libro, String fechaReserva) {
		this.numeroSolicitud = numeroSolicitud;
		this.libro=libro;
		this.nombreUsuario=nombreUsuario;
		this.fechaReserva=fechaReserva;
	}

	public int getNumeroSolicitud() {
		return this.numeroSolicitud;
	}

	public void setNumeroSolicitud(int numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Libro getLibro() {
		return this.libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public String getFechaReserva() { return this.fechaReserva; }

	public void setFechaReserva(String fechaReserva) { this.fechaReserva = fechaReserva; }

	@Override
	public String toString() {
		return "Reserva{" +
				"numeroSolicitud=" + numeroSolicitud +
				", nombreUsuario='" + nombreUsuario + '\'' +
				", libro=" + libro.getTitulo() +
				", fechaReserva='" + fechaReserva + '\'' +
				'}';
	}

}