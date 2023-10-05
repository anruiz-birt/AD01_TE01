package ejercicios;

public class Personaje {
	private int id;
	private String dni;
	private String nombre;
	private String identidad;
	private String tipo;
	private int peso;
	private int altura;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdentidad() {
		return identidad;
	}
	public void setIdentidad(String identidad) {
		this.identidad = identidad;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	public String toString() {
		return "Personaje [dni=" + this.dni+ ", nombre=" + String.format("%-12s", this.nombre + "," ) + "identidad=" + String.format("%-22s", this.identidad + "," ) + "tipo=" + String.format("%-12s", this.tipo + "," ) + "peso=" + String.format("%-6s", this.peso + "," ) + "altura=" + this.altura + "]";
	}
	
	public String getControlPeso(int pesoNuevo) {
		String sControl = "";
		if(this.peso == pesoNuevo) {
			sControl = this.nombre + " se mantiene en el peso anterior.";
		}else if (this.peso > pesoNuevo) {
			sControl = this.nombre + " ha adelgazado " + (this.peso-pesoNuevo) + " kilos.";
		}else {
			sControl = this.nombre + " ha engordado " + (pesoNuevo-this.peso) + " kilos.";
		}
		return sControl;
	}	

}
