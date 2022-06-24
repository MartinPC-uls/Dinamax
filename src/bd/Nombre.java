package bd;

public class Nombre {

	private String nombre;
	private String apellido1;
	private String apellido2;
	
	public Nombre(String nombre, String apellido1, String apellido2) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}
	
	// getters
	public String get_nombre() {
		return nombre;
	}
	public String get_apellido1() {
		return apellido1;
	}
	public String get_apellido2() {
		return apellido2;
	}
	
	// setters
	public void set_nombre(String nombre) {
		this.nombre = nombre;
	}
	public void set_apellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public void set_apellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
}
