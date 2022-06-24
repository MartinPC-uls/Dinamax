package bd;

public class Fecha_inicio {

	private String dia;
	private String mes;
	private String ano;
	
	public Fecha_inicio(String dia, String mes, String ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	// getters
	public String get_dia() {
		return dia;
	}
	public String get_mes() {
		return mes;
	}
	public String get_ano() {
		return ano;
	}
	
	// setters
	public void set_dia(String dia) {
		this.dia = dia;
	}
	public void set_mes(String mes) {
		this.mes = mes;
	}
	public void set_ano(String ano) {
		this.ano = ano;
	}
	
}
