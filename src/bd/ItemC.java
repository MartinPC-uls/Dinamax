package bd;

public class ItemC {

	private String partida;
	private String designacion;
	private String unidad;
	private double preciototal;
	
	public ItemC(String partida, String designacion, String unidad, double preciototal) {
		this.partida = partida;
		this.designacion = designacion;
		this.unidad = unidad;
		this.preciototal = preciototal;
	}
	
	// getters
	public String get_partida() {
		return partida;
	}
	public String get_designacion() {
		return designacion;
	}
	public String get_unidad() {
		return unidad;
	}
	public double get_preciototal() {
		return preciototal;
	}
	
	// setters
	public void set_partida(String partida) {
		this.partida = partida;
	}
	public void set_designacion(String designacion) {
		this.designacion = designacion;
	}
	public void set_unidad(String unidad) {
		this.unidad = unidad;
	}
	public void set_preciototal(int preciototal) {
		this.preciototal = preciototal;
	}
	
}
