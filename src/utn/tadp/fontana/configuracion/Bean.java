package utn.tadp.fontana.configuracion;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import utn.tadp.fontana.Compleja;
import utn.tadp.fontana.Dependencia;
import utn.tadp.fontana.estrategia.Inicializacion;

public class Bean<T extends Object> extends Componente {

	private String name;
	private Map<String,Componente> componentes = new HashMap<String,Componente>();
	private Inicializacion<T> tipoDeInicializacion;
	private Class<T> cClass;
	
	public Bean(String name, Class<T> cClass){
		super();
		this.name = name;
		this.cClass = cClass;
	}
	@Override
	protected Dependencia createDependencia() {
		Compleja<T> compleja = (tipoDeInicializacion == null) ? new Compleja<T>(this.cClass) : new Compleja<T>(this.cClass, tipoDeInicializacion);
		for (Entry<String, Componente> entry : componentes.entrySet()) {
			compleja.addDependencia(entry.getKey(), entry.getValue().getDependencia());
		}
		return compleja;
	}
	
	public Bean<T> addComponente(String property, Componente componente){
		this.componentes.put(property, componente);
		return this;
	}

	public void setPolitica(Inicializacion<T> tipoDeInicializacion){
		this.tipoDeInicializacion = tipoDeInicializacion;
	}
	
	public void setClass(Class<T> cClass){
		this.cClass = cClass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
