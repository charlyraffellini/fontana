package utn.tadp.fontana.estrategia;

import java.util.HashMap;
import java.util.Map;

import utn.tadp.fontana.Compleja;
import utn.tadp.fontana.Dependencia;

public abstract class Inicializacion <T extends Object> {

	Map<String, Dependencia> dependencias = new HashMap<String, Dependencia>();
	
	protected Compleja<T> miDependenciaCompleja;
	public abstract T getObject();

	public Compleja<T> getMiDependenciaCompleja() {
		return miDependenciaCompleja;
	}
	
	public void addDependencia(String nombre, Dependencia unaDependencia){
		this.dependencias.put(nombre, unaDependencia);
	}
	
	public void setMiDependenciaCompleja(Compleja<T> miDependenciaCompleja) {
		this.miDependenciaCompleja = miDependenciaCompleja;
	}

}
