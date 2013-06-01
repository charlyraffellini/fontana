package utn.tadp.fontana;

import java.util.ArrayList;
import java.util.Collection;
import utn.tadp.fontana.politica.CreacionDeDependencia;
import utn.tadp.fontana.politica.InstanciaComun;

public class Lista<K, T extends Collection<K>> extends Dependencia<T> {
	private ArrayList<Dependencia<K>> listaDeDependencias;
	CreacionDeDependencia<T> policy;
	

	public Lista(Class<T> c){
		this.listaDeDependencias = new ArrayList<Dependencia<K>>();
		this.cClass = c;
		this.policy = new InstanciaComun<T>(c);
	}
	
	public Lista(Class<T> c, CreacionDeDependencia<T> policy){
		this.listaDeDependencias = new ArrayList<Dependencia<K>>();
		this.cClass = c;
		this.policy = policy;
	}	
	
	public Lista<K,T> addDependenciaALaLista(Dependencia<K> dep){
		this.listaDeDependencias.add(dep);
		return this;
	}
	

	@Override
	public T getValue() {
		T value = policy.getObject();
		for(Dependencia<K> unaDependencia : listaDeDependencias){
			value.add(unaDependencia.getValue());
		}
		return value;
	}

	public Class<T> getcClass() {
		return cClass;
	}
}
