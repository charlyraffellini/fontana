package utn.tadp.fontana.configuracion;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import utn.tadp.fontana.Compleja;
import utn.tadp.fontana.Dependencia;
import utn.tadp.fontana.politica.CreacionDeDependencia;

public class Bean<T extends Object> extends Componente {

	private String name;
	private Map<String,Componente> componentes = new HashMap<String,Componente>();
	private CreacionDeDependencia<T> politica;
	private Class<T> cClass;
	
	@SuppressWarnings("rawtypes")
	@Override
	protected Dependencia createDependencia() {
		Compleja<T> compleja = (politica == null) ? new Compleja<T>(this.cClass) : new Compleja<T>(this.cClass, politica);
		for (Entry<String, Componente> entry : componentes.entrySet()) {
			if(entry.getValue().getClass() == SimpleComponente.class)
				compleja.addDependencia(entry.getKey(), entry.getValue().getDependencia());
			else
				compleja.addDependencia(entry.getKey(), this.conf.getDependencia((Bean)entry.getValue()));
		}
		return compleja;
	}
	
	public void addComponente(String property, Componente componente){
		this.componentes.put(property, componente);
	}

	public void setPolitica(CreacionDeDependencia<T> politica){
		this.politica = politica;
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
