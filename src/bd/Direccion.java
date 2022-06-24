package bd;

public class Direccion {

	private String calle;
	private String numero;
	private String CCP;
	
	public Direccion(String calle, String numero, String CCP) {
		this.calle = calle;
		this.numero = numero;
		this.CCP = CCP;
	}
	
	// getters
	public String get_calle() {
		return calle;
	}
	public String get_numero() {
		return numero;
	}
	public String get_CCP() {
		return CCP;
	}
	
	// setters
	public void set_calle(String calle) {
		this.calle = calle;
	}
	public void set_numero(String numero) {
		this.numero = numero;
	}
	public void set_CCP(String CCP) {
		this.CCP = CCP;
	}
	
}
