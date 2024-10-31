public class Usuario {

	private String nombre;
	private int identificacion;
	private List<Prestamo> prestamos;

	public String getNombre() {
		return this.nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdentificacion() {
		return this.identificacion;
	}

	/**
	 * 
	 * @param identificacion
	 */
	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	public List<Prestamo> getPrestamos() {
		return this.prestamos;
	}

	/**
	 * 
	 * @param prestamos
	 */
	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

}