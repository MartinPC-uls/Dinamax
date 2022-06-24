package bd;

import java.util.ArrayList;

public class Proyecto {

	private String _id;
	private String nombre_proyecto;
	private String rut;
	private Nombre nombre;
	private Direccion direccion;
	private String subsidio;
	private String monto_subsidio;
	private String presupuesto;
	private String duracion_obra;
	private Fecha_inicio fecha_inicio;
	private String estado_obra;
	private ArrayList<String> materiales_usados;
	private ArrayList<String> registro;
	
	public Proyecto(String nombre_proyecto, String rut, Nombre nombre, Direccion direccion, String subsidio, String monto_subsidio,
			String presupuesto, String duracion_obra, Fecha_inicio fecha_inicio, String estado_obra, ArrayList<String> materiales_usados, ArrayList<String> registro) {
		this.nombre_proyecto = nombre_proyecto;
		this.rut = rut;
		this.nombre = nombre;
		this.direccion = direccion;
		this.subsidio = subsidio;
		this.monto_subsidio = monto_subsidio;
		this.presupuesto = presupuesto;
		this.duracion_obra = duracion_obra;
		this.fecha_inicio = fecha_inicio;
		this.estado_obra = estado_obra;
		this.materiales_usados = materiales_usados;
		this.registro = registro;
	}
	
	public Proyecto(String _id, String nombre_proyecto, String rut, Nombre nombre, Direccion direccion, String subsidio, String monto_subsidio,
			String presupuesto, String duracion_obra, Fecha_inicio fecha_inicio, String estado_obra, ArrayList<String> materiales_usados, ArrayList<String> registro) {
		this._id = _id;
		this.nombre_proyecto = nombre_proyecto;
		this.rut = rut;
		this.nombre = nombre;
		this.direccion = direccion;
		this.subsidio = subsidio;
		this.monto_subsidio = monto_subsidio;
		this.presupuesto = presupuesto;
		this.duracion_obra = duracion_obra;
		this.fecha_inicio = fecha_inicio;
		this.estado_obra = estado_obra;
		this.materiales_usados = materiales_usados;
		this.registro = registro;
	}
	
	// getters
	public String get__id() {
		return _id;
	}
	public String get_nombre_proyecto() {
		return nombre_proyecto;
	}
	public String get_rut() {
		return rut;
	}
	public Nombre get_nombre() {
		return nombre;
	}
	public Direccion get_direccion() {
		return direccion;
	}
	public String get_subsidio() {
		return subsidio;
	}
	public String get_monto_subsidio() {
		return monto_subsidio;
	}
	public String get_presupuesto() {
		return presupuesto;
	}
	public String get_duracion_obra() {
		return duracion_obra;
	}
	public Fecha_inicio get_fecha_inicio() {
		return fecha_inicio;
	}
	public String get_estado_obra() {
		return estado_obra;
	}
	public ArrayList<String> get_materiales_usados() {
		return materiales_usados;
	}
	public ArrayList<String> get_registro() {
		return registro;
	}
	
	// setters
	public void set__id(String _id) {
		this._id = _id;
	}
	public void set_nombre_proyecto(String nombre_proyecto) {
		this.nombre_proyecto = nombre_proyecto;
	}
	public void set_rut(String rut) {
		this.rut = rut;
	}
	public void set_nombre(Nombre nombre) {
		this.nombre = nombre;
	}
	public void set_direccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public void set_subsidio(String subsidio) {
		this.subsidio = subsidio;
	}
	public void set_monto_subsidio(String monto_subsidio) {
		this.monto_subsidio = monto_subsidio;
	}
	public void set_presupuesto(String presupuesto) {
		this.presupuesto = presupuesto;
	}
	public void set_duracion_obra(String duracion_obra) {
		this.duracion_obra = duracion_obra;
	}
	public void set_fecha_inicio(Fecha_inicio fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public void set_estado_obra(String estado_obra) {
		this.estado_obra = estado_obra;
	}
	public void set_materiales_usados(ArrayList<String> materiales_usados) {
		this.materiales_usados = materiales_usados;
	}
	public void set_registro(ArrayList<String> registro) {
		this.registro = registro;
	}
	
	
}
