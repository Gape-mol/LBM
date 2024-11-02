import java.util.Date;

public class Multa {

	private int monto;
	private Date fecha;
	private String estado;
	private Prestamo prestamo;
	private String tipoPago;

	public Multa(Date fecha, int monto, Prestamo prestamo) {
		this.prestamo = prestamo;
		this.fecha = fecha;
		this.estado="No pagado";
		this.monto=monto;
		this.tipoPago="No pagado";
	}

	public void pagarMulta(String formaPago){
		this.estado="Pagado";
		this.tipoPago=formaPago;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
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