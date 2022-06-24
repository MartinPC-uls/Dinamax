package bd;

public class Materiales {

	private String descripcion;
	private String unidad;
	private String precio_vigente_uf;
	
	public Materiales(String descripcion, String unidad, String precio_vigente_uf) {
		this.descripcion = descripcion;
		this.unidad = unidad;
		this.precio_vigente_uf = precio_vigente_uf;
	}
	
	// getters
	public String get_descripcion() {
		return descripcion;
	}
	public String get_unidad() {
		return unidad;
	}
	public String get_precio_vigente_uf() {
		return precio_vigente_uf;
	}
	
	// setters
	public void set_descripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void set_unidad(String unidad) {
		this.unidad = unidad;
	}
	public void set_precio_vigente_uf(String precio_vigente_uf) {
		this.precio_vigente_uf = precio_vigente_uf;
	}
	
}
