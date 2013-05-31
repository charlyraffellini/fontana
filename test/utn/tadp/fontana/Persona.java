package utn.tadp.fontana;

import java.util.ArrayList;

public class Persona {

	private String nombre;
	private boolean vive;
	private int edad;
	private Persona conocido;
	private ArrayList<String> apodos = new ArrayList<String>();
	
	public Persona(){
		super();
	}
	public Persona(String nombre,int edad){
		this.setNombre(nombre);
		this.setEdad(edad);
	}
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
	public ArrayList<String> getApodos() {
		return apodos;
	}
	public void setApodos(ArrayList<String> apodos) {
		this.apodos = apodos;
	}
	
}
