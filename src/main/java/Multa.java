import java.util.Date;

public class Multa {

	private int monto;

	private Date fecha;
	private String estado;

	public Multa(Date fecha, String estado, int monto) {
		this.fecha = fecha;
		this.estado=estado;
		this.monto=monto;
	}

	public int getMonto() {
		return this.monto;
	}

	/**
	 *
	 * @param monto
	 */
	public void setMonto(int monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return this.fecha;
	}

	/**
	 *
	 * @param fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return this.estado;
	}

	/**
	 *
	 * @param estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

}