import java.util.Date;

public class Reserva {
	private int numeroSolicitud;
	private Usuario usuario;
	private Libro libro;
	private Date fechaReserva;

	public Reserva(int numeroSolicitud, Usuario usuario, Libro libro, Date fechaReserva) {
		this.numeroSolicitud = numeroSolicitud;
		this.libro=libro;
		this.usuario=usuario;
		this.fechaReserva=fechaReserva;
	}

	public int getNumeroSolicitud() {
		return this.numeroSolicitud;
	}

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

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Date getFechaReserva() { return this.fechaReserva; }

	public void setFechaReserva(Date fechaReserva) { this.fechaReserva = fechaReserva; }

	@Override
	public String toString() {
		return "Reserva{" +
				"numeroSolicitud=" + numeroSolicitud +
				", usuario='" + usuario + '\'' +
				", libro=" + libro.getTitulo() +
				", fechaReserva='" + fechaReserva + '\'' +
				'}';
	}

}