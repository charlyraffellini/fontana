package utn.tadp.fontana;

import utn.tadp.fontana.estrategia.Inicializacion;
import utn.tadp.fontana.estrategia.InicializacionPorSetters;
import utn.tadp.fontana.politica.CreacionDeDependencia;
import utn.tadp.fontana.politica.InstanciaComun;

public class Compleja<T extends Object> extends Dependencia {

	Class<T> cClass;
	//CreacionDeDependencia<T> policy;
	
	private Inicializacion<T> miInicializacion;
	
	public Compleja(Class<T> cClass){
		this.cClass = cClass;
		CreacionDeDependencia<T> defaultPolicy = new InstanciaComun<T>(cClass);
		InicializacionPorSetters<T> inicializacionDefault = new InicializacionPorSetters<T>();
		inicializacionDefault.setMiDependenciaCompleja(this);
		inicializacionDefault.setPolicy(defaultPolicy);
		this.miInicializacion = inicializacionDefault;
	}
	public Compleja(Class<T> cClass, Inicializacion<T> tipoDeInicializacion){
		this.cClass = cClass;
		this.miInicializacion = tipoDeInicializacion;
	}
	
	
	@Override
	public T getValue() {
		this.miInicializacion.setMiDependenciaCompleja(this);
		return this.miInicializacion.getObject();

	}
	
	public Compleja<T> addDependencia(String property, Dependencia dep){
		this.miInicializacion.addDependencia(property, dep);
		return this;
	}

	@Override
	public Class<T> getDepClass() {
		return this.cClass;
	}
	public Class<T> getcClass() {
		return cClass;
	}
	public Inicializacion<T> getMiInicializacion() {
		return miInicializacion;
	}

}
