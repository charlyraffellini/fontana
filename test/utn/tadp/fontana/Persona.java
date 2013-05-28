package utn.tadp.fontana;

public class Persona {

	public String nombre;
	public boolean vive;
	public int edad;
	public Persona conocido;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean getVive() {
		return vive;
	}
	public void setVive(boolean vive) {
		this.vive = vive;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Persona getConocido() {
		return conocido;
	}
	public void setConocido(Persona conocido) {
		this.conocido = conocido;
	}
	
}
